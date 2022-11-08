package com.github.mattyhd0.command;

import com.github.mattyhd0.gui.component.IInventoryEvent;
import com.github.mattyhd0.util.ItemStackUtil;
import com.github.mattyhd0.ArceusLIB;
import com.github.mattyhd0.gui.component.ClickComponent;
import com.github.mattyhd0.gui.InventoryGui;
import com.github.mattyhd0.gui.component.action.IInventoryClickAction;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player player = (Player) commandSender;

        InventoryGui inventoryGui = new InventoryGui(InventoryType.CHEST, "Test GUI", true, false);
        inventoryGui.getInventoryEvents().add(new IInventoryEvent() {
            @Override
            public void onOpen(InventoryOpenEvent event) {

            }

            @Override
            public void onClick(InventoryClickEvent event) {
                event.setCancelled(true);
            }

            @Override
            public void onClose(InventoryCloseEvent event) {

            }
        });

        inventoryGui.setSlot(4,
                ItemStackUtil.getItemStack(Material.STICK, "Necron's Handle", "OMG UN HANDLE", ":0"),
                new ClickComponent(
                        new IInventoryClickAction() {
                            @Override
                            public void onClick(InventoryClickEvent event) {
                                event.getWhoClicked().sendMessage("OMG Hiciste click xd");

                            }
                        }
                )
                );

        ArceusLIB.getInstance().getGuiManager().openGui(inventoryGui, player);
        player.sendMessage("GUI open");
        return true;
    }
}
