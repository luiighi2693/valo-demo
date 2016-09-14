package com.vaadin.tests.themes.valo;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Uploader extends VerticalLayout implements View, Upload.Receiver {

    public Uploader(){
        addComponent(new HorizontalLayout());

        Upload upload = new Upload("Componente para subir Archivos", this);
        addComponent(upload);

        addComponent(new HorizontalLayout());

        addComponent(new Label("Ruta definida para subir archivos: C:\\Users\\lrodriguez\\Desktop\\"));

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
