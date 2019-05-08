package eco.ouarhou.ecommerce.entities;

import groovyjarjarpicocli.CommandLine;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class CommandeItem implements Serializable{
	@EmbeddedId
	CommandeItemId id=new CommandeItemId();
	@ManyToOne
	@MapsId("produit_id")
	@JoinColumn(name = "produit_id")
	Produit produit;

	@ManyToOne
	@MapsId("command_id")
	@JoinColumn(name = "command_id")
	Commande commande;
	private int qte;
}
