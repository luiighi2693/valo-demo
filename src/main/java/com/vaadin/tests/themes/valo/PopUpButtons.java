package com.vaadin.tests.themes.valo;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Demo para popUp buttons
 * Created by ypetrilli on 15/09/2016.
 */
public class PopUpButtons extends VerticalLayout implements View {

    public PopUpButtons(){
        setMargin(true);
        Label h2 = new Label("PopUp Buttons");
        h2.addStyleName(ValoTheme.LABEL_H2);
        addComponent(h2);

        HorizontalLayout wrap = new HorizontalLayout();
        wrap.addStyleName(ValoTheme.LAYOUT_HORIZONTAL_WRAPPING);
        wrap.setSpacing(true);
        addComponent(wrap);

        wrap.addComponent(getMenuButton("Normal", false));

        MenuBar split = getMenuButton("Small", false);
        split.addStyleName(ValoTheme.MENUBAR_SMALL);
        wrap.addComponent(split);

        split = getMenuButton("Borderless", false);
        split.addStyleName(ValoTheme.MENUBAR_BORDERLESS);
        wrap.addComponent(split);

        Label label = new Label(
                "<pre>MenuBar split = new MenuBar();\n" +
                        "MenuBar.MenuItem dropdown = split.addItem(caption, null);\n" +
                        "if (splitButton) {\n" +
                        "   dropdown = split.addItem(\"\", null);\n" +
                        "}\n" +
                        "dropdown.addItem(\"Secondary Action\", null);\n" +
                        "     dropdown.addItem(\"Another Action\", null);   </pre>",
                ContentMode.HTML);

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponent(label);
        verticalLayout.setMargin(true);

        Panel panel = new Panel();
        panel.setContent(verticalLayout);
        addComponent(panel);
    }

    static MenuBar getMenuButton(String caption, boolean splitButton) {
        MenuBar split = new MenuBar();
        MenuBar.MenuItem dropdown = split.addItem(caption, null);
        if (splitButton) {
            dropdown = split.addItem("", null);
        }
        dropdown.addItem("Secondary Action", null);
        dropdown.addItem("Another Action", null);
        dropdown.addSeparator();
        dropdown.addItem("Last Action", null);

        return split;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
