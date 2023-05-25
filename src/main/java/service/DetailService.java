package service;

import entity.Detail;
import repository.DetailsRepository;

import java.util.List;

public class DetailService {
    private final DetailsRepository repository;

    public DetailService(DetailsRepository repository) {
        this.repository = repository;
    }

    public boolean addDetail(Detail detail) {
        try {
            repository.createDetail(detail);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public boolean updateDetail(Detail detail, Long listID) {
        try {
            Detail updated = isExisted(listID, detail);
            if (updated == null)
                repository.updateDetail(detail);
            else
                repository.createDetail(detail);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public boolean deleteDetail(Long id) {
        try {
            repository.deleteDetail(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Detail> getListDetails(Long listID) {
        try {
            return repository.getDetailsByListId(listID);
        } catch (Exception e) {
            return null;
        }
    }

    private Detail isExisted(Long listID, Detail compared) {
        List<Detail> details = getListDetails(listID);
        for (Detail detail : details) {
            if (detail.equals(compared))
                return null;
        }
        return compared;
    }

}
