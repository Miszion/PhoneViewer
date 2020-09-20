package com.example.phoneviewer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class Specifications extends AppCompatActivity {

    private String nameOf;
    private TextView specsView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specifications);

        nameOf = getIntent().getStringExtra("NameOfPhone");
        specsView = (TextView)findViewById(R.id.specsView);
        nameChecker();


    }

    public void nameChecker()
    {
                String intent = nameOf;
                String desc = "";
                String filename = "";

                if (intent.equals("IPhone X"))
                {
                    filename = "iphonexfile.txt";

                }
                else if (intent.equals("IPhone XS"))
                {
                   filename = "iphonexsfile.txt";
                }
                else if (intent.equals("IPhone XS Max"))
                {
                    filename = "iphonexsmaxfile.txt";
                }
                else if (intent.equals("Google Pixel 3"))
                {
                    filename = "googlepixel3file.txt";
                }
                else if (intent.equals("Google Pixel 3 XL"))
                {
                    filename = "googlepixel3xlfile.txt";
                }
                else if (intent.equals("Samsung Galaxy S9"))
                {
                    filename = "samsunggalaxys9file.txt";
                }
                else if (intent.equals("Samsung Galaxy S9 Plus"))
                {
                    filename = "samsunggalaxys9plusfile.txt";
                }
                else if (intent.equals("Huawei P20 Pro"))
                {
                    filename = "huaweifile.txt";
                }
                else if (intent.equals("LG V40 ThinQ"))
                {
                    filename = "lgfile.txt";
                }
                else if (intent.equals("Sony Xperia XZ3"))
                {
                   filename = "sonyxperiafile.txt";
                }

                try
                {
                    InputStream input = getAssets().open(filename);
                    int size = input.available();
                    byte[] buffer = new byte[size];
                    input.read(buffer);
                    input.close();
                    desc = new String(buffer);
                }
                catch(IOException ex)
                {
                    ex.printStackTrace();
                }

            specsView.setText(desc);


        }
    }



