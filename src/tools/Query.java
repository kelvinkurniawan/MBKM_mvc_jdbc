package tools;

public enum Query {

    GET_REGION("SELECT * FROM regions"),
    GET_BY_ID_REGION("SELECT * FROM regions WHERE region_id = ?"),
    UPDATE_REGION("UPDATE regions SET region_id = ?, region_name = ? WHERE region_id = ?"),
    DELETE_REGION("DELETE FROM regions WHERE region_id = ?"),
    INSERT_REGION("INSERT INTO regions(region_id, region_name) VALUES (?, ?)"),
    INSERT_OR_UPDATE_REGION("INSERT INTO regions(region_id, region_name) VALUES (?, ?) ON DUPLICATE KEY UPDATE region_name = ?");

    private final String displayQuery;

    Query(String displayQuery){
        this.displayQuery = displayQuery;
    }

    public String getDisplayQuery(){
        return displayQuery;
    }
}
