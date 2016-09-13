package com.vaadin.tests.themes.valo.test;

import ve.com.pt.base.views.BaseContainerUI;

/**
 * TestView
 * Created by ypetrilli on 09/09/2016.
 */
public class TestView extends BaseContainerUI {

    public TestView(){
        super();
        this.listView = new TestList();
        this.detailView = new TestDetail();
        this.filterView = new TestFilter();
    }

}