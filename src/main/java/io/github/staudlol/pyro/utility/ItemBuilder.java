package io.github.staudlol.pyro.utility;

/*
 * Created by Kyle
 * Project: pyro
 * Date: 22/07/2022 - 12:43
 */


import lombok.Getter;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

@Getter
public class ItemBuilder {

    private final ItemStack itemStack;

    /**
     * Constructor to create a {@link ItemBuilder}
     *
     * @param itemStack the itemStack.
     */

    public ItemBuilder(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    /**
     * Set the name of a {@link Item}
     *
     * @param name the name.
     * @return the item.
     */

    public ItemBuilder setName(String name) {
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    /**
     * Set the lore of a {@link Item}
     *
     * @param lore the lore.
     * @return the {@link Item}
     */

    public ItemBuilder setLore(String... lore) {
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setLore(Arrays.asList(lore));
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    /**
     * Add a {@link Enchantment} to a {@link Item}
     *
     * @param enchantment the enchantment.
     * @param level the level.
     * @return the item.
     */

    public ItemBuilder addEnchantment(Enchantment enchantment, int level) {
        final ItemMeta itemMeta = this.itemStack.getItemMeta();
        itemMeta.addEnchant(enchantment, level, true);
        this.itemStack.setItemMeta(itemMeta);
        return this;
    }

    /**
     * Add a glow to a {@link Item}
     *
     * @return the item.
     */

    public ItemBuilder addGlow() {
        this.itemStack.addUnsafeEnchantment(Enchantment.DURABILITY, 1);

        final ItemMeta itemMeta = this.itemStack.getItemMeta();
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        this.itemStack.setItemMeta(itemMeta);
        return this;
    }

    /**
     * Build a {@link ItemStack}
     *
     * @return the item.
     */

    public ItemStack buildItem() {
        return this.itemStack;
    }
}