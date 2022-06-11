package tsp.demonicexpansion.implementation.item.weapon;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.inventory.ItemStack;
import tsp.demonicexpansion.implementation.item.AbstractItem;
import tsp.smartplugin.event.LivingEntityDamageByLivingEntityEvent;

public class DemonicWeapon extends AbstractItem {

    public DemonicWeapon(SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(item, recipeType, recipe);
    }

    public void onHit(LivingEntityDamageByLivingEntityEvent event) {}

}
