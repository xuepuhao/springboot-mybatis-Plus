package org.i9.xiaofang.service.repository.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
@TableName("t_manager")
public class TManager implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 注册时间
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
     * 区(县)
     */
    private String county;

    /**
     * 具体位置
     */
    @TableField("positionAddr")
    private String positionAddr;

    /**
     * 身份证号
     */
    @TableField("idCard")
    private String idCard;

    /**
     * 0：启用，1：停用
     */
    @TableField("useType")
    private Integer useType;

    /**
     * 0：未审核  1：已审核
     */
    @TableField("audiType")
    private Integer audiType;


}
