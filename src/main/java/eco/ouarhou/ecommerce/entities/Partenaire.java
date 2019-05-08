package eco.ouarhou.ecommerce.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Partenaire extends Client{
	@OneToMany(mappedBy = "partenaire")
	private Set<ProduitPart> produitParts;
	public Partenaire(String email, String nom, Adresse adresse) {
		super(email, nom, adresse);
	}
}
