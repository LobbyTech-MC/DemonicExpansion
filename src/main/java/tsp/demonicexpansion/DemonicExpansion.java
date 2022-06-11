package tsp.demonicexpansion;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import org.bukkit.plugin.java.JavaPlugin;
import tsp.demonicexpansion.command.DXCommand;
import tsp.demonicexpansion.implementation.entity.Entities;
import tsp.demonicexpansion.implementation.entity.EntityManager;
import tsp.demonicexpansion.implementation.group.Groups;
import tsp.demonicexpansion.implementation.item.Items;
import tsp.demonicexpansion.implementation.research.Researches;
import tsp.demonicexpansion.listener.EntityCombustListener;
import tsp.demonicexpansion.listener.EntityDamageListener;
import tsp.demonicexpansion.listener.EntityTargetListener;
import tsp.demonicexpansion.task.ArmorTask;
import tsp.demonicexpansion.task.EntityTask;
import tsp.demonicexpansion.util.Logger;
import tsp.smartplugin.SmartPlugin;
import tsp.smartplugin.event.EntityDamageByEntityListener;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class DemonicExpansion extends SmartPlugin implements SlimefunAddon {

    private static DemonicExpansion instance;
    private Logger logger;
    private Items items;
    private Researches researches;
    private EntityManager entityManager;

    @Override
    public void onStart() {
        instance = this;
        this.logger = new Logger(getConfig().getBoolean("debug"));
        logger.info("Loading DemonicExpansion - " + getPluginVersion());
        Groups.MAIN.register(DemonicExpansion.getInstance());

        logger.debug("Loading items...");
        this.items = new Items();
        items.setup();

        logger.debug("Loading researches...");
        this.researches = new Researches();
        researches.setup();

        logger.debug("Loading entities...");
        this.entityManager = new EntityManager();
        Entities.registerAll(entityManager);

        new EntityCombustListener();
        new EntityDamageByEntityListener();
        new EntityDamageListener();
        new EntityTargetListener();

        new ArmorTask().schedule(this);
        new EntityTask().schedule(this);

        new DXCommand().register(this);

        logger.info("Done!");
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Researches getResearches() {
        return researches;
    }

    public Items getItems() {
        return items;
    }

    @Nonnull
    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Nullable
    @Override
    public String getBugTrackerURL() {
        return "todo";
    }

    public Logger getLog() {
        return logger;
    }

    public static DemonicExpansion getInstance() {
        return instance;
    }

}
