/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beuvron.web.amour.vues;

import com.vaadin.flow.component.combobox.ComboBox;
import fr.insa.beuvron.web.amour.VuePrincipale;
import fr.insa.beuvron.web.amour.bdd.GestionBdD;
import fr.insa.beuvron.web.amour.model.Role;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author francois
 */
public class RoleCombobox extends ComboBox<Role> {

    private VuePrincipale main;

    public RoleCombobox(VuePrincipale main) {
        super("Role");
        this.main = main;
        try {
            this.setItems(GestionBdD.tousLesRoles(this.main.getSessionInfo().getConBdD()));
            this.setItemLabelGenerator(Role::getNrole);
            this.setPlaceholder("select role");
        } catch (SQLException ex) {
            List<Role> bidon = new ArrayList<>();
            bidon.add(new Role(-1, "!!Erreur BdD!!"));
        }
    }

    public Role selectedIdRole() {
        if (this.hasValidValue()) {
            return this.getValue();
        } else {
            return null;
        }
    }

}