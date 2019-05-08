package eco.ouarhou.ecommerce.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Produit implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produit_id")
    private long id;
    @NotNull
    @Size(max = 100)
    private String nom;
    @NotNull
    private String description;
    private double prix;
    private int qteProduit;
	@OneToMany(mappedBy = "produit")
	private Set<ProduitPart> produitParts;
    public Produit(String nom, String description, double prix) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }
}
