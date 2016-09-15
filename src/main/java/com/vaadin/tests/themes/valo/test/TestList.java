package com.vaadin.tests.themes.valo.test;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;
import ve.com.pt.base.new_views.ListUI;

/**
 * Pantalla listado de ejemplo
 */
public class TestList extends ListUI {

    public TestList() {
        super();
        setTitle("Listado");
    }

    @Override
    public void buildHeader(boolean showHeader) {
        super.buildHeader(true);
    }

    @Override
    public void buildHeaderGrid(boolean showHeaderGrid) {
        super.buildHeaderGrid(true);

        CssLayout group = new CssLayout();
        group.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);

        TextField field = new TextField("Parámetro");
        field.setInputPrompt("parámetro");
        field.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
        field.setWidth("55%");

        group.addComponent(field);
        Button button = new Button(FontAwesome.SEARCH);
        group.addComponent(button);

        headerGrid.addComponents(group);
    }

    @Override
    public void buildGrid() {
        super.buildGrid();
        grid.setSizeFull();
        grid.addColumn("Name", String.class);
        grid.addColumn("Description", String.class);
        grid.addColumn("Version", String.class);
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
    }

    @Override
    public void fillGrid() {
        super.fillGrid();
    }

    @Override
    public void buildFooter(boolean showFooter) {
        super.buildFooter(true);
    }
}