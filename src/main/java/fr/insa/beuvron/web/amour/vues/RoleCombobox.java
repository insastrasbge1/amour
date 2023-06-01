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

    private List<Role> lesRoles;

    public RoleCombobox(VuePrincipale main) {
        super("Role");
        this.main = main;
        try {
            this.lesRoles = GestionBdD.tousLesRoles(this.main.getSessionInfo().getConBdD());
        } catch (SQLException ex) {
            this.lesRoles = new ArrayList<>();
            this.lesRoles.add(new Role(-1, "!!Erreur BdD!!"));
        }
        this.setItems(this.lesRoles);
        this.setItemLabelGenerator(Role::getNrole);
        this.setPlaceholder("select role");
    }

    public boolean setSelectedRole(Role role) {
        Role rInThis = this.lesRoles.stream()
                .filter((r) -> r.getId() == role.getId()).findFirst().orElse(null);
        if(rInThis != null) {
            this.setValue(rInThis);
            return true;
        } else {
            return false;
        }
    }

    public Role selectedRole() {
        if (this.hasValidValue()) {
            return this.getValue();
        } else {
            return null;
        }
    }
    
    public String selectedRoleName() {
        Role rs = this.selectedRole();
        if (rs != null) {
            return rs.getNrole();
        } else {
            return null;
        }
    }

}
