package com.util;

import java.security.MessageDigest;

/**
 * Created by huyan on 2015/5/7.
 */
public class ParseMD5 {

    public static String parseStrToMd5L32(String str){
        String reStr = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(str.getBytes());

            StringBuilder builder = new StringBuilder();
            for (byte b : bytes){
                int bt = b&0xff;
                if (bt < 16){
                    builder.append(0);
                }
                builder.append(Integer.toHexString(bt));
            }
            reStr = builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reStr;
    }

    public static void main(String[] args){
        System.out.println(parseStrToMd5L32("admin@123"));
    }

}
