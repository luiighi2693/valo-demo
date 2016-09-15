package com.vaadin.tests.themes.valo.testwizard;

import com.vaadin.ui.FormLayout;
import com.vaadin.ui.themes.ValoTheme;
import org.vaadin.teemu.switchui.Switch;
import ve.com.pt.base.new_views.StepWizardUI;

public class Step2 extends StepWizardUI {

    @Override
    public String getCaption() {
        return "Paso 2";
    }

    @Override
    public FormLayout buildForm() {
        super.buildForm();

        form.setStyleName(ValoTheme.FORMLAYOUT_LIGHT, false);

        Switch switch1 = new Switch(null, false);
        form.addComponent(switch1);

        Switch switch2 = new Switch(null, true);
        form.addComponent(switch2);

        return form;
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