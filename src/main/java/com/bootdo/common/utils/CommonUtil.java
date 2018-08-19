package com.bootdo.common.utils;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.*;
import java.util.List;

public class CommonUtil {

    public static List<Map<String, Object>> copyArrayList(List<Map<String, Object>> list) {

        if (list == null || list.size() == 0) {
            return new ArrayList<Map<String, Object>>();
        }
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        for (Map<String, Object> item : list) {
            result.add(item);
        }
        return result;
    }

    /**
     * 功能描述: <br>
     * 〈获取客户端的IP〉
     *
     * @param request
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getRemortIP(HttpServletRequest request) {

        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }

    public static boolean isAjaxRequest(HttpServletRequest request) {

        if (request.getHeader("X-Requested-With") == null) {
            return false;
        }

        return request.getHeader("X-Requested-With").equals("XMLHttpRequest");
    }

    /**
     * 获取树形结构的数据
     *
     * @param dataList
     * @param parentId
     * @return
     */
    public static List<Map<String, Object>> getTreeList(List<Map<String, Object>> dataList, String parentId, String name) {
        List<Map<String, Object>> childMenu = new ArrayList<Map<String, Object>>();
        for (Map<String, Object> data : dataList) {
            String menuId = MapUtils.getString(data, "id");
            String pid = MapUtils.getString(data, "pid");
            String _name = MapUtils.getString(data, name);
            data.put("name", _name);
            if (parentId.equals(pid)) {
                List<Map<String, Object>> c_node = getTreeList(dataList, menuId, name);
                data.put("childList", c_node);
                childMenu.add(data);
            }
        }
        return childMenu;
    }

    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
    }

    public static boolean isUseOss(String flag) {
        if (StringUtils.isEmpty(flag)) {
            return false;
        }

        return flag.equals("1");
    }

    public static boolean isStrExistInStrArr(String str, String[] strArr) {

        if (strArr == null || strArr.length == 0) {
            return false;
        }

        for (String item : strArr) {
            if (item.equals(str)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 判断字符串是存在于List<Map<String, Object>>中
     *
     * @param str
     * @param list
     * @param key
     * @return
     */
    public static boolean exists(List<Map<String, Object>> list, String key, String str) {

        if (CollectionUtils.isEmpty(list) || StringUtils.isEmpty(key) || StringUtils.isEmpty(str)) {
            return false;
        }

        for (Map<String, Object> item : list) {
            String _str = MapUtils.getString(item, key);
            if (_str.equals(str)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 列表中获取数据
     *
     * @param list
     * @param key
     * @return
     */
    public static List<String> getListStringFromListMap(List<Map<String, Object>> list, String key) {

        if (CollectionUtils.isEmpty(list)) {
            return new ArrayList<String>();
        }

        List<String> result = new ArrayList<String>();
        for (Map<String, Object> item : list) {
            result.add(MapUtils.getString(item, key));
        }

        return result;
    }

    /**
     * 创建指定数量的随机字符串
     *
     * @param numberFlag 是否是数字
     * @param length
     * @return
     */
    public static String createRandom(boolean numberFlag, int length) {
        String retStr = "";
        String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
        int len = strTable.length();
        boolean bDone = true;
        do {
            retStr = "";
            int count = 0;
            for (int i = 0; i < length; i++) {
                double dblR = Math.random() * len;
                int intR = (int) Math.floor(dblR);
                char c = strTable.charAt(intR);
                if (('0' <= c) && (c <= '9')) {
                    count++;
                }
                retStr += strTable.charAt(intR);
            }
            if (count >= 2) {
                bDone = false;
            }
        } while (bDone);

        return retStr;
    }

    /**
     * 根据值，从列表中遍历对应字段的Map
     *
     * @param list
     * @param column
     * @param value
     * @return
     */
    public static Map<String, Object> getMapFromList(List<Map<String, Object>> list, String column, String value) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        for (Map<String, Object> item : list) {
            if (MapUtils.getString(item, column, "").equals(value)) {
                return item;
            }
        }
        return null;
    }

    /**
     * 字符串连接，采用逗号分隔
     *
     * @param list
     * @return
     */
    public static String stringJoin(List<String> list) {
        if (CollectionUtils.isEmpty(list)) {
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        for (String str : list) {
            if (StringUtils.isEmpty(str)) {
                continue;
            }
            if (StringUtils.isNotEmpty(sb.toString())) {
                sb.append(",");
            }
            sb.append(str);
        }
        return sb.toString();
    }

    /**
     * 从字符串List删除str
     *
     * @param list
     * @param str
     * @return
     */
    public static List<String> removeItem(List<String> list, String str) {
        if (CollectionUtils.isNotEmpty(list)) {
            List<String> result = new ArrayList<String>();
            for (String item : list) {
                if (StringUtils.isNotEmpty(item) && item.equals(str)) {
                    continue;
                }
                result.add(item);
            }
            return result;
        }
        return list;
    }

    public static String generateCode(int count) {
        return generateCode(count, 3);
    }

    public static String generateCode(int count, int min) {
        int num = count + 1;
        String code = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        for (int i = code.length(); i < min; i++) {
            sb.append("0");
        }
        sb.append(code);
        return sb.toString();
    }
    
    /**
     * 将字符串数据组转成ArrayList
     *
     * @param array
     * @return
     */
    public static List<String> asArrayList(String[] array) {
        List<String> result = new ArrayList<String>();
        if (array != null && array.length > 0) {
            for (String item : array) {
                if (StringUtils.isEmpty(item)) {
                    continue;
                }
                result.add(item);
            }
        }
        return result;
    }

    /**
     * 获取文件完整URL
     *
     * @param url
     * @return
     */
    public static String getFileUrl(String url) {
        if (StringUtils.isEmpty(url)) {
            return "";
        }
        return CommonConfig.OSS_URL + "/" + url;
    }

    public static String getFileName(String filename) {
        return filename.substring(filename.lastIndexOf("/") + 1, filename.length());
    }
    /*
      获取图片的宽高
     */
    public static  Map<String,String> getWH(String dataurl){

        Map<String,String> map = new HashMap<String,String>();

        InputStream is = null;

        BufferedImage sourceImg = null;

        //获取阿里云上传媒体根路径
        String ossUrl  =  CommonConfig.getConfigString("oss.url");

        try {
            map.put("height","0");
            map.put("width","0");
            is = new URL(ossUrl+"/"+dataurl).openStream();
            sourceImg = ImageIO.read(is);
            System.out.println("系统上传图片宽度："+sourceImg.getWidth());
            System.out.println("系统上传图片高度："+sourceImg.getHeight());
            String height=Integer.toString( sourceImg.getHeight());
            String width=Integer.toString( sourceImg.getWidth());
            //获取图片宽高，并放入map中
            if(org.apache.commons.lang3.StringUtils.isNotEmpty(height)&& org.apache.commons.lang3.StringUtils.isNotEmpty(width)){
                map.put("height",height);
                map.put("width",width);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
    /*
      获取视频的宽高
     */
    public static  Map<String,String> getVideoWH(String dataurl){

        Map<String,String> map = new HashMap<String,String>();

        InputStream is = null;

        BufferedImage sourceImg = null;

        //获取阿里云上传媒体根路径
        String ossUrl  =  CommonConfig.getConfigString("oss.url");

        try {
            map.put("height","0");
            map.put("width","0");
            is = new URL(ossUrl+"/"+dataurl).openStream();
            sourceImg = ImageIO.read(is);
            System.out.println("系统上传图片宽度："+sourceImg.getWidth());
            System.out.println("系统上传图片高度："+sourceImg.getHeight());
            String height=Integer.toString( sourceImg.getHeight());
            String width=Integer.toString( sourceImg.getWidth());
            //获取图片宽高，并放入map中
            if(org.apache.commons.lang3.StringUtils.isNotEmpty(height)&& org.apache.commons.lang3.StringUtils.isNotEmpty(width)){
                map.put("height",height);
                map.put("width",width);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     */
    public static Map<String, String> getAliParams(HttpServletRequest request) throws UnsupportedEncodingException {
        //获取支付宝POST过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        return params;
    }

    public static boolean isNotEmpty(Object pObj) {
        if (pObj == null){
            return false;
        }
        if (pObj == ""){
            return false;
        }
        if (pObj instanceof String) {
            if (((String) pObj).length() == 0) {
                return false;
            }
        } else if (pObj instanceof Collection) {
            if (((Collection) pObj).size() == 0) {
                return false;
            }
        } else if (pObj instanceof Map) {
            if (((Map) pObj).size() == 0) {
                return false;
            }
        }
        return true;
    }
}
