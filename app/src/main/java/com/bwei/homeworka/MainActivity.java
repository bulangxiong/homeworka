package com.bwei.homeworka;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.homeworka.bean.Result;
import com.bwei.homeworka.core.DataCall;
import com.bwei.homeworka.presenter.ParticularsPresenter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.item_title)
    TextView itemTitle;
    @BindView(R.id.item_price)
    TextView itemPrice;
    @BindView(R.id.item_yuan)
    TextView itemYuan;
    private ParticularsPresenter presenter;
    private List<String> imagesss = new ArrayList<>();
    private List<String> titles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new ParticularsPresenter(new CAll());
        init();
        dataBanner();
    }


    private void dataBanner() {
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                com.nostra13.universalimageloader.core.ImageLoader instance = com.nostra13.universalimageloader.core.ImageLoader.getInstance();
                instance.displayImage((String) path, imageView);
            }
        });

    }

    private void init() {
        presenter.request(1);
    }

    class CAll implements DataCall<Result> {

        @Override
        public void loadSuccess(Result data) {
            String title = data.getData().getTitle();
            double price = data.getData().getPrice();
            double bargainPrice = data.getData().getBargainPrice();
            String images = data.getData().getImages();
            String[] split = images.split("!");
            for (int i = 0; i < 3; i++) {
                imagesss.add(split[i]);

            }
            itemTitle.setText(title);
            itemPrice.setText(price + "");
            itemYuan.setText(bargainPrice + "");
            titles.add("1");
            titles.add("2");
            titles.add("3");
            banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
            banner.setImages(imagesss);
            banner.setBannerTitles(titles);
            banner.start();

        }

        @Override
        public void loadError(Throwable throwable) {

        }
    }
}
