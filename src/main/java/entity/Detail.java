package entity;

public class Detail {
    private String key, value;
    private Long id, listId;

    public Detail() {
    }

    public Detail(String key, String value, Long id, Long listId) {
        this.key = key;
        this.value = value;
        this.id = id;
        this.listId = listId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getListId() {
        return listId;
    }

    public void setListId(Long listId) {
        this.listId = listId;
    }
}
