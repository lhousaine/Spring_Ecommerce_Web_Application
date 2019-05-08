package eco.ouarhou.ecommerce.Controller;

import eco.ouarhou.ecommerce.Metier.ClientMetierdao;
import eco.ouarhou.ecommerce.Metier.PanierMetdao;
import eco.ouarhou.ecommerce.Metier.productMetierdao;
import eco.ouarhou.ecommerce.dao.ClientRepository;
import eco.ouarhou.ecommerce.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class PagePrincipaleController {
    @Autowired
    private productMetierdao prodMet;
    @Autowired
    private PanierMetdao panierMetdao;
    @Autowired
    private ClientMetierdao clientMetierdao;
    @RequestMapping(value ="/",method = RequestMethod.GET)
    public String index(){
        return "redirect:/WebProducts";
    }

    public PagePrincipaleController() {
    }

    @RequestMapping(value ="/WebProducts",method = RequestMethod.GET)
    public String allProduit(Model model,
                             @RequestParam(name="motCle",defaultValue="")String mot, HttpSession session) {
        List<Produit> listProduits = prodMet.chercherProducts("%" + mot + "%");
        model.addAttribute("listProduits",listProduits);
        model.addAttribute("motCle",mot);
        List<Produit> produits=(List<Produit>) session.getAttribute("ProduitSession");
        if (produits==null){
            produits = new ArrayList<Produit>();
        }
        model.addAttribute("produits",produits);
        return "Accueil";
    }
    @RequestMapping(value="/ajoutPanier", method=RequestMethod.GET)
    public String addPanier(@RequestParam("idProduit") Long idProduit,HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        List<Produit> Produits = (List<Produit>) request.getSession().getAttribute("ProduitSession");
        Produit p = prodMet.chercherById(idProduit);
        if (Produits == null) {
            Produits = new ArrayList<>();
            request.getSession().setAttribute("ProduitSession", Produits);
        }
        Produits.add(p);
        request.getSession().setAttribute("ProduitSession", Produits);
        return "redirect:/WebProducts";
    }

    @RequestMapping(value="/voirPanier", method=RequestMethod.GET)
    public String voirPanier(Model model, HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        List<Produit> Produits = (List<Produit>)request.getSession().getAttribute("ProduitSession");
        double somme=panierMetdao.sommePanier(Produits);
        model.addAttribute("Produits", Produits);
        model.addAttribute("somme",somme);
        return "maPanier";
    }
    @RequestMapping(value="/ConfirmerPanier", method=RequestMethod.GET)
    public String confirmerPanier(HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        List<Produit> Produits = (List<Produit>) request.getSession().getAttribute("ProduitSession");
        Users user=(Users) request.getSession().getAttribute("user");
        System.out.println(user.getUsername());
        Client client=clientMetierdao.selectClientByAccount(user);
        panierMetdao.savePanier(Produits,client);
        return "redirect:/WebProducts";
    }
}
