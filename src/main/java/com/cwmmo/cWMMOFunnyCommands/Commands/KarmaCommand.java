package com.cwmmo.cWMMOFunnyCommands.Commands;

import com.cwmmo.cWMMOFunnyCommands.CWMMOFunnyCommands;
import com.cwmmo.cWMMOFunnyCommands.Utils.ConfigManager;
import com.cwmmo.cWMMOFunnyCommands.Utils.messageHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class KarmaCommand implements CommandExecutor {
    private final CWMMOFunnyCommands INSTANCE =
            CWMMOFunnyCommands.INSTANCE;
    private final ConfigManager configManager = new ConfigManager();
    private final messageHandler messageHandler = new messageHandler("commands.karma.contents.lyrics", 1);

    @Override
    public boolean onCommand(@NotNull CommandSender sender,
                             @NotNull Command command,
                             @NotNull String label,
                             @NotNull String[] args) {
        if (!(sender instanceof Player) || sender.hasPermission(configManager.getString("commands.karma.permission"))) {
            sender.sendMessage(configManager.getLocale("commands.karma.contents.messages.executed"));

            messageHandler.LoopLyrics();
        } else {
            sender.sendMessage(configManager.getLocale("commands.karma.permission-message"));
        }

        return true;
    }
}
