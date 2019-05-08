package eco.ouarhou.ecommerce;

import eco.ouarhou.ecommerce.dao.*;
import eco.ouarhou.ecommerce.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
       /* Roles role=roleRepository.save(new Roles("ADMIN"));
        Roles role1=roleRepository.save(new Roles("CLIENT"));
        Set<Roles> rolesSet=new HashSet<>();rolesSet.add(role);rolesSet.add(role1);
        Set<Roles> rolesSet1=new HashSet<>();rolesSet.add(role1);
        String pass=bCryptPasswordEncoder.encode("1234");
        Users us1=new Users("admin",pass,true);
        us1.setRoles(rolesSet);
        usersRepository.save(us1);
        Users us2=new Users("client",pass,true);
        us2.setRoles(rolesSet1);
        usersRepository.save(us2);*/
    }
}
