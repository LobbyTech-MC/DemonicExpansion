package tsp.demonicexpansion.implementation.item.armor;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import tsp.demonicexpansion.DemonicExpansion;

public class DemonicHelmet extends DemonicArmor {

    public DemonicHelmet() {
        super(DemonicExpansion.getInstance().getItems().DEMONIC_HELMET, new ItemStack(Material.NETHERITE_HELMET));
    }

    @Override
    public void whileWearing(LivingEntity entity) {
        entity.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 20, 0));
    }

}
