/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polytech.bd2;


import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
/**
 *
 * @author p1404693
 */
@Entity
public class Message {
        @Id                 // création de ID
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MESSAGE_GEN")    // va permettre de générer des valeurs grâce à la séquence MEMBRE_GEN
        @SequenceGenerator(name = "MESSAGE_GEN", sequenceName = "message_seq", allocationSize=1)  // On génère la séquence membre_seq dans MEMBRE_GEN
        private int id;
        
        @ManyToOne
        @JoinColumn(name = "salle")
        private Salle salle;
        
        @ManyToOne
        @JoinColumn(name = "moderateur")
        private Membre moderateur;
        
        @OneToOne
        private int parent;
        
        @OneToOne(mappedBy="message")
        
        @Column(name="date_envoie") 
        private Timestamp date_envoie;
        
        @Column(name="titre") 
        private String titre;
        
        @Column(name="corps")   
        private String corps;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the salle
     */
    public Salle getSalle() {
        return salle;
    }

    /**
     * @param salle the salle to set
     */
    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    /**
     * @return the moderateur
     */
    public Membre getModerateur() {
        return moderateur;
    }

    /**
     * @param moderateur the moderateur to set
     */
    public void setModerateur(Membre moderateur) {
        this.moderateur = moderateur;
    }

    /**
     * @return the parent
     */
    public int getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(int parent) {
        this.parent = parent;
    }

    /**
     * @return the date_envoie
     */
    public Timestamp getDate_envoie() {
        return date_envoie;
    }

    /**
     * @param date_envoie the date_envoie to set
     */
    public void setDate_envoie(Timestamp date_envoie) {
        this.date_envoie = date_envoie;
    }

    /**
     * @return the titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * @param titre the titre to set
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * @return the corps
     */
    public String getCorps() {
        return corps;
    }

    /**
     * @param corps the corps to set
     */
    public void setCorps(String corps) {
        this.corps = corps;
    }
        
     }

         