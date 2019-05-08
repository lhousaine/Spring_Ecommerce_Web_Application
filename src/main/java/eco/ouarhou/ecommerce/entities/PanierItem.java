package eco.ouarhou.ecommerce.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class PanierItem implements Serializable{
	@EmbeddedId
	PanierItemId id=new PanierItemId();
	@ManyToOne
	@MapsId("panier_id")
	@JoinColumn(name = "panier_id")
	private Panier panier;
	@ManyToOne
	@MapsId("produit_id")
	@JoinColumn(name = "produit_id")
	private Produit produit;
	private long qte;
}
