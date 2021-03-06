/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/27 14:07
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.plugin.wx.controller;

import cn.sixlab.minesitex.bean.wx.entity.MsxWxMsg;
import cn.sixlab.minesitex.lib.base.BaseController;
import cn.sixlab.minesitex.lib.base.util.SecretService;
import cn.sixlab.minesitex.plugin.wx.service.WxService;
import cn.sixlab.minesitex.plugin.wx.util.WxUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

@RestController
@RequestMapping("/wx/pub")
public class WxPubController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(WxPubController.class);
    
    @Autowired
    private WxService wxService;
    
    @Autowired
    private SecretService secretService;
    
    @RequestMapping("/push")
    public String push(HttpServletRequest request, HttpServletResponse response,
            String signature, String timestamp, String nonce, String echostr) throws Exception {
        logger.info("微信来消息了。。。");
        
        // 验签失败返回
        if (!wxService.checkToken(signature, timestamp, nonce)) {
            logger.info("验签失败");
            return "fail";
        }
        
        // 如果 echostr
        if (!StringUtils.isEmpty(echostr)) {
            return echostr;
        }
        
        //如果不是 echostr
        InputStream inputStream = request.getInputStream();
        
        MsxWxMsg wxMsg = wxService.dealMsg(inputStream);
    
        if (null != wxMsg) {
            String userOpenId = wxMsg.getFromUserName();
            String devUserId = wxMsg.getToUserName();
            String msgType = wxMsg.getMsgType();
        
            String msgId = secretService.encrypt(wxMsg.getId());
        
            return WxUtil.returnMsg(msgType, userOpenId, devUserId, wxMsg.getTitle(), msgId);
        } else {
            return "success";
        }
    }
}
