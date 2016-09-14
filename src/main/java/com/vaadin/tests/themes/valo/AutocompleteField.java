package com.vaadin.tests.themes.valo;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import eu.maxschuster.vaadin.autocompletetextfield.AutocompleteSuggestionProvider;
import eu.maxschuster.vaadin.autocompletetextfield.AutocompleteTextField;
import eu.maxschuster.vaadin.autocompletetextfield.provider.CollectionSuggestionProvider;
import eu.maxschuster.vaadin.autocompletetextfield.provider.MatchMode;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

/**
 * Demo para campos con autocompletado.
 * Created by ypetrilli on 14/09/2016.
 */
public class AutocompleteField extends VerticalLayout implements View {

    private VerticalLayout mainLayout;
    private AutocompleteTextField field;
    Label label;
    private Panel panel;

    public AutocompleteField() {
        Label h1 = new Label("AutoCompleteTextField");
        h1.addStyleName(ValoTheme.LABEL_H1);

        Collection<String> theJavas = Arrays.asList("j", "JavaScript", "Join Java", "JavaFX Script");

        mainLayout = new VerticalLayout();
        mainLayout.setMargin(true);
        mainLayout.setSpacing(true);

        mainLayout.addComponent(h1);

        field = new AutocompleteTextField("Campo con autocompletado");
        field.setInputPrompt("descripción");
        AutocompleteSuggestionProvider suggestionProvider = new CollectionSuggestionProvider(theJavas, MatchMode.CONTAINS, true, Locale.ENGLISH);
        field.setSuggestionProvider(suggestionProvider);

        label = new Label(
                "<pre>Collection<String> theJavas = Arrays.asList(new String[] {\n" +
                        "    \"Java\",\n" +
                        "    \"JavaScript\",\n" +
                        "    \"Join Java\",\n" +
                        "    \"JavaFX Script\"\n" +
                        "});\n" +
                        "" +
                        "AutocompleteSuggestionProvider suggestionProvider = new CollectionSuggestionProvider(theJavas, MatchMode.CONTAINS, true, Locale.US);\n" +
                        "" +
                        "AutocompleteTextField field = new AutocompleteTextField();</pre>" +
                        "\n" +
                        "<h4><strong>Parámetros para construir el CollectionSuggestionProvider :</strong></h4>"+
                        "<ul>" +
                            "<li>Colección para el autocompletado</li>"+
                            "<li>Modo de búsqueda (MatchMode.CONTAINS / MatchMode.BEGINS)</li>"+
                            "<li>Si desea o no tomar en cuenta las mayúsculas</li>"+
                            "<li>Localidad</li>"+
                        "</ul>",
                ContentMode.HTML);

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponent(label);
        verticalLayout.setMargin(true);

        panel = new Panel(new Label("<code>Implementación</code>",ContentMode.HTML));
        panel.setContent(verticalLayout);

        mainLayout.addComponents(field, new VerticalLayout(), panel);

        addComponent(mainLayout);
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
