package mapper;

import entity.Detail;
import repository.MySQLConfigure;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DetailsMapper implements DetailsMapperInterface {
    private Detail detail = new Detail();

    @Override
    public List<Detail> getDetailsOfList(Long listId) {
        Connection connection = MySQLConfigure.getConnection();
        String query = "Select * from Detail where ListId=" + listId;
        List<Detail> details = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                detail.setId(resultSet.getLong("Id"));
                detail.setValue(resultSet.getString("Value"));
                detail.setKey(resultSet.getString("Key"));
                detail.setListId(resultSet.getLong("ListId"));
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
