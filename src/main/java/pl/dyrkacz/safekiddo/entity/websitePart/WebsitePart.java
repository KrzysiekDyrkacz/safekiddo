package pl.dyrkacz.safekiddo.entity.websitePart;

import lombok.Getter;
import lombok.Setter;
import pl.dyrkacz.safekiddo.entity.category.Category;

import java.util.List;

@Getter
@Setter
public class WebsitePart {
    private List<Category> category;
}
