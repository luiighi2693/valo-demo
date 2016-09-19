package com.vaadin.tests.themes.valo;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import ve.com.pt.base.core.GridUI;

/**
 * Ejemplo para componente grid personalizado.
 * Created by ypetrilli on 19/09/2016.
 */
public class CustomGrid extends VerticalLayout implements View {

    GridUI gridUI;
    VerticalLayout mainLayout;

    public CustomGrid() {
        mainLayout = new VerticalLayout();
        mainLayout.setMargin(true);
        mainLayout.setSpacing(true);

        gridUI = new GridUI();
        gridUI.getGrid().setSizeFull();
        gridUI.getGrid().addColumn("Nombre", String.class);
        gridUI.getGrid().addColumn("Descripción", String.class);
        gridUI.getGrid().addColumn("Versión", String.class);
        gridUI.getGrid().setSelectionMode(Grid.SelectionMode.MULTI);

        gridUI.getGrid().addRow("com.vaadin", "vaadin-server", "7.4.0");
        gridUI.getGrid().addRow("com.vaadin", "vaadin-client-compiled", "7.4.0");
        gridUI.getGrid().addRow("com.vaadin", "vaadin-client", "7.7.0");

        Label label = new Label(
                "<pre>GridUI gridContainer = new GridUI();\n" +
                        "gridContainer.getGrid();\n" +
                        "<strong>La GridUI contiene los métodos: </strong>\n" +
                        "buildHeaderGrid(boolean showHeader);\n" +
                        "buildGrid();\n" +
                        "getGrid();\n" +
                        "setVisibleHeader(boolean showHeaderGrid);\n" +
                        "</pre>",
                ContentMode.HTML);

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponent(label);
        verticalLayout.setMargin(true);

        Panel panel = new Panel();
        panel.setContent(verticalLayout);

        mainLayout.addComponents(gridUI, panel);

        addComponent(mainLayout);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
