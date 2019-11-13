/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.ip.net.dk.digit.ejb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author HP
 */
@Entity
@Data@NoArgsConstructor@AllArgsConstructor
@Table(name = "objet_publications")
public class ObjetPublication implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "libelle", nullable = false)
    private String libelle;

    @OneToMany(mappedBy = "objetPublication", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Publication> publications = new ArrayList<>();

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
        publications.forEach((publication) -> {
            publication.setObjetPublication(this);
        });
    }
    
}
