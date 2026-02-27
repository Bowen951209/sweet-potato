package dev.bnj.sweetpotato;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class ModItems {
    public static Item register_food(String name, FoodProperties foodProps) {
        // Create the item key.
        var itemKey = ResourceKey.create(
                Registries.ITEM, Identifier.fromNamespaceAndPath(SweetPotatoMod.MOD_ID, name));

        // Create the item instance.
        var props = new Item.Properties().food(foodProps).setId(itemKey);

        // Create the item instance.
        var item = new Item(props);

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize() {
    }
}
