package pl.dyrkacz.safekiddo.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("/website")
public class WebsiteController {

    @GetMapping("/getSite/{name}")
    public void getSite(@PathVariable String name){
        String jwt = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiMTMwZjE0OTJkYmI4MDdjMGY2YzAwOWIwM2E0MWY5YzJkZDQ0MTU2OWU5NDIyMjQ1ZDE3ZjM5M2RmNGU1MmUwZmY3YzYzZjllNWQ0ZDM4MDgiLCJpYXQiOjE2MjU2ODY3NDQsIm5iZiI6MTYyNTY4Njc0NCwiZXhwIjoxNjU3MjIyNzQ0LCJzdWIiOiIyOTQ0Iiwic2NvcGVzIjpbXX0.qdGt0P5OMAtSbYNAI2Wg6kGUqWCXq29d9O7j8pTAnZciGkGmGT9pBbv401--t7Cmh1kprfcps5YyMlvib7G2CQ";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer "+ jwt);
        HttpEntity httpEntity = new HttpEntity(headers);
        ResponseEntity<String> entity = restTemplate.exchange("https://www.klazify.com/api/categorize?url=http://interia.pl ",
                HttpMethod.POST,
                httpEntity,
                String.class);

        System.out.println(entity.getBody());


    }
}
