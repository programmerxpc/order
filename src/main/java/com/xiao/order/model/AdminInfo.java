package com.xiao.order.model;

/**
 * @author XiaoPengCheng
 * @create 2019-04-26 16:09
 */
public class AdminInfo {

    private Integer id;

    /**
     * 管理员用户名
     */
    private String adminName;

    /**
     * 管理员密码
     */
    private String adminPassword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public String toString() {
        return "AdminInfo{" +
                "id=" + id +
                ", adminName='" + adminName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }
}
