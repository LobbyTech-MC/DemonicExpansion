package tsp.demonicexpansion.implementation.item.generator;

import io.github.thebusybiscuit.slimefun4.api.items.ItemSetting;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.settings.IntRangeSetting;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetProvider;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;
import tsp.demonicexpansion.DemonicExpansion;
import tsp.demonicexpansion.implementation.item.AbstractItem;

import javax.annotation.Nonnull;

public class ThermalGenerator extends AbstractItem implements EnergyNetProvider {

    private final ItemSetting<Integer> energy = new IntRangeSetting(this, "energy-generation", 2, 2, Integer.MAX_VALUE);

    public ThermalGenerator() {
        super(DemonicExpansion.getInstance().getItems().THERMAL_GENERATOR, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                SlimefunItems.NETHER_ICE_COOLANT_CELL, SlimefunItems.LAVA_CRYSTAL, SlimefunItems.NETHER_ICE_COOLANT_CELL,
                SlimefunItems.LAVA_CRYSTAL, SlimefunItems.SOLAR_GENERATOR_4, SlimefunItems.LAVA_CRYSTAL,
                SlimefunItems.NETHER_ICE_COOLANT_CELL, SlimefunItems.LAVA_CRYSTAL, SlimefunItems.NETHER_ICE_COOLANT_CELL
        });
        addItemSettings(energy);
    }

    @Override
    public int getGeneratedOutput(@Nonnull Location l, @Nonnull Config data) {
        World world = l.getWorld();
        if (world != null && world.getEnvironment() == World.Environment.NETHER && l.clone().subtract(0, 1, 0).getBlock().getType() == Material.LAVA) {
            return energy.getValue();
        } else {
            return 0;
        }
    }

    @Override
    public int getCapacity() {
        return 0;
    }

}
