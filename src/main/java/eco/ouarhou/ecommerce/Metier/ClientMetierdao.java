package eco.ouarhou.ecommerce.Metier;

import eco.ouarhou.ecommerce.entities.Client;
import eco.ouarhou.ecommerce.entities.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientMetierdao {
    Page<Client> listClients(String motCle, Pageable pageable);
    public void insererClient(Client client);
    public void supprimerClient(String email);
    public Client selectClientByAccount(Users user);
}
