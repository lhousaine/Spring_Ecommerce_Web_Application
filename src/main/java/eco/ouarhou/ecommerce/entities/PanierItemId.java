package eco.ouarhou.ecommerce.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PanierItemId implements Serializable{
    @Column(name = "panier_id")
    private Long panierId;
    @Column(name = "produit_id")
    private Long produitId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PanierItemId that = (PanierItemId) o;
        return Objects.equals(panierId, that.panierId) &&
                Objects.equals(produitId, that.produitId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(panierId, produitId);
    }
}
