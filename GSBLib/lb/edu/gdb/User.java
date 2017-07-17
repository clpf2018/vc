/*
 * VESRION ) juste pour vous montrer
 */
package lb.edu.gdb;

import java.io.Serializable;

/**
 *
 * @author Pascal Fares
 * @see https://github.com/projets2017cl/vc/wiki/Type-utilisateurs-et-Droit-actions
 * Un utilisateur possède :
 * ID
 * Name
 * Credentials (username, password, Mobile , phone , Email, fax)
 * Address (Street , City , State , Zip, Country , Note)
 * 
 * Les objets devrait être des beans ceci facilitra leur utilisation par la suite
 * VERSION 0
 */
public class User implements Serializable{
    /**
     * TODO l'id un string ou autre chose?
    */
    private String id;

    //TODO Continuer pour les autres attributs ...
    
    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(String id) {
        this.id = id;
    }

}
