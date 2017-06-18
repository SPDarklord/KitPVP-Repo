package net.pvping.kitpvp.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Thomas on 09/02/2017.
 */
public class Chat {


    private static Chat ins = new Chat();

    public static Chat get() {
        return ins;
    }

    public static String prefix = "§2KitPVP §5> §r";

    public String getPrefix() {
        return prefix;
    }

    public static void logCS(String s) {
        Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', s));
    }

    public static void pm(Player player, String msg, String targetName, String playerName, Player target) {
        player.sendMessage("§a[§5You §b-> §5" + targetName + "§a] §d" + msg);
        target.sendMessage("§a[§5You §b<- §5" + playerName + "§a] §d" + msg);
    }

    public static void sendMessage(Player players, String s) {
        players.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', s));
    }

    public static void sendMessage(CommandSender cs, String s) {
        cs.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', s));
    }

    public static void sendRaw(Player player, String s) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
    }

    public static void noPerms(Player player) {
        sendRaw(player, "§cYou can't do this!");
    }

    public static void bc(String msg) {
        for (Player players : Bukkit.getOnlinePlayers()) {
            sendMessage(players, ChatColor.YELLOW + msg);
        }
    }


    public static String formatDateDiff(long date) {
        Calendar c = new GregorianCalendar();
        c.setTimeInMillis(date);
        Calendar now = new GregorianCalendar();
        return formatDateDiff(now, c);
    }

    static int dateDiff(int type, Calendar fromDate, Calendar toDate,
                        boolean future) {
        int diff = 0;
        long savedDate = fromDate.getTimeInMillis();
        while (((future) && (!fromDate.after(toDate)))
                || ((!future) && (!fromDate.before(toDate)))) {
            savedDate = fromDate.getTimeInMillis();
            fromDate.add(type, future ? 1 : -1);
            diff++;
        }
        diff--;
        fromDate.setTimeInMillis(savedDate);
        return diff;
    }

    public static String formatDateDiff(Calendar fromDate, Calendar toDate) {
        boolean future = false;
        if (toDate.equals(fromDate)) {
            return "now";
        }
        if (toDate.after(fromDate)) {
            future = true;
        }
        StringBuilder sb = new StringBuilder();
        int[] types = { 1, 2, 5, 11, 12, 13 };

        String[] names = { "years",
                "year", "months",
                "month", "days",
                "day", "hours",
                "hour",
                "minutes",
                "minute",
                "seconds",
                "second" };

        int accuracy = 0;
        for (int i = 0; i < types.length; i++) {
            if (accuracy > 2) {
                break;
            }
            int diff = dateDiff(types[i], fromDate, toDate, future);
            if (diff > 0) {
                accuracy++;
                sb.append(" ").append(diff).append(" ").append(names[(i * 2 + 0)]);
            }
        }
        if (sb.length() == 0) {
            return "now";
        }
        return sb.toString().trim();
    }



    public String getShort(String name) {
        switch(name.length()){
            case 16:
                return name.substring(0, name.length() - 3);
            case 15:
                return name.substring(0, name.length() - 2);
            case 14:
                return name.substring(0, name.length() - 1);
        }
        return name;
    }

}
