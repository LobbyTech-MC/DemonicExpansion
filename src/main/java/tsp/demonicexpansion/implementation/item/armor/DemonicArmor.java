package tsp.demonicexpansion.implementation.item.armor;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.inventory.ItemStack;
import tsp.demonicexpansion.DemonicExpansion;
import tsp.demonicexpansion.implementation.item.DemonicItemStack;

public class DemonicArmor extends AbstractArmor {

    private static final DemonicItemStack essence = DemonicExpansion.getInstance().getItems().DEMONIC_ESSENCE;

    public DemonicArmor(SlimefunItemStack item, ItemStack recipe) {
        super(item, RecipeType.ANCIENT_ALTAR, new ItemStack[]{
                essence, essence, essence,
                essence, recipe, essence,
                essence, essence, essence
        });
    }

}
