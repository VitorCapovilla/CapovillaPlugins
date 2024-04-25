package br.com.vitorcapovilla;

import br.com.vitorcapovilla.Fake.Fake;
import br.com.vitorcapovilla.listener.CapovillaListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public final class CapovillaPlugins extends JavaPlugin{

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§5§l[CapovillaPlugins] Vitor Capovilla project was successfully loaded!");

        this.getServer().getPluginManager().registerEvents(new CapovillaListener(), this);
//        this.getServer().getPluginManager().registerEvents(new Fake(), this);
        getCommand("fake").setExecutor(new Fake());
        Bukkit.getConsoleSender().sendMessage("§5§l[CapovillaPlugins] Fake Ativado!!");

    }

    @Override
    public void onDisable() {

        Bukkit.getConsoleSender().sendMessage("§5§l[CapovillaPlugins] Vitor Capovilla project was successfully stoppped!");

    }

}
