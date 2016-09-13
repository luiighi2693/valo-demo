package com.vaadin.tests.themes.valo.testwizard;

import com.vaadin.ui.FormLayout;
import com.vaadin.ui.themes.ValoTheme;
import eu.maxschuster.vaadin.autocompletetextfield.AutocompleteSuggestionProvider;
import eu.maxschuster.vaadin.autocompletetextfield.AutocompleteTextField;
import eu.maxschuster.vaadin.autocompletetextfield.provider.CollectionSuggestionProvider;
import eu.maxschuster.vaadin.autocompletetextfield.provider.MatchMode;
import ve.com.pt.base.new_views.StepWizardUI;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

public class IntroStep extends StepWizardUI {

    private AutocompleteTextField field;
    Collection<String> theJavas = Arrays.asList("j", "JavaScript", "Join Java", "JavaFX Script");

    @Override
    public String getCaption() {
        return "Paso 1: Intro";
    }

    @Override
    public FormLayout buildForm() {
        super.buildForm();
        form.setStyleName(ValoTheme.FORMLAYOUT_LIGHT,false);

        field = new AutocompleteTextField("The autocomplete");
        AutocompleteSuggestionProvider suggestionProvider = new CollectionSuggestionProvider(theJavas, MatchMode.CONTAINS, true, Locale.ENGLISH);
        field.setSuggestionProvider(suggestionProvider);
        form.addComponent(field);

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