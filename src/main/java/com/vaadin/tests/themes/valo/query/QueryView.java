package com.vaadin.tests.themes.valo.query;

import ve.com.pt.base.views.BaseContainerUI;

/** Contiene todas las vistas del módulo.
 * Created by ypetrilli on 23/05/2016.
 */
public class QueryView  extends BaseContainerUI {
    public QueryView(){
        super();
//        this.listView = new QueryListView();
        this.detailView = new QueryDetailView();
        this.filterView = new QueryFilterView();
    }
}