package me.sfiguz7.extratools.implementation.tools;

import io.github.thebusybiscuit.slimefun5.utils.compatibility.MaterialCompat;
import io.github.thebusybiscuit.slimefun5.libraries.xseries.XMaterial;
import io.github.thebusybiscuit.slimefun5.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun5.core.handlers.ToolUseHandler;
import io.github.thebusybiscuit.slimefun5.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun5.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun5.implementation.items.SimpleSlimefunItem;
import me.sfiguz7.extratools.lists.ETItems;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class Hammer extends SimpleSlimefunItem<ToolUseHandler> {

    private static final boolean CAN_SUPPRESS_VANILLA_DROPS = canSuppressVanillaDrops();

    public Hammer() {
        super(ETItems.extra_tools, ETItems.HAMMER, RecipeType.MAGIC_WORKBENCH,
            new ItemStack[] {MaterialCompat.stack(XMaterial.IRON_INGOT), MaterialCompat.stack(XMaterial.IRON_INGOT),
                MaterialCompat.stack(XMaterial.IRON_INGOT),
                MaterialCompat.stack(XMaterial.IRON_INGOT), MaterialCompat.stack(XMaterial.STICK), MaterialCompat.stack(XMaterial.IRON_INGOT),
                null, MaterialCompat.stack(XMaterial.STICK), null});
    }

    @Override
    public ToolUseHandler getItemHandler() {
        return (e, tool, fortune, drops) -> {
            if (Slimefun.getPermissionsService().hasPermission(e.getPlayer(), Hammer.this)) {

                Block b = e.getBlock();
                ItemStack drop = getDrop(b);

                if (drop == null) {
                    return;
                }

                if (CAN_SUPPRESS_VANILLA_DROPS) {
                    drops.add(drop);
                } else {
                    e.setCancelled(true);
                    b.setType(Material.AIR);
                    b.getWorld().dropItemNaturally(b.getLocation(), drop);
                }
            }
        };
    }

    /**
     * @implNote Core hands a tool's drops back and turns the block's own drops off through
     *           {@code BlockBreakEvent#setDropItems}, which only exists from 1.12; below it the vanilla drop would
     *           come on top of the hammer's, so the break is done here instead.
     */
    private static boolean canSuppressVanillaDrops() {
        try {
            BlockBreakEvent.class.getMethod("setDropItems", boolean.class);
            return true;
        } catch (NoSuchMethodException absent) {
            return false;
        }
    }

    public ItemStack getDrop(Block b) {
        if (b.getType() == XMaterial.GRASS_BLOCK.parseMaterial()) {
            return MaterialCompat.stack(XMaterial.SAND);
        }
        String name = b.getType().name();
        switch (name) {
            case "STONE":
            case "GRANITE":
            case "DIORITE":
            case "ANDESITE":
            case "COBBLESTONE":
                return MaterialCompat.stack(XMaterial.GRAVEL);
            case "GRAVEL":
            case "DIRT":
            case "COARSE_DIRT":
            case "PODZOL":
                return MaterialCompat.stack(XMaterial.SAND);
            case "IRON_ORE":
            case "DEEPSLATE_IRON_ORE":
                return SlimefunItems.IRON_DUST.item();
            case "GOLD_ORE":
            case "DEEPSLATE_GOLD_ORE":
                return SlimefunItems.GOLD_DUST.item();
            case "COPPER_ORE":
            case "DEEPSLATE_COPPER_ORE":
                return SlimefunItems.COPPER_DUST.item();
            case "NETHERRACK":
                return MaterialCompat.stack(XMaterial.SOUL_SAND);
            default:
                return null;
        }
    }
}