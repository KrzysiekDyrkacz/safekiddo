package pl.dyrkacz.safekiddo.entity.site;

import org.springframework.stereotype.Service;
import pl.dyrkacz.safekiddo.client.CategoryClient;
import pl.dyrkacz.safekiddo.entity.category.CategoryServices;

import java.io.IOException;

@Service
public class WebsiteServices {

    private WebsiteRepository websiteRepository;
    private CategoryServices categoryServices;
    private CategoryClient categoryClient;

    public WebsiteServices(WebsiteRepository websiteRepository, CategoryServices categoryServices, CategoryClient categoryClient) {
        this.websiteRepository = websiteRepository;
        this.categoryServices = categoryServices;
        this.categoryClient = categoryClient;
    }

    public Website saveWebsite(Website website) {
        websiteRepository.save(website);
        return website;

    }

    public boolean existSiteInDb(String name){
        return websiteRepository.existsById(name);
    }
    public Website getWebsiteById(String name){
       return websiteRepository.getById(name);
    }


    public Website getWebsite(String name) throws IOException {
        if(existSiteInDb(name)){
            return getWebsiteById(name);
        }
        else{
            Website website = new Website();
            website.setSiteName(name);
            website.setCategory(categoryServices.saveIfDoesntExist(categoryClient.getData(name)));
            return saveWebsite(website);
        }

    }

    public Website addWebsiteManual(Website website){
        if(existSiteInDb(website.getSiteName())){
            return getWebsiteById(website.getSiteName());
        }else{
            Website websiteManual = new Website();
            websiteManual.setSiteName(website.getSiteName());
            website.setCategory(categoryServices.saveIfDoesntExist(categoryClient.getCategoryFromPost(website)));
            return saveWebsite(website);
        }

    }
     public void deleteWebsite(String name){
        websiteRepository.deleteBySiteName(name);
     }




}
