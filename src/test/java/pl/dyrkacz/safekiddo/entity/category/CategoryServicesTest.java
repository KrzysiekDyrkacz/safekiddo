package pl.dyrkacz.safekiddo.entity.category;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServicesTest {

    @InjectMocks
    private CategoryServices categoryServices;

    @Mock
    private CategoryRepository mockCategoryRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldFindCategoryByNameAndReturnCategory() {
        //given
        Category category = new Category("categoryName");
        when(mockCategoryRepository.findCategoryByName("categoryName")).thenReturn(category);
        //when
        var categoryFound = categoryServices.findByName("categoryName");
        //then
        assertThat(categoryFound.getName().equals(category.getName()));
        verify(mockCategoryRepository).findCategoryByName("categoryName");
    }

    @Test
    void shouldReturnFalseIfCategoryDoesntExistInDb(){
        //given
        when(mockCategoryRepository.existsByName("categoryNameNotInDb")).thenReturn(false);
        //when
        var categoryFound = categoryServices.existByNameCategory("categoryNameNotInDb");
        //then
        assertThat(categoryFound).isEqualTo(false);
    }

    @Test
    void shouldSaveCategoryByNameAndReturnTheSameCategory() {
        //given
        Category category = new Category("name");
        when(mockCategoryRepository.save(Mockito.any(Category.class)))
                .thenAnswer(c -> c.getArguments()[0]);
        //when
        var savedCategory = categoryServices.saveCategory("name");
        //then
        assertThat(savedCategory.getName().equals(category.getName()));

    }
}
