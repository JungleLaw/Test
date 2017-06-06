package com.imageloader.i;

import android.content.Context;
import android.view.View;

import com.imageloader.config.Params;
import com.imageloader.config.SingleConfig;

import java.io.File;

/**
 * Created by Jungle on 2017/6/6.
 */

public interface ILoader {
    void init(Context context, int cacheSizeInM);

    void request(SingleConfig config);

    void pause();

    void resume();

    void clearDiskCache();

    void clearMomoryCache();

    long getCacheSize();

    void clearCacheByUrl(String url);

    void clearMomoryCache(View view);

    void clearMomoryCache(String url);

    File getFileFromDiskCache(String url);

    void getFileFromDiskCache(String url, FileGetter getter);


    boolean isCached(String url);

    void trimMemory(int level);

    void onLowMemory();
}
