package eco.ouarhou.ecommerce.dao;


import eco.ouarhou.ecommerce.entities.Panier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanierRepository extends JpaRepository<Panier, Long> {

}
