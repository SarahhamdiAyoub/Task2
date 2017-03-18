package com.example.lenovo.task.DataProcess;

/**
 * Created by Lenovo on 3/16/2017.
 */

public class DataEncap {
    int Id;
    String productDescription;
    String image;
    int price;
    int width,height;


    public String getProductDescription() {

        return productDescription;
    }

    public void setProductDescription(String productDescription){

        this.productDescription = productDescription;
    }

    public int getId() {

        return Id;
    }

    public void setId(int Id1) {

        this.Id = Id1;
    }


    public String getImage() {

        return image;
    }

    public void setImage(String image) {

        this.image = image;
    }

    public int getPrice() {

        return price;
    }

    public void setPrice(int price) {

        this.price = price;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public void setWidth(int width){
        this.width=width;
    }

    public int getHeight(){
        return height;
    }
    public int getWidth(){
        return width;
    }
}
