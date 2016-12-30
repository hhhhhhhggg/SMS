package com.jfq.msms.utils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016.12.29.
 */

public class MessageJsonAnalysis {


    //解析拿到flag值
    public static String flag(String json) throws JSONException {
        JSONObject j = new JSONObject(json);
        return j.getString("flag");
    }

    //解析拿到msg值
    public static String msg(String json) throws JSONException {
        JSONObject j = new JSONObject(json);
        return j.getString("msg");
    }
}
