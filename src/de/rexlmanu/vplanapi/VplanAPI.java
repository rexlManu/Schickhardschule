package de.rexlmanu.vplanapi;

import de.rexlmanu.vplanapi.manager.SchoolManager;
import de.rexlmanu.vplanapi.misc.Days;

public class VplanAPI {

    private static SchoolManager schoolManager;

    static {
        schoolManager = new SchoolManager();
    }
    public VplanAPI() {
    }

    public void onShutdown() {

    }

    public void onLaunch() {
        System.out.println(schoolManager.loadSchoolPlan(Days.FRIDAY.getUrl()));
    }

    public static SchoolManager getSchoolManager() {
        return schoolManager;
    }
}
