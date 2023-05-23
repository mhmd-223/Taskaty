package mapper;

import entity.Detail;

import java.util.List;

public interface DetailsMapperInterface {
    List<Detail> getDetailsOfList(Long listId);
}
