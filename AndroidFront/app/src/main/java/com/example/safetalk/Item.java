package com.example.safetalk;

public class Item {
    String text;
    int id;

    public void setText(String text) {
        this.text = text;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public Item(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}






//public class Item {
//    String text;
//
//    public String getText() {
//        return text;
//    }
//
//    public Item(String text) {
//        this.text = text;
//    }
//
//    public Item() {}
//}
