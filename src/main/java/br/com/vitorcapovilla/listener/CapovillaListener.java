package br.com.vitorcapovilla.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class CapovillaListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta cmeta = compass.getItemMeta();

        assert cmeta != null;
        cmeta.setDisplayName(ChatColor.DARK_PURPLE.toString() + ChatColor.BOLD+ "MiniGames");
        compass.setItemMeta(cmeta);
        PlayerInventory i = player.getInventory();

        if(player.hasPlayedBefore()){
            player.getInventory().clear();
            if(!i.contains((compass))){
                i.setItem(4, compass);
            }
        }

        event.setJoinMessage(ChatColor.DARK_PURPLE.toString() + ChatColor.BOLD + "Player " + player.getName() + " entrou no servidor!");
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        event.setQuitMessage(ChatColor.DARK_PURPLE.toString() + ChatColor.BOLD + "Player " + event.getPlayer().getName() + " saiu no servidor!");
    }

    @EventHandler
    public void selectMiniGameMenu(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
            if (event.getMaterial() == Material.COMPASS){
                Inventory minigameSelector = Bukkit.createInventory(null, 27, ChatColor.DARK_PURPLE.toString() + ChatColor.BOLD + "Selecione o Minigame");

                ItemStack diamond_sword = new ItemStack(Material.DIAMOND_SWORD, 1);

                ItemMeta diamond_swordMeta = diamond_sword.getItemMeta();
                assert diamond_swordMeta != null;
                diamond_swordMeta.setDisplayName(ChatColor.DARK_GREEN.toString() + ChatColor.BOLD + "SkyWars");

                diamond_sword.setItemMeta(diamond_swordMeta);

                minigameSelector.setItem(10, diamond_sword);

                player.openInventory(minigameSelector);

            }

        }
    }
}
