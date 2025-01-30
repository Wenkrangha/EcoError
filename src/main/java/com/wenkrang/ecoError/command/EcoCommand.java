package com.wenkrang.ecoError.command;

import com.wenkrang.ecoError.gui.board.BoardGUI;
import com.wenkrang.ecoError.item.BoardItem;
import com.wenkrang.ecoError.item.PublicItem;
import com.wenkrang.ecoError.lib.JavaUse;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.List;

public class EcoCommand implements CommandExecutor, TabCompleter {
    private static final String HELP_TEXT =
"""
§7[!]  §4EcoError - EcoError §7正在运行
 §4| §7help      帮助列表
 §4| §7board     获取图册
 §4| §7camera    获取相机
 §4| §7announce  查看公告""";
    @Override
    public boolean onCommand(@Nonnull CommandSender commandSender,
                             @Nonnull Command command,
                             @Nonnull String s,
                             @Nonnull String[] strings) {
        if ((strings.length == 0 ? "help" : strings[0]).equalsIgnoreCase("help")) {
            HELP_TEXT.lines().forEach(commandSender::sendMessage);
            return true;
        } else return switch (strings[0].toLowerCase()) {
            case "board" -> switch (commandSender) {
                case Player player -> {
                    player.getInventory().addItem(PublicItem.get_book());
                    yield true;
                }
                case CommandSender cs1 -> {
                    cs1.sendMessage("§7[!]只有玩家才能使用这个命令");
                    yield false;
                }
            };
            case "camera" -> switch (commandSender) {
                case Player player -> {
                    player.getInventory().addItem(PublicItem.get_camara());
                    yield true;
                }
                case CommandSender cs1 -> {
                    cs1.sendMessage("§7[!]只有玩家才能使用这个命令");
                    yield false;
                }
            };
            case "announce" -> {
                try {
                    BoardGUI.openboard((Player)commandSender);
                    yield true;
                } catch (ClassCastException ignored) {
                    JavaUse.nn(JavaUse.nn(BoardItem.boardHead().getItemMeta()).getLore())
                            .forEach(commandSender::sendMessage);
                    yield true;
                } catch (IOException | InvalidConfigurationException e) {
                    commandSender.sendMessage("§7[!]出错了！" + e.getMessage());
                    for (var i = 0; i < 3; i++) {
                        commandSender.sendMessage("§7[!]" + e.getStackTrace()[i].toString());
                    }
                    yield false;
                }
            }
            default -> {
                commandSender.sendMessage("§7[!]未知的操作" + strings[0]);
                HELP_TEXT.lines().forEach(commandSender::sendMessage);
                yield false;
            }
        };
    }

    @Override
    public List<String> onTabComplete(@Nonnull CommandSender commandSender,
                                      @Nonnull Command command,
                                      @Nonnull String s,
                                      @Nonnull String[] strings) {
        return strings.length == 0 ?
                commandSender instanceof Player ?
                        List.of("announce", "board", "camera", "help")
                        : List.of("announce", "help")
                : List.of("没了......");
    }
}