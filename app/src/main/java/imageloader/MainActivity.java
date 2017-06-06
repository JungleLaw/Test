package imageloader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;


import com.example.jungle.test.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 图片加载库的封装演示案例
 * Created by soulrelay on 2016/12/11 19:18
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.iv_normal)
    ImageView ivNormal;
    @BindView(R.id.iv_gif)
    ImageView ivGif;
    @BindView(R.id.iv_circle)
    ImageView ivCircle;
    @BindView(R.id.iv_circle1)
    ImageView ivCircle1;
    @BindView(R.id.iv_circle2)
    ImageView ivCircle2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
//        ImageLoaderUtil.getInstance().loadImage("http://image.sports.baofeng.com/25a3dbb0c99c5e48e52e60941ed230be", R.drawable.bg_default_video_common_small, ivNormal);
        ImageLoaderUtil.getInstance().loadImage("http://image.sports.baofeng.com/19ce5d6ac3b4fff255196f200b1d3079", R.drawable.bg_default_video_common_small, ivNormal);
        ImageLoaderUtil.getInstance().loadGifImage("http://image.sports.baofeng.com/19ce5d6ac3b4fff255196f200b1d3079", R.drawable.bg_default_video_common_small, ivGif);
        ImageLoaderUtil.getInstance().loadCircleImage("http://image.sports.baofeng.com/25a3dbb0c99c5e48e52e60941ed230be", R.drawable.avata_default,
                ivCircle);
        ImageLoaderUtil.getInstance().loadCircleImage("http://image.sports.baofeng.com/25a3dbb0c99c5e48e52e60941ed230be", R.drawable.avata_default,
                ivCircle1);
        ImageLoaderUtil.getInstance().loadRoundRectImage("http://image.sports.baofeng.com/25a3dbb0c99c5e48e52e60941ed230be", R.drawable.avata_default,
                ivCircle2);
    }

}
