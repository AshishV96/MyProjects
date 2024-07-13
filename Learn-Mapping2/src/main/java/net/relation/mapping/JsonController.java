package net.relation.mapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonController {

    @PostMapping("getJsonAsString")
    public void getJsonAsString(String json) {

        String question = json.substring(json.indexOf('[')).replaceAll("[\\s\\[\\]]", "");

    }

}
