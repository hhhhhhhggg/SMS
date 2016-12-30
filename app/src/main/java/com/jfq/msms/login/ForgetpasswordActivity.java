package com.jfq.msms.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jfq.msms.R;
import com.jfq.msms.url.URLs;
import com.jfq.msms.utils.MessageIsTrue;
import com.jfq.msms.utils.MessageJsonAnalysis;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;

public class ForgetpasswordActivity extends AppCompatActivity {
    private EditText forgetpassword_et_phone, forgetoassword_et_verifycode, forgetpassword_et_password, forgetpassword_et_passwordtrue;
    String phone;
    String password;
    String passwordtrue;
    String verifycode;
    String getverifycode;
    String flag;
    private SharedPreferences sharepreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);

        init();
    }

    //初始化
    public void init() {
        forgetpassword_et_phone = (EditText) findViewById(R.id.forgetpassword_et_phone);
        forgetoassword_et_verifycode = (EditText) findViewById(R.id.forgetoassword_et_verifycode);
        forgetpassword_et_password = (EditText) findViewById(R.id.forgetpassword_et_password);
        forgetpassword_et_passwordtrue = (EditText) findViewById(R.id.forgetpassword_et_passwordtrue);
        sharepreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        editor = sharepreferences.edit();
    }

    //提交修改密码信息
    public void forgetpassword_true(View view) {
        phone = forgetpassword_et_phone.getText().toString();
        password = forgetpassword_et_password.getText().toString();
        passwordtrue = forgetpassword_et_passwordtrue.getText().toString();
        verifycode = forgetpassword_et_passwordtrue.getText().toString();

    }

    //返回
    public void forgetpassword_back(View view) {
        finish();
    }

    //获取验证码
    public void getverifycode(View view) {
        phone = forgetpassword_et_phone.getText().toString();
        if (!MessageIsTrue.phone(phone)) {
            Toast.makeText(this, "手机号不正确", Toast.LENGTH_SHORT).show();
        } else {
            OkHttpUtils.post().url(URLs.BASE_URL + URLs.USER + URLs.VERIFYCOD)
                    .addParams("phone", phone)
                    .addParams("type", "2")
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e) {
                            Toast.makeText(ForgetpasswordActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onResponse(Call call, String s) {
                            try {
                                String flag = MessageJsonAnalysis.flag(s);
                                String msg = MessageJsonAnalysis.msg(s);
                                if (flag.equals("10")) {
                                    Toast.makeText(ForgetpasswordActivity.this, msg, Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(ForgetpasswordActivity.this, msg, Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        }
    }
}
