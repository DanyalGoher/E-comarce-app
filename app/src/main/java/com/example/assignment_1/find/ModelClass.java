package com.example.assignment_1.find;

public class ModelClass {

    private final int imageview;
    private final String textview1;
    private final String textview2;
    private final String textview3;
    //new code
    private final String divider;



    ModelClass (int imageview ,String textview1,String textview2,String textview3,String divider)
    {
        this.imageview=imageview;
        this.textview1=textview1;
        this.textview2=textview2;
        this.textview3=textview3;
        this.divider=divider;
    }

    public int getImageview() {
        return imageview;
    }

    public String getTextview1() {
        return textview1;
    }

    public String getDivider()
    {
        return divider;
    }


    public String getTextview2() {
        return textview2;
    }

    public String getTextview3() {
        return textview3;
    }


}
