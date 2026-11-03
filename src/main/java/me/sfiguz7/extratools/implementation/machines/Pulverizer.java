package me.sfiguz7.extratools.implementation.machines;

import io.github.thebusybiscuit.slimefun5.utils.compatibility.MaterialCompat;
import io.github.thebusybiscuit.slimefun5.libraries.xseries.XMaterial;
import io.github.thebusybiscuit.slimefun5.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun5.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun5.implementation.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.sfiguz7.extratools.lists.ETItems;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Pulverizer extends AContainer implements RecipeDisplayItem {

    public Pulverizer() {
        super(ETItems.extra_tools, ETItems.PULVERIZER, RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {SlimefunItems.SILICON.item(), SlimefunItems.HARDENED_METAL_INGOT.item(), SlimefunItems.SILICON.item(),
                SlimefunItems.ELECTRIC_MOTOR.item(), SlimefunItems.STEEL_PLATE.item(), SlimefunItems.ELECTRIC_MOTOR.item(),
                MaterialCompat.stack(XMaterial.IRON_PICKAXE), SlimefunItems.MEDIUM_CAPACITOR.item(),
                MaterialCompat.stack(XMaterial.IRON_PICKAXE)});
    }

    @Override
    protected void registerDefaultRecipes() {

        registerRecipe(8, new ItemStack[] {MaterialCompat.stack(XMaterial.STONE, 4)},
            new ItemStack[] {MaterialCompat.stack(XMaterial.SAND)});
        registerRecipe(8, new ItemStack[] {MaterialCompat.stack(XMaterial.GRANITE, 4)},
            new ItemStack[] {MaterialCompat.stack(XMaterial.SAND)});
        registerRecipe(8, new ItemStack[] {MaterialCompat.stack(XMaterial.DIORITE, 4)},
            new ItemStack[] {MaterialCompat.stack(XMaterial.SAND)});
        registerRecipe(8, new ItemStack[] {MaterialCompat.stack(XMaterial.ANDESITE, 4)},
            new ItemStack[] {MaterialCompat.stack(XMaterial.SAND)});
        registerRecipe(8, new ItemStack[] {MaterialCompat.stack(XMaterial.COBBLESTONE, 4)},
            new ItemStack[] {MaterialCompat.stack(XMaterial.SAND)});

        registerRecipe(8, new ItemStack[] {MaterialCompat.stack(XMaterial.GRAVEL, 4)},
            new ItemStack[] {MaterialCompat.stack(XMaterial.SAND)});
        registerRecipe(8, new ItemStack[] {MaterialCompat.stack(XMaterial.GRASS_BLOCK, 4)},
            new ItemStack[] {MaterialCompat.stack(XMaterial.SAND)});
        registerRecipe(8, new ItemStack[] {MaterialCompat.stack(XMaterial.DIRT, 4)},
            new ItemStack[] {MaterialCompat.stack(XMaterial.SAND)});
        registerRecipe(8, new ItemStack[] {MaterialCompat.stack(XMaterial.COARSE_DIRT, 4)},
            new ItemStack[] {MaterialCompat.stack(XMaterial.SAND)});
        registerRecipe(8, new ItemStack[] {MaterialCompat.stack(XMaterial.PODZOL, 4)},
            new ItemStack[] {MaterialCompat.stack(XMaterial.SAND)});

        registerRecipe(8, new ItemStack[] {MaterialCompat.stack(XMaterial.NETHERRACK, 4)},
            new ItemStack[] {MaterialCompat.stack(XMaterial.SOUL_SAND)});

    }

    @Override
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> displayRecipes = new ArrayList<>(recipes.size() * 2);

        for (MachineRecipe recipe : recipes) {
            displayRecipes.add(recipe.getInput()[0]);
            displayRecipes.add(recipe.getOutput()[recipe.getOutput().length - 1]);
        }

        return displayRecipes;
    }

    @Override
    public ItemStack getProgressBar() {
        return MaterialCompat.stack(XMaterial.IRON_PICKAXE);
    }

    @Override
    public String getInventoryTitle() {
        return "&cPulverizer";
    }

    @Override
    public String getMachineIdentifier() {
        return "PULVERIZER";
    }

    @Override
    public int getCapacity() {
        return 256;
    }

    @Override
    public int getEnergyConsumption() {
        return 25;
    }

    @Override
    public int getSpeed() {
        return 4;
    }

}
