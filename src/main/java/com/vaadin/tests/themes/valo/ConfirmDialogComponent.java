package com.vaadin.tests.themes.valo;

import com.sun.jmx.mbeanserver.NamedObject;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.vaadin.addons.comboboxmultiselect.ComboBoxMultiselect;
import org.vaadin.dialogs.ConfirmDialog;

import java.util.ArrayList;
import java.util.List;

public class ConfirmDialogComponent extends VerticalLayout implements View {

    public ConfirmDialogComponent(){

        Label h1 = new Label("Pop Up Windows");
        h1.addStyleName(ValoTheme.LABEL_H1);

        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setMargin(true);
        mainLayout.setSpacing(true);

        mainLayout.addComponent(h1);

        Button button = new Button("Ventana de Pop Up");
        button.addClickListener((Button.ClickListener) clickEvent -> ConfirmDialog.show(UI.getCurrent(), "Pop Up de Confirmación", "Este es un ejemplo de confirmación","Si", "No", (ConfirmDialog.Listener) dialog -> {
            if (dialog.isConfirmed()) {
                Notification.show("confirmed");
            }else{
                Notification.show("not confirmed");
            }
        }));

        mainLayout.addComponent(button);

        Label label = new Label(
                "<pre>Button button = new Button(\"Ventana de Pop Up\");\n" +
                        "        button.addClickListener((Button.ClickListener) clickEvent -> ConfirmDialog.show(UI.getCurrent(), \"Pop Up de Confirmación\", " +
                        "\"<br>Este es un ejemplo de confirmación\",\"Si\", \"No\", (ConfirmDialog.Listener) dialog -> {\n" +
                        "            if (dialog.isConfirmed()) {\n" +
                        "                Notification.show(\"confirmed\");\n" +
                        "            }else{\n" +
                        "                Notification.show(\"not confirmed\");\n" +
                        "            }\n" +
                        "        }));</pre>"+
                        "<h4><strong>Parámetros para construir el ConfirmDialog :</strong></h4>"+
                        "<ul>" +
                        "<li>UI</li>"+
                        "<li>titulo</li>"+
                        "<li>okCaption</li>"+
                        "<li>cancelCaption</li>"+
                        "<li>eventListener</li>"+
                        "</ul>",
                ContentMode.HTML);

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponent(label);
        verticalLayout.setMargin(true);

        Panel panel = new Panel();
        panel.setContent(verticalLayout);

        mainLayout.addComponents(new VerticalLayout(), panel);

        addComponent(mainLayout);

        addComponent(new HorizontalLayout());


    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
