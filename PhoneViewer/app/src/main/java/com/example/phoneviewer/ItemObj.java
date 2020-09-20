package com.example.phoneviewer;

public class ItemObj {

    private int image;
    private String desc;
    private String title;


    public ItemObj(String title, String desc, int image)
    {
        this.title = title;
        this.desc = desc;
        this.image = image;
    }

    public String getTitle()
    {
        return title;
    }

    public int getImage()
    {
        return image;
    }

    public String getDesc()
    {
        return desc;
    }


}
