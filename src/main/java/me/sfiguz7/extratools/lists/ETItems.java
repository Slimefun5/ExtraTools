package me.sfiguz7.extratools.lists;

import io.github.thebusybiscuit.slimefun5.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun5.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun5.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun5.libraries.keys.NamespacedKey;
import org.bukkit.Material;

public final class ETItems {

    /* Category */
    public static final ItemGroup extra_tools = new ItemGroup(new NamespacedKey("extratools", "extra_tools"),
        CustomItemStack.create(Material.DIAMOND_AXE, "&4Extra Tools")
    );

    /* Items */
    public static final SlimefunItemStack HAMMER = new SlimefunItemStack("HAMMER", Material.IRON_PICKAXE);

    /* Machines */
    public static final SlimefunItemStack GOLD_TRANSMUTER = new SlimefunItemStack("GOLD_TRANSMUTER", Material.YELLOW_TERRACOTTA);
    public static final SlimefunItemStack ELECTRIC_COMPOSTER = new SlimefunItemStack("ELECTRIC_COMPOSTER", Material.MAGENTA_TERRACOTTA);
    public static final SlimefunItemStack ELECTRIC_COMPOSTER_2 = new SlimefunItemStack("ELECTRIC_COMPOSTER_2", Material.MAGENTA_TERRACOTTA);
    public static final SlimefunItemStack COBBLESTONE_GENERATOR = new SlimefunItemStack("COBBLESTONE_GENERATOR", Material.POLISHED_ANDESITE);
    public static final SlimefunItemStack VAPORIZER = new SlimefunItemStack("VAPORIZER", Material.RED_STAINED_GLASS);
    public static final SlimefunItemStack CONCRETE_FACTORY = new SlimefunItemStack("CONCRETE_FACTORY", Material.BLACK_CONCRETE);
    public static final SlimefunItemStack PULVERIZER = new SlimefunItemStack("PULVERIZER", Material.ORANGE_TERRACOTTA);

    private ETItems() {
    }
}