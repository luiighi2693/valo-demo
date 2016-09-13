package com.vaadin.tests.themes.valo.query;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Grid;
import com.vaadin.ui.renderers.NumberRenderer;
import ve.com.pt.base.views.BaseListUI;

/**
 * Listado de consultas
 * Created by ypetrilli on 23/05/2016.
 * Modified by ypetrilli on 01/08/2016.
 */
public class QueryListView extends BaseListUI  {
    public QueryListView() {
        super();
        setTitle("QUERY_LIST_VIEW_TITLE");
//        model = new QueryModel();
    }

    /**
     * Construye la grid con propiedades específicas como el tipo de selección y las dimensiones.
     */
    @Override
    public void buildGrid() {
        super.buildGrid();
        grid.setSizeFull();
        grid.setSelectionMode(Grid.SelectionMode.SINGLE);
        fillGrid();
    }

    /**
     * Carga a la grid construida la información especificada proveniente del modelo asociado a la entidad.
     */
    @Override
    public void fillGrid() {
        super.fillGrid();
        if (model != null) {
            grid.getColumn("ATTRIBUTE_ID").setRenderer(new NumberRenderer("%d")).setHeaderCaption("ID_LABEL").setWidth(80);
            grid.getColumn("ATTRIBUTE_CODE").setHeaderCaption("CODE_LABEL");
            grid.getColumn("ATTRIBUTE_TYPE").setHeaderCaption("TYPE_LABEL");
            grid.getColumn("ATTRIBUTE_SUBTYPE".toLowerCase()).setHeaderCaption("SUBTYPE_LABEL");
            grid.getColumn("ATTRIBUTE_SQLQUERY").setHeaderCaption("SQL_LABEL");
            grid.clearSortOrder();
        }
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
