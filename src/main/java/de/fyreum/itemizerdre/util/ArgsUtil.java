package de.fyreum.itemizerdre.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.ChatColor;

public class ArgsUtil {

    public static String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static Component parse(String msg) {
        String message = color(msg);
        return MiniMessage.get().parse(message);
    }

}
