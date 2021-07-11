package pl.dyrkacz.safekiddo.controller;

import org.springframework.web.bind.annotation.*;
import pl.dyrkacz.safekiddo.client.CategoryClient;
import pl.dyrkacz.safekiddo.entity.site.Website;
import pl.dyrkacz.safekiddo.entity.site.WebsiteServices;
import pl.dyrkacz.safekiddo.entity.websitePart.WebsitePart;

import javax.transaction.Transactional;
import java.io.IOException;


@RestController
@RequestMapping("/website")
public class WebsiteController {

    private WebsiteServices websiteServices;
    private CategoryClient client;


    public WebsiteController(WebsiteServices websiteServices, CategoryClient client) {
        this.websiteServices = websiteServices;
        this.client = client;
    }

    @GetMapping("/getSite/{name}")
    public String getSite(@PathVariable String name) throws IOException {

        return websiteServices.getWebsite(name).toString();
    }

    @PostMapping("/addSite")
    public String addWebsite(@RequestBody Website website) {

        Website web = websiteServices.addWebsiteManual(website);

        return "Add: " + web.getSiteName() + "  " + " with categories:  " + web.getCategory().toString();

    }

    @DeleteMapping("/deleteSite/{name}")
    @Transactional
    public void deleteWebsite(@PathVariable String name) {
        websiteServices.deleteWebsite(name);
    }

    @PatchMapping("/updateSite/{name}")
    public String update(@PathVariable String name, @RequestBody WebsitePart websitePart) {


        if (websiteServices.existSiteInDb(name)) {
            websiteServices.updateWebsite(name, websitePart.getCategory());
            return "updated";
        } else {
            return "website does not exist";
        }


    }
}
