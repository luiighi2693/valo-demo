package com.vaadin.tests.themes.valo.testwizard;

import com.vaadin.ui.FormLayout;
import ve.com.pt.base.new_views.StepWizardUI;

public class LastStep extends StepWizardUI {

    @Override
    public String getCaption() {
        return "Paso 3";
    }

    @Override
    public FormLayout buildForm() {
        super.buildForm();

        return form;
    }

    public boolean onAdvance() {
        return true;
    }

    public boolean onBack() {
        return false;
    }

}