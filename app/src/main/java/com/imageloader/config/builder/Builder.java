package com.imageloader.config.builder;

import android.view.View;

import com.imageloader.MyUtil;
import com.imageloader.config.Params;
import com.imageloader.config.SingleConfig;

/**
 * Created by Jungle on 2017/6/6.
 */

public class Builder {
    public Params params;

    private Builder() {
    }

    public Builder(Params params) {
        this.params = params;
    }

    public void into(View target) {
        params.target = target;
        new SingleConfig(params).excute();
    }

    public void setBitmapListener(Params.BitmapListener listener) {
        params.bitmapListener = MyUtil.getBitmapListenerProxy(listener);
        new SingleConfig(params).excute();
    }
}
