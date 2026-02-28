package dev.bnj.sweetpotato;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.entity.npc.villager.VillagerTrades;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SweetPotatoMod implements ModInitializer {
    public static final String MOD_ID = "sweetpotato";

    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final Block SWEET_POTATOES = ModBlocks.register(
            "sweet_potatoes",
            SweetPotatoBlock::new,
            BlockBehaviour.Properties
                    .of()
                    .mapColor(MapColor.PLANT)
                    .noCollision()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.CROP)
                    .pushReaction(PushReaction.DESTROY),
            false);
    public static final Item SWEET_POTATO = ModItems.register(
            "sweet_potato",
            properties -> new BlockItem(SWEET_POTATOES, properties.useItemDescriptionPrefix()),
            new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.3F).build())
    );
    public static final Item BAKED_SWEET_POTATO = ModItems.register(
            "baked_sweet_potato",
            Item::new,
            new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.6F).build())
    );

    @Override
    public void onInitialize() {
        ModItems.initialize();
        ModBlocks.initialize();

        // Villager trade
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
            factories.add(new VillagerTrades.EmeraldForItems(SWEET_POTATO, 26, 16, 2));
            factories.add(new VillagerTrades.EmeraldForItems(BAKED_SWEET_POTATO, 22, 16, 2));
        });
    }
}