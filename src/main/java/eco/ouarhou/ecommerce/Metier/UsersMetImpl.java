package eco.ouarhou.ecommerce.Metier;

import eco.ouarhou.ecommerce.dao.UsersRepository;
import eco.ouarhou.ecommerce.entities.Users;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class UsersMetImpl implements UsersMetdao{
     @Autowired
     private UsersRepository usersRepository;
    public UsersMetImpl() {
    }

    @Override
    public Users rechercheByUsername(String username) {
        return usersRepository.getOne(username);
    }
}
