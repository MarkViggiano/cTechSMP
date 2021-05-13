package me.mark.techsmp.boss;

import me.mark.techsmp.Main;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public abstract class SMPEntity {

    private EntityType type;
    private Entity entity;
    private double MAX_HEALTH;
    private double health;

    public SMPEntity(EntityType type, double MAX_HEALTH) {
        this.type = type;
        this.MAX_HEALTH = MAX_HEALTH;
        this.health = MAX_HEALTH;
    }

    public abstract String getName();

    public void spawnEntity(Location location) {
        World world = location.getWorld();
        if (world == null) return; //should never happen but just in case
        Entity entity = world.spawnEntity(location, getType());
        setEntity(entity);

        Main.getInstance().getSmpEntityManager().addEntity(this);
    }

    public void killEntity() {
        getEntity().remove();
        Main.getInstance().getSmpEntityManager().removeEntity(getEntity().getUniqueId());
    }

    public EntityType getType() {
        return type;
    }

    protected void setEntity(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }

    public double getMAX_HEALTH() {
        return MAX_HEALTH;
    }

    public double getHealth() {
        return health;
    }

    public int getHealthInt() {
        return (int) health;
    }

    public int getMAX_HEALTHInt() {
        return (int) MAX_HEALTH;
    }

    public void damage(double amount) {
        this.health -= amount;
        if (getHealth() <= 0) killEntity();
    }

    public void damage(int amount) {
        this.health -= amount;
        if (getHealth() <= 0) killEntity();
    }

    public void heal(double amount) {
        this.health += amount;
        if (getHealth() >= getMAX_HEALTH()) this.health = getMAX_HEALTH();
    }

    public void heal(int amount) {
        this.health += amount;
        if (getHealth() >= getMAX_HEALTH()) this.health = getMAX_HEALTH();
    }

}
