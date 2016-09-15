package com.vaadin.tests.themes.valo;

/**
 * Bean test
 * Created by ypetrilli on 15/09/2016.
 */
public class Bean {

    Long value;
    String name;

    public Bean(Long value, String name){
        this.value = value;
        this.name = name;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
