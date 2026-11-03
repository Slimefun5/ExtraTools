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

public class ConcreteFactory extends AContainer implements RecipeDisplayItem {

    public ConcreteFactory() {
        super(ETItems.extra_tools, ETItems.CONCRETE_FACTORY, RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {MaterialCompat.stack(XMaterial.WATER_BUCKET), SlimefunItems.GILDED_IRON.item(),
                MaterialCompat.stack(XMaterial.WATER_BUCKET),
                SlimefunItems.ADVANCED_CIRCUIT_BOARD.item(), SlimefunItems.ELECTRIC_MOTOR.item(),
                SlimefunItems.ADVANCED_CIRCUIT_BOARD.item(),
                MaterialCompat.stack(XMaterial.WATER_BUCKET), SlimefunItems.SMALL_CAPACITOR.item(),
                MaterialCompat.stack(XMaterial.WATER_BUCKET)});
    }

    @Override
    protected void registerDefaultRecipes() {

        registerRecipe(4, new ItemStack[] {MaterialCompat.stack(XMaterial.WHITE_CONCRETE_POWDER, 8)},
            new ItemStack[] {MaterialCompat.stack(XMaterial.WHITE_CONCRETE, 8)});
        registerRecipe(4, new ItemStack[] {MaterialCompat.stack(XMaterial.ORANGE_CONCRETE_POWDER, 8)},
            new ItemStack[] {MaterialCompat.stack(XMaterial.ORANGE_CONCRETE, 8)});
        registerRecipe(4, new ItemStack[] {MaterialCompat.stack(XMaterial.MAGENTA_CONCRETE_POWDER, 8)},
            new ItemStack[] {MaterialCompat.stack(XMaterial.MAGENTA_CONCRETE, 8)});
        registerRecipe(4, new ItemStack[] {MaterialCompat.stack(XMaterial.LIGHT_BLUE_CONCRETE_POWDER, 8)},
            new ItemStack[] {MaterialCompat.stack(XMaterial.LIGHT_BLUE_CONCRETE, 8)});
        registerRecipe(4, new ItemStack[] {MaterialCompat.stack(XMaterial.YELLOW_CONCRETE_POWDER, 8)},
            new ItemStack[] {MaterialCompat.stack(XMaterial.YELLOW_CONCRETE, 8)});
        registerRecipe(4, new ItemStack[] {MaterialCompat.stack(XMaterial.LIME_CONCRETE_POWDER, 8)},
            new ItemStack[] {MaterialCompat.stack(XMaterial.LIME_CONCRETE, 8)});
        registerRecipe(4, new ItemStack[] {MaterialCompat.stack(XMaterial.PINK_CONCRETE_POWDER, 8)},
            new ItemStack[] {MaterialCompat.stack(XMaterial.PINK_CONCRETE, 8)});
        registerRecipe(4, new ItemStack[] {MaterialCompat.stack(XMaterial.GRAY_CONCRETE_POWDER, 8)},
            new ItemStack[] {MaterialCompat.stack(XMaterial.GRAY_CONCRETE, 8)});
        registerRecipe(4, new ItemStack[] {MaterialCompat.stack(XMaterial.LIGHT_GRAY_CONCRETE_POWDER, 8)},
            new ItemStack[] {MaterialCompat.stack(XMaterial.LIGHT_GRAY_CONCRETE, 8)});
        registerRecipe(4, new ItemStack[] {MaterialCompat.stack(XMaterial.CYAN_CONCRETE_POWDER, 8)},
            new ItemStack[] {MaterialCompat.stack(XMaterial.CYAN_CONCRETE, 8)});
        registerRecipe(4, new ItemStack[] {MaterialCompat.stack(XMaterial.PURPLE_CONCRETE_POWDER, 8)},
            new ItemStack[] {MaterialCompat.stack(XMaterial.PURPLE_CONCRETE, 8)});
        registerRecipe(4, new ItemStack[] {MaterialCompat.stack(XMaterial.BLUE_CONCRETE_POWDER, 8)},
            new ItemStack[] {MaterialCompat.stack(XMaterial.BLUE_CONCRETE, 8)});
        registerRecipe(4, new ItemStack[] {MaterialCompat.stack(XMaterial.BROWN_CONCRETE_POWDER, 8)},
            new ItemStack[] {MaterialCompat.stack(XMaterial.BROWN_CONCRETE, 8)});
        registerRecipe(4, new ItemStack[] {MaterialCompat.stack(XMaterial.GREEN_CONCRETE_POWDER, 8)},
            new ItemStack[] {MaterialCompat.stack(XMaterial.GREEN_CONCRETE, 8)});
        registerRecipe(4, new ItemStack[] {MaterialCompat.stack(XMaterial.RED_CONCRETE_POWDER, 8)},
            new ItemStack[] {MaterialCompat.stack(XMaterial.RED_CONCRETE, 8)});
        registerRecipe(4, new ItemStack[] {MaterialCompat.stack(XMaterial.BLACK_CONCRETE_POWDER, 8)},
            new ItemStack[] {MaterialCompat.stack(XMaterial.BLACK_CONCRETE, 8)});

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
        return MaterialCompat.stack(XMaterial.IRON_SHOVEL);
    }

    @Override
    public String getInventoryTitle() {
        return "&cConcrete Factory";
    }

    @Override
    public String getMachineIdentifier() {
        return "CONCRETE_FACTORY";
    }

    @Override
    public int getCapacity() {
        return 256;
    }

    @Override
    public int getEnergyConsumption() {
        return 8;
    }

    @Override
    public int getSpeed() {
        return 1;
    }

}
