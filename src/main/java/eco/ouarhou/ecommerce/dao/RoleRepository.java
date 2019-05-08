package eco.ouarhou.ecommerce.dao;

import eco.ouarhou.ecommerce.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles,String> {

}
