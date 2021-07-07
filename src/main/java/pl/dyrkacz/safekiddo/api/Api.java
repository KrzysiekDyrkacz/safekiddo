package pl.dyrkacz.safekiddo.api;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;

import java.net.URL;


@Service
public class Api {


   public String getData(String siteName) throws IOException {
       URL url = new URL("https://www.klazify.com/api/categorize?url= "+siteName);

       InputStreamReader reader = new InputStreamReader(url.openStream());
       System.out.println(reader.read());

       return "";
   }




}
