package com.imageloader.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.MemoryCategory;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.imageloader.ImageLoader;
import com.imageloader.MyUtil;
import com.imageloader.config.GlobalConfig;
import com.imageloader.config.ScaleMode;
import com.imageloader.config.SingleConfig;
import com.imageloader.i.FileGetter;
import com.imageloader.i.ILoader;

import java.io.File;

/**
 * Created by Jungle on 2017/6/6.
 */

public class GlideImageLoaderImpl implements ILoader {
    @Override
    public void init(Context context, int cacheSizeInM) {
        Glide.get(context).setMemoryCategory(MemoryCategory.NORMAL);
    }

    @Override
    public void request(final SingleConfig config) {
        if (config.getParams().getBitmapListener() != null) {
            RequestManager requestManager = Glide.with(config.getParams().context);
            DrawableTypeRequest request = getDrawableTypeRequest(config, requestManager);
            if (config.getParams().getWidth() > 0 && config.getParams().getHeight() > 0) {
                request.override(config.getParams().getWidth(), config.getParams().getHeight());
            }

            SimpleTarget target = new SimpleTarget<Bitmap>() {
                @Override
                public void onResourceReady(Bitmap bitmap, GlideAnimation glideAnimation) {
                    // do something with the bitmap
                    // for demonstration purposes, let's just set it to an ImageView
                    // BitmapPool mBitmapPool = Glide.get(BigLoader.context).getBitmapPool();
                    //bitmap = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight())

                    config.getParams().getBitmapListener().onSuccess(bitmap);
                }

                @Override
                public void onLoadFailed(Exception e, Drawable errorDrawable) {
                    super.onLoadFailed(e, errorDrawable);
                    config.getParams().getBitmapListener().onFail();
                }
            };
            // setShapeModeAndBlur(config, request);
            request.asBitmap().into(target);

        } else {
            RequestManager requestManager = Glide.with(config.getParams().context);
            DrawableTypeRequest request = getDrawableTypeRequest(config, requestManager);

            if (request == null) {
                return;
            }

            int scaleMode = config.getParams().getMode();
            switch (scaleMode) {
                case ScaleMode.FIT_CENTER:
                    request.fitCenter();
                    break;
                case ScaleMode.CENTER_CROP:
                case ScaleMode.CENTER_INSIDE:
                case ScaleMode.FIT_XY:
                case ScaleMode.FIT_END:
                case ScaleMode.FOCUS_CROP:
                case ScaleMode.CENTER:
                case ScaleMode.FIT_START:
                    request.centerCrop();
                    break;
                default:
                    break;
            }

            if (config.getParams().getWidth() > 0 && config.getParams().getHeight() > 0) {
                request.override(config.getParams().getWidth(), config.getParams().getHeight());
            }

            if (config.getParams().getPlaceHolderResId() > 0) {
                request.placeholder(config.getParams().getPlaceHolderResId());
            } else {
            }

            if (config.getParams().getThumbnail() > 0) {
                request.thumbnail(config.getParams().getThumbnail());
            }

            if (config.getParams().getErrorResId() > 0) {
                request.error(config.getParams().getErrorResId());
            }

            if (config.getParams().getTarget() instanceof ImageView) {
                if (config.getParams().asBitmap) {
                    request.asBitmap().into((ImageView) config.getParams().getTarget());
                    return;
                } else if (config.getParams().asGif) {
                    request.asGif().into((ImageView) config.getParams().getTarget());
                    Log.i("TAG", "asGif");
                    return;
                }
                request.into((ImageView) config.getParams().getTarget());
            }
        }
    }

    @Nullable
    private DrawableTypeRequest getDrawableTypeRequest(SingleConfig config, RequestManager requestManager) {
        DrawableTypeRequest request = null;
        if (!TextUtils.isEmpty(config.getParams().getUrl())) {
            request = requestManager.load(config.getParams().getUrl());
            //request.diskCacheStrategy(DiskCacheStrategy.SOURCE);//只缓存原图
        } else if (config.getParams().getFile() == null) {
            request = requestManager.load(config.getParams().getFile());
        } else if (!TextUtils.isEmpty(config.getParams().getUri().getPath())) {
            request = requestManager.loadFromMediaStore(config.getParams().getUri());
        } else if (config.getParams().getResId() > 0) {
            request = requestManager.load(config.getParams().getResId());
        }
        return request;
    }

    @Override
    public void pause() {
        Glide.with(GlobalConfig.mContext).pauseRequestsRecursive();
    }

    @Override
    public void resume() {
        Glide.with(GlobalConfig.mContext).resumeRequestsRecursive();
    }

    @Override
    public void clearDiskCache() {
        Glide.get(ImageLoader.context).clearDiskCache();
    }

    @Override
    public void clearMomoryCache() {
        Glide.get(ImageLoader.context).clearMemory();
    }

    @Override
    public long getCacheSize() {
        return MyUtil.getCacheSize();
    }

    @Override
    public void clearCacheByUrl(String url) {

    }

    @Override
    public void clearMomoryCache(View view) {
        Glide.clear(view);
    }

    @Override
    public void clearMomoryCache(String url) {

    }

    @Override
    public File getFileFromDiskCache(String url) {
        return null;
    }

    @Override
    public void getFileFromDiskCache(String url, final FileGetter getter) {
        Glide.with(ImageLoader.context)
                .load(url)
                .downloadOnly(new SimpleTarget<File>() {
                    @Override
                    public void onResourceReady(File resource, GlideAnimation<? super File> glideAnimation) {
                        if (resource.exists() && resource.isFile()) {//&& resource.length() > 70
                            getter.onSuccess(resource);
                        } else {
                            getter.onFail();
                        }
                    }

                    @Override
                    public void onLoadFailed(Exception e, Drawable errorDrawable) {
                        getter.onFail();
                    }
                });
    }

    @Override
    public boolean isCached(String url) {
        return false;
    }

    @Override
    public void trimMemory(int level) {
        Glide.with(GlobalConfig.mContext).onTrimMemory(level);
    }

    @Override
    public void onLowMemory() {
        Glide.with(GlobalConfig.mContext).onLowMemory();
    }
}
