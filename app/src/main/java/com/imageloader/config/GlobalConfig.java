package com.imageloader.config;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;

import com.imageloader.i.ILoader;

/**
 * Created by Jungle on 2017/6/6.
 */

public class GlobalConfig {

    public static Context mContext;
    public static Handler mMainHanlder;

    public static Handler getMainHandler() {
        if (mMainHanlder == null) {
            synchronized (GlobalConfig.class) {
                if (mMainHanlder == null) {
                    mMainHanlder = new Handler(Looper.getMainLooper());
                }
            }
        }
        return mMainHanlder;
    }

    private static int mDisplayHeight;
    private static int mDisplayWidth;

    public static int getDisplayHeight() {
        if (mContext.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            return mDisplayHeight < mDisplayWidth ? mDisplayHeight : mDisplayWidth;
        } else if (mContext.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            return mDisplayHeight > mDisplayWidth ? mDisplayHeight : mDisplayWidth;
        }
        return mDisplayHeight;
    }

    public static int getDisplayWidth() {
        if (mContext.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            return mDisplayHeight > mDisplayWidth ? mDisplayHeight : mDisplayWidth;
        } else if (mContext.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            return mDisplayHeight < mDisplayWidth ? mDisplayHeight : mDisplayWidth;
        }
        return mDisplayWidth;
    }

    public static void init(Context context, int cacheSizeInM, ILoader imageLoader) {
        GlobalConfig.mContext = context;
        GlobalConfig.cacheSize = cacheSizeInM;

        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        GlobalConfig.mDisplayWidth = wm.getDefaultDisplay().getWidth();
        GlobalConfig.mDisplayHeight = wm.getDefaultDisplay().getHeight();

        GlobalConfig.loader = imageLoader;
        imageLoader.init(context, cacheSizeInM);
    }

    /**
     * lrucache 最大值
     */
    public static int cacheSize = 10;

    /**
     * 缓存文件夹
     */
    public static String cacheFolderName = "imageCache";

    /**
     * bitmap是888还是565编码,后者内存占用相当于前者一般,前者显示效果要好一点点,但两者效果不会差太多
     */
    public static boolean highQuality = false;

    /**
     * https是否忽略校验,默认不忽略
     */
    public static boolean ignoreCertificateVerify = false;

    private static ILoader loader;

    public static ILoader getLoader() {
        return loader;
    }
}
