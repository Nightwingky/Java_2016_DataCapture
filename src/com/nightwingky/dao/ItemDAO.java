package com.nightwingky.dao;

import com.nightwingky.vo.ItemDescriptionVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by nightwingky on 17-1-1.
 */
public class ItemDAO extends BaseDAO{

    public void addItem(ItemDescriptionVO itemDescriptionVO) {
        Connection conn = getConnection();

        try {
            String sql = "INSERT INTO tb_item_info(itemContentTitle, itemPicURL, itemDescription) " +
                    "values (?, ?, ?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, itemDescriptionVO.getItemContentTitle());
            preparedStatement.setString(2, itemDescriptionVO.getItemPicURL());
            preparedStatement.setString(3, itemDescriptionVO.getItemDescription());

            int count = preparedStatement.executeUpdate();
            if(count > 0) {
                System.out.println("Insert success!");
            } else {
                System.out.println("Insert failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn);
        }
    }

    public void updateTitle(String updateString, int i) throws SQLException {
        Connection conn = getConnection();

        String sql = "Update tb_item_info SET itemContentTitle = ? WHERE id = ?";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, updateString);
        preparedStatement.setInt(2, i);

        preparedStatement.execute();
    }

    public void updateDescription(String updateString, int i) throws SQLException {
        Connection conn = getConnection();

        String sql = "Update tb_item_info SET itemDescription = ? WHERE id = ?";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, updateString);
        preparedStatement.setInt(2, i);

        preparedStatement.execute();
    }

    public void updatePrice(String updateString, int i) throws SQLException {
        Connection conn = getConnection();

        String sql = "Update tb_item_info SET itemPrice = ? WHERE id = ?";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, updateString);
        preparedStatement.setInt(2, i);

        preparedStatement.execute();
    }
}
