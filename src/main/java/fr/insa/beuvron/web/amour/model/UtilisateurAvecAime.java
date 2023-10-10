/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beuvron.web.amour.model;

/**
 *
 * @author francois
 */
public class UtilisateurAvecAime extends Utilisateur {
    
    private int nbrAime;
    private int nbrAimePar;
    private int nbrAmis;

    public UtilisateurAvecAime(int id, String nom, String pass, Role role,
            int nbrAime, int nbrAimePar, int nbrAmis) {
        super(id, nom, pass, role);
        this.nbrAime = nbrAime;
        this.nbrAimePar = nbrAimePar;
        this.nbrAmis = nbrAmis;
    }

    @Override
    public String toString() {
        return "UtilisateurAvecAime{"
                 + "id=" + getId() + ", nom=" + getNom() + ", pass=" + getPass() + ", role=" + getRole()
                + ", nbrAime=" + getNbrAime() + ", nbrAimePar=" + getNbrAimePar() + ", nbrAmis=" + getNbrAmis() + '}';
    }

    /**
     * @return the nbrAime
     */
    public int getNbrAime() {
        return nbrAime;
    }

    /**
     * @return the nbrAimePar
     */
    public int getNbrAimePar() {
        return nbrAimePar;
    }

    /**
     * @return the nbrAmis
     */
    public int getNbrAmis() {
        return nbrAmis;
    }
    
    
    
}
