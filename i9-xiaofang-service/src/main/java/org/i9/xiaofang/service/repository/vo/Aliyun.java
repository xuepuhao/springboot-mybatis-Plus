/**
 * FileName: Aliyun
 * Author:   xph
 * Date:     2019/3/19 9:20
 * Description:
 */
package org.i9.xiaofang.service.repository.vo;


/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author lenovo
 * @create 2019/3/19
 * @since 1.0.0
 */
public class Aliyun {
    private String appKey;

    private String appSecret;

    private String bucket;

    private String endPoint;

    public static class Builder{
        private String appKey;

        private String appSecret;

        private String bucket;

        private String endPoint;

        public String getAppKey() {
            return appKey;
        }

        public void setAppKey(String appKey) {
            this.appKey = appKey;
        }

        public String getAppSecret() {
            return appSecret;
        }

        public void setAppSecret(String appSecret) {
            this.appSecret = appSecret;
        }

        public String getBucket() {
            return bucket;
        }

        public void setBucket(String bucket) {
            this.bucket = bucket;
        }

        public String getEndPoint() {
            return endPoint;
        }

        public void setEndPoint(String endPoint) {
            this.endPoint = endPoint;
        }
        public Aliyun build(){
            return new Aliyun(this);
        }
    }

    private Aliyun(Builder builder){
        this.appKey = builder.appKey;
        this.appSecret = builder.appSecret;
        this.bucket = builder.bucket;
        this.endPoint = builder.endPoint;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }
}

