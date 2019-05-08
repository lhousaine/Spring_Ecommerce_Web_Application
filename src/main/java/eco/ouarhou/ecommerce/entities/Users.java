package eco.ouarhou.ecommerce.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users{
    @Id
    private String username;
    private String password;
    private boolean active;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "usersRoles",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "role"))
    private Set<Roles> roles;
    public Users(String username, String password, boolean active) {
        super();
        this.username = username;
        this.password = password;
        this.active = active;
    }
}