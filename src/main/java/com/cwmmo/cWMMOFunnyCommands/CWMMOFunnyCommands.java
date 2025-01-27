package com.cwmmo.cWMMOFunnyCommands;

import com.cwmmo.cWMMOFunnyCommands.Commands.KarmaCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class CWMMOFunnyCommands extends JavaPlugin {
    public static CWMMOFunnyCommands INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;

        saveDefaultConfig();

        getCommand("karma").setExecutor(new KarmaCommand());
    }

}
