package dev.bnj.sweetpotato;

import net.fabricmc.api.ModInitializer;

import net.minecraft.world.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SweetPotatoMod implements ModInitializer {
	public static final String MOD_ID = "sweetpotato";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Item SWEET_POTATO = ModItems.register("sweet_potato");
	public static final Item BAKED_SWEET_POTATO = ModItems.register("baked_sweet_potato");

	@Override
	public void onInitialize() {
		ModItems.initialize();
	}
}