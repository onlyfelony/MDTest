package com.example.administrator.mdtest;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Fruit implements Parcelable{

    private String fruitname;
    private int imageId;

    protected Fruit(Parcel in) {
        fruitname = in.readString();//读取fruitname
        imageId = in.readInt();//读取imageId
    }

    public static final Creator<Fruit> CREATOR = new Creator<Fruit>() {
        @Override
        public Fruit createFromParcel(Parcel in) {
            return new Fruit(in);
        }

        @Override
        public Fruit[] newArray(int size) {
            return new Fruit[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fruitname);//写出fruitname
        dest.writeInt(imageId);//写出imageId

    }

    public Fruit(String fruitname, int imageId) {
        this.fruitname = fruitname;
        this.imageId = imageId;
    }

    public String getFruitname() {
        return fruitname;
    }

    public void setFruitname(String fruitname) {
        this.fruitname = fruitname;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }


}
