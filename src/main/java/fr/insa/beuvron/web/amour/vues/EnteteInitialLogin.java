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
import com.vaadin.flow.component.notification.Notification;
import fr.insa.beuvron.web.amour.VuePrincipale;

/**
 *
 * @author francois
 */
public class EnteteInitialLogin extends MyHorizontalLayout {
    
    private VuePrincipale main;
    
    private Button vbLogin;
    private Button vbNouvelUtilisateur;
    
    public EnteteInitialLogin(VuePrincipale main) {
        this.main = main;
        this.setWidth("100%");
        this.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        this.setJustifyContentMode(JustifyContentMode.CENTER);
        
        this.vbLogin = new Button("Login");
        this.vbLogin.getStyle().set("fontWeight", "bold");
        this.vbLogin.getStyle().set("font-size", "2em");
        this.vbLogin.setHeight("100px");
        this.vbLogin.setWidth("6cm");
        this.vbLogin.addClickListener((event) -> {
            this.main.setMainContent(new LoginForm(this.main));
        });
        this.vbNouvelUtilisateur = new Button("Nouvel utilisateur");
        this.vbNouvelUtilisateur.addClickListener((t) -> {
            this.main.setMainContent(new NouvelUtilisateur(this.main));
        });
        this.add(this.vbLogin,this.vbNouvelUtilisateur);
        
        Button enPlus = new Button("dis que coucou");
        enPlus.addClickListener((event) -> {
            Notification.show("Ah que coucou");
        });
        this.add(enPlus);

    }
    
}
