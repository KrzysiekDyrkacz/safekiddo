package pl.dyrkacz.safekiddo.entity.site;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import pl.dyrkacz.safekiddo.entity.category.Category;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class Website {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String siteName;
    @NotNull
    @OneToMany
    private List<Category> category;
}
