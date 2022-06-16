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
            "&c恶魔之心"
    );

    public final DemonicItemStack PENTECOSTAL_COIN = new DemonicItemStack(
            "PENTECOSTAL_COIN",
            Material.ORANGE_DYE,
            "&c五旬节硬币",
            "",
            "&7Shift+右击 在当前方块顶端锁定该位置(主世界 & 下界)",
            "&7右击 传送至下界一段时间后再传送回来(60s)"
    );

    public final DemonicItemStack NAPALM = new DemonicItemStack(
            "NAPALM",
            Material.GREEN_DYE,
            "&2凝固汽油"
    );

    // Armor

    public final DemonicItemStack DEMONIC_HELMET = new DemonicItemStack(
            "DEMONIC_HELMET",
            Material.NETHERITE_HELMET,
            "&c魑魅头盔",
            "",
            "&6窥探: &7获得 &9夜视"
    );

    public final DemonicItemStack DEMONIC_CHESTPLATE = new DemonicItemStack(
            "DEMONIC_CHESTPLATE",
            Material.NETHERITE_CHESTPLATE,
            "&c魑魅胸甲",
            "",
            "&6夜隐: &7获得 &6抗火"
    );

    public final DemonicItemStack DEMONIC_LEGGINGS = new DemonicItemStack(
            "DEMONIC_LEGGINGS",
            Material.NETHERITE_LEGGINGS,
            "&c魑魅护腿",
            "",
            "&6寻觅: &7获得 &c生命恢复2"
    );

    public final DemonicItemStack DEMONIC_BOOTS = new DemonicItemStack(
            "DEMONIC_BOOTS",
            Material.NETHERITE_BOOTS,
            "&c魑魅靴子",
            "",
            "&6岩浆行者: &7将周围的岩浆永久性的变为黑曜石!"
    );

    // Weapon

    public final DemonicItemStack DEVILS_RING = new DemonicItemStack(
            "DEVILS_RING",
            Material.RED_DYE,
            "&c魑魅之戒",
            "",
            "&6主动技能: &7使周围的敌人失明、虚弱、燃烧(60s)"
    );

    // Machines

    public final DemonicItemStack THERMAL_GENERATOR = new DemonicItemStack(
            "THERMAL_GENERATOR",
            HeadTexture.GENERATOR,
            "&c魑魅发电机",
            "",
            "&7可在下界发电",
            "&7必须放置在岩浆上方"
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
