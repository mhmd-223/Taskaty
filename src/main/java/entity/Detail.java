package entity;

import java.util.Objects;

public class Detail {
    private String key, value;
    private Long id, listId;

    public Detail() {
    }

    public Detail(String key, String value, Long listId) {
        this.key = key;
        this.value = value;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detail detail = (Detail) o;
        return Objects.equals(key, detail.key) && Objects.equals(value, detail.value) && Objects.equals(listId, detail.listId);
    }

}
