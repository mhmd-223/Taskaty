package repository.mysql;

import entity.Detail;
import mapper.DetailsMapper;
import repository.DetailsRepository;
import repository.MySQLConfigure;
import utilities.QueryBuilder;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySQLDetailsRepo implements DetailsRepository {

    @Override
    public void createDetail(Detail detail) {
        String detailValues ="null,"+detail.getListId()+",'"+detail.getKey()+"','"+detail.getValue()+"'";
        String createQuery = new QueryBuilder().insert("detail", detailValues).build();
        MySQLConfigure.accessDatabase(MySQLConfigure.getConnection(),createQuery);
    }

    @Override
    public void updateDetail(Detail detail) {
        Map<String, String> attributes = new HashMap<>();
        attributes.put("id",Long.toString(detail.getId()));
        attributes.put("listid",Long.toString(detail.getListId()));
        attributes.put("key_","'"+detail.getKey()+"'");
        attributes.put("value_","'"+detail.getValue()+"'");
        String updateQuery = new QueryBuilder()
                .update("detail")
                .set(attributes)
                .where("id=" +detail.getId())
                .build();
        MySQLConfigure.accessDatabase(MySQLConfigure.getConnection(),updateQuery);
    }

    @Override
    public void deleteDetail(Long detailID) {
        String deleteQuery = new QueryBuilder()
                .delete("detail")
                .where("id=" +detailID)
                .build();
        MySQLConfigure.accessDatabase(MySQLConfigure.getConnection(),deleteQuery);
    }

    @Override
    public List<Detail> getDetailsByListId(Long listId) {
        //String query = "Select * from Detail where ListId=" + listId;
        String query = new QueryBuilder()
                .select("*")
                .from("detail")
                .where("listid="+listId)
                .build();
        return new DetailsMapper().getDetailsOfList(MySQLConfigure.getConnection(),query);
    }
}
