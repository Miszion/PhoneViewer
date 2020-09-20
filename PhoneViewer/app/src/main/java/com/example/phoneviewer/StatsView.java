package com.example.phoneviewer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class StatsView extends AppCompatActivity {

    private ImageView image;
    private String sInt;
    private String browser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_view);

        image = (ImageView)findViewById(R.id.bigImage);
        sInt = getIntent().getStringExtra("NameOfPhone");
        checkImage(sInt);
        image.setOnClickListener(new ImageClicker());



    }

    public void checkImage(String intent)
    {

        if (intent.equals("IPhone X"))
        {
            image.setImageResource(R.drawable.iphonex);
            browser = "https://www.apple.com/iphone/";
        }
        else if (intent.equals("IPhone XS"))
        {
            image.setImageResource(R.drawable.iphonexs);
            browser = "https://www.apple.com/iphone-xs/";
        }
        else if (intent.equals("IPhone XS Max"))
        {
            image.setImageResource(R.drawable.iphonexs);
            browser = "https://www.apple.com/shop/buy-iphone/iphone-xs#01";
        }
        else if (intent.equals("Google Pixel 3"))
        {
            image.setImageResource(R.drawable.googlepixel3);
            browser = "https://store.google.com/us/product/pixel_3?hl=en-US";
        }
        else if (intent.equals("Google Pixel 3 XL"))
        {
            image.setImageResource(R.drawable.googlepixel3xl);
            browser = "https://store.google.com/us/product/pixel_3?hl=en-US";
        }
        else if (intent.equals("Samsung Galaxy S9"))
        {
            image.setImageResource(R.drawable.samsunggalaxys9);
            browser = "https://www.samsung.com/global/galaxy/galaxy-s9/";
        }
        else if (intent.equals("Samsung Galaxy S9 Plus"))
        {
            image.setImageResource(R.drawable.samsunggalaxys9plus);
            browser = "https://www.samsung.com/global/galaxy/galaxy-s9/";
        }
        else if (intent.equals("Huawei P20 Pro"))
        {
            image.setImageResource(R.drawable.huawei);
            browser = "https://consumer.huawei.com/en/phones/p20-pro/";
        }
        else if (intent.equals("LG V40 ThinQ"))
        {
            image.setImageResource(R.drawable.lgv40);
            browser = "https://www.lg.com/us/mobile-phones/v40-thinq";
        }
        else if (intent.equals("Sony Xperia XZ3"))
        {
            image.setImageResource(R.drawable.sony);
            browser = "https://www.sonymobile.com/us/products/phones/xperia-xz3/#gref";
        }

    }

    private class ImageClicker implements View.OnClickListener
    {
        public void onClick(View v)
        {
            Uri newUri = Uri.parse(browser);
            Intent browserInt = new Intent(Intent.ACTION_VIEW, newUri);
            startActivity(browserInt);
        }
    }


}
