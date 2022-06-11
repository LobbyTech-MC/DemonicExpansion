package tsp.demonicexpansion.implementation.item.weapon;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import tsp.demonicexpansion.DemonicExpansion;
import tsp.demonicexpansion.implementation.item.Unburnable;
import tsp.demonicexpansion.util.Utils;
import tsp.smartplugin.player.PlayerUtils;
import tsp.smartplugin.utils.ItemUtils;

import java.util.Arrays;
import java.util.List;

public class DevilsRing extends DemonicWeapon implements Unburnable {

    public DevilsRing() {
        super(DemonicExpansion.getInstance().getItems().DEVILS_RING, RecipeType.ANCIENT_ALTAR, new ItemStack[]{
                null, null, null,
                null, null, null,
                null, null, null
        }); // TODO: Finish recipe
    }

    private final List<PotionEffect> effects = Arrays.asList(
            new PotionEffect(PotionEffectType.BLINDNESS, 100, 0),
            new PotionEffect(PotionEffectType.WEAKNESS, 100, 0)
    );

    @Override
    public void onRightClick(PlayerRightClickEvent event) {
        ItemUtils.use(event.getItem(), 30, cd -> {
            for (LivingEntity entity : Utils.getNearbyLivingEntities(event.getPlayer(), 5)) {
                entity.addPotionEffects(effects);
            }
            event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 1f, 1f);
        }, left -> PlayerUtils.sendMessage(event.getPlayer(), "&cYou can not use this for another: &e" + left + "s")); // No sound because it would be deafening when spammed on cooldown.
    }

}
