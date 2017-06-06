package com.imageloader.config;

/**
 * Created by Jungle on 2017/6/6.
 */

public class SingleConfig {
    private Params params;

    public Params getParams() {
        return params;
    }

    public SingleConfig(Params params) {
        this.params = params;
    }

    public void excute() {
        GlobalConfig.getLoader().request(this);
    }
}
