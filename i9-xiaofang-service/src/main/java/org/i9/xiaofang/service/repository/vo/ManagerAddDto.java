package org.i9.xiaofang.service.repository.vo;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ManagerAddDto {
    /**
     * 用户名
     */
    private String username;
    
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @Size(min = 5, max = 11, message = "请输入正确密码格式(5-11位)")
    private String password;
    
    /**
     * 确认密码
     */
    @NotBlank(message = "确认密码不能为空")
    @Size(min = 5, max = 11, message = "请输入正确密码格式(5-11位)")
    private String confirmPwd;
    
    /**
     * 姓名
     */
    private String name;
    
    /**
     * 创建时间
     */
    private String createtime;
    
    /**
     * 手机号 
     */
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^1[3|4|5|6|7|8][0-9]\\d{8}$", message = "请输入正确的手机号")
    private String phone;

    /**
     * 省
     */
    private String provincial;
    
    /**
     * 市
     */
    private String city;
    
    /**
     * 区
     */
    private String county;
    
    /**
     * 具体地址
     */
    private String positionAddr;
    
    /**
     * 身份证号
     */
    private String idCard;
    
    /**
     * 0：启用 1：停用
     */
    private Integer useType;
    
    /**
     * 0:未审核 1：审核
     */
    private Integer audiType;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvincial() {
        return provincial;
    }

    public void setProvincial(String provincial) {
        this.provincial = provincial;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPositionAddr() {
        return positionAddr;
    }

    public void setPositionAddr(String positionAddr) {
        this.positionAddr = positionAddr;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getUseType() {
        return useType;
    }

    public void setUseType(Integer useType) {
        this.useType = useType;
    }

    public Integer getAudiType() {
        return audiType;
    }

    public void setAudiType(Integer audiType) {
        this.audiType = audiType;
    }

    public String getConfirmPwd() {
        return confirmPwd;
    }

    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }
    
}
