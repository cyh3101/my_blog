package com.cyh.blog.utils;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Created by cai on 2017/7/4.
 */
public class CryptographyUtil {
    public static String encBase64(String str){
        return Base64.encodeToString(str.getBytes());
    }

    public static String decBase64(String str){
        return Base64.decodeToString(str.getBytes());
    }

    public static String md5(String str , String salt){
        return new Md5Hash(str , salt).toString();
    }
}
