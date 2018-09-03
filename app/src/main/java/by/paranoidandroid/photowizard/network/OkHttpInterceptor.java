package by.paranoidandroid.photowizard.network;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        final String QUERY_KEY_ACCESS_KEY = "client_id",
                     QUERY_VALUE_ACCESS_KEY ="9d49bfead5a1db3e395bb97bcea8fa1242b1434bf310445fe117511fe7434c9f";
        Request request = chain.request();
        HttpUrl url = chain.request().url()
                .newBuilder()
                .addQueryParameter(QUERY_KEY_ACCESS_KEY, QUERY_VALUE_ACCESS_KEY)
                .build();
        return chain.proceed(request.newBuilder().url(url).build());
    }
}
