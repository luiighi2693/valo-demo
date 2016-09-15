package com.vaadin.tests.themes.valo;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.Date;

/**
 * Tipos de textfields
 * Created by ypetrilli on 15/09/2016.
 */
public class GroupTextFields extends VerticalLayout implements View {
    private VerticalLayout mainLayout;

    public GroupTextFields() {
        Label h1 = new Label("Group TextFields");
        h1.addStyleName(ValoTheme.LABEL_H1);

        mainLayout = new VerticalLayout();
        mainLayout.setMargin(true);
        mainLayout.setSpacing(true);

        mainLayout.addComponent(h1);

        CssLayout group = new CssLayout();
        group.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);

        TextField field = new TextField();
        field.setInputPrompt("parámetro");
        field.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
        field.setIcon(FontAwesome.SEARCH);
        field.setWidth("80%");

        group.addComponent(field);
        Button button = new Button(FontAwesome.FILTER);
        group.addComponent(button);

        CssLayout group2 = new CssLayout();
        group2.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);

        final DateField date2 = new DateField();
        group2.addComponent(date2);

        Button today = new Button("Hoy", (Button.ClickListener) event -> date2.setValue(new Date()));
        group2.addComponent(today);

        Label label = new Label(
                "<pre>CssLayout group = new CssLayout();\n" +
                        "group.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);\n" +
                        "\n" +
                        "TextField field = new TextField();\n" +
                        "field.setInputPrompt(\"parámetro\");\n" +
                        "field.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);\n" +
                        "\n" +
                        "group.addComponent(field);\n" +
                        "Button button = new Button(FontAwesome.FILTER);\n" +
                        "group.addComponent(button); </pre>" +
                        "\n" +
                        "<h4><strong>La agrupación se realiza a través del CssLayout, agregando a el los " +
                        "componentes que se deseen agrupar.</strong></h4>",
                ContentMode.HTML);

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponent(label);
        verticalLayout.setMargin(true);

        Panel panel = new Panel();
        panel.setContent(verticalLayout);

        mainLayout.addComponents(group, new VerticalLayout(), group2, new VerticalLayout(), panel);

        addComponent(mainLayout);

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
