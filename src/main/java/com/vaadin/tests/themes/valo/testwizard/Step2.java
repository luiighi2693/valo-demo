package com.vaadin.tests.themes.valo.testwizard;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import ve.com.pt.base.new_views.StepWizardUI;

public class Step2 extends StepWizardUI {

    @Override
    public String getCaption() {
        return "Paso 2";
    }

    @Override
    public Component getContent() {

        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setMargin(true);

        Label label = new Label(
                "<pre> Se construye el wizard step implementando la interfaz <strong>WizardStep</strong> y que" +
                        "contiene los siguientes métodos:\n\n" +
                        "   public String getCaption() {\n" +
                        "        return \"Initialize the Wizard\";\n" +
                        "    }\n" +
                        "\n" +
                        "    public Component getContent() {\n" +
                        "        VerticalLayout content = new VerticalLayout();\n" +
                        "        content.setMargin(true);\n" +
                        "\n" +
                        "        return content;\n" +
                        "    }\n " +
                        "" +
                        "public boolean onAdvance() {\n" +
                        "        return true;\n" +
                        "    }\n" +
                        "\n" +
                        "    public boolean onBack() {\n" +
                        "        return true;\n" +
                        "    }</pre>",
                ContentMode.HTML);

        Panel panel = new Panel();
        panel.setContent(label);

        mainLayout.addComponents(panel);

        return mainLayout;
    }

    @Override
    public boolean onAdvance() {
        return true;
    }

    @Override
    public boolean onBack() {
        return true;
    }
}