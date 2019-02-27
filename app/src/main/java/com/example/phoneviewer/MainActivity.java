package com.example.phoneviewer;

import android.content.ClipData;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import java.util.ArrayList;
import java.util.List;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;
import android.support.v7.widget.RecyclerView.ViewHolder;

public class MainActivity extends AppCompatActivity {


    private ListView viewer;
    private ArrayList<String> nameList;
    private ArrayList<Integer> imageList;
    private ArrayList<String> descList;
    private String nameOf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewer = (ListView)findViewById(R.id.viewer);

        nameList = new ArrayList<String>();
        imageList = new ArrayList<Integer>();
        descList = new ArrayList<String>();

        nameOf = "";

        nameList.add("IPhone X");
        nameList.add("IPhone XS");
        nameList.add("IPhone XS Max");
        nameList.add("Google Pixel 3");
        nameList.add("Google Pixel 3 XL");
        nameList.add("Samsung Galaxy S9");
        nameList.add("Samsung Galaxy S9 Plus");
        nameList.add("Huawei P20 Pro");
        nameList.add("LG V40 ThinQ");
        nameList.add("Sony Xperia XZ3");


        descList.add("5.8 Inch Screen Size, $899");
        descList.add("5.8 Inch Screen Size, $999");
        descList.add("6.5 Inch Screen Size $1099");
        descList.add("5.5 Inch Screen Size $599");
        descList.add("6.3 Inch Screen Size $799");
        descList.add("5.8 Inch Screen Size $699");
        descList.add("6.2 Inch Screen Size $839");
        descList.add("6.1 Inch Screen Size $649");
        descList.add("6.4 Inch Screen Size $949");
        descList.add("6.0 Inch Screen Size $749");


        imageList.add(R.mipmap.iphonex_round);
        imageList.add(R.mipmap.iphonexs_round); //
        imageList.add(R.mipmap.iphonexsmax_round); //
        imageList.add(R.mipmap.googlepixel3);
        imageList.add(R.mipmap.googlexl_round);
        imageList.add(R.mipmap.samsunggalaxys9);
        imageList.add(R.mipmap.samsunggalaxyplus_round);
        imageList.add(R.mipmap.huawei_round);
        imageList.add(R.mipmap.lg_round);
        imageList.add(R.mipmap.sony_round);
//
//        imageList.add(R.drawable.iphonex);
//        imageList.add(R.drawable.iphonexs);
//        imageList.add(R.drawable.iphonexsmax);
//        imageList.add(R.drawable.googlepixel3);
//        imageList.add(R.drawable.googlepixel3xl);
//        imageList.add(R.drawable.samsunggalaxys9);
//        imageList.add(R.drawable.samsunggalaxys9plus);
//        imageList.add(R.drawable.huawei);
//        imageList.add(R.drawable.lgv40);
//        imageList.add(R.drawable.sony);


        ObjAdapter adapt = new ObjAdapter();

        viewer.setAdapter(adapt);
        viewer.setOnItemClickListener(new ClickListener());
        viewer.setClickable(true);
        registerForContextMenu(viewer);

        viewer.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                ItemObj objector = (ItemObj)viewer.getAdapter().getItem(position);
                nameOf = objector.getTitle();
                return false;
            }
        });



    }

    private class ClickListener implements AdapterView.OnItemClickListener
    {
        public void onItemClick(AdapterView<?> adapter, View v, int i, long l)
        {

            ItemObj clicked = (ItemObj)viewer.getAdapter().getItem(i);

            Intent newInt = new Intent(MainActivity.this, StatsView.class);

            newInt.putExtra("NameOfPhone", clicked.getTitle());

            startActivity(newInt);



        }

    }

    private class ObjAdapter extends BaseAdapter {
        public int getCount() {
            return nameList.size();
        }

        public ItemObj getItem(int i) {

            return new ItemObj(nameList.get(i), descList.get(i), imageList.get(i));

        }

        public long getItemId(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {

            ViewHolder viewH;


            if (view == null) {

                view = getLayoutInflater().inflate(R.layout.viewlayout, null);

                viewH = new ViewHolder();

                viewH.image = (ImageView) view.findViewById(R.id.imageView);
                viewH.title = (TextView) view.findViewById(R.id.titleView);
                viewH.desc = (TextView) view.findViewById(R.id.bodyView);

                viewH.image.setImageResource(imageList.get(i));
                viewH.title.setText(nameList.get(i));
                viewH.desc.setText(descList.get(i));

                view.setTag(viewH);

            }
            else {
                viewH = (ViewHolder) view.getTag();

            }

            viewH.position = i;
            return view;

        }
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.contextmenu, menu);

    }

    public boolean onContextItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.specs:
                Intent specInt = new Intent(MainActivity.this, Specifications.class);
                specInt.putExtra("NameOfPhone", nameOf);
                startActivity(specInt);
                break;
            case R.id.show:
                Intent showInt = new Intent(MainActivity.this, StatsView.class);
                showInt.putExtra("NameOfPhone", nameOf);
                startActivity(showInt);
                break;
            case R.id.web:

                String intent = nameOf;
                String browser = "";

                if (intent.equals("IPhone X"))
                {
                    browser = "https://www.apple.com/iphone/";
                }
                else if (intent.equals("IPhone XS"))
                {
                    browser = "https://www.apple.com/iphone-xs/";
                }
                else if (intent.equals("IPhone XS Max"))
                {
                    browser = "https://www.apple.com/shop/buy-iphone/iphone-xs#01";
                }
                else if (intent.equals("Google Pixel 3"))
                {
                    browser = "https://store.google.com/us/product/pixel_3?hl=en-US";
                }
                else if (intent.equals("Google Pixel 3 XL"))
                {
                    browser = "https://store.google.com/us/product/pixel_3?hl=en-US";
                }
                else if (intent.equals("Samsung Galaxy S9"))
                {
                    browser = "https://www.samsung.com/global/galaxy/galaxy-s9/";
                }
                else if (intent.equals("Samsung Galaxy S9 Plus"))
                {
                    browser = "https://www.samsung.com/global/galaxy/galaxy-s9/";
                }
                else if (intent.equals("Huawei P20 Pro"))
                {
                    browser = "https://consumer.huawei.com/en/phones/p20-pro/";
                }
                else if (intent.equals("LG V40 ThinQ"))
                {
                    browser = "https://www.lg.com/us/mobile-phones/v40-thinq";
                }
                else if (intent.equals("Sony Xperia XZ3"))
                {
                    browser = "https://www.sonymobile.com/us/products/phones/xperia-xz3/#gref";
                }

                Uri uriN = Uri.parse(browser);
                Intent webIntent = new Intent(Intent.ACTION_VIEW, uriN);
                startActivity(webIntent);

        }
        return true;
    }

    static class ViewHolder
    {
        TextView title;
        TextView desc;
        ImageView image;
        int position;
    }



}
