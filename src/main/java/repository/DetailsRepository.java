package repository;

import entity.Detail;

import java.util.List;

public interface DetailsRepository {
    void createDetail(Detail detail);
    void updateDetail(Detail detail);
    void deleteDetail(Long detailID);
    List<Detail> getDetailsByListId(Long listId);
}
