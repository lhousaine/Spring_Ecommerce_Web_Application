package eco.ouarhou.ecommerce.Metier;

import eco.ouarhou.ecommerce.dao.CommandeItemRepository;
import eco.ouarhou.ecommerce.dao.CommandeRepository;
import eco.ouarhou.ecommerce.entities.Commande;
import eco.ouarhou.ecommerce.entities.CommandeItem;
import org.springframework.beans.factory.annotation.Autowired;

public class CommandMetImpl implements CommandeMetdao{
    @Autowired
    private CommandeItemRepository commandeItemRepository;
    @Autowired
    private CommandeRepository commandeRepository;

    public CommandMetImpl() {
    }
    @Override
    public void envoyerCommande(Commande commande) {
        commandeRepository.save(commande);
    }
}
