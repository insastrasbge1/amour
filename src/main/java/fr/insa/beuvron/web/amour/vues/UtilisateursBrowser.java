/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beuvron.web.amour.vues;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import fr.insa.beuvron.web.amour.VuePrincipale;
import fr.insa.beuvron.web.amour.bdd.GestionBdD;
import fr.insa.beuvron.web.amour.model.Role;
import fr.insa.beuvron.web.amour.model.Utilisateur;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author francois
 */
public class UtilisateursBrowser extends HorizontalLayout {

    private VuePrincipale main;

    private UtilisateurGrid allUsers;
    private UtilisateurForm userEditor;
    private Button bModifyUser;

    public UtilisateursBrowser(VuePrincipale main) {
//        this.add(new PanneauErreur("testErreur", new Exception("test")));
        this.setWidth("100%");
        try {
            this.main = main;
            List<Utilisateur> users = GestionBdD.tousLesUtilisateurs(
                    this.main.getSessionInfo().getConBdD());
            this.allUsers = new UtilisateurGrid(users);
            this.allUsers.addItemClickListener((t) -> {
                Utilisateur cur = t.getItem();
                this.userEditor.setEditedUser(cur);
            });
            this.allUsers.setWidth("50%");
            this.add(this.allUsers);
            Utilisateur cDebut;
            if (users.isEmpty()) {
                cDebut = new Utilisateur(0, "no user selected", "no user selected",Role.getDefaultRole());
            } else {
                cDebut = users.get(0);
                this.allUsers.select(cDebut);
            }
            this.userEditor = new UtilisateurForm(main, cDebut);
            this.bModifyUser = new Button("Sauvegarder les modifications");
            this.bModifyUser.addClickListener((t) -> {
                this.doModify();
            });
            VerticalLayout vlEdit = new VerticalLayout(this.userEditor,this.bModifyUser);
            vlEdit.setWidth("100%");
            this.add(vlEdit);
        } catch (SQLException ex) {
            this.add(new PanneauErreur("Impossible de construire la liste des utilisateurs", ex));
        }
    }

    private void doModify() {
        try {
            this.userEditor.updateModel();
            Connection con = this.main.getSessionInfo().getConBdD();
            this.userEditor.getEditedUser().saveInDB(con);
            this.allUsers.setDatas(GestionBdD.tousLesUtilisateurs(con));
        } catch (InvalidViewException ex) {
            ex.notificationVaadin();
        } catch (SQLException ex) {
            Notification.show("Problème BdD : " + ex.getLocalizedMessage());
        }
    }

}
