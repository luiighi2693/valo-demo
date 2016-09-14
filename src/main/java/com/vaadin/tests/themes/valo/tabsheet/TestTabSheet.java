package com.vaadin.tests.themes.valo.tabsheet;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import ve.com.pt.base.views.BaseTabContainer;

/**
 * Ejemplo implementación tabSheet
 * Created by ypetrilli on 14/09/2016.
 */
public class TestTabSheet extends BaseTabContainer {
    private FirstTab firstTab;
    private SecondTab secondTab;

    @Override
    protected void buildTabSheet() {
        super.buildTabSheet();
        firstTab = new FirstTab();
        secondTab = new SecondTab();

        for (int i = 1; i <= 9; i++) {
            VerticalLayout content = new VerticalLayout();
            content.setMargin(true);
            content.setSpacing(true);
            String tabcaption;
            if (i == 1) {
                tabcaption = "Tab 1";
                content.addComponent(firstTab);
                TabSheet.Tab t = addTab(content, tabcaption);
                t.setEnabled(true);
            }
            if (i == 2) {
                tabcaption = "Tab 2";
                content.addComponent(secondTab);
                TabSheet.Tab t = addTab(content, tabcaption);
                t.setEnabled(true);
            }
        }

    }

}
