package net.gamerfer.tutorial_mod;

import net.fabricmc.api.ModInitializer;

import net.gamerfer.tutorial_mod.block.ModBlocks;
import net.gamerfer.tutorial_mod.item.ModItemGroup;
import net.gamerfer.tutorial_mod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Comentariooooooooooooooooo
public class TUTORIAL implements ModInitializer {
	public static final String MOD_ID = "tutorial";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override

	public void onInitialize() {
		ModItemGroup.registerItemGroups();

		ModItems.registerModItem();
		ModBlocks.registerModBlocks();
	}
}