package com.vaadin.tests.themes.valo.testwizard;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import ve.com.pt.base.new_views.StepWizardUI;

public class IntroStep extends StepWizardUI {

    @Override
    public String getCaption() {
        return "Paso 1: Intro";
    }

    @Override
    public Component getContent() {

        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setMargin(true);

        Label label = new Label(
                "<pre> " +
                        "Wizard wizard = new Wizard();\n" +
                        "\n" +
                        "wizard.addStep(new FirstStep());\n" +
                        "wizard.addStep(new SecondStep());\n" +
                        "wizard.addStep(new ThirdStep());\n" +
                        "\n" +
                        "mainLayout.addComponent(wizard); </pre>",
                ContentMode.HTML);

        Panel panel = new Panel();
        panel.setContent(label);

        mainLayout.addComponents(panel);

        return mainLayout;
    }

    @Override
    public FormLayout buildForm() {
        super.buildForm();
        form.setStyleName(ValoTheme.FORMLAYOUT_LIGHT,false);
        return form;
    }

    @Override
    public boolean onAdvance() {
        return super.onAdvance();
    }

    @Override
    public boolean onBack() {
        return super.onBack();
    }

}