package eco.ouarhou.ecommerce.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@Embeddable
public class ProduitPartId implements Serializable{
    @Column(name = "partenaire_id")
    private Long partenaireId;
    @Column(name = "produit_id")
    private Long produitId;
}
