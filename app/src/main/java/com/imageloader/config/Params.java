package com.imageloader.config;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;

import java.io.File;

/**
 * Created by Jungle on 2017/6/6.
 */

public class Params {
    public Context context;
    public boolean ignoreCertificateVerify = GlobalConfig.ignoreCertificateVerify;
    public String url;
    public File file;
    public Uri uri;
    public int resId;
    public float thumbnail = -1;
    public boolean asGif = false;
    public boolean asBitmap = false;
    public View target;
    public BitmapListener bitmapListener;
    public int width;
    public int height;
    public int mode;

    public int placeHolderResId;
    public int loadingResId;
    public int errorResId;

    public float getThumbnail() {
        return thumbnail;
    }

    public String getUrl() {
        return url;
    }

    public File getFile() {
        return file;
    }

    public Uri getUri() {
        return uri;
    }

    public int getResId() {
        return resId;
    }

    public int getMode() {
        return mode;
    }

    public int getPlaceHolderResId() {
        return placeHolderResId;
    }

    public int getLoadingResId() {
        return loadingResId;
    }

    public int getErrorResId() {
        return errorResId;
    }

    public View getTarget() {
        return target;
    }

    public BitmapListener getBitmapListener() {
        return bitmapListener;
    }

    public int getHeight() {
        if (height <= 0) {
            //先去imageview里取,如果为0,则赋值成matchparent
            if (target != null) {
                height = target.getMeasuredWidth();
            }
            if (height <= 0) {
                height = GlobalConfig.getDisplayWidth();
            }
        }
        return height;
    }

    public int getWidth() {
        if (width <= 0) {
            //先去imageview里取,如果为0,则赋值成matchparent
            if (target != null) {
                width = target.getMeasuredWidth();
            }
            if (width <= 0) {
                width = GlobalConfig.getDisplayWidth();
            }
        }
        return width;
    }

    public interface BitmapListener {
        void onSuccess(Bitmap bitmap);

        void onFail();
    }
}
