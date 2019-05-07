/**
 * FileName: Constants
 * Author:   xph
 * Date:     2019/2/22 14:51
 * Description: 默认值
 */
package org.i9.xiaofang.util;


/**
 * 〈一句话功能简述〉<br> 
 * 〈默认值〉
 *
 * @author lenovo
 * @create 2019/2/22
 * @since 1.0.0
 */
public class Constants {
    /**
     * 网站管理员的type
     */
    public static final Byte[] S_NET_MANAGER = { (byte) 0 };

    /**
     * 用户的type
     */
    public static final Byte[] S_ACCOUNT = { (byte) 1, (byte) 2 };

    /**
     * 经销商的type
     */
    public static final Byte[] S_AGENCY_TYPE = { (byte) 1 };

    /**
     * 项目管理员的type
     */
    public static final Byte[] S__Project_Type = { (byte) 2 };

    /**
     * channel类型
     *
     */
    public static final Integer[] S_Chaanel_TYPES = { 1, 2, 3 };

    /**
     * 登录url
     */
    public static final String S_LOGIN_URL = "/login";

    /**
     * 登录页面url
     */
    public static final String S_LOGIN_PAGE = "/login.zhtml";

    /**
     * 注册url
     */
    public static final String S_REGIST_URL = "/regist";

    /**
     * 经销商列表
     */
    public static final String[] S_ADMIN = { "超级管理员", "普通管理员" };

    /**
     * 经销商列表
     */
    public static final String[] S_AGENCY = { "省级经销商", "地市级经销商" };

    /**
     * 项目管理员列表
     */
    public static final String[] S_PROJ_MANAGER = { "主管领导", "值班人员", "管理人员" };

    public static final String[] NOT_DJUGE_NULL_LIST = {};

    /**
     * 判断隐患的数据类型
     */
    public static final Integer[] DATATYPE = { 2, 5 };
}
