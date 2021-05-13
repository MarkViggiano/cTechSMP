package me.mark.techsmp.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import java.util.List;

public class ItemUtil {

    public static ItemStack createItem(@Nonnull Material material, @Nonnull String title, @Nonnull List<String> description) {
        ItemStack item = new ItemStack(material);
        if (item.getItemMeta() == null) return item;
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(title);
        meta.setLore(description);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createUnbreakableItem(@Nonnull Material material, @Nonnull String title, @Nonnull List<String> description) {
        ItemStack item = createItem(material, title, description);
        if (item.getItemMeta() == null) return item;
        ItemMeta meta = item.getItemMeta();
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        return item;
    }

}
