package com.vaadin.tests.themes.valo;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import tokenfield.src.org.vaadin.tokenfield.TokenField;

import java.util.Set;

public class AddressField extends VerticalLayout implements View {
    public Button button;
    public TokenField tagField;

    public Label direccion1;
    public Label direccion2;

    public TextField direccionText1;
    public TextField direccionText2;

    public AddressField() {
        setMargin(true);

        Label h1 =  new Label("Address Field");
        h1.addStyleName(ValoTheme.LABEL_H1);
        addComponent(h1);

        HorizontalLayout row = new HorizontalLayout();
        row.addStyleName(ValoTheme.LAYOUT_HORIZONTAL_WRAPPING);
        row.setSpacing(true);

        tagField = new TokenField() {

            @Override
            protected void onTokenInput(Object tokenId) {
                Set<Object> set = (Set<Object>) getValue();
                if (set != null && set.contains(tokenId.toString())){
                    Notification.show(getTokenCaption(tokenId)
                            + " ya existe");
                }
                else {
                    super.addToken(tokenId);
                }
            }

            protected void onTokenDelete(Object tokenId) {
                this.removeToken(tokenId);
            }

            protected void configureTokenButton(Object tokenId,Button button) {
                super.configureTokenButton(tokenId, button);
            }
        };

        tagField.setStyleName(TokenField.STYLE_TOKENFIELD);
        tagField.setSizeFull();
        row.addComponent(tagField);

        button = new Button("add");
        row.addComponent(button);
        button.addClickListener((Button.ClickListener) clickEvent -> subWindow());

        addComponent(row);
    }

    public void subWindow() {
        Window subWindow = new Window("Nueva Dirección");
        subWindow.setWidth("60%");
        subWindow.setHeight("60%");
        subWindow.setModal(true);

        VerticalLayout subContent = new VerticalLayout();
        subContent.setMargin(true);
        subContent.setHeight("100%");
        subWindow.setContent(subContent);

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSpacing(true);
        verticalLayout.setMargin(new MarginInfo(true,true));

        direccion1 = new Label("dirección 1");
        verticalLayout.addComponent(direccion1);
        direccionText1 = new TextField();
        verticalLayout.addComponent(direccionText1);

        verticalLayout.addComponent(new HorizontalLayout());

        direccion2 = new Label("dirección 2");
        verticalLayout.addComponent(direccion2);
        direccionText2 = new TextField();
        verticalLayout.addComponent(direccionText2);

        subContent.addComponent(verticalLayout);

        HorizontalLayout ho = new HorizontalLayout();
        ho.setStyleName("align-right");

        Button closeWindow = new Button("aceptar");
        closeWindow.addStyleName("v-button-primary");
        ho.addComponent(closeWindow);
        subContent.addComponent(ho);
        subContent.setComponentAlignment(ho, Alignment.BOTTOM_RIGHT);

        closeWindow.addClickListener((Button.ClickListener) event -> {

            tagField.addToken(direccionText1.getValue()+", "+direccionText2.getValue());
            direccionText1.clear();
            direccionText2.clear();
            subWindow.close();
        });
        subWindow.center();
        UI.getCurrent().addWindow(subWindow);
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

}
