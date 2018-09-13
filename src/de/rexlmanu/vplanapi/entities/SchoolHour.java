package de.rexlmanu.vplanapi.entities;

public class SchoolHour {

    private String hour;
    private String data;

    public SchoolHour(String hour, String data) {
        this.hour = hour;
        this.data = data;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
