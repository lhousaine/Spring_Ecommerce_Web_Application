package eco.ouarhou.ecommerce.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Commande implements Serializable{
	    @Id
	    private String ref;
	   @OneToMany(mappedBy = "commande")
	   private Set<CommandeItem> commandeItems;
		public Commande(String ref) {
	        this.ref = ref;
	    }
}
