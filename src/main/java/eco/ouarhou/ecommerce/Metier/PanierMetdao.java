package eco.ouarhou.ecommerce.Metier;

import eco.ouarhou.ecommerce.entities.Client;
import eco.ouarhou.ecommerce.entities.Produit;

import java.util.List;

public interface PanierMetdao {
    public void savePanier(List<Produit> Produits,Client client);
    public double sommePanier(List<Produit> Produits);
}
