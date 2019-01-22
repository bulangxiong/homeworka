package com.bwei.homeworka.app;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by zxk
 * on 2019/1/22 12:40
 * QQ:666666
 * Describe:
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader instance = ImageLoader.getInstance();
        instance.init(configuration);
    }
}
