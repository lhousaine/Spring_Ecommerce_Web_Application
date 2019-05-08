package eco.ouarhou.ecommerce.dao;

import eco.ouarhou.ecommerce.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,String> {

}
