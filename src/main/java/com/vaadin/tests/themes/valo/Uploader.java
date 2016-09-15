package com.vaadin.tests.themes.valo;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Uploader extends VerticalLayout implements View, Upload.Receiver {

    public Uploader(){

        Label h1 = new Label("Upload Files");
        h1.addStyleName(ValoTheme.LABEL_H1);

        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setMargin(true);
        mainLayout.setSpacing(true);

        mainLayout.addComponent(h1);

        Upload upload = new Upload("Componente para subir Archivos", this);
        mainLayout.addComponent(upload);

        Label label = new Label(
                "<pre>Upload upload = new Upload(\"Componente para subir Archivos\", this);\n\n" +
                        " @Override\n" +
                        "    public OutputStream receiveUpload(String s, String s1) {\n" +
                        "        FileOutputStream output = null;\n" +
                        "\n" +
                        "        try{\n" +
                        "            output = new FileOutputStream(\"C:\\\\Users\\\\lrodriguez\\\\Desktop\\\\\"+s);\n" +
                        "        }catch (FileNotFoundException e){\n" +
                        "            e.printStackTrace();\n" +
                        "        }\n" +
                        "        return output;\n" +
                        "    }</pre>"+
                        "\n" +
                        "<h4><strong>Parámetros para construir el Upload :</strong></h4>"+
                        "<ul>" +
                        "<li>String captionUpload.Receiver uploadReceiver</li>"+
                        "<li>Upload.Receiver uploadReceiver</li>"+
                        "</ul>",
                ContentMode.HTML);

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponent(label);
        verticalLayout.setMargin(true);

        Panel panel = new Panel();
        panel.setContent(verticalLayout);

        mainLayout.addComponents(new VerticalLayout(), panel);

        addComponent(mainLayout);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
    }

    @Override
    public OutputStream receiveUpload(String s, String s1) {
        FileOutputStream output = null;

        try{
            output = new FileOutputStream("C:\\Users\\lrodriguez\\Desktop\\"+s);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return output;
    }
}
