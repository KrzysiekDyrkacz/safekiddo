package pl.dyrkacz.safekiddo.entity.site;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.dyrkacz.safekiddo.client.CategoryClient;
import pl.dyrkacz.safekiddo.entity.category.Category;
import pl.dyrkacz.safekiddo.entity.category.CategoryServices;

import java.util.List;

class WebsiteServicesTest {

    private WebsiteRepository websiteRepository;
    private CategoryServices categoryServices;
    private CategoryClient categoryClient;
    private WebsiteServices sut;

    @BeforeEach
    public void beforeEach(){
        this.websiteRepository = Mockito.mock(WebsiteRepository.class);
        this.categoryServices = Mockito.mock(CategoryServices.class);
        this.categoryClient = Mockito.mock(CategoryClient.class);
        this.sut = new WebsiteServices(websiteRepository,categoryServices,categoryClient);
    }
    @Test
    void shouldSaveWebsite() {
        Mockito.when(websiteRepository.save(new Website()));



    }

}
