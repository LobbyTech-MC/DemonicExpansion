package tsp.demonicexpansion.implementation.item.armor;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import tsp.demonicexpansion.DemonicExpansion;

public class DemonicChestplate extends DemonicArmor {

    public DemonicChestplate() {
        super(DemonicExpansion.getInstance().getItems().DEMONIC_CHESTPLATE, new ItemStack(Material.NETHERITE_CHESTPLATE));
    }

    @Override
    public void whileWearing(LivingEntity entity) {
        entity.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 20, 0));
    }

}
