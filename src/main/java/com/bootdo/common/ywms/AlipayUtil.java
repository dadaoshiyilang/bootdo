package com.bootdo.common.ywms;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayFundTransToaccountTransferRequest;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import org.apache.commons.collections.MapUtils;

import java.util.Map;

/**
 * Created by Administrator on 2018\3\6 0006.
 * /**
 * 支付宝工具类
 * @ClassName: IosVerify
 * @Description:Apple Pay
 */
public class AlipayUtil {

    private static final String APPID=Contants.ALIPAY_APPID;
    private static final String APP_PRIVATE_KEY = Contants.ALIPAY_COMMERCIAL_PRIVATE;
    private static final String ALIPAY_PUBLIC_KEY = Contants.ALIPAY_PUBLIC_KEY;
    private static final String CHARSET="UTF-8";



    public static AlipayFundTransToaccountTransferResponse getTransferInfo(Map<String,Object> params) throws  AlipayApiException {

        String out_biz_no= MapUtils.getString(params,"out_biz_no");
        String payacount= MapUtils.getString(params,"payaccount");
        String amount= MapUtils.getString(params,"amount");

        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",APPID,APP_PRIVATE_KEY,"json",CHARSET,ALIPAY_PUBLIC_KEY,"RSA2");
        AlipayFundTransToaccountTransferRequest request1 = new AlipayFundTransToaccountTransferRequest();
        request1.setBizContent("{" +
                "\"out_biz_no\":\""+out_biz_no+"\"," +
                "\"payee_type\":\"ALIPAY_LOGONID\"," +
                "\"payee_account\":\""+payacount+"\"," +
                "\"amount\":\""+amount+"\"," +
                "\"payer_show_name\":\"网红\"," +
                "\"payee_real_name\":\"大胖子\"," +
                "\"remark\":\"缘币提现\"" +
                "}");
        AlipayFundTransToaccountTransferResponse response = alipayClient.execute(request1);;
        System.out.println(response.toString());
        if(response.isSuccess()){
            System.out.println("调用成功");

            return response;
        } else {
            System.out.println("调用失败");
            System.out.println(response.getCode());
            System.out.println(response.getSubCode());
            System.out.println(response.getMsg());
            System.out.println(response.getSubMsg());
            return  response;
        }
//        return response;

    }







}
