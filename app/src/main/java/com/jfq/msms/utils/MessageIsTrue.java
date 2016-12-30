package com.jfq.msms.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016.12.29.
 */

public class MessageIsTrue {

    //判断电话号码正确
    public static boolean phone(String phone){
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    //判断2次密码是否正确
    public static boolean password(String password,String again_password){
        if(password.equals(again_password)){
            return true;
        }
        return false;
    }

    //判断验证码是否正确
    public static boolean verifycode(String verifycode,String verifycode2){
        if(verifycode.equals(verifycode2)){
            return true;
        }
        return false;
    }
}
