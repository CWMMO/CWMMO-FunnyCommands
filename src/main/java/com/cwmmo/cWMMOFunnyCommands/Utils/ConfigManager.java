package com.cwmmo.cWMMOFunnyCommands.Utils;

import com.cwmmo.cWMMOFunnyCommands.CWMMOFunnyCommands;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;
import java.util.Objects;

public class ConfigManager {
    public final FileConfiguration CONFIG =
            CWMMOFunnyCommands.INSTANCE.getConfig();

    public Component getLocale(String key) {
        return MiniMessage.miniMessage().deserialize(
                Objects.requireNonNull(CONFIG.getString(key))
        );
    }
    public Component getLocale(String key, Object... formatted) {
        return MiniMessage.miniMessage().deserialize(
                Objects.requireNonNull(CONFIG.getString(key).formatted(formatted))
        );
    }

    public String getString(String key) {
        return CONFIG.getString(key);
    }
    public String getString(String key, Object... formatted) {
        return CONFIG.getString(key).formatted(formatted);
    }

    public List<String> getStringList(String key) {
        return CONFIG.getStringList(key);
    }
}
