package tsp.demonicexpansion.implementation.entity;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;

import io.github.thebusybiscuit.slimefun4.libraries.dough.data.persistent.PersistentDataAPI;
import lombok.Data;
import tsp.demonicexpansion.DemonicExpansion;
import tsp.smartplugin.event.LivingEntityDamageByLivingEntityEvent;
import tsp.smartplugin.utils.AttributeUtils;
import tsp.smartplugin.utils.StringUtils;
import tsp.smartplugin.utils.Validate;

@Data
public class DemonicEntity {

    public static final NamespacedKey ENTITY_ID = new NamespacedKey(DemonicExpansion.getInstance(), "entity_id");

    private NamespacedKey key;
    private Class<? extends LivingEntity> entityClass = Zombie.class;
    private String name = getClass().getSimpleName();

    private double maxHealth = 20d;
    private double health = maxHealth;
    private double attackDamage = 20d;
    private double attackKnockback = 0d;
    private double movementSpeed = 0.23;
    private double knockbackResistance = 0.4; // 0.0 - 1.0 (1.0 is 100% knockback resistance. 0.4 means 60% of knockback is applied.)
    private double followRanage = 20d;
    private double armor = 20d;
    private double armorToughness = 0d;

    public void onDamageDealt(LivingEntityDamageByLivingEntityEvent event) {}

    public void onDamageReceived(LivingEntityDamageByLivingEntityEvent event) {}

    public void spawn(Location location) {
        Validate.notNull(location.getWorld(), "World can not be null!");

        location.getWorld().spawn(location, getEntityClass(), false, entity -> {
            PersistentDataAPI.setString(entity, ENTITY_ID, getKey().toString());

            AttributeUtils.setAttributes(entity, new HashMap<>() {/**
				 * 
				 */
				private static final long serialVersionUID = -2476804853315333514L;

			{
                put(Attribute.GENERIC_MAX_HEALTH, getMaxHealth());
                put(Attribute.GENERIC_ATTACK_DAMAGE, getAttackDamage());
                put(Attribute.GENERIC_ATTACK_KNOCKBACK, getAttackKnockback());
                put(Attribute.GENERIC_MOVEMENT_SPEED, getMovementSpeed());
                put(Attribute.GENERIC_KNOCKBACK_RESISTANCE, getKnockbackResistance());
                put(Attribute.GENERIC_FOLLOW_RANGE, getFollowRanage());
                put(Attribute.GENERIC_ARMOR, getArmor());
                put(Attribute.GENERIC_ARMOR_TOUGHNESS, getArmorToughness());
            }

			});
            entity.setHealth(getHealth());

            entity.setCustomName(StringUtils.colorize("&c" + getName()));
            entity.setCustomNameVisible(true);

            preSpawn(entity);

            DemonicExpansion.getInstance().getLog().trace("Spawned entity with TYPE: " + entity.getType().name() +  " | UUID:" + entity.getUniqueId().toString() + " | IMPL: " + getKey().toString());
        });
    }

    public double getHealth() {
		// TODO Auto-generated method stub
		return health;
	}

    public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

    public NamespacedKey getKey() {
		// TODO Auto-generated method stub
		return key;
	}

    public Class<? extends LivingEntity> getEntityClass() {
		// TODO Auto-generated method stub
		return entityClass;
	}

    public double getMaxHealth() {
		// TODO Auto-generated method stub
		return maxHealth;
	}

    public double getArmorToughness() {
		// TODO Auto-generated method stub
		return armorToughness;
	}

    public double getArmor() {
		// TODO Auto-generated method stub
		return armor;
	}

    public double getFollowRanage() {
		// TODO Auto-generated method stub
		return followRanage;
	}

    public double getKnockbackResistance() {
		// TODO Auto-generated method stub
		return knockbackResistance;
	}

    public double getMovementSpeed() {
		// TODO Auto-generated method stub
		return movementSpeed;
	}

    public double getAttackKnockback() {
		// TODO Auto-generated method stub
		return attackKnockback;
	}

    public double getAttackDamage() {
		// TODO Auto-generated method stub
		return attackDamage;
	}
	
	public void preSpawn(LivingEntity entity) {}

    public void tick(LivingEntity entity) {}

    public void register(EntityManager manager) {
        manager.register(getKey(), this);
    }

}
