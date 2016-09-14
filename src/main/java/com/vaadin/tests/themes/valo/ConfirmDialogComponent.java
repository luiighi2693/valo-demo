package com.vaadin.tests.themes.valo;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import org.vaadin.dialogs.ConfirmDialog;

public class ConfirmDialogComponent extends VerticalLayout implements View {

    public ConfirmDialogComponent(){
        addComponent(new HorizontalLayout());

        Button button = new Button("Ventana de Pop Up");
        button.addClickListener((Button.ClickListener) clickEvent -> ConfirmDialog.show(UI.getCurrent(), "Pop Up de Confirmación", "Este es un ejemplo de confirmación","Si", "No", (ConfirmDialog.Listener) dialog -> {
            if (dialog.isConfirmed()) {
                Notification.show("confirmed");
            }else{
                Notification.show("not confirmed");
            }
        }));

        addComponent(button);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
