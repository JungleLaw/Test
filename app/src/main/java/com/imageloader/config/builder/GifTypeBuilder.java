package com.imageloader.config.builder;

import com.imageloader.config.Params;

/**
 * Created by Jungle on 2017/6/6.
 */

public class GifTypeBuilder extends DrawableBuilder {

    public GifTypeBuilder(Params params) {
        super(params);
    }

    public DrawableBuilder asBitmap() {
        params.asBitmap = true;
        return this;
    }

    public DrawableBuilder asGif() {
        params.asBitmap = true;
        return this;
    }
}
