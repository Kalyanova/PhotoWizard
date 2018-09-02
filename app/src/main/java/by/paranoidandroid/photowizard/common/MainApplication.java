package by.paranoidandroid.photowizard.common;

import android.app.Application;

import by.paranoidandroid.photowizard.network.NetworkClient;
import by.paranoidandroid.photowizard.network.service.UnsplashService;

public class MainApplication extends Application {
    static UnsplashService api;

    @Override
    public void onCreate() {
        super.onCreate();
        api = NetworkClient.getClient().create(UnsplashService.class);
    }

    public static UnsplashService getApi() {
        return api;
    }
}
