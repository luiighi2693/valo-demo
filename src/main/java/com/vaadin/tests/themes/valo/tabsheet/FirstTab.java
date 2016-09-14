package com.vaadin.tests.themes.valo.tabsheet;

import com.vaadin.tests.themes.valo.testmaintenance.TestMaintenance;
import com.vaadin.ui.VerticalLayout;

/**
 * Tab example
 * Created by ypetrilli on 14/09/2016.
 */
public class FirstTab extends VerticalLayout {

    public FirstTab(){
        addComponent(new TestMaintenance());
    }

}
