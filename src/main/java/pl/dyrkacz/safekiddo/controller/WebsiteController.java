package pl.dyrkacz.safekiddo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dyrkacz.safekiddo.entity.site.WebsiteServices;

import java.io.IOException;


@RestController
@RequestMapping("/website")
public class WebsiteController {

   private WebsiteServices websiteServices;

    public WebsiteController(WebsiteServices websiteServices) {
        this.websiteServices = websiteServices;
    }

    @GetMapping("/getSite/{name}")
    public String getSite(@PathVariable String name) throws IOException {

        return websiteServices.getWebsite(name).toString();
    }
}
