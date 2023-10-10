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
import fr.insa.beuvron.web.amour.model.Utilisateur;
import fr.insa.beuvron.web.amour.model.UtilisateurAvecAime;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author francois
 */
public class UtilisateurAvecAimeGrid extends Grid<UtilisateurAvecAime>{ 
    
    private List<UtilisateurAvecAime> datas;
    
    public UtilisateurAvecAimeGrid(List<UtilisateurAvecAime> datas) {
        this.datas = datas;
        
         Column<UtilisateurAvecAime> cNom = this.addColumn(UtilisateurAvecAime::getNom)
                .setHeader("Nom");
        cNom.setSortable(true);
        
         Column<UtilisateurAvecAime> cNbrAime = this.addColumn(UtilisateurAvecAime::getNbrAime)
                .setHeader("Aime");
        cNbrAime.setSortable(true);
        
         Column<UtilisateurAvecAime> cNbrAimePar = this.addColumn(UtilisateurAvecAime::getNbrAimePar)
                .setHeader("Aimé par");
        cNbrAimePar.setSortable(true);
        
         Column<UtilisateurAvecAime> cNbrAmis = this.addColumn(UtilisateurAvecAime::getNbrAmis)
                .setHeader("Amis");
        cNbrAmis.setSortable(true);
        
         this.setItems(datas);
        // pour affichage compact pour transparents
        // this.setMaxHeight("12em");
    }
    
    public void addUtilisateurs(Collection<UtilisateurAvecAime> toAdd) {
        this.datas.addAll(toAdd);
        this.setItems(this.datas);
        this.getDataProvider().refreshAll();
    }
    
    public void removeUtilisateurs(Collection<UtilisateurAvecAime> toRemove) {
        this.datas.removeAll(toRemove);
        this.setItems(this.datas);
        this.getDataProvider().refreshAll();
    }

    /**
     * @return the datas
     */
    public List<UtilisateurAvecAime> getDatas() {
        return datas;
    }

    /**
     * @param datas the datas to set
     */
    public void setDatas(List<UtilisateurAvecAime> datas) {
        this.datas = datas;
        this.setItems(this.datas);
        this.getDataProvider().refreshAll();
    }
    


    
}
