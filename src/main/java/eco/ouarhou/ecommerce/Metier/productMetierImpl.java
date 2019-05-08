package eco.ouarhou.ecommerce.Metier;



import eco.ouarhou.ecommerce.dao.CommandeRepository;
import eco.ouarhou.ecommerce.dao.PanierRepository;
import eco.ouarhou.ecommerce.dao.ProduitRepository;
import eco.ouarhou.ecommerce.entities.Commande;
import eco.ouarhou.ecommerce.entities.Panier;
import eco.ouarhou.ecommerce.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class productMetierImpl implements productMetierdao{
    @Autowired
    private ProduitRepository prodRepo;
    @Autowired
    private CommandeRepository comRepo;
    @Autowired
    private PanierRepository panierRepo;
    public productMetierImpl() {
    }
    @Override
    public Panier consulterPanier(long paniertId) {
        Panier panier = panierRepo.getOne(paniertId);
        if(panier == null) throw new RuntimeException("Le Panier rechercher est introuvable");
        return panier;
    }
    @Override
    public Produit chercherProduit(long id) {
        Produit p=prodRepo.getOne(id);
        return p;
    }
    @Override
    public void ajouterProduit(Produit produit) {
        prodRepo.save(produit);
    }
    @Override
    public void supprimerProduit(long produitId) {
            prodRepo.deleteById(produitId);
    }
    @Override
    public Page<Produit> chercher(String motCle, Pageable pageable) {
        return prodRepo.chercher(motCle, pageable);
    }
    @Override
    public List<Produit> chercherProducts(String mot) {
        return prodRepo.chercherListProduits(mot);
    }

    @Override
    public Produit chercherById(Long idProduit) {
        return prodRepo.chercherById(idProduit);
    }

    @Override
    public void updateProduct(Produit produit) {
        prodRepo.setUserInfoById(produit.getNom(),produit.getDescription(),produit.getPrix(),produit.getId());
    }
}
