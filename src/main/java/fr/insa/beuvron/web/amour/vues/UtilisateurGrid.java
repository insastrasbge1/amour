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

import com.vaadin.flow.component.grid.Grid;
import fr.insa.beuvron.web.amour.VuePrincipale;
import fr.insa.beuvron.web.amour.model.Utilisateur;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author francois
 */
public class UtilisateurGrid extends Grid<Utilisateur>{ 
    
    private List<Utilisateur> datas;
    
    public UtilisateurGrid(List<Utilisateur> datas) {
        this.datas = datas;
        
        Column<Utilisateur> cID = this.addColumn(Utilisateur::getId)
                .setHeader("ID");
        cID.setWidth("3em");
        Column<Utilisateur> cNom = this.addColumn(Utilisateur::getNom)
                .setHeader("Nom");
        cNom.setSortable(true);
        
       Column<Utilisateur> cNomRole = this.addColumn(Utilisateur::getNomRole)
                .setHeader("Role");
       
         this.setItems(datas);
        // pour affichage compact pour transparents
        // this.setMaxHeight("12em");
    }
    
    public void addUtilisateurs(Collection<Utilisateur> toAdd) {
        this.datas.addAll(toAdd);
        this.setItems(this.datas);
        this.getDataProvider().refreshAll();
    }
    
    public void removeUtilisateurs(Collection<Utilisateur> toRemove) {
        this.datas.removeAll(toRemove);
        this.setItems(this.datas);
        this.getDataProvider().refreshAll();
    }

    /**
     * @return the datas
     */
    public List<Utilisateur> getDatas() {
        return datas;
    }

    /**
     * @param datas the datas to set
     */
    public void setDatas(List<Utilisateur> datas) {
        this.datas = datas;
        this.setItems(this.datas);
        this.getDataProvider().refreshAll();
    }
    


    
}
