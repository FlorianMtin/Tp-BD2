/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polytech.bd2;


import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author p1404693
 */
@Entity

public class Membre {
        @Id                 // création de ID
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBRE_GEN")    // va permettre de générer des valeurs grâce à la séquence MEMBRE_GEN
        @SequenceGenerator(name = "MEMBRE_GEN", sequenceName = "membre_seq", allocationSize=1)  // On génère la séquence membre_seq dans MEMBRE_GEN
        private int id;
    
        @Column(name="titre")
        private String titre;
        
        @OneToMany(mappedBy="moderateur")  // relation 1-n
        @Column(name="email")
        private String email;
        
        @Column(name="nom")
        private String nom;
        
        
        
        public int getId(){
            return id;
        }
        
        public String getEmail(){
            return this.email;
        }
        
        public void setEmail(String email){
            this.email = email;
        }
        
        public String getNom(){
            return this.nom;
        }
        
        public void setNom(String nom){
            this.nom = nom;
        }
        
        private Collection<Salle> sallesdumoderateur = new ArrayList<Salle>();

    /**
     * @return the sallesdumoderateur
     */
    public Collection<Salle> getSallesdumoderateur() {
        return this.sallesdumoderateur;
    }    
        
        
        
}
