package com.vaadin.tests.themes.valo.test;

import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import ve.com.pt.base.new_views.ListUI;

/**
 * Pantalla listado de ejemplo
 */
public class TestList extends ListUI {

    public TestList() {
        super();
        setTitle("Listado");
        gridContainer.headerGrid.addComponent(new Label("hola"));
        gridContainer.setVisibleHeader(false);
    }

    @Override
    public void buildHeader(boolean showHeader) {
        super.buildHeader(true);
    }

    public void buildHeaderGrid(boolean showHeaderGrid) {
        gridContainer.buildHeaderGrid(showHeaderGrid);
    }

    @Override
    public void buildGrid() {
        super.buildGrid();
        gridContainer.getGrid().setSizeFull();
        gridContainer.getGrid().addColumn("Name", String.class);
        gridContainer.getGrid().addColumn("Description", String.class);
        gridContainer.getGrid().addColumn("Version", String.class);
        gridContainer.getGrid().setSelectionMode(Grid.SelectionMode.MULTI);
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