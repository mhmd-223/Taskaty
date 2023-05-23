package mapper;

import entity.Detail;

import java.sql.Connection;
import java.util.List;

public interface DetailsMapperInterface {
    List<Detail> getDetailsOfList(Connection connection,String query);
}
