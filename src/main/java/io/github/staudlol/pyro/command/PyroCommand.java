package io.github.staudlol.pyro.command;

/*
 * Created by Kyle
 * Project: pyro
 * Date: 22/07/2022 - 11:32
 */

import io.github.staudlol.pyro.utility.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PyroCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be used by players");
            return true;
        }

        final Player player = (Player) sender;

        if (!player.hasPermission("pyro.command")) {
            player.sendMessage(ChatColor.RED + "You do not have permission to use this command");
        } else {

            final ItemStack pyro = new ItemBuilder(new ItemStack(Material.DIAMOND_AXE))
                    .setName(ChatColor.DARK_RED + "Pyro Axe")
                    .setLore(ChatColor.DARK_RED + "I come from the Iron Hills")
                    .addEnchantment(Enchantment.DAMAGE_ALL, 5)
                    .addEnchantment(Enchantment.FIRE_ASPECT, 2)
                    .buildItem();

            player.getInventory().addItem(pyro);
            player.sendMessage(ChatColor.GREEN + "You have been given the " + ChatColor.DARK_RED + "Pyro Axe" + ChatColor.YELLOW + "!");
        }

        return true;
    }
}
