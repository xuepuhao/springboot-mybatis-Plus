package org.i9.xiaofang.service.repository.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author xuepuhao
 * @since 2019-05-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 房东姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 身份证号
     */
    @TableField("idCard")
    private String idCard;

    /**
     * 身份证号照片
     */
    @TableField("idCardPicAddr")
    private String idCardPicAddr;

    /**
     * 0：未审核 1：已审核
     */
    private Integer ifcheck;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private String createTime;

    /**
     * 微信id
     */
    @TableField("wechatId")
    private String wechatId;

    /**
     * 微信名称
     */
    @TableField("wechatName")
    private String wechatName;

    /**
     * 0：未注册，1 已注册
     */
    private Integer state;

    /**
     * 亲情号
     */
    @TableField("familyPhone")
    private String familyPhone;

    /**
     * 0:未绑定, 1:已绑定
     */
    @TableField("ifBinding")
    private Integer ifBinding;

    /**
     * 备注
     */
    private String description;

    /**
     * 自己邀请码
     */
    @TableField("inviteCode")
    private String inviteCode;

    /**
     * 别人的邀请码
     */
    @TableField("inviteCodeOther")
    private String inviteCodeOther;

    /**
     * 余额
     */
    private BigDecimal account;


}
