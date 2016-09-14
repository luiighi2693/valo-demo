package com.vaadin.tests.themes.valo.tabsheet;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.VerticalLayout;

/**
 * Test para pantalla con TabSheet.
 * Created by ypetrilli on 14/09/2016.
 */
public class TabSheetView extends VerticalLayout implements View {

    private TestTabSheet testTabSheet;

    public TabSheetView(){
        setMargin(true);
        testTabSheet = new TestTabSheet();
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addStyleName("content-labels");
        verticalLayout.addComponent(testTabSheet);
        addComponent(verticalLayout);
    }

    @Override
    public void enter(final ViewChangeListener.ViewChangeEvent event) {
    }

}