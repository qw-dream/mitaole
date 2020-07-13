package com.qfedu.mitaole.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

    public static String md5(String str,String salt){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String password = str + salt;
            //获取去MD5加密对象
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //将需要加密的字符串放入Digest中，返回值是加密之后的密文
            byte[] bytes = messageDigest.digest(password.getBytes());

            for (int i = 0; i < bytes.length; i++) {
                String s = Integer.toHexString(bytes[i] & 0xFF);
                if (s.length() == 1){
                    s = "0" + s;
                }
                stringBuilder.append(s);
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

}