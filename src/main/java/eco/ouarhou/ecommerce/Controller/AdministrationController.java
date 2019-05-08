package eco.ouarhou.ecommerce.Controller;

import eco.ouarhou.ecommerce.Metier.UsersMetdao;
import eco.ouarhou.ecommerce.dao.ClientRepository;
import eco.ouarhou.ecommerce.dao.UsersRepository;
import eco.ouarhou.ecommerce.entities.Adresse;
import eco.ouarhou.ecommerce.entities.Client;
import eco.ouarhou.ecommerce.entities.Roles;
import eco.ouarhou.ecommerce.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
public class AdministrationController {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private UsersMetdao usersMetdao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @RequestMapping(value="/login")
    public String login(Model model, HttpServletRequest request){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user=usersMetdao.rechercheByUsername(auth.getName());
        System.out.println(user.getUsername());
        request.getSession().setAttribute("user",user);
        return "login";
    }
    @RequestMapping(value="/403")
    public String accessDenied(){
        return "ErrorPage";
    }
    @RequestMapping(value = "/createAccount")
    public String CreerCompte(){
        return "SignUp";
    }
    @RequestMapping(value="/signup",method = RequestMethod.POST)
    public String SignUp(@Valid Client client, Adresse adresse, Users user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "SignUp";
        }
        String pass=bCryptPasswordEncoder.encode(user.getPassword());
        Set<Roles> rolesSet=new HashSet<>();
        rolesSet.add(new Roles("CLIENT"));
        user.setRoles(rolesSet);
        user.setPassword(pass);
        user.setActive(true);
        client.setClientAccount(user);
        client.setAdresse(adresse);
        clientRepository.save(client);
        return "login";
    }

}
