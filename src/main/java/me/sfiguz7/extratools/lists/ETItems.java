package me.sfiguz7.extratools.lists;

import io.github.thebusybiscuit.slimefun5.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun5.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun5.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun5.libraries.keys.NamespacedKey;
import io.github.thebusybiscuit.slimefun5.libraries.xseries.XMaterial;
import io.github.thebusybiscuit.slimefun5.utils.compatibility.MaterialCompat;

public final class ETItems {

    public static final ItemGroup extra_tools = new ItemGroup(new NamespacedKey("extratools", "extra_tools"),
        CustomItemStack.create(MaterialCompat.stack(XMaterial.DIAMOND_AXE), "Extra Tools")
    );

    public static final SlimefunItemStack HAMMER = item("HAMMER", XMaterial.IRON_PICKAXE);

    public static final SlimefunItemStack GOLD_TRANSMUTER = item("GOLD_TRANSMUTER", XMaterial.YELLOW_TERRACOTTA);
    public static final SlimefunItemStack ELECTRIC_COMPOSTER = item("ELECTRIC_COMPOSTER", XMaterial.MAGENTA_TERRACOTTA);
    public static final SlimefunItemStack ELECTRIC_COMPOSTER_2 = item("ELECTRIC_COMPOSTER_2", XMaterial.MAGENTA_TERRACOTTA);
    public static final SlimefunItemStack COBBLESTONE_GENERATOR = item("COBBLESTONE_GENERATOR", XMaterial.POLISHED_ANDESITE);
    public static final SlimefunItemStack VAPORIZER = item("VAPORIZER", XMaterial.RED_STAINED_GLASS);
    public static final SlimefunItemStack CONCRETE_FACTORY = item("CONCRETE_FACTORY", XMaterial.BLACK_CONCRETE);
    public static final SlimefunItemStack PULVERIZER = item("PULVERIZER", XMaterial.ORANGE_TERRACOTTA);

    private ETItems() {
    }

    private static SlimefunItemStack item(String id, XMaterial material) {
        return new SlimefunItemStack(id, MaterialCompat.stack(material));
    }
}
