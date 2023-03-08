package tsp.demonicexpansion.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tsp.demonicexpansion.implementation.entity.Entities;
import tsp.smartplugin.command.SmartCommand;
import tsp.smartplugin.player.PlayerUtils;

public class DXCommand extends SmartCommand {

    public DXCommand() {
        super("dx", "dx.command.use", "&c没有权限!");
    }

    @Override
    public void handle(CommandSender sender, String[] args) {
        if (!(sender instanceof Player player)) {
            PlayerUtils.sendMessage(sender, "&c仅限在线玩家!");
            return;
        }
        if (args.length == 0) {
            PlayerUtils.sendMessage(player, "&c你需要指定一个实体! 使用方法: &e/dx <entity>");
        }

        String name = args[0];
        if (name.equalsIgnoreCase("necromancer")) {
            Entities.NECROMANCER.spawn(player.getLocation());
        } else if (name.equalsIgnoreCase("reaper")) {
            Entities.REAPER.spawn(player.getLocation());
        } else if (name.equalsIgnoreCase("vulcan")) {
            Entities.VULCAN.spawn(player.getLocation());
        } else if (name.equalsIgnoreCase("hellhound")) {
            Entities.HELLHOUND.spawn(player.getLocation());
        } else {
            PlayerUtils.sendMessage(player, "&c未知实体: &e" + name);
        }
    }

}
