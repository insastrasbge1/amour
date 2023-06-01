/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beuvron.web.amour.vues;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import fr.insa.beuvron.web.amour.VuePrincipale;
import fr.insa.beuvron.web.amour.bdd.GestionBdD;
import fr.insa.beuvron.web.amour.model.Role;
import fr.insa.beuvron.web.amour.model.Utilisateur;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

/**
 *
 * @author francois
 */
public class UtilisateurForm extends FormLayout {

    private VuePrincipale main;
    private Utilisateur editedUser;

    private TextField vtID;
    private TextField vtNom;
    private PasswordField vtPass;
    private RoleCombobox cRole;

    public UtilisateurForm(VuePrincipale main,Utilisateur editedUser) {
        this.main = main;
        this.editedUser = editedUser;
        this.vtID = new TextField("ID");
        this.vtID.setEnabled(false);
        this.vtNom = new TextField("nom");
        this.vtPass = new PasswordField("pass");
        this.cRole = new RoleCombobox(main);
        this.add(this.vtID,this.vtNom, this.vtPass, this.cRole);
        this.updateView();
    }
    
    public void updateView() {
        this.vtID.setValue(""+this.getEditedUser().getId());
        this.vtNom.setValue(this.getEditedUser().getNom());
        this.vtPass.setValue(this.getEditedUser().getPass());
        this.cRole.setSelectedRole(this.getEditedUser().getRole());
    }
    
    public void updateModel() throws InvalidViewException {
        String pass = this.vtPass.getValue();
        if (pass.length() < 2) {
            throw new InvalidViewException("pass doit contenir au moins 2 caractères");
        }
        Role rn = this.cRole.selectedRole();
        if (rn == null) {
            throw new InvalidViewException("Role non défini");
        }
        this.getEditedUser().setNom(this.vtNom.getValue());
        this.getEditedUser().setPass(this.vtPass.getValue());
        this.getEditedUser().setRole(rn);
    }
    
    /**
     * @return the editedUser
     */
    public Utilisateur getEditedUser() {
        return editedUser;
    }

    /**
     * @param editedUser the editedUser to set
     */
    public void setEditedUser(Utilisateur editedUser) {
        this.editedUser = editedUser;
        this.updateView();
    }

}
