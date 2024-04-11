package ru.ingver.autotest.pages.components;

public class Card {
    private final String title;
    private final String description;
    private final String price;
    private final String imgUrl;

    public Card(String title, String description, String price, String imgUrl) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
