package eco.ouarhou.ecommerce.dao;


import eco.ouarhou.ecommerce.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    @Query("select p from Produit p where p.nom like :x")
    public Page<Produit> chercher(@Param("x") String motCle, Pageable pageable);
    @Query("select p from Produit p where p.id like :x")
    public Produit chercherById(@Param("x")long idProduit);
    @Query("select p from Produit p where p.nom like :x")
    public List<Produit> chercherListProduits(@Param("x") String motCle);
    @Modifying
    @Query("update Produit p set p.nom = ?1, p.description = ?2,p.prix = ?3 where p.id = ?4")
    void setUserInfoById(String nom, String description, Double prix, Long idProduit);
}
