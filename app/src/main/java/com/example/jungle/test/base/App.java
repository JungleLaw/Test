package com.example.jungle.test.base;

import android.app.Application;

import com.imageloader.ImageLoader;
import com.imageloader.impl.GlideImageLoaderImpl;
import com.zhy.autolayout.config.AutoLayoutConifg;

import imageloader.GlideImageLoaderStrategy2;
import imageloader.ImageLoaderUtil;

/**
 * Created by Jungle on 2017/6/2.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AutoLayoutConifg.getInstance().useDeviceSize();
        ImageLoader.init(this, 10, new GlideImageLoaderImpl());
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        ImageLoader.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        ImageLoader.trimMemory(level);
    }
}
