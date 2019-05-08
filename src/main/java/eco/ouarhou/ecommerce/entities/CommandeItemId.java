package eco.ouarhou.ecommerce.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@Embeddable
public class CommandeItemId implements Serializable{
	@Column(name = "commande_id")
	 private Long commandeId;
	@Column(name = "produit_id")
	private Long produitId;
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CommandeItemId that = (CommandeItemId) o;
		return Objects.equals(commandeId, that.commandeId) &&
				Objects.equals(produitId, that.produitId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(commandeId, produitId);
	}
}
