package eco.ouarhou.ecommerce.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Panier implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paniertId;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_creation;
	@OneToOne
	private Client client;
	@OneToMany(mappedBy = "panier")
	private Set<PanierItem> panierItems;
	public Panier(Date date_creation) {
		this.date_creation = date_creation;
	}
}

