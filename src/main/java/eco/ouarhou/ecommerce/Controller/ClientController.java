package eco.ouarhou.ecommerce.Controller;

import eco.ouarhou.ecommerce.Metier.ClientMetierdao;
import eco.ouarhou.ecommerce.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientController {
    @Autowired
    private ClientMetierdao clientMet;
    @RequestMapping(value ="/touslesclients",method = RequestMethod.GET)
    public String getAllClients(Model model,
                                @RequestParam(name="page",defaultValue="0")int p,
                                @RequestParam(name="size",defaultValue="5")int s,
                                @RequestParam(name="motCle",defaultValue="")String mot) {
        //Page<Produit> pageProduits = prodMet.chercher("%" + mot + "%", new PageRequest(p, s));
        Page<Client> pagesClient=clientMet.listClients("%"+mot+"%",new PageRequest(p,s));
        model.addAttribute("listClients", pagesClient.getContent());
        int[] pages = new int[pagesClient.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("size", s);
        model.addAttribute("pageCourante", p);
        model.addAttribute("motCle", mot);
        return "Clients";
    }
    @RequestMapping(value = "/SupprimerClient",method = RequestMethod.GET)
    public String deleteClient(String email,int page,int size){
         clientMet.supprimerClient(email);
        return "redirect:/touslesclients?page="+page+"&size="+size;
    }
}
