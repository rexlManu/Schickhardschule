package de.rexlmanu.vplanapi.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchoolPlan {

    private long createdAt;
    private long lastChangeAt;
    private Map<SchoolClass, List<SchoolHour>> classes;

    public SchoolPlan() {
        this.classes = new HashMap<>();
    }

    public Map<SchoolClass, List<SchoolHour>> getClasses() {
        return classes;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getLastChangeAt() {
        return lastChangeAt;
    }

    public void setLastChangeAt(long lastChangeAt) {
        this.lastChangeAt = lastChangeAt;
    }

    public void setClasses(Map<SchoolClass, List<SchoolHour>> classes) {
        this.classes = classes;
    }
}
