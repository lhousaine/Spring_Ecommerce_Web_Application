package eco.ouarhou.ecommerce.Metier;

import eco.ouarhou.ecommerce.dao.ClientRepository;
import eco.ouarhou.ecommerce.dao.PanierProduitRepository;
import eco.ouarhou.ecommerce.dao.PanierRepository;
import eco.ouarhou.ecommerce.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class PanierMetImpl implements PanierMetdao{
    @Autowired
    private PanierRepository panierRepository;
    @Autowired
    private PanierProduitRepository panierProduitRepository;
    @Autowired
    private ClientRepository clientRepository;

    public PanierMetImpl(){

    }
    @Override
    public void savePanier(List<Produit> Produits,Client client){
        Panier panier1 = new Panier(new Date());
        Set<PanierItem> setPi = new HashSet<PanierItem>();
        for (int i = 0; i < Produits.size();i++){
            PanierItem panierItem = new PanierItem();
            panierItem.setQte(1);
            panierItem.setPanier(panier1);
            panierItem.setProduit(Produits.get(i));
            setPi.add(panierItem);
        }
        panier1.setPanierItems(setPi);
        panier1.setClient(client);
        panierRepository.save(panier1);
      /*  for (PanierItem p:setPi){
          panierProduitRepository.save(p);
        }*/
       }
    @Override
    public double sommePanier(List<Produit> Produits) {
        double somme=0;
        for (Produit produit:Produits){
         somme+=produit.getPrix();
        }
        return somme;
      }
}
