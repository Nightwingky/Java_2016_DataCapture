package com.nightwingky.http;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by nightwingky on 16-12-30.
 */
public class HttpQuery {

    private static String url = "http://www.imooc.com/api/teacher?type=4&num=30";

    public static String getQueryContent() throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();

        HttpUrl httpUrl = HttpUrl.parse(url)
                .newBuilder()
                .build();

        Request request = new Request
                .Builder()
                .url(url)
                .build();
        Response response = okHttpClient.newCall(request).execute();

        return response.body().string();
    }
}
