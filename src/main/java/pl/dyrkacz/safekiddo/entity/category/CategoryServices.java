package pl.dyrkacz.safekiddo.entity.category;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServices {
    private CategoryRepository categoryRepository;

    public CategoryServices(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public boolean existByNameCategory(String name) {
        return categoryRepository.existsByName(name);
    }

    public Category findByName(String name) {
        return categoryRepository.findCategoryByName(name);
    }


    public Category saveCategory(String name) {
        Category category = new Category(name);
        categoryRepository.save(category);
        return category;
    }

    public List<Category> saveIfDoesntExist(List<String> categoryList) {

        List<Category> categories = new ArrayList<>();

        for (String categoryName : categoryList) {
            if (existByNameCategory(categoryName)) {
                categories.add(findByName(categoryName));
            } else {
                categories.add(saveCategory(categoryName));
            }
        }
        return categories;
    }


}
