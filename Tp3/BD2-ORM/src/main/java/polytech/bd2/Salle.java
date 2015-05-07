package polytech.bd2;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.SequenceGenerator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author p1404693
 */
@Entity

public class Salle {
    

        
        
        @Id     // annotation ID
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALLE_GEN")  // va permettre de générer des valeurs avec la séquence SALLE_GEN 
        @SequenceGenerator(name = "SALLE_GEN", sequenceName = "salle_seq", allocationSize=1) //on récupère salle_seq dans SALLE_GEN
        private int id;
        @Column(name="titre")   // on associe le membre de l'entité titre à une colonne
        private String titre;
        @OneToMany(mappedBy="salle")
        
        @ManyToOne      // relation n - 1
        @JoinColumn(name = "moderateur") // clé étrangère modérateur de Membre 
        private Membre moderateur;
        
        
        
        public int getId() {
            return id;
        }

        public String getTitre() {
            return titre;
        }
        
        public void setTitre(String titre) {
            this.titre = titre;
        }

        public Membre getModerateur() {
            return moderateur;
        }
        
        public void setModerateur(Membre moderateur) {
            moderateur.getSallesdumoderateur().add(this);
            this.moderateur.getSallesdumoderateur().remove(this);
            
        }
}