package com.vaadin.tests.themes.valo.testwizard;

import com.vaadin.ui.Component;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.VerticalLayout;
import ve.com.pt.base.new_views.StepWizardUI;

public class LastStep extends StepWizardUI {

    @Override
    public String getCaption() {
        return "Paso 3";
    }

    @Override
    public Component getContent() {
        VerticalLayout content = new VerticalLayout();
        content.setSizeFull();
        content.setMargin(true);

        RichTextArea rta = new RichTextArea();
        rta.setValue("<b>Some</b> <i>rich</i> textArea");
        content.addComponent(rta);

        return content;
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