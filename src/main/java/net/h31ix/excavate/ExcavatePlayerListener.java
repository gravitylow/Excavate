package net.h31ix.excavate;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class ExcavatePlayerListener implements Listener {
    public final Excavate plugin;
    
    ExcavatePlayerListener(Excavate plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event)
    {
        Player player = event.getPlayer();
        if (player.hasPermission("excavate.tunnel"))
        {
            if (plugin.isUsingW(player))
            {
                Location loc = player.getLocation();
                loc.getBlock().setType(Material.AIR);
                Block b = loc.getBlock().getFace(BlockFace.UP);
                Block j = b.getFace(BlockFace.DOWN);
                b.setType(Material.AIR);
                b.getFace(BlockFace.EAST).setType(Material.AIR);
                b.getFace(BlockFace.NORTH).setType(Material.AIR);
                b.getFace(BlockFace.SOUTH).setType(Material.AIR);
                b.getFace(BlockFace.WEST).setType(Material.AIR);
                b.getFace(BlockFace.NORTH_EAST).setType(Material.AIR);
                b.getFace(BlockFace.NORTH_WEST).setType(Material.AIR);
                b.getFace(BlockFace.SOUTH_EAST).setType(Material.AIR);
                b.getFace(BlockFace.SOUTH_WEST).setType(Material.AIR);
                j.setType(Material.AIR);
                j.getFace(BlockFace.EAST).setType(Material.TORCH);
                j.getFace(BlockFace.NORTH).setType(Material.AIR);
                j.getFace(BlockFace.SOUTH).setType(Material.AIR);
                j.getFace(BlockFace.WEST).setType(Material.AIR);
                j.getFace(BlockFace.NORTH_EAST).setType(Material.AIR);
                j.getFace(BlockFace.NORTH_WEST).setType(Material.AIR);
                j.getFace(BlockFace.SOUTH_EAST).setType(Material.AIR);
                j.getFace(BlockFace.SOUTH_WEST).setType(Material.AIR);            
            }
        }
    }
    
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK)
        {
            if (player.hasPermission("excavate.tool"))
            {
                if (plugin.isUsingT(player))
                {
                    if (player.getInventory().getItemInHand().getType() == Material.DIAMOND_PICKAXE)
                    {
                         String dir = null;
                         float y = player.getLocation().getYaw();
                         if( y < 0 ){y += 360;}
                         y %= 360;
                         int i = (int)((y+8) / 22.5);
                         if(i == 0){dir = "west";}
                         else if(i == 1){dir = "west";}
                         else if(i == 2){dir = "west";}
                         else if(i == 3){dir = "north";}
                         else if(i == 4){dir = "north";}
                         else if(i == 5){dir = "north";}
                         else if(i == 6){dir = "north";}
                         else if(i == 7){dir = "east";}
                         else if(i == 8){dir = "east";}
                         else if(i == 9){dir = "east";}
                         else if(i == 10){dir = "east";}
                         else if(i == 11){dir = "south";}
                         else if(i == 12){dir = "south";}
                         else if(i == 13){dir = "south";}
                         else if(i == 14){dir = "south";}
                         else if(i == 15){dir = "west";}
                         else {dir = "west";}
                        event.getClickedBlock().setType(Material.AIR);
                        for (int l=1;l!=plugin.getLength(player);l++)
                        {
                            Location e = null;
                            if (dir.equals("north"))
                            {
                                e = new Location(player.getWorld(),event.getClickedBlock().getLocation().getX()-l,event.getClickedBlock().getLocation().getY(),event.getClickedBlock().getLocation().getZ());
                            }
                            else if (dir.equals("east"))
                            {
                                e = new Location(player.getWorld(),event.getClickedBlock().getLocation().getX(),event.getClickedBlock().getLocation().getY(),event.getClickedBlock().getLocation().getZ()-l);
                            }
                            else if (dir.equals("south"))
                            {
                                e = new Location(player.getWorld(),event.getClickedBlock().getLocation().getX()+l,event.getClickedBlock().getLocation().getY(),event.getClickedBlock().getLocation().getZ());
                            } 
                            else if (dir.equals("west"))
                            {
                                e = new Location(player.getWorld(),event.getClickedBlock().getLocation().getX(),event.getClickedBlock().getLocation().getY(),event.getClickedBlock().getLocation().getZ()+l);
                            }    
                            e.getBlock().setType(Material.AIR);
                        }
                    }
                }
            }
        }
    }    
    
}
