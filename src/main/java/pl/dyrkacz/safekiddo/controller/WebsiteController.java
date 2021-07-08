package pl.dyrkacz.safekiddo.controller;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import pl.dyrkacz.safekiddo.entity.category.Category;
import pl.dyrkacz.safekiddo.entity.category.CategoryServices;
import pl.dyrkacz.safekiddo.entity.site.Website;
import pl.dyrkacz.safekiddo.entity.site.WebsiteServices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/website")
public class WebsiteController {

   private WebsiteServices websiteServices;
   private CategoryServices categoryServices;

    public WebsiteController(WebsiteServices websiteServices) {
        this.websiteServices = websiteServices;
    }

    @GetMapping("/getSite/{name}")
    public String getSite(@PathVariable String name) throws IOException {

        return websiteServices.getWebsite(name).toString();
    }
    @PostMapping("/addWebsite")
    public String addWebsite(@RequestBody Website website){

      Website web = websiteServices.addWebsiteManual(website);

      return "Add: " + web.getSiteName() + "  " + " with categories:  " + web.getCategory().toString();

    }
}
