package tsp.demonicexpansion.implementation.item;

import io.github.thebusybiscuit.slimefun4.utils.HeadTexture;
import org.bukkit.Material;
import tsp.demonicexpansion.implementation.item.armor.DemonicBoots;
import tsp.demonicexpansion.implementation.item.armor.DemonicChestplate;
import tsp.demonicexpansion.implementation.item.armor.DemonicHelmet;
import tsp.demonicexpansion.implementation.item.armor.DemonicLeggings;
import tsp.demonicexpansion.implementation.item.generator.ThermalGenerator;
import tsp.demonicexpansion.implementation.item.misc.DemonicEssence;
import tsp.demonicexpansion.implementation.item.misc.Napalm;
import tsp.demonicexpansion.implementation.item.misc.PentecostalCoin;
import tsp.demonicexpansion.implementation.item.weapon.DevilsRing;

/**
 * Contains all the items that are used by this addon.
 */
public class Items {

    // Misc

    public final DemonicItemStack DEMONIC_ESSENCE = new DemonicItemStack(
            "DEMONIC_ESSENCE",
            Material.PURPLE_DYE,
            "&cDemonic Essence"
    );

    public final DemonicItemStack PENTECOSTAL_COIN = new DemonicItemStack(
            "PENTECOSTAL_COIN",
            Material.ORANGE_DYE,
            "&cPentecostal Coin",
            "",
            "&7Shift-Right-Click the top of a block to anchor yourself to that location. (World & Nether)",
            "&7Right-Click to travel to the nether and back. (60s)"
    );

    public final DemonicItemStack NAPALM = new DemonicItemStack(
            "NAPALM",
            Material.GREEN_DYE,
            "&2Napalm"
    );

    // Armor

    public final DemonicItemStack DEMONIC_HELMET = new DemonicItemStack(
            "DEMONIC_HELMET",
            Material.NETHERITE_HELMET,
            "&cDemonic Helmet",
            "",
            "&6Enlightened: &7Gain &9Night Vision&."
    );

    public final DemonicItemStack DEMONIC_CHESTPLATE = new DemonicItemStack(
            "DEMONIC_CHESTPLATE",
            Material.NETHERITE_CHESTPLATE,
            "&cDemonic Chestplate",
            "",
            "&6Demon Shade: &7Gain &6Fire Resistance&7."
    );

    public final DemonicItemStack DEMONIC_LEGGINGS = new DemonicItemStack(
            "DEMONIC_LEGGINGS",
            Material.NETHERITE_LEGGINGS,
            "&cDemonic Leggings",
            "",
            "&6Recovery: &7Gain &cRegeneration 2&7."
    );

    public final DemonicItemStack DEMONIC_BOOTS = new DemonicItemStack(
            "DEMONIC_BOOTS",
            Material.NETHERITE_BOOTS,
            "&cDemonic Boots",
            "",
            "&6Lava Walker: &7Turns lava around you into obsidian &cpermanently&7!"
    );

    // Weapon

    public final DemonicItemStack DEVILS_RING = new DemonicItemStack(
            "DEVILS_RING",
            Material.RED_DYE,
            "&cDevils Ring",
            "",
            "&6Active - Paranoia: &7Blind, weaken and burn nearby enemies. (60s)"
    );

    // Machines

    public final DemonicItemStack THERMAL_GENERATOR = new DemonicItemStack(
            "THERMAL_GENERATOR",
            HeadTexture.GENERATOR,
            "&cThermal Generator",
            "",
            "&7Generates energy in the nether. Must be placed above &6lava&7."
    );

    public void setup() {
        new DemonicEssence().registerDefault();
        new DemonicHelmet().registerDefault();
        new DemonicChestplate().registerDefault();
        new DemonicLeggings().registerDefault();
        new DemonicBoots().registerDefault();
        new PentecostalCoin().registerDefault();
        new Napalm().registerDefault();
        new DevilsRing().registerDefault();
        new ThermalGenerator().registerDefault();
    }

}
