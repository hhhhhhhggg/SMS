package com.jfq.msms.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jfq.msms.R;
import com.jfq.msms.bean.Loginbean;
import com.jfq.msms.url.URLs;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

public class LoginActivity extends AutoLayoutActivity {

    private EditText login_et_phone,login_et_password;
    private SharedPreferences sharepreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

    }

    //初始化
    private void init() {
        login_et_phone = (EditText) findViewById(R.id.login_et_phone);
        login_et_password = (EditText) findViewById(R.id.login_et_password);
        sharepreferences = getSharedPreferences("usertoken", Context.MODE_PRIVATE);
        editor = sharepreferences.edit();
    }

    //忘记密码
    public void forgetpassword(View view) {
    }

    //登录
    public void login(View view) {
        OkHttpUtils.post()
                .url(URLs.BASE_URL + URLs.USER + URLs.LOGIN)
                .addParams("phone", login_et_phone.getText().toString())
                .addParams("pwd", login_et_password.getText().toString())
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {
                        Toast.makeText(LoginActivity.this, "网络异常", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(Call call, String s) {
                        if(s!= null){
                            Gson g = new Gson();
                            Loginbean loginbean = g.fromJson(s,Loginbean.class);
                            if(loginbean.getFlag().equals("3")){
                                Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                                editor.putString("token",loginbean.getData().getToken());
                                editor.putString("user",login_et_phone.getText().toString());
                                editor.putString("password",login_et_password.getText().toString());
                                Log.i("xxx","======"+loginbean.getData().getToken());
                            }else {
                                Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }

    //注册
    public void register(View view) {
    }

    //返回
    public void login_back(View view) {
        finish();
    }
}
