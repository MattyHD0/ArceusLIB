# ArceusLIB

**ArceusLIB** is a private library for personal plugins, but anyone who wants to use it can do it, it was created to be used with **Spigot**, it allows you to create interfaces (GUI) of all kinds in an easy and fast way in **Minecraft**

## Important

It is also important that you relocate ArceusLIB within your plugin, since it is not recommended to use ArceusLIB within the plugins folder for its testing commands.

## Dependency

Officially ArceusLIB is not in any repository like maven central, but you can import it from [Jitpack](https://jitpack.io/#MattyHD0/ArceusLIB/)

### Maven
```xml
<repositories>
	<repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
	</repository>
</repositories>
```
```xml
<dependencies>
	<dependency>
	    <groupId>com.github.MattyHD0</groupId>
	    <artifactId>ArceusLIB</artifactId>
	    <version>-SNAPSHOT</version>
	</dependency>
</dependencies>
```
### Gradle

```groovy
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
}
	
dependencies {
        implementation 'com.github.MattyHD0:ArceusLIB:-SNAPSHOT'
}
```

## Code Example

```java
import com.github.mattyhd0.ArceusLibrary;
import org.bukkit.Bukkit;

class Example extends JavaPlugin {

    private ArceusLibrary arceusLibrary;

    @Override
    public void onEnable() {
        //This step is very important to register the necessary listeners
        this.arceusLibrary = new ArceusLibrary(this);
        
        openExampleGui("MattyHD0");
    }

    @Override
    public void onDisable() {

    }


    public void openExampleGui(String playerName) {

        Player player = Bukkit.getPlayer(playerName);
        ArceusMenu menu = new ArceusMenu();

        menu.addComponents(
                InventoryEventComponent.create()
                        .click(event -> {
                            event.setCancelled(true);
                            event.getWhoClicked().sendMessage("You use action " + event.getClick() + " on slot " + event.getSlot());
                        })
                        .close(event -> event.getPlayer().sendMessage("You closed the menu"))
                        .open(event -> event.getPlayer().sendMessage("You open the menu"))
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

        menu.fillInventory(new ItemStack(Material.valueOf("STAINED_GLASS_PANE"), 1, (byte) 15));

        menu.fillSlots(new ItemStack(Material.valueOf("STAINED_GLASS_PANE"), 1, (byte) 0), 0, 8);

        menu.setSlots(
                new ItemStack(Material.valueOf("STAINED_GLASS_PANE"), 1, (byte) 7),
                new int[]{9, 10, 11, 12, 13, 14, 15, 16, 17}
        );

        menu.getInventory().setItem(13,
                ItemStackUtil.getItemStack(
                        Material.EMERALD,
                        ChatColor.translateAlternateColorCodes('&', "&2&lMagic Emerald"),
                        ChatColor.translateAlternateColorCodes('&', "&aClick to run some Components"))
        );

        player.openInventory(menu.getInventory());

    }

}

```