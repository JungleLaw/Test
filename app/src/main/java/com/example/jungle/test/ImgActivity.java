package com.example.jungle.test;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.imageloader.ImageDisplayUtils;
import com.imageloader.ImageLoader;
import com.imageloader.config.Params;

import me.imid.swipebacklayout.lib.app.SwipeBackAutoLayotActivity;

/**
 * Created by Jungle on 2017/6/7.
 */
public class ImgActivity extends SwipeBackAutoLayotActivity {

    private static final String IMG_URL = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496812211400&di=a82365ea201d93d00bdac168f5fc1619&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F568b21088b65c.jpg";
    private static final String IMG_URL2 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496812208004&di=ed807cf96d56cb4605d8d0d7fe154bad&imgtype=0&src=http%3A%2F%2Fwww.ah.xinhuanet.com%2F2014-09%2F24%2F1112606690_14115307357331n.jpg";
    private static final String GIF_URL = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496829549251&di=dacc3d5fb262df6b44edea18ec3d9095&imgtype=0&src=http%3A%2F%2Fimg.weixinyidu.com%2F160412%2F0f1d3e93.jpg";
    private static final String GIF_URL2 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1497425579&di=87d2f38ff537fc731dce411e725ce775&imgtype=jpg&er=1&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201511%2F30%2F20151130011137_uCkiF.gif";

    private ImageView imageView;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView gifView;
    private ImageView gifView2;
    private ImageView gifView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);
        imageView = (ImageView) findViewById(R.id.img);
        imageView2 = (ImageView) findViewById(R.id.img2);
        imageView3 = (ImageView) findViewById(R.id.img3);
        gifView = (ImageView) findViewById(R.id.gif);
        gifView2 = (ImageView) findViewById(R.id.gif2);
        gifView3 = (ImageView) findViewById(R.id.gif3);
//        ImageLoader.with(this)
//                .load(IMG_URL2)
//                .centerCrop()
//                .placeHolder(R.drawable.bg_default_video_common_small)
//                .error(R.drawable.avata_default)
//                .into(imageView);
        ImageDisplayUtils.display(this, IMG_URL, imageView);

        ImageLoader.with(this).load(IMG_URL2)
                .fitCenter()
                .placeHolder(R.drawable.bg_default_video_common_small)
                .error(R.drawable.avata_default)
                .setBitmapListener(new Params.BitmapListener() {
                    @Override
                    public void onSuccess(Bitmap bitmap) {
                        imageView2.setImageBitmap(bitmap);
                    }

                    @Override
                    public void onFail() {
                        Toast.makeText(ImgActivity.this, "failed", Toast.LENGTH_SHORT).show();
                    }
                });
//        ImageDisplayUtils.displayWithMode(this, IMG_URL2, imageView2, ImageDisplayUtils.MODE.MODE_BITMAP);

//        ImageLoader.with(this)
//                .load(IMG_URL)
//                .placeHolder(R.drawable.bg_default_video_common_small)
//                .error(R.drawable.avata_default)
//                .into(imageView2);

        Glide.with(this)
                .load(IMG_URL2)
//                .centerCrop()
//                .placeholder(R.drawable.bg_default_video_common_small)
//                .error(R.drawable.avata_default)
                .into(imageView3);


//        ImageLoader.with(this)
//                .load(GIF_URL)
//                .asGif()
//                .placeHolder(R.drawable.bg_default_video_common_small)
//                .error(R.drawable.avata_default)
//                .into(gifView);
//        ImageDisplayUtils.display(this, GIF_URL, gifView
//                , R.drawable.bg_default_video_common_small
//                , R.drawable.avata_default
//                , ImageDisplayUtils.MODE.MODE_GIF, 0, 0);
        ImageDisplayUtils.displayWithMode(this, GIF_URL, gifView
                , ImageDisplayUtils.MODE.MODE_GIF);

//        ImageLoader.with(this)
//                .load(GIF_URL)
//                .asBitmap()
//                .placeHolder(R.drawable.bg_default_video_common_small)
//                .error(R.drawable.avata_default)
//                .into(gifView2);
//        ImageDisplayUtils.display(this, GIF_URL, gifView2
//                , R.drawable.bg_default_video_common_small
//                , R.drawable.avata_default
//                , ImageDisplayUtils.MODE.MODE_BITMAP, 0, 0);
        ImageDisplayUtils.displayWithMode(this, GIF_URL, gifView2
                , ImageDisplayUtils.MODE.MODE_BITMAP);

        Glide.with(this)
                .asBitmap()
                .load(GIF_URL)
//                .asGif()
//                .placeholder(R.drawable.bg_default_video_common_small)
//                .error(R.drawable.avata_default)
                .into(gifView3);
    }
}
