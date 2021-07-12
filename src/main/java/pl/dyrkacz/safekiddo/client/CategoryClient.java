package pl.dyrkacz.safekiddo.client;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import pl.dyrkacz.safekiddo.entity.site.Website;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
public class CategoryClient {

//    @Value("${token}")
//    String token;

    public List<String> getData(String siteName) throws IOException {
//        URL url = new URL("https://www.klazify.com/api/categorize?url=https://" + siteName);
//
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authorization", "Bearer " + token);
//        headers.add("Accept","application/json");
//        headers.add("Content-Type","application/json");
//        headers.add("cache-control","no-cache");
//        HttpEntity httpEntity = new HttpEntity(headers);
//        ResponseEntity<String> entity = restTemplate.exchange(url.toString(),
//                HttpMethod.POST,
//                httpEntity,
//                String.class);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        Map map = new HashMap<String, String>();
        map.put("Content-Type", "application/json");
        map.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiMTMwZjE0OTJkYmI4MDdjMGY2YzAwOWIwM2E0MWY5YzJkZDQ0MTU2OWU5NDIyMjQ1ZDE3ZjM5M2RmNGU1MmUwZmY3YzYzZjllNWQ0ZDM4MDgiLCJpYXQiOjE2MjU2ODY3NDQsIm5iZiI6MTYyNTY4Njc0NCwiZXhwIjoxNjU3MjIyNzQ0LCJzdWIiOiIyOTQ0Iiwic2NvcGVzIjpbXX0.qdGt0P5OMAtSbYNAI2Wg6kGUqWCXq29d9O7j8pTAnZciGkGmGT9pBbv401--t7Cmh1kprfcps5YyMlvib7G2CQ");

        headers.setAll(map);

        Map req_payload = new HashMap();
        req_payload.put("url", "https://"+siteName);

        HttpEntity<?> request = new HttpEntity<>(req_payload, headers);
        String url = "https://www.klazify.com/api/categorize";

        ResponseEntity<String> entity = new RestTemplate().postForEntity(url, request, String.class);




        JSONObject obj = new JSONObject(entity.getBody());
        JSONArray jsonArray = obj.getJSONObject("domain").getJSONArray("categories");

        return IntStream.range(0, jsonArray.length())
                .mapToObj(index -> ((JSONObject) jsonArray.get(index)).optString("name"))
                .collect(Collectors.toList());

    }

    public List<String> getCategoryFromPost(Website website) {
        JSONObject jsonObject = new JSONObject(website);
        JSONArray jsonArray = jsonObject.getJSONArray("category");

        return IntStream.range(0, jsonArray.length())
                .mapToObj(index -> ((JSONObject) jsonArray.get(index)).optString("name"))
                .collect(Collectors.toList());

    }

    ;


}





