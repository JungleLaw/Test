package com.imageloader.i;

import java.io.File;

/**
 * Created by Administrator on 2017/5/3.
 */

public interface FileGetter {

    void onSuccess(File file);

    //void onSuccess(InputStream is);

    void onFail();

}
