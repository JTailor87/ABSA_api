package org.example.payloads;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PostPayload {
    public HashMap postPayload(){
        /*Below is the payload needs to be construct*/
        /*{
            "id": 20,
            "category": {
                    "id": 30,
                    "name": "abc"
                },
            "name": "doggie",
            "photoUrls": ["https://www.abc.com"],
            "tags": [
                        {
                            "id": 30,
                            "name": "abc"
                        }
                    ],
            "status": "available"
        }*/

        HashMap Payload = new HashMap();
        Payload.put("id", 9044);
        HashMap Category = new HashMap();
        Category.put("id", 30);
        Category.put("name", "abc");
        Payload.put("category", Category);
        Payload.put("name", "doggie");
        String urlArray[] = {"https://www.abc.com"};
        Payload.put("photoUrls", urlArray);
        List<Map<String,Object>> TagList = new LinkedList<Map<String,Object>>();
        TagList.add(Category);
        Payload.put("tags", TagList);
        Payload.put("status", "available");

        return Payload;
    }
    public HashMap putPayload(Integer id){
        HashMap Payload = new HashMap();
        Payload.put("id", id);
        HashMap Category = new HashMap();
        Category.put("id", 30);
        Category.put("name", "xyz");
        Payload.put("category", Category);
        Payload.put("name", "fish");
        String urlArray[] = {"https://www.xyz.com"};
        Payload.put("photoUrls", urlArray);
        List<Map<String,Object>> TagList = new LinkedList<Map<String,Object>>();
        TagList.add(Category);
        Payload.put("tags", TagList);
        Payload.put("status", "available");

        return Payload;
    }
}
