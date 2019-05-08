package eco.ouarhou.ecommerce.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;


@Setter
@Getter
@NoArgsConstructor
@Embeddable
public class Adresse implements Serializable{
	    private int zipecode;
	    private String rue;
	    private  String ville;
	    private String pays;
		public Adresse(int zipecode, String rue, String ville, String pays) {
			super();
			this.zipecode = zipecode;
			this.rue = rue;
			this.ville = ville;
			this.pays = pays;
		}
}
