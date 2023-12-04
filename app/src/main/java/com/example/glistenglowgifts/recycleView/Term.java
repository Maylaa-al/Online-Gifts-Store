package com.example.glistenglowgifts.recycleView;

public class Term {
    private String name;
    private int image;
    private String currency;
    private double price;
    private String description;
    private double convertedPrice;



    public Term(String name, int image,String currency, double price, String description) {
        this.name = name;
        this.image = image;
        this.currency = currency;
        this.price = price;
        this.convertedPrice = price;
        this.description = description;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public String getCurrency() { return currency; }

    public double getPrice() { return price; }

    public void setImage(int image) {
        this.image = image;
    }

    public double getConvertedPrice() {
        return convertedPrice;
    }

    public void setConvertedPrice(double convertedPrice) {
        this.convertedPrice = convertedPrice;
    }



    public String getDescription() { return description; }

}
