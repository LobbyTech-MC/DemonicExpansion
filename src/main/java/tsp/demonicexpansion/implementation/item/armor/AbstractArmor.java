package tsp.demonicexpansion.implementation.item.armor;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import tsp.demonicexpansion.implementation.item.AbstractItem;

public class AbstractArmor extends AbstractItem {

    public AbstractArmor(SlimefunItemStack item, RecipeType type, ItemStack[] recipe) {
        super(item, type, recipe);
    }

    public void whileWearing(LivingEntity entity) {}

}
