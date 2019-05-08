package eco.ouarhou.ecommerce.Controller;

import eco.ouarhou.ecommerce.Metier.productMetierdao;
import eco.ouarhou.ecommerce.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class productController {
    @Autowired
    private productMetierdao prodMet;
    @RequestMapping(value="/managerProduits")
    public String manageProducts(Model model,
                                 @RequestParam(name="page",defaultValue="0")int p,
                                 @RequestParam(name="size",defaultValue="5")int s,
                                 @RequestParam(name="motCle",defaultValue="")String mot) {
        Page<Produit> pageProduits = prodMet.chercher("%" + mot + "%", new PageRequest(p, s));
        model.addAttribute("listProduits", pageProduits.getContent());
        int[] pages = new int[pageProduits.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("size", s);
        model.addAttribute("pageCourante", p);
        model.addAttribute("motCle", mot);
        return "ManageProducts";
    }
    @RequestMapping(value="/Supprimerproduit",method= RequestMethod.GET)
    public String delete(Long id,int page,int size){
        prodMet.supprimerProduit(id);
        return "redirect:/managerProduits?page="+page+"&size="+size;
    }
    @RequestMapping(value="/editProduit",method= RequestMethod.GET)
    public String updateProduit(Model model, Long id){
       Produit p=prodMet.chercherProduit(id);
        String a="edit";
        model.addAttribute("produit",p);
        model.addAttribute("oper",a);
        return "insererProduit";
    }

    @RequestMapping(value ="/AjouterProdiut",method = RequestMethod.GET)
    public String getAddProductForm(Model model){
        model.addAttribute("oper","insert");
        return "insererProduit";
    }
    @RequestMapping(value="/saveProduit", method= RequestMethod.POST)
    public String save(Model model, @Valid Produit produit, @RequestParam(name="oper")String oper,
                       BindingResult bindingResult){
        if (bindingResult.hasErrors()){
                return "insererProduit";
        }
        if(oper=="edit")
            prodMet.updateProduct(produit);
        else
            prodMet.ajouterProduit(produit);
        return "redirect:/managerProduits";
    }
}
