package com.github.mattyhd0.command;

import com.github.mattyhd0.gui.ArceusPaginatedMenu;
import com.github.mattyhd0.gui.component.arceus.Button;
import com.github.mattyhd0.gui.component.arceus.DisplayItem;
import com.github.mattyhd0.gui.actions.OpenPageAction;
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
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
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

            ArceusMenu menu = new ArceusMenu.Builder()
                    .title("Demon Menu")
                    .rows(3)
                    .build();

            menu.registerEventListener(InventoryClickEvent.class, event -> {
                        event.setCancelled(true);
                        event.getWhoClicked().sendMessage("You use action "+event.getClick()+" on slot "+event.getSlot());
            });

            menu.registerEventListener(InventoryOpenEvent.class, event -> {
                event.getPlayer().sendMessage("You open the menu");
            });

            menu.registerEventListener(InventoryCloseEvent.class, event -> {
                event.getPlayer().sendMessage("You closed the menu");
            });

            menu.addComponent(
                    13,
                    new Button.Builder().rightClickAction(context -> {
                        context.getClicker().sendMessage("You press Right-Click");
                    }).leftClickAction(context -> {
                        context.getClicker().sendMessage("You press Left-Click");
                    }).dropAction(context -> {
                                context.getClicker().sendMessage("You press Q");
                    }).build()
            );

            menu.fillInventory(new DisplayItem(
                    new ItemStack(Material.valueOf("STAINED_GLASS_PANE"), 1, (byte)15))
            );

            menu.fillSlots(
                    new DisplayItem(
                            new ItemStack(Material.valueOf("STAINED_GLASS_PANE"),1, (byte)0)
                    ), 0, 8);

            menu.setSlots(
                    new DisplayItem(new ItemStack(Material.valueOf("STAINED_GLASS_PANE"), 1, (byte)7)),
                    new int[]{9, 10, 11, 12, 13, 14, 15, 16, 17}
            );

            menu.addComponent(13, new DisplayItem(
                    ItemStackUtil.getItemStack(
                    Material.EMERALD,
                    ChatColor.translateAlternateColorCodes('&', "&2&lMagic Emerald"),
                    ChatColor.translateAlternateColorCodes('&', "&aClick to run some Components")))
            );

            player.openInventory(menu.getInventory());

        } else if(strings[0].equalsIgnoreCase("paginated")){

            ArceusPaginatedMenu menu =  new ArceusPaginatedMenu.Builder()
                    .title("Demon Paginated Menu")
                    .rows(5)
                    .pageSlots(9, 10, 19, 20, 21, 12, 13, 14, 23, 24, 25, 16, 17)
                    .build();


            menu.registerEventListener(InventoryClickEvent.class, event -> {
                event.setCancelled(true);
                event.getWhoClicked().sendMessage("You use action "+event.getClick()+" on slot "+event.getSlot());
            });

            menu.registerEventListener(InventoryOpenEvent.class, event -> {
                event.getPlayer().sendMessage("You open the menu");
            });

            menu.registerEventListener(InventoryCloseEvent.class, event -> {
                event.getPlayer().sendMessage("You closed the menu");
            });


            menu.fillInventory(new DisplayItem(new ItemStack(Material.valueOf("STAINED_GLASS_PANE"), 1, (byte)15)));

            menu.addComponent(36,
                    new Button.Builder()
                            .item(new ItemStack(Material.ARROW))
                            .anyAction(new OpenPageAction(OpenPageAction.Type.PREVIOUS))
                            .build()
            );
            menu.addComponent(44,
                    new Button.Builder()
                            .item(new ItemStack(Material.ARROW))
                            .anyAction(new OpenPageAction(OpenPageAction.Type.NEXT))
                            .build()
                    );

            for (int i = 0; i < 200; i++){

                final int index = i;
                ItemStack item = ItemStackUtil.getItemStack(Material.EMERALD, String.valueOf(i));
                item.setAmount(index);

                menu.addPaginatedComponents(
                        new Button.Builder()
                                .item(item)
                                .anyAction(context -> {
                                    context.getClicker().sendMessage(ChatColor.translateAlternateColorCodes('&', "&aClicked emerald number "+index));
                                }).build()
                );

            }

            player.openInventory(menu.getInventory());

        } else if (strings[0].equalsIgnoreCase("input")){

            ArceusLIB.getInstance().getArceusLibrary().getPlayerInputManager().sendInputDialog(

                    player,
                    new PlayerChatInputDialog(
                            (context) -> {

                                if (!context.getInput().equalsIgnoreCase("yes")){
                                    return false;
                                }

                                context.getPlayer().sendMessage("Thanks you!");
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
