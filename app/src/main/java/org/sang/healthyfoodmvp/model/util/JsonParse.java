package org.sang.healthyfoodmvp.model.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.sang.healthyfoodmvp.model.FoodEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王松 on 2016/10/8.
 */

public class JsonParse {
    public static List<FoodEntity> parseJson2FoodList(String jsonStr) {
        List<FoodEntity> list = new ArrayList<>();
        try {
            JSONObject jo = new JSONObject(jsonStr);
            JSONArray tngou = jo.getJSONArray("tngou");
            for (int i = 0; i < tngou.length(); i++) {
                JSONObject data = tngou.getJSONObject(i);
                String description = data.getString("description");
                String keywords = data.getString("keywords");
                String img = "http://tnfs.tngou.net/image"+data.getString("img");
                list.add(new FoodEntity(img,keywords,description));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
