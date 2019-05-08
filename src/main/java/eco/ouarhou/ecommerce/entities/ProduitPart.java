package eco.ouarhou.ecommerce.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class ProduitPart {
	@EmbeddedId
	ProduitPartId id=new ProduitPartId();
	@ManyToOne
	@MapsId("partenaire_id")
	@JoinColumn(name = "partenaire_id")
	Partenaire partenaire;

	@ManyToOne
	@MapsId("produit_id")
	@JoinColumn(name = "produit_id")
	Produit produit;
	double prix;
}
