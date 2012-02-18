package net.h31ix.excavate;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ExcavateCommandHandler implements CommandExecutor {
    public final Excavate plugin;
    
    public ExcavateCommandHandler(Excavate plugin)
    {
        this.plugin = plugin;
    }
    
    public boolean onCommand(CommandSender cs, Command cmd, String alias, String[] args) {
        if (cs instanceof Player)
        {
            Player player = (Player)cs;
            if (args.length == 2)
            {
                if (args[0].equalsIgnoreCase("tool"))
                {
                    if (player.hasPermission("excavate.tool"))
                    {
                        if (args[1].equalsIgnoreCase("toggle"))
                        {
                            if (plugin.isUsingT(player))
                            {
                                plugin.setUsingT(player, false);
                                player.sendMessage(ChatColor.AQUA+"Excavate tool has been toggled off.");
                            }
                            else
                            {
                                plugin.setUsingT(player, true);
                                player.sendMessage(ChatColor.AQUA+"Excavate tool has been toggled on.");
                            }
                        }
                        else
                        {
                            player.sendMessage(ChatColor.AQUA+"Usage: /excavate tool [toggle]");
                        }
                    }
                    else
                    {
                        player.sendMessage(ChatColor.AQUA+"Insufficient Permissions!");
                    }
                }
                else if (args[0].equalsIgnoreCase("tunnel"))
                {
                    if (player.hasPermission("excavate.tunnel"))
                    {
                        if (args[1].equalsIgnoreCase("toggle"))
                        {
                            if (plugin.isUsingW(player))
                            {
                                plugin.setUsingW(player, false);
                                player.sendMessage(ChatColor.AQUA+"Excavate tunnel has been toggled off.");
                            }
                            else
                            {
                                plugin.setUsingW(player, true);
                                player.sendMessage(ChatColor.AQUA+"Excavate tunnel has been toggled on.");
                            }                            
                        }
                        else 
                        {
                            player.sendMessage(ChatColor.AQUA+"Usage: /excavate tunnel [toggle]");
                        }
                    }
                    else
                    {
                        player.sendMessage(ChatColor.AQUA+"Insufficient Permissions!");
                    }
                }
                else
                {
                    player.sendMessage(ChatColor.AQUA+"Usage: /excavate [tool/tunnel] [toggle/set]");
                }
                     
            }
            else if (args.length == 3)
            {
                if (args[0].equalsIgnoreCase("tool"))
                {
                    if (player.hasPermission("excavate.tool"))
                    {
                        if (args[1].equalsIgnoreCase("set"))
                        {
                            int d = Integer.parseInt(args[2]);
                            plugin.setLength(player, d);
                            player.sendMessage(ChatColor.AQUA+"Tool length set to "+d);
                        }
                    }
                }
            }
            else
            {
                player.sendMessage(ChatColor.AQUA+"Usage: /excavate [tool/tunnel] [toggle/set]");
            }
        }
        else
        {
            System.out.println("That command can only be used in-game.");
        }
        return true;
    }
    
}
