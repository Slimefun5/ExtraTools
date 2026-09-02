package me.sfiguz7.extratools;

import io.github.thebusybiscuit.slimefun5.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun5.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun5.api.researches.Research;
import io.github.thebusybiscuit.slimefun5.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun5.libraries.keys.NamespacedKey;
import me.sfiguz7.extratools.implementation.machines.CobblestoneGenerator;
import me.sfiguz7.extratools.implementation.machines.ConcreteFactory;
import me.sfiguz7.extratools.implementation.machines.ElectricComposter;
import me.sfiguz7.extratools.implementation.machines.GoldTransmuter;
import me.sfiguz7.extratools.implementation.machines.Pulverizer;
import me.sfiguz7.extratools.implementation.machines.Vaporizer;
import me.sfiguz7.extratools.implementation.tools.Hammer;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class ExtraTools extends JavaPlugin implements SlimefunAddon {

    public static ExtraTools instance;
    private int researchId = 4100;

    @Override
    public void onEnable() {

        instance = this;

        if (!new File(getDataFolder(), "config.yml").exists()) {
            saveDefaultConfig();
        }

        int bStatsId = 6945;
        new Metrics(this, bStatsId);

        Hammer hammer = new Hammer();
        hammer.register(this);
        registerResearch("hammer", "Hammer", 3, hammer);

        GoldTransmuter goldTransmuter = new GoldTransmuter();
        goldTransmuter.register(this);
        registerResearch("gold_transmuter", "Gold Transmuter", 12, goldTransmuter);

        ElectricComposter composter1 = new ElectricComposter(ElectricComposter.Tier.ONE) {

            @Override
            public int getEnergyConsumption() {
                return 9;
            }

            @Override
            public int getSpeed() {
                return 1;
            }

        };
        composter1.register(this);
        registerResearch("electric_composter", "Electric Composter", 18, composter1);

        ElectricComposter composter2 = new ElectricComposter(ElectricComposter.Tier.TWO) {

            @Override
            public int getEnergyConsumption() {
                return 25;
            }

            @Override
            public int getSpeed() {
                return 4;
            }

        };
        composter2.register(this);
        registerResearch("electric_composter_2", "Electric Composter II", 18, composter2);

        CobblestoneGenerator cobblestoneGenerator = new CobblestoneGenerator();
        cobblestoneGenerator.register(this);
        registerResearch("cobblestone_generator", "Cobblestone Generator", 40, cobblestoneGenerator);

        Vaporizer vaporizer = new Vaporizer();
        vaporizer.register(this);
        registerResearch("vaporizer", "Vaporizer", 18, vaporizer);

        ConcreteFactory concreteFactory = new ConcreteFactory();
        concreteFactory.register(this);
        registerResearch("concrete_factory", "Concrete Factory", 12, concreteFactory);

        Pulverizer pulverizer = new Pulverizer();
        pulverizer.register(this);
        registerResearch("pulverizer", "Pulverizer", 18, pulverizer);

        // Register addon translations with Slimefun5
        Slimefun.getItemTranslationService().registerTranslations(this);
        Slimefun.getMenuTranslationService().registerTranslations(this);

    }

    private void registerResearch(String key, String name, int cost, SlimefunItem item) {
        Research research = new Research(new NamespacedKey(this, key), ++researchId, name, cost);
        research.addItems(item);
        research.register();
    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/Sfiguz7/ExtraTools/issues";
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    public static ExtraTools getInstance() {
        return instance;
    }

}
