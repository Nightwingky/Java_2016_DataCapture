package com.nightwingky;

import com.nightwingky.dao.ContentDAO;
import com.nightwingky.http.HttpQuery;
import com.nightwingky.http.MyJsonConverter;
import com.nightwingky.vo.ContentVO;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here

        String content = HttpQuery.getQueryContent();

        List<ContentVO> mList = MyJsonConverter.convertJsonString(content);

        ContentDAO contentDAO = new ContentDAO();

        for(int i = 0; i < mList.size(); i++) {
            contentDAO.addStudent(mList.get(i));
        }

        mList = contentDAO.quertAll();
        for(int i = 0; i < mList.size(); i++) {
            System.out.println(mList.get(i));
        }
    }
}
