/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beuvron.web.amour.vues;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 *
 * @author francois
 */
public class PanneauErreur extends VerticalLayout {
    
    public PanneauErreur(String message,Throwable error) {
        H2 titre = new H2("Problème : " + message);
        titre.getStyle().set("color", "red");
        this.add(titre);
        H3 sousTitre = new H3("Cause : " + error.getLocalizedMessage());
        this.add(sousTitre);
        StringWriter out = new StringWriter();
        PrintWriter pout = new PrintWriter(out);
        error.printStackTrace(pout);
        pout.flush();
        this.add(new Paragraph(out.toString()));
    }
    
}
