package de.rexlmanu.vplanapi.bootstrap;

import de.rexlmanu.vplanapi.VplanAPI;

public class VplanAPILaunch {

    public static void main(String[] args) {
        VplanAPI api = new VplanAPI();
        Runtime.getRuntime().addShutdownHook(new Thread(api::onShutdown));
        api.onLaunch();
    }
}
