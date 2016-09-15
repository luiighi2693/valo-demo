package com.vaadin.tests.themes.valo.test;

import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;
import ve.com.pt.base.new_views.FilterUI;

/**
 * Test Filter
 * Created by ypetrilli on 09/09/2016.
 */
public class TestFilter extends FilterUI {
    private TextField code;
    private TextField name;

    public TestFilter() {
        super();
        setTitle("Filtros");
    }

    @Override
    public void buildHeader(boolean showHeader) {
        super.buildHeader(true);
    }

    @Override
    public void buildForm() {
        super.buildForm();
        form.setStyleName(ValoTheme.FORMLAYOUT_LIGHT, false);

        code = new TextField("Código");
        code.setInputPrompt("código");
        form.addComponent(code);

        name = new TextField("Nombre");
        name.setInputPrompt("nombre");
        form.addComponent(name);
    }

}