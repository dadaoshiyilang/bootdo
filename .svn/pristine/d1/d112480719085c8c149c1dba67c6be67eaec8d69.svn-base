package com.bootdo.common.utils;

public class CommonConfig {
    public static String REDIS_SHARD_CONFIG;
    public static String OSS_FLAG;
    public static String OSS_ACCESS_KEY_ID;
    public static String OSS_ACCESS_KEY_SECRET;
    public static String OSS_BUCKET;
    public static String OSS_ENDPOINT;
    public static String OSS_URL;
    public static String OSS_CALLBACK;
    public static String ROCKETMQ_NAMESRVADDR;
    public static String ROCKETMQ_CONSUMERGROUP;
    public static String ROCKETMQ_PRODUCERGROUP;
    public static int SMS_TIMEOUT;
    public static String SMS_REGION_ID;
    public static String SMS_ACCESSKEY_ID;
    public static String SMS_SECRET;
    public static String SMS_ENDPOINTNAME;
    public static String SMS_PRODUCT;
    public static String SMS_DOMAIN;
    public static String SMS_SIGNNAME;
    public static String SMS_SYSNAME;
    public static String SMS_REG_TEMPLATE;
    public static String SMS_RESET_TEMPLATE;
    public static int EMAIL_TIMEOUT;
    public static String EMAIL_HOST;
    public static String EMAIL_FROM;
    public static String EMAIL_FROM_PWD;
    public static int SHARD_COUNT;
    private static PropConfig propConfig = PropConfig.loadConfig("setting-web.properties");

    public CommonConfig() {
    }

    public static String getConfigString(String key) {
        return propConfig.getConfigString(key);
    }

    public static int getConfigInt(String key) {
        return propConfig.getConfigInt(key);
    }

    static {
        if (propConfig != null) {
            REDIS_SHARD_CONFIG = propConfig.getConfigString("default.redis.shardConfig");
            OSS_FLAG = propConfig.getConfigString("oss.flag");
            OSS_ACCESS_KEY_ID = propConfig.getConfigString("oss.accessKeyId");
            OSS_ACCESS_KEY_SECRET = propConfig.getConfigString("oss.accessKeySecret");
            OSS_BUCKET = propConfig.getConfigString("oss.accessBucket");
            OSS_ENDPOINT = propConfig.getConfigString("oss.accessEndpoint");
            OSS_URL = propConfig.getConfigString("oss.url");
            OSS_CALLBACK = propConfig.getConfigString("oss.callback");
            ROCKETMQ_NAMESRVADDR = propConfig.getConfigString("rocketmq.namesrvAddr");
            ROCKETMQ_CONSUMERGROUP = propConfig.getConfigString("rocketmq.consumerGroup");
            ROCKETMQ_PRODUCERGROUP = propConfig.getConfigString("rocketmq.producerGroup");
            SMS_TIMEOUT = propConfig.getConfigInt("sms.timeout");
            SMS_REGION_ID = propConfig.getConfigString("sms.regionId");
            SMS_ACCESSKEY_ID = propConfig.getConfigString("sms.accessKeyId");
            SMS_SECRET = propConfig.getConfigString("sms.secret");
            SMS_ENDPOINTNAME = propConfig.getConfigString("sms.endpointName");
            SMS_PRODUCT = propConfig.getConfigString("sms.product");
            SMS_DOMAIN = propConfig.getConfigString("sms.domain");
            SMS_SIGNNAME = propConfig.getConfigString("sms.signName");
            SMS_SYSNAME = propConfig.getConfigString("sms.sysName");
            SMS_REG_TEMPLATE = propConfig.getConfigString("sms.regTemplateCode");
            SMS_RESET_TEMPLATE = propConfig.getConfigString("sms.resetTemplateCode");
            EMAIL_TIMEOUT = propConfig.getConfigInt("email.timeout");
            EMAIL_HOST = propConfig.getConfigString("email.host");
            EMAIL_FROM = propConfig.getConfigString("email.from");
            EMAIL_FROM_PWD = propConfig.getConfigString("email.frompwd");
            SHARD_COUNT = propConfig.getConfigInt("shard.count");
        }
    }
}
