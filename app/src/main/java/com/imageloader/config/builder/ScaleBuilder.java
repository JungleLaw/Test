package com.imageloader.config.builder;

import com.imageloader.config.Params;
import com.imageloader.config.ScaleMode;

/**
 * Created by Jungle on 2017/6/6.
 */

public class ScaleBuilder extends Builder {
    public ScaleBuilder(Params params) {
        super(params);
    }

    public DrawableBuilder fitCenter() {
        params.mode = ScaleMode.FIT_CENTER;
        return new DrawableBuilder(params);
    }


    public DrawableBuilder CenterCrop() {
        params.mode = ScaleMode.CENTER_CROP;
        return new DrawableBuilder(params);
    }


}
