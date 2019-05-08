package eco.ouarhou.ecommerce.dao;


import eco.ouarhou.ecommerce.entities.CommandeItem;
import eco.ouarhou.ecommerce.entities.CommandeItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeItemRepository extends JpaRepository<CommandeItem, CommandeItemId> {
}
