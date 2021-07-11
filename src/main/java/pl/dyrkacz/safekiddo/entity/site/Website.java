package pl.dyrkacz.safekiddo.entity.site;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.dyrkacz.safekiddo.entity.category.Category;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
public class Website {

    @Id
    private String siteName;
    @NotNull
    @OneToMany
    private List<Category> category;
}
