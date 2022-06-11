package tsp.demonicexpansion.implementation.item.misc;

import io.github.thebusybiscuit.slimefun4.api.items.ItemSetting;
import io.github.thebusybiscuit.slimefun4.api.items.settings.IntRangeSetting;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RandomMobDrop;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import tsp.demonicexpansion.DemonicExpansion;
import tsp.demonicexpansion.implementation.item.AbstractItem;

public class DemonicEssence extends AbstractItem implements RandomMobDrop {

    private final ItemSetting<Integer> chance = new IntRangeSetting(this, "drop-chance", 0, 100, 100); // TODO: change default after debug

    public DemonicEssence() {
        super(DemonicExpansion.getInstance().getItems().DEMONIC_ESSENCE, RecipeType.MOB_DROP, new ItemStack[]{
                null, null, null,
                null, new CustomItemStack(Material.WITHER_SKELETON_SKULL, "Wither Skeleton"), null,
                null, null, null
        });
        addItemSettings(chance);
    }

    @Override
    public int getMobDropChance() {
        return chance.getValue();
    }

}
