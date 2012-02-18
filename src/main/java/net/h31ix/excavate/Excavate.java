package net.h31ix.excavate;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Excavate extends JavaPlugin {
    
    public Map<Player, Boolean> togglet = new HashMap<Player,Boolean>();
    public Map<Player, Integer> toggletl = new HashMap<Player,Integer>();
    public Map<Player, Boolean> togglew = new HashMap<Player,Boolean>();
    
    public void onDisable() {

    }

    public void onEnable() {
        getCommand("excavate").setExecutor(new ExcavateCommandHandler(this));
        getServer().getPluginManager().registerEvents(new ExcavatePlayerListener(this), this);
    }
    
    public boolean isUsingT(Player player)
    {
        if (togglet.get(player) != null && togglet.get(player) == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public int getLength(Player player)
    {
        int a = 10;
        if (toggletl.get(player) != null)
        {
            a = toggletl.get(player);
        }
        return a;
    }
    
    public void setLength(Player player, int a)
    {
        toggletl.put(player, a);
    }
    
    public void setUsingT(Player player, boolean a)
    {
        togglet.put(player, a);
    }
    
    public boolean isUsingW(Player player)
    {
        if (togglew.get(player) != null && togglew.get(player) == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void setUsingW(Player player, boolean a)
    {
        togglew.put(player, a);
    }    
}

