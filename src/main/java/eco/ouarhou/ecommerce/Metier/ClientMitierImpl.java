package eco.ouarhou.ecommerce.Metier;

import eco.ouarhou.ecommerce.dao.ClientRepository;
import eco.ouarhou.ecommerce.entities.Client;
import eco.ouarhou.ecommerce.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class ClientMitierImpl implements ClientMetierdao{
    @Autowired
    private ClientRepository clientRepository;
    public ClientMitierImpl() {
    }
    @Override
    public Page<Client> listClients(String motCle, Pageable pageable) {
        return clientRepository.chercherallClient(motCle,pageable);
    }
    @Override
    public void insererClient(Client client) {
        clientRepository.save(client);
    }
    @Override
    public void supprimerClient(String email) {

    }
    @Override
    public Client selectClientByAccount(Users user){
        return clientRepository.chercherClientByAccount(user.getUsername());
    }
}
