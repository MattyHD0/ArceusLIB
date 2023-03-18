package com.github.mattyhd0.command;

import com.github.mattyhd0.gui.actions.PlaySoundClickAction;
import com.github.mattyhd0.gui.component.ClickComponent;
import com.github.mattyhd0.gui.component.InventoryEventComponent;
import com.github.mattyhd0.input.PlayerChatInputDialog;
import com.github.mattyhd0.ArceusLIB;
import com.github.mattyhd0.gui.ArceusMenu;
import com.github.mattyhd0.util.ItemStackUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player player = (Player) commandSender;

        if (strings.length == 0){
            player.sendMessage(color("/acltest <gui/input>"));
            return true;
        }

        if(strings[0].equalsIgnoreCase("gui")){

            ArceusMenu menu = new ArceusMenu();

            menu.addComponents(
                    InventoryEventComponent.create()
                            .click(event -> event.setCancelled(true)),
                    InventoryEventComponent.create()
                            .close(event -> event.getPlayer().sendMessage("You closed the menu"))
                            .open(event -> event.getPlayer().sendMessage("You open the menu"))
                            .click(event -> event.getWhoClicked().sendMessage("You use action "+event.getClick()+" on slot "+event.getSlot()))
                            );

            menu.addComponent(
                    ClickComponent.create(13).right(event -> {
                        event.getWhoClicked().sendMessage("You press Right-Click");
                    }).left(event -> {
                        event.getWhoClicked().sendMessage("You press Left-Click");
                    }).drop(event -> {
                                event.getWhoClicked().sendMessage("You press Q");
                    })
            );

            menu.fillInventory(new ItemStack(Material.valueOf("STAINED_GLASS_PANE"), 1, (byte)15));

            menu.fillSlots(new ItemStack(Material.valueOf("STAINED_GLASS_PANE"), 1, (byte)0), 0, 8);

            menu.setSlots(
                    new ItemStack(Material.valueOf("STAINED_GLASS_PANE"), 1, (byte)7),
                    new int[]{9, 10, 11, 12, 13, 14, 15, 16, 17}
            );

            menu.getInventory().setItem(13,
                    ItemStackUtil.getItemStack(
                            Material.EMERALD,
                            ChatColor.translateAlternateColorCodes('&', "&2&lMagic Emerald"),
                            ChatColor.translateAlternateColorCodes('&', "&aClick to run some Components"))
            );

            player.openInventory(menu.getInventory());

        } else if (strings[0].equalsIgnoreCase("input")){

            ArceusLIB.getInstance().getArceusLibrary().getPlayerInputManager().sendInputDialog(

                    player,
                    new PlayerChatInputDialog(
                            (player1, input) -> {

                                if (!input.equalsIgnoreCase("yes")){
                                    return false;
                                }

                                player1.sendMessage("Thanks you!");
                                return true;

                            },
                            "&aWrite &eyes &ain chat", ""
                    )

            );

        } else {
            player.sendMessage(color("/acltest <gui/input>"));
        }



        return true;
    }

    private String color(String text){
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
