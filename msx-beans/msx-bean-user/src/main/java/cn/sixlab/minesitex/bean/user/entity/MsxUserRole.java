/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/26 17:29
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.bean.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
public class MsxUserRole implements Serializable{
    
    @Id
    @GeneratedValue
    private Integer id;
    private Integer userId;
    private String role;
    private String roleName;
    
    private Timestamp insertTime;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getUserId() {
        return userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public String getRoleName() {
        return roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    public Timestamp getInsertTime() {
        return insertTime;
    }
    
    public void setInsertTime(Timestamp insertTime) {
        this.insertTime = insertTime;
    }
}
