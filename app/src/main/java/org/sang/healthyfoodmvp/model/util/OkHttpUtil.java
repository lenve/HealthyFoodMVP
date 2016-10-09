package org.sang.healthyfoodmvp.model.util;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by 王松 on 2016/10/8.
 */

public class OkHttpUtil {
    public static OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .build();
    public static OkHttpClient getOkHttpClient() {
        return client;
    }
}
