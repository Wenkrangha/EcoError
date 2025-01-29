package com.wenkrang.ecoError.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

public class EcoCommand implements CommandExecutor, TabCompleter {
    private static String helpText = 
"""
§7[!]  §4EcoError - EcoError §7正在运行
 §4| §7help      帮助列表
 §4| §7board     获取图册
 §4| §7camera    获取相机
 §4| §7announce  查看公告
""";
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) { /*todo*/
        if ((strings.length == 0 ? "help" : strings[0]).equals("help")) {
            helpText.lines().forEach(commandSender::sendMessage);
            return true;
        } else switch (strings[0]) {
            case "board":
                return true;
            case "camera":
                return true;
            case "announce":
                return true;
            default:
                commandSender.sendMessage("§7[!]未知的操作" + strings[0]);
                helpText.lines().forEach(commandSender::sendMessage);
                return false;
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return strings.length == 0 ? List.of("announce", "board", "camera", "help") : List.of("没了......");
    }
}
//你做一下命令，和boatfly 一样的命令提示，你先做吧，我先做一下图册和公告
