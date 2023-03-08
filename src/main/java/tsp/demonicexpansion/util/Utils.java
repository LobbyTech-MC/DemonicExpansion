package tsp.demonicexpansion.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

import io.github.thebusybiscuit.slimefun4.libraries.commons.lang.Validate;

public class Utils {

    @Nonnull
    public static List<LivingEntity> getNearbyLivingEntities(Entity entity, int x, int y, int z) {
        Validate.notNull(entity, "Entity can not be null!");

        List<LivingEntity> entities = new ArrayList<>();
        for (Entity nearby : entity.getNearbyEntities(x, y, z)) {
            if (nearby instanceof LivingEntity livingEntity
                    && !(livingEntity instanceof ArmorStand)) { // We do not want armor stands and such
                entities.add(livingEntity);
            }
        }

        return entities;
    }

    @Nonnull
    public static List<LivingEntity> getNearbyLivingEntities(Entity entity, int radius) {
        return getNearbyLivingEntities(entity, radius, radius, radius);
    }

}
