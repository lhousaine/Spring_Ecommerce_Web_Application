package eco.ouarhou.ecommerce.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Client implements Serializable{
	    @Id
	    private String email;
	    private String nom;
	   @NotNull
	   @Size(max = 100)
	   @Size(min =2)
	   private String compte_bancaire;
	    @Embedded
	    private Adresse adresse;
	   @OneToOne(cascade = CascadeType.ALL)
	   @JoinColumn(name = "idAccount")
	   private Users clientAccount;
	   @OneToOne(mappedBy = "client")
	   private Panier panier;
	    public Client(String email, String nom, Adresse adresse) {
	        this.email = email;
	        this.nom = nom;
	        this.adresse = adresse;
	    }
}
