package com.bootdo.common.ywms;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.*;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

import java.util.Collection;
import java.util.Map;

/**
 * Created by sjk on 2017/9/27.
 */
public class JiguangPush {

    private static final String APP_KEY =Contants.APP_KEY ;
    private static final String MASTER_SECRET = Contants.MASTER_SECRET;

    //推送到单个用户
    public static void JiguangPush(String alert, String alia) {

        //极光服务
        JPushClient jpushClient = new JPushClient(MASTER_SECRET,APP_KEY, null, ClientConfig.getInstance());

        //构建推送的人员 ----- 单个--别名推送
        PushPayload payload = buildPushObject_all_alias_alert(alia,alert);

        //推送消息
        try {
            PushResult result = jpushClient.sendPush(payload);
            System.out.println("Got result - " + result);
        } catch (APIConnectionException e) {
            System.out.println("Connection error, should retry later");
        } catch (APIRequestException e) {
            System.out.println("Should review the error, and fix the request");
        }
    }

    //评论消息推送到单个用户
    public static void JiguangPushComment(String alert, String alia, Map<String,String> PushInfo) {

        //极光服务
        JPushClient jpushClient = new JPushClient(MASTER_SECRET,APP_KEY, null, ClientConfig.getInstance());

        //构建推送的人员 ----- 单个--别名推送
        PushPayload payload = buildPushObject_all_alias_alertComment(alia,alert,PushInfo);

        //推送消息
        try {
            PushResult result = jpushClient.sendPush(payload);
            System.out.println("Got result - " + result);
        } catch (APIConnectionException e) {
            System.out.println("Connection error, should retry later");
        } catch (APIRequestException e) {
            System.out.println("Should review the error, and fix the request");
        }
    }

    //购买消息推送到单个用户
    public static void JiguangPushBuyNews(String alert, String alia, Map<String,String> PushInfo) {

        //极光服务
        JPushClient jpushClient = new JPushClient(MASTER_SECRET,APP_KEY, null, ClientConfig.getInstance());

        //构建推送的人员 ----- 单个--别名推送
        PushPayload payload = buildPushObject_all_alias_alertBuyNews(alia,alert,PushInfo);

        //推送消息
        try {
            PushResult result = jpushClient.sendPush(payload);
            System.out.println("Got result - " + result);
        } catch (APIConnectionException e) {
            System.out.println("Connection error, should retry later");
        } catch (APIRequestException e) {
            System.out.println("Should review the error, and fix the request");
        }
    }





    //推送到多个用户
    public static void JiguangPush(String alert, Collection<String> alia) {

        //极光服务
        JPushClient jpushClient = new JPushClient(MASTER_SECRET,APP_KEY, null, ClientConfig.getInstance());

        System.out.println(alia);
        //构建推送的人员 ----- 单个--别名推送
        PushPayload payload = buildPushObject_Multiple_alias_alert(alia,alert);

        //推送消息
        try {
            PushResult result = jpushClient.sendPush(payload);
            System.out.println("Got result - " + result);
        } catch (APIConnectionException e) {
            System.out.println("Connection error, should retry later");
        } catch (APIRequestException e) {
            System.out.println("Should review the error, and fix the request");
        }
    }

    //推送到全体用户
    public static void JiguangPush(String alert) {

        //极光服务
        JPushClient jpushClient = new JPushClient(MASTER_SECRET,APP_KEY, null, ClientConfig.getInstance());

        //构建推送的人员 -----  所有安装APP用户
        PushPayload payload = buildPushObject_all_all_alert(alert);

        //推送消息
        try {
            PushResult result = jpushClient.sendPush(payload);
            System.out.println("Got result - " + result);
        } catch (APIConnectionException e) {
            System.out.println("Connection error, should retry later");
        } catch (APIRequestException e) {
            System.out.println("Should review the error, and fix the request");
        }
    }

    //推送到单个用户  ----通过 REGISTRATION_ID 推送
    public static PushPayload buildPushObject_registration_alert(String registrationId, String ALERT) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.registrationId(registrationId))
                .setNotification(Notification.alert(ALERT))
                .build();
    }
    //推送到单个用户  ----通过 alias（别名） 推送
    public static PushPayload buildPushObject_all_alias_alert(String alia, String ALERT) {

        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alia))
                .setNotification(Notification.alert(ALERT))
                .build();
    }

    //评论消息推送到单个用户
    public static PushPayload buildPushObject_all_alias_alertComment(String alia, String ALERT, Map<String,String> PushInfo) {

        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alia))
                .setNotification(
                        Notification.newBuilder()
                                .addPlatformNotification(AndroidNotification.newBuilder()
                                        .addExtras(PushInfo)
                                        .setAlert(ALERT)
                                        .build())
                                .addPlatformNotification(IosNotification.newBuilder()
                                        .addExtras(PushInfo)
                                        .setAlert(ALERT)
                                        .build())
                                .build()
                )
                .build();
    }

    //购买消息推送到单个用户
    public static PushPayload buildPushObject_all_alias_alertBuyNews(String alia, String ALERT, Map<String,String> PushInfo) {

        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alia))
                .setNotification(
                        Notification.newBuilder()
                                .addPlatformNotification(AndroidNotification.newBuilder()
                                        .addExtras(PushInfo)
                                        .setAlert(ALERT)
                                        .build())
                                .addPlatformNotification(IosNotification.newBuilder()
                                        .addExtras(PushInfo)
                                        .setAlert(ALERT)
                                        .build())
                                .build()
                )
                .build();
    }

    //推送到多个用户  ----通过 多个alias（别名） 推送
    public static PushPayload buildPushObject_Multiple_alias_alert(Collection<String> alia, String ALERT) {

        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alia))
                .setNotification(Notification.alert(ALERT))
                .build();
    }

    //推送到全体 安装APP  用户
    public static PushPayload buildPushObject_all_all_alert(String ALERT) {
        return PushPayload.alertAll(ALERT);
    }
}
