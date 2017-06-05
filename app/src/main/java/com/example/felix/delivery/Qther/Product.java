package com.example.felix.delivery.Qther;

import android.graphics.Bitmap;

/**
 * Created by gladi on 02.05.2017.
 */

public class Product {
    // TODO: В геттера и сеттерах нет нужды. Сеттер и геттер юзается тогда, когда из одного типа данных нужно получить другой
    private Bitmap image;
    private String name;
    private String prise;
    private String dom;

    /**
     * Коструктор, копирующий уже существующий Product, но без метаинформации
     * @param product Элемент, который будет скопирован
     */
    public Product(Product product) {
        this.image = product.getImage();
        this.name = product.getName();
        this.prise = product.getPrise();
        this.dom = product.getDom();
    }

    public String getDom() {
        return dom;
    }

    public void setDom(String dom) {
        this.dom = dom;
    }

    public Product(Bitmap image, String name, String prise, String dom) {
        this.image = image;
        this.name = name;
        this.prise = prise;
        this.dom = dom;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrise() {
        return prise;
    }

    public void setPrise(String prise) {
        this.prise = prise;
    }
}
