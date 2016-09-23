package com.vaadin.tests.themes.valo;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class JspComponent extends VerticalLayout implements View {

    public JspComponent() {
        setMargin(true);

        Label h1 = new Label("External Resource");
        h1.addStyleName(ValoTheme.LABEL_H1);
        addComponent(h1);

        VerticalLayout wrap = new VerticalLayout();

        BrowserFrame browser = new BrowserFrame(null, new ExternalResource("http://200.74.198.170/saut/home.jsp"));
        browser.setWidth("100%");
        browser.setHeight("100%");

        wrap.addComponent(browser);
        addComponent(wrap);
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

}