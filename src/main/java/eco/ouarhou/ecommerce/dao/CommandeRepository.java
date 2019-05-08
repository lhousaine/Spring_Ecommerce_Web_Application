package eco.ouarhou.ecommerce.dao;


import eco.ouarhou.ecommerce.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,String> {

}
