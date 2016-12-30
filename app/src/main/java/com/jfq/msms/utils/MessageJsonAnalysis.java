package com.jfq.msms.utils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016.12.29.
 */

public class MessageJsonAnalysis {

    public static String flag(String json) throws JSONException {
        JSONObject j = new JSONObject(json);
        return j.getString("flag");
    }

    public static String msg(String json) throws JSONException {
        JSONObject j = new JSONObject(json);
        return j.getString("msg");
    }
}
