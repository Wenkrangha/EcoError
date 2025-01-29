package com.wenkrang.ecoError.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

public class EcoCommand implements CommandExecutor, TabCompleter {
    private static String helpText = """
§7[!]  §4EcoError - EcoError §7正在运行
 §4| §7help  帮助列表
 §4| §7board  获取图册
            """;
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 1) {
            helpText.lines().forEach(commandSender::sendMessage);
        } else switch (strings[1]) {
            case help
            case "board":

            default:
                if (strings[1].equals("help")) {
                    commandSender.sendMessage("§7[!]未知的操作" + strings[1]);
                }
                helpText.lines().forEach(commandSender::sendMessage);
                return false;
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return strings.length == 0 ? List.of("help", "board") : null;
    }
}
//你做一下命令，和boatfly 一样的命令提示，你先做吧，我先做一下图册和公告
