package com.company.util;

import com.company.models.QueuedOrder;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class InputParser {
    public static List<QueuedOrder> parseOrdersFromFile(String filePath) throws Exception {
        JSONParser parser = new JSONParser();
        JSONArray a = (JSONArray) parser.parse(new FileReader(filePath));
        List<QueuedOrder> queuedOrderList = new ArrayList<>();

        for (Object o : a)
        {
            JSONObject jsonObject = (JSONObject) o;

            /*String name = (String) person.get("name");
            System.out.println(name);

            String city = (String) person.get("city");
            System.out.println(city);

            String job = (String) person.get("job");
            System.out.println(job);

            JSONArray cars = (JSONArray) person.get("cars");

            for (Object c : cars)person
            {
                System.out.println(c+"");
            }*/
            QueuedOrder queuedOrder = new Gson().fromJson(jsonObject.toJSONString(),QueuedOrder.class);
            queuedOrderList.add(queuedOrder);
        }
        return queuedOrderList;
    }

}
