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
    private final Detail detail = new Detail();

    @Override
    public List<Detail> getDetailsOfList(Connection connection,String query) {
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
