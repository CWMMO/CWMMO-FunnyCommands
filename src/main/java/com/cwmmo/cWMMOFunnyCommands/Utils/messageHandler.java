package com.cwmmo.cWMMOFunnyCommands.Utils;

import com.cwmmo.cWMMOFunnyCommands.CWMMOFunnyCommands;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;

public class messageHandler {
    private final ConfigManager configManager =
            new ConfigManager();
    private final String ymlpath;
    private final long waittime;

    private final List<String> colors;
    private final List<String> formats;

    public messageHandler(String ymlpath, long seconds) {
        this.ymlpath = ymlpath;

        this.colors = configManager.getStringList("utils.colors");
        this.formats = configManager.getStringList("utils.formats");

        this.waittime = seconds * 1000;
    }

    public void LoopLyrics() {

        for (String lyric : configManager.getStringList(ymlpath)) {
            String colour = getRandomElement(colors);
            String format = getRandomElement(formats);

            CWMMOFunnyCommands.INSTANCE.getServer().broadcast(
                    configManager.getLocale("utils.header-template", colour, format, lyric)
            ); // header (colour, format, and lyric are passed into the built in .format() method)

            for (Player player : CWMMOFunnyCommands.INSTANCE.getServer().getOnlinePlayers())
                player.chat(lyric); // no brackets cause im js chill like that ykyk

            try {
                wait(waittime);
            } catch (InterruptedException e) {
                // couldn't wait :'(
            }
        }
    }

    public static <O> O getRandomElement(List<O> list) {
        Random random = new Random();
        int randomIndex = random.nextInt(list.size());

        return list.get(randomIndex);
    }

}
