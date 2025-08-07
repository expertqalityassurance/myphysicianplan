package com.selenium.connectors;

import com.selenium.ui.helper.ResourceHelper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;


public class JsonConnector {
    public static String getConfig(String requestparam) {
        try {
            Object obj = new JSONParser().parse(new FileReader(ResourceHelper.getResourceHelper("/src/main/resources/config.json")));
            JSONObject jo = (JSONObject) obj;
            requestparam = (String) jo.get(requestparam);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return requestparam;
    }

}
