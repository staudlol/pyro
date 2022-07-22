package io.github.staudlol.pyro;

/*
 * Created by Kyle
 * Project: pyro
 * Date: 22/07/2022 - 11:26
 */

import io.github.staudlol.pyro.command.PyroCommand;
import io.github.staudlol.pyro.listener.DamageListener;
import io.github.staudlol.pyro.utility.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class PyroSpigotPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.addRecipe(getPyroRecipe());

        this.getServer().getPluginManager().registerEvents(new DamageListener(), this);
        this.getCommand("pyro").setExecutor(new PyroCommand());
    }


    public ShapedRecipe getPyroRecipe() {
        final ItemStack pyro = new ItemBuilder(new ItemStack(Material.DIAMOND_AXE))
                .setName(ChatColor.DARK_RED + "Pyro Axe")
                .setLore(ChatColor.DARK_RED + "I come from the Iron Hills")
                .addEnchantment(Enchantment.DAMAGE_ALL, 5)
                .addEnchantment(Enchantment.FIRE_ASPECT, 2)
                .buildItem();

        final ShapedRecipe pyroRecipe = new ShapedRecipe(new NamespacedKey(this, "pyro_axe"), pyro);
        pyroRecipe.shape(" X ", " X ", " X ");
        pyroRecipe.setIngredient('X', Material.NETHER_STAR);

        return pyroRecipe;
    }
}
