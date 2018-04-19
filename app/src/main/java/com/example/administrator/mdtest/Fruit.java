package com.example.administrator.mdtest;

public class Fruit {

    private String fruitname;
    private int imageId;

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
