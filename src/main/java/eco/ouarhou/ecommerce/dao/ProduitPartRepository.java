package eco.ouarhou.ecommerce.dao;


import eco.ouarhou.ecommerce.entities.ProduitPart;
import eco.ouarhou.ecommerce.entities.ProduitPartId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitPartRepository extends JpaRepository<ProduitPart, ProduitPartId> {

}
