package org.i9.xiaofang.service.repository.model;

import java.util.Date;

public class User {
    private Integer id;

    private String name;

    private String phone;

    private String password;

    private String idCard;

    private String idCardPicAddr;

    private Integer ifcheck;

    private Date createTime;

    private String wechatId;

    private String wechatName;

    private Integer state;

    private String familyPhone;

    private Integer ifBinding;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getIdCardPicAddr() {
        return idCardPicAddr;
    }

    public void setIdCardPicAddr(String idCardPicAddr) {
        this.idCardPicAddr = idCardPicAddr == null ? null : idCardPicAddr.trim();
    }

    public Integer getIfcheck() {
        return ifcheck;
    }

    public void setIfcheck(Integer ifcheck) {
        this.ifcheck = ifcheck;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId == null ? null : wechatId.trim();
    }

    public String getWechatName() {
        return wechatName;
    }

    public void setWechatName(String wechatName) {
        this.wechatName = wechatName == null ? null : wechatName.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getFamilyPhone() {
        return familyPhone;
    }

    public void setFamilyPhone(String familyPhone) {
        this.familyPhone = familyPhone == null ? null : familyPhone.trim();
    }

    public Integer getIfBinding() {
        return ifBinding;
    }

    public void setIfBinding(Integer ifBinding) {
        this.ifBinding = ifBinding;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}