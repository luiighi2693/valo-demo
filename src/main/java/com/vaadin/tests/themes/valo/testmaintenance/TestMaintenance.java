package com.vaadin.tests.themes.valo.testmaintenance;

import com.vaadin.ui.TextField;
import eu.maxschuster.vaadin.autocompletetextfield.AutocompleteSuggestionProvider;
import eu.maxschuster.vaadin.autocompletetextfield.AutocompleteTextField;
import eu.maxschuster.vaadin.autocompletetextfield.provider.CollectionSuggestionProvider;
import eu.maxschuster.vaadin.autocompletetextfield.provider.MatchMode;
import ve.com.pt.base.views.BaseMaintenance;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

/**
 * Test para pantalla de mantenimiento
 * Created by ypetrilli on 14/09/2016.
 */
public class TestMaintenance extends BaseMaintenance {

    private TextField code;
    private AutocompleteTextField field;
    AutocompleteSuggestionProvider suggestionProvider;

    public TestMaintenance() {
        setMargin(true);
    }

    @Override
    public void buildGrid() {
        super.buildGrid();
        grid.addColumn("Name", String.class);
        grid.addColumn("Description", String.class);
        grid.addColumn("Version", String.class);
        grid.addRow("com.vaadin", "vaadin-server", "7.4.0");
        grid.addRow("com.vaadin", "vaadin-client-compiled", "7.4.0");
        grid.addRow("com.vaadin", "vaadin-client", "7.7.0");
    }

    @Override
    public void buildForm() {
        super.buildForm();
        form.setSpacing(true);
        form.setMargin(true);
        code = new TextField("Código");
        code.setInputPrompt("código");
        form.addComponent(code);
        Collection<String> theJavas = Arrays.asList("Jav", "JavaScript", "Join Java", "JavaFX Script");
        field = new AutocompleteTextField("Nombre");
        field.setInputPrompt("nombre");
        suggestionProvider = new CollectionSuggestionProvider(theJavas, MatchMode.CONTAINS, true, Locale.US);
        field.setSuggestionProvider(suggestionProvider);
        form.addComponent(field);
    }
}
