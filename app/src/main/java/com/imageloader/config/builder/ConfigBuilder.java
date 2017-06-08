package com.imageloader.config.builder;

import android.content.Context;

import com.imageloader.config.Params;

/**
 * 配置加载图片参数建造者
 * Created by Jungle on 2017/6/6.
 */
public class ConfigBuilder {
    public Params params;

    public ConfigBuilder() {
        params = new Params();
    }

    public RequestBuilder with(Context context) {
        params.context = context;
        return new RequestBuilder(params);
    }
}
