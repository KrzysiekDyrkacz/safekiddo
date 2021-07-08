package pl.dyrkacz.safekiddo.client;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.dyrkacz.safekiddo.entity.site.Website;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
public class CategoryClient {

    @Value("${token}")
    String token;

    public List<String> getData(String siteName) throws IOException {
        URL url = new URL("https://www.klazify.com/api/categorize?url=http://" + siteName);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        HttpEntity httpEntity = new HttpEntity(headers);
        ResponseEntity<String> entity = restTemplate.exchange(url.toString(),
                HttpMethod.POST,
                httpEntity,
                String.class);

        JSONObject obj = new JSONObject(entity.getBody());
        JSONArray jsonArray = obj.getJSONObject("domain").getJSONArray("categories");

        return IntStream.range(0, jsonArray.length())
                .mapToObj(index -> ((JSONObject) jsonArray.get(index)).optString("name"))
                .collect(Collectors.toList());

    }

    public List<String> getCategoryFromPost(Website website){
        JSONObject jsonObject = new JSONObject(website);
        JSONArray jsonArray = jsonObject.getJSONArray("category");

        return IntStream.range(0, jsonArray.length())
                .mapToObj(index -> ((JSONObject) jsonArray.get(index)).optString("name"))
                .collect(Collectors.toList());

    };


}





