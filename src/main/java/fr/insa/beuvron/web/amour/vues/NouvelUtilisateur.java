/*
    Copyright 2000- Francois de Bertrand de Beuvron

    This file is part of CoursBeuvron.

    CoursBeuvron is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    CoursBeuvron is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with CoursBeuvron.  If not, see <http://www.gnu.org/licenses/>.
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
public class NouvelUtilisateur extends FormLayout {

    private VuePrincipale main;

    private TextField vtNom;
    private PasswordField vtPass;
    private RoleCombobox cRole;
    private Button vbValidate;

    public NouvelUtilisateur(VuePrincipale main) {
        this.main = main;
        this.vtNom = new TextField("nom");
        this.vtPass = new PasswordField("pass");
        this.cRole = new RoleCombobox(main);
        this.vbValidate = new Button("Valider");
        this.vbValidate.addClickListener((event) -> {
            Connection con = this.main.getSessionInfo().getConBdD();
            String nom = this.vtNom.getValue();
            String pass = this.vtPass.getValue();
            try {
                Role r = this.cRole.selectedRole();
                if (r == null) {
                    Notification.show("Vous devez selectionner un role");
                } else {

                    int id = GestionBdD.createUtilisateur(con, nom, pass, r.getId());
                    Utilisateur curU = new Utilisateur(id, nom, pass, r);
                    this.main.getSessionInfo().setCurUser(Optional.of(curU));
                    Notification.show("Utilisateur " + nom + " créé");
                    this.main.setMainContent(new MainAfterLogin(this.main));
                    this.main.setEntete(new EnteteAfterLogin(this.main));
                }

            } catch (GestionBdD.NomExisteDejaException ex) {
                Notification.show("Ce nom existe déjà, choississez en un autre");
            } catch (SQLException ex) {
                Notification.show("Problème BdD : " + ex.getLocalizedMessage());
            }
        });
        this.add(this.vtNom, this.vtPass, this.cRole, this.vbValidate);
    }

}
