package com.vaadin.tests.themes.valo.test;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import org.vaadin.hene.popupbutton.PopupButton;
import ve.com.pt.base.new_views.ListUI;

/**
 * Pantalla listado de ejemplo
 */
public class TestList extends ListUI {

    public TestList() {
        super();
        setTitle("ListView");
    }

    @Override
    public void buildHeader(boolean showHeader) {
        super.buildHeader(true);
    }

    @Override
    public void buildHeaderGrid(boolean showHeaderGrid) {
        super.buildHeaderGrid(true);
        headerGrid.addComponents(new TextField(), new Button(FontAwesome.SEARCH));
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