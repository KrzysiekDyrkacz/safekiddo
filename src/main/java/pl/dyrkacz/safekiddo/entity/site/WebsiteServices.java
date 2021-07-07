package pl.dyrkacz.safekiddo.entity.site;

import org.springframework.stereotype.Service;

@Service
public class WebsiteServices   {

    private WebsiteRepository websiteRepository;

    public WebsiteServices(WebsiteRepository websiteRepository) {
        this.websiteRepository = websiteRepository;
    }

    public void saveWebsite( Website website){
        websiteRepository.save(website);
    }

}
