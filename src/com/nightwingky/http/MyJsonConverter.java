package com.nightwingky.http;

import com.nightwingky.vo.ContentVO;
import com.nightwingky.vo.ItemDescriptionVO;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nightwingky on 16-12-30.
 */

public class MyJsonConverter {

    public static List<ContentVO> convertContentJsonString(String jsonString){
        List<ContentVO> contentVOList = new ArrayList<ContentVO>();
        ContentVO contentVO;

        JSONObject jsonObject = new JSONObject(jsonString);

        JSONArray jsonArray = jsonObject.getJSONArray("data");

        for(int i = 0; i < jsonArray.length(); i++) {
            jsonObject = jsonArray.getJSONObject(i);
            contentVO = new ContentVO();
            contentVO.setContentImageURL(jsonObject.getString("picSmall"));
            contentVO.setContentTitle(jsonObject.getString("name"));
            contentVO.setContentPrice(jsonObject.getString("description"));

            contentVOList.add(contentVO);
        }

        return contentVOList;
    }

    public static List<ItemDescriptionVO> convertItemJsonString(String jsonString) {
        List<ItemDescriptionVO> itemDescriptionVOList = new ArrayList<ItemDescriptionVO>();
        ItemDescriptionVO itemDescriptionVO = null;

        JSONObject jsonObject = new JSONObject(jsonString);

        JSONArray jsonArray = jsonObject.getJSONArray("data");

        for(int i = 0; i < jsonArray.length(); i++) {
            jsonObject = jsonArray.getJSONObject(i);
            itemDescriptionVO = new ItemDescriptionVO();
            itemDescriptionVO.setItemContentTitle(jsonObject.getString("name"));
            itemDescriptionVO.setItemPicURL(jsonObject.getString("picBig"));
            itemDescriptionVO.setItemDescription(jsonObject.getString("description"));

            itemDescriptionVOList.add(itemDescriptionVO);
        }

        return itemDescriptionVOList;
    }

    public static void main(String[] args) {
        try {
            String jsonString = HttpQuery.getQueryContent();
            List<ContentVO> contentVOList = MyJsonConverter.convertContentJsonString(jsonString);

            for (ContentVO c : contentVOList) {
                System.out.println(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("*******************************************************");

        try {
            String jsonString = HttpQuery.getQueryContent();
            List<ItemDescriptionVO> itemDescriptionVOList = MyJsonConverter.convertItemJsonString(jsonString);

            for (ItemDescriptionVO d : itemDescriptionVOList) {
                System.out.println(d);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
