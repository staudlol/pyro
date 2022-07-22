package io.github.staudlol.pyro.listener;

/*
 * Created by Kyle
 * Project: pyro
 * Date: 22/07/2022 - 11:58
 */

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (event.isCancelled()) {
            return;
        }

        if (event.getDamager() instanceof Player && event.getEntity() instanceof Player) {
            final Player target = (Player) event.getDamager();

            if (target.getInventory().getItemInMainHand().getType() == Material.DIAMOND_AXE && target.getInventory().getItemInMainHand().getItemMeta().getLore().get(0).equalsIgnoreCase(ChatColor.DARK_RED + "I come from the Iron Hills")) {
                target.getWorld().playEffect(target.getLocation(), Effect.ZOMBIE_DESTROY_DOOR, 1);
                target.getWorld().playSound(target.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 0.001F);

                event.setDamage(event.getDamage() * 3.0D);
            }
        }
    }
}