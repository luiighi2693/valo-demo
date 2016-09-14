package com.vaadin.tests.themes.valo.testwizard;

import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.teemu.wizards.event.WizardCompletedEvent;
import org.vaadin.teemu.wizards.event.WizardProgressListener;
import ve.com.pt.base.new_views.WizardUI;

/**
 * Ejemplo de implementación para ventana wizard.
 */
public class WizardTest extends WizardUI implements WizardProgressListener {

    private static final long serialVersionUID = 1L;
    private VerticalLayout mainLayout;

    public WizardTest() {
        mainLayout = new VerticalLayout();
        addComponent(mainLayout);
    }

    @Override
    public void setWizardCaption(String caption) {
        super.setWizardCaption("TestWizard");
    }

    @Override
    public void buildWizard() {
        super.buildWizard();
        setMargin(true);
        wizard.addStep(new IntroStep(), "intro");
        wizard.addStep(new Step2(), "setup");
        wizard.addStep(new LastStep(), "listen");
    }

    @Override
    public void wizardCompleted(WizardCompletedEvent event) {
        endWizard("Completado");
    }

    @Override
    public void endWizard(String message) {
        super.endWizard(message);
        Button startOverButton = new Button("Ejecutar wizard", (ClickListener) event -> {
            VaadinSession.getCurrent().close();
            Page.getCurrent().setLocation("");
        });
        mainLayout.addComponent(startOverButton);
        mainLayout.setComponentAlignment(startOverButton, Alignment.MIDDLE_CENTER);
    }

}