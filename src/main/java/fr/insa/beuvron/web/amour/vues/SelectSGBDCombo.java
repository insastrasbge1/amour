/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beuvron.web.amour.vues;

import com.vaadin.flow.component.combobox.ComboBox;
import fr.insa.beuvron.web.amour.bdd.GestionBdD;
import fr.insa.beuvron.web.amour.bdd.GestionBdD.SGBD;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author francois
 */
public class SelectSGBDCombo extends ComboBox<GestionBdD.SGBD> {

    public SelectSGBDCombo() {
        List<SGBD> alls = new ArrayList<>();
        alls.add(GestionBdD.PostgresqlSGBD);
        alls.add(GestionBdD.MySQLSGBD);
        this.setItems(alls);
        this.setValue(GestionBdD.PostgresqlSGBD);
    }

    public Optional<SGBD> selectedSGBD() {
        if (this.hasValidValue()) {
            return Optional.of(this.getValue());
        } else {
            return Optional.empty();
        }
    }

}
