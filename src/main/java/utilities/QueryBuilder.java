package utilities;

import java.util.Map;

/**
 * This class is responsible for building basic SQL queries.
 */
public class QueryBuilder {

    private final StringBuilder query;

    public QueryBuilder() {
        query = new StringBuilder();
    }


    public QueryBuilder select(String columns) {
        query.append("SELECT ").append(columns);
        return this;
    }

    public QueryBuilder from(String tables) {
        query.append(" FROM ").append(tables);
        return this;
    }

    public QueryBuilder where(String condition) {
        query.append(" WHERE ").append(condition);
        return this;
    }

    public QueryBuilder insert(String table, String values) {
        query.append("INSERT INTO ").append(table).append(" VALUES(").append(values).append(")");
        return this;
    }

    public QueryBuilder delete(String table) {
        query.append("DELETE FROM ").append(table);
        return this;
    }

    public QueryBuilder update(String table) {
        query.append("UPDATE ").append(table).append(" SET ");
        return this;
    }

    public QueryBuilder set(Map<String, String> values) {
        values.forEach((key, value) -> query.append(key).append("=").append(value).append(","));
        query.deleteCharAt(query.length() - 1);
        return this;
    }


    public String build() {
        return query + ";";
    }

}
