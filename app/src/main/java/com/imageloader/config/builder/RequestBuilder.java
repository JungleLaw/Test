package com.imageloader.config.builder;

import android.net.Uri;
import android.support.annotation.DrawableRes;

import com.imageloader.config.Params;

import java.io.File;

/**
 * Created by Jungle on 2017/6/6.
 */

public class RequestBuilder extends Builder {

    public RequestBuilder(Params params) {
        super(params);
    }

    public ScaleBuilder load(@DrawableRes int resId) {
        params.resId = resId;
        return new ScaleBuilder(params);
    }

    public ScaleBuilder load(String url) {
        params.url = url;
        return new ScaleBuilder(params);
    }

    public ScaleBuilder load(File file) {
        params.file = file;
        return new ScaleBuilder(params);
    }

    public ScaleBuilder load(Uri uri) {
        params.uri = uri;
        return new ScaleBuilder(params);
    }

}
