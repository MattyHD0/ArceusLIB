package com.github.mattyhd0.command;

import com.github.mattyhd0.gui.component.InventoryEventListener;
import com.github.mattyhd0.util.ItemStackUtil;
import com.github.mattyhd0.ArceusLIB;
import com.github.mattyhd0.gui.component.ClickComponent;
import com.github.mattyhd0.gui.InventoryGui;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player player = (Player) commandSender;

        InventoryGui inventoryGui = new InventoryGui(9*6, "Test GUI");

        inventoryGui.setSlot(4,
                ItemStackUtil.getItemStack(Material.STICK, "Necron's Handle", "OMG UN HANDLE", ":0"),
                ClickComponent.of( event -> {
                    event.getWhoClicked().sendMessage("OMG Hiciste click xd");
                })
        );

        ArceusLIB.getInstance().getGuiManager().openGui(inventoryGui, player);

        return true;
    }
}
