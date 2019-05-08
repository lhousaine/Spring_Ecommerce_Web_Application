package eco.ouarhou.ecommerce.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Roles implements Serializable {
    @Id
    private String role;
    @ManyToMany(mappedBy="roles",cascade = CascadeType.ALL)
    private Set<Users> users;
    public Roles(String role) {
        this.role = role;
    }
}