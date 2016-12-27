package com.jfq.msms.utils;

import com.google.gson.Gson;
import com.zhy.http.okhttp.callback.Callback;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import okhttp3.Response;

public abstract class GsonCallback<T> extends Callback<T> {
    @Override
    public T parseNetworkResponse(Response response) throws Exception {

        //获取我们的数据
        String result = response.body().string();
        Gson gson = new Gson();

        //获取传入类型 通过反射获取的
        Type genericSuperclass = getClass().getGenericSuperclass();//获取带有泛型的父类
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();  //获取泛型参数的数组，可能有多个
        Class<T> clazz = (Class<T>) actualTypeArguments[0];
        // 将数据转换成 对象
        T o = gson.fromJson(result, clazz);
        return o;
    }

}

