package utils;

public enum ApiResources {
    ADDPLACE("maps/api/place/add/json");

    private String resource;

    ApiResources(String s) {
        this.resource = s;
    }

    public String getResource() {
        return resource;
    }
}
