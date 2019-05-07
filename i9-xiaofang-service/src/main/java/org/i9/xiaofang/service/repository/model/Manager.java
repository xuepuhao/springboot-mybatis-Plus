package org.i9.xiaofang.service.repository.model;
/**
 * 管理员表
 * @ClassName: Manager
 * @author xph
 * @date 2018年11月27日
 */
public class Manager {
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

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

    public String getCreatetime() {
        if(null !=createtime) {
            return createtime.substring(0,19);
        }
        return "";
    }

    public String getLongAddress() {
        if(provincial !=null ||city !=null ||county !=null) {
            return provincial+"/"+city+"/"+county;
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
}