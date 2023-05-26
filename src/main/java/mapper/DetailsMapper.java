package mapper;

import entity.Detail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DetailsMapper implements DetailsMapperInterface {

    @Override
    public List<Detail> getDetailsOfList(Connection connection, String query) {
        List<Detail> details = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Detail detail = new Detail();
                detail.setId(resultSet.getLong("id"));
                detail.setValue(resultSet.getString("value_"));
                detail.setKey(resultSet.getString("key_"));
                detail.setListId(resultSet.getLong("listid"));
                details.add(detail);
            }
            resultSet.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return details;
    }
}
