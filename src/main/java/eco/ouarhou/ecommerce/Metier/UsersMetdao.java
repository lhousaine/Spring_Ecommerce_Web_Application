package eco.ouarhou.ecommerce.Metier;

import eco.ouarhou.ecommerce.entities.Users;

public interface UsersMetdao {
    public Users rechercheByUsername(String username);
}
