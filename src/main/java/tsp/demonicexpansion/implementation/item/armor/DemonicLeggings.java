package tsp.demonicexpansion.implementation.item.armor;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import tsp.demonicexpansion.DemonicExpansion;

public class DemonicLeggings extends DemonicArmor {

    public DemonicLeggings() {
        super(DemonicExpansion.getInstance().getItems().DEMONIC_LEGGINGS, new ItemStack(Material.NETHERITE_LEGGINGS));
    }

    @Override
    public void whileWearing(LivingEntity entity) {
        entity.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, 1));
    }

}
