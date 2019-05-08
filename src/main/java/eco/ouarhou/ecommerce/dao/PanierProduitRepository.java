package eco.ouarhou.ecommerce.dao;


import eco.ouarhou.ecommerce.entities.PanierItem;
import eco.ouarhou.ecommerce.entities.PanierItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanierProduitRepository extends JpaRepository<PanierItem, PanierItemId> {

}
