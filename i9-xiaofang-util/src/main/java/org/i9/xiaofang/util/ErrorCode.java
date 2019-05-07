package org.i9.xiaofang.util;

public class ErrorCode {

    /**
     * 未知错误
     */
    public static final int UNKNOWN_ERROR = -99999;

    /**
     * 增删改查失败
     */
    public static final int CRUD_ERROR = 10000;

    /**
     *阿里云短信验证错误代码
     */
    public static final int ALIYUN_NOT_ENOUGH_ERROR = 10017;
    
    /**
     *阿里云短信变量超过字数限制错误代码
     */
    public static final int ALIYUN_GREATER_TemplateSize_ERROR = 10018;
    
    /**
     * 阿里云短信手机号错误
     */
    public static final int ALIYUN_ERROR_PHONE = 10019;
    
    /**
     * 短时间发送短信数量超过限制
     */
    public static final int ALIYUN_NUMBER_LIMIT = 10020;
    
    public static final int LOGIN_ERROR = 500;
    
}
