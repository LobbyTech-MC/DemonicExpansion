package tsp.demonicexpansion.implementation.item.armor;

import io.github.thebusybiscuit.slimefun4.api.items.ItemSetting;
import io.github.thebusybiscuit.slimefun4.api.items.settings.IntRangeSetting;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Levelled;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import tsp.demonicexpansion.DemonicExpansion;

public class DemonicBoots extends DemonicArmor {

    private final ItemSetting<Integer> radiusSetting = new IntRangeSetting(this, "radius", 1, 2, 100);

    public DemonicBoots() {
        super(DemonicExpansion.getInstance().getItems().DEMONIC_BOOTS, new ItemStack(Material.NETHERITE_BOOTS));
        addItemSettings(radiusSetting);
    }

    @Override
    public void whileWearing(LivingEntity entity) {
        Block stoodBlock = entity.getLocation().clone().subtract(0, 1, 0).getBlock();
        int radius = radiusSetting.getValue();

        // Thanks Sefiraat for this part, heavily tweaked to fit this addon
        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                Block b = stoodBlock.getRelative(x, 0, z);

                // TODO: Find a way to stop entities from possibly being able to use this to grief builds with this
                if (entity instanceof Player p) {
                    if (!Slimefun.getProtectionManager().hasPermission(p, b, Interaction.PLACE_BLOCK)) {
                        return;
                    }

                    if (b.getType() == Material.LAVA && b.getBlockData() instanceof Levelled l) {
                        if (l.getLevel() == 0) {
                            b.setType(Material.OBSIDIAN);
                            // The obsidian doesn't turn back into lava, this is intentional!
                        }
                    }
                }
                // Lava walker will only work on players, it is *possible* that entities can be abused to grief with it.
            }
        }
    }

}
