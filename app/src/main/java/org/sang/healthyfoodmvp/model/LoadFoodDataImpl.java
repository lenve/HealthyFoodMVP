package org.sang.healthyfoodmvp.model;

import org.sang.healthyfoodmvp.model.util.JsonParse;
import org.sang.healthyfoodmvp.model.util.OkHttpUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 王松 on 2016/10/8.
 */

public class LoadFoodDataImpl implements ILoadFoodData {
    @Override
    public void getData(String httpUrl, final OnDataLoadListener onDataLoadListener) {
        final Request request = new Request.Builder()
                .url(httpUrl)
                .build();
        Call call = OkHttpUtil.getOkHttpClient().newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                onDataLoadListener.onFailed(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    onDataLoadListener.onSuccess(JsonParse.parseJson2FoodList(response.body().string()));
                } else {
                    onDataLoadListener.onFailed("数据加载失败");
                }
            }
        });
    }
}
