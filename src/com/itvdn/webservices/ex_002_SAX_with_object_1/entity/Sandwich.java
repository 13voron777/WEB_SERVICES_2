package com.itvdn.webservices.ex_002_SAX_with_object_1.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 03.12.2017.
 */
public class Sandwich {

    private String title;
    private List<Ingridient> ingridients;

    public Sandwich() {
        ingridients = new ArrayList<>();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addIngridient(Ingridient ingridient) {
        ingridients.add(ingridient);
    }

    public String getTitle() {
        return title;
    }

    public List<Ingridient> getIngridients() {
        return ingridients;
    }

}
