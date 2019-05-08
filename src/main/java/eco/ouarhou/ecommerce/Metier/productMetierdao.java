package eco.ouarhou.ecommerce.Metier;

import eco.ouarhou.ecommerce.entities.Commande;
import eco.ouarhou.ecommerce.entities.Panier;
import eco.ouarhou.ecommerce.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface productMetierdao {
    //Panier
    public Panier consulterPanier(long paniertId);
    // produit
    public Produit chercherProduit(long id);
    public void ajouterProduit(Produit produit);
    public void supprimerProduit(long produitId);
    public Page<Produit> chercher(String mc, Pageable pageable);

    void updateProduct(Produit produit);
    List<Produit> chercherProducts(String s);
    public Produit chercherById(Long idProduit);
}
