package me.camden.ac.check;

import me.camden.ac.AntiCheatPlugin;

import java.util.HashMap;

public class CheckManager {
    private final HashMap<String, Check> checks = new HashMap<>();

    public void initChecks() {
        // Store Checks
        //putCheck(new ExampleCheck());

        // Register Event Listeners
        getChecks().values().forEach(check -> AntiCheatPlugin.getInstance().bus.registerListener(check));
    }


    public void putCheck(Check check) {
        checks.put(check.getClass().getName(), check);
    }

    public HashMap<String, Check> getChecks() {
        return checks;
    }
}
