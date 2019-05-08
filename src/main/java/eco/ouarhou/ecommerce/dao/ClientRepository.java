package eco.ouarhou.ecommerce.dao;

import eco.ouarhou.ecommerce.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, String> {
     @Query("select c from Client c where c.email like :x")
     public Page<Client> chercherallClient(@Param("x") String motCle,Pageable pageable);
     @Query("select c from Client c where c.clientAccount.username like :x")
     public Client chercherClientByAccount(@Param("x")String username);
}
