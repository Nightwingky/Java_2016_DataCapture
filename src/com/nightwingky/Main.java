package com.nightwingky;

import com.nightwingky.dao.ContentDAO;
import com.nightwingky.dao.ItemDAO;
import com.nightwingky.http.HttpQuery;
import com.nightwingky.http.MyJsonConverter;
import com.nightwingky.vo.ContentVO;
import com.nightwingky.vo.ItemDescriptionVO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {
	// write your code here

        String content = HttpQuery.getQueryContent();

//        List<ContentVO> mList = MyJsonConverter.convertContentJsonString(content);

//        ContentDAO contentDAO = new ContentDAO();

//        for (int i = 0; i < mList.size(); i++) {
//            contentDAO.addContent(mList.get(i));
//        }
//
//        mList = contentDAO.quertAll();
//        for (int i = 0; i < mList.size(); i++) {
//            System.out.println(mList.get(i));
//        }

//        for (int i = 0; i < mList.size(); i++) {
//            try {
//                contentDAO.updateAllNewsTitle("Title" + i, i);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        for (int i = 0; i <= mList.size(); i++) {
//            try {
//                contentDAO.updateAllNewsContent(String.valueOf((double) i), i);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        mList = contentDAO.quertAll();
//        for (int i = 0; i < mList.size(); i++) {
//            System.out.println(mList.get(i));
//        }
//
//        for (int i = 0; i < mList.size(); i++) {
//            contentDAO.addContent(mList.get(i));
//        }

        ItemDAO itemDAO = new ItemDAO();

        List<ItemDescriptionVO> itemList = MyJsonConverter.convertItemJsonString(content);

//        for (ItemDescriptionVO i : itemList) {
//            itemDAO.addItem(i);
//        }
        for (int i = 0; i <= itemList.size(); i++) {
            try {
                itemDAO.updateTitle("Title" + i, i);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i <= itemList.size(); i++) {
            try {
                itemDAO.updateDescription("This is the description of commodity " + i, i);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i <= itemList.size(); i++) {
            itemDAO.updatePrice(String.valueOf((double) i), i);
        }
    }
}
