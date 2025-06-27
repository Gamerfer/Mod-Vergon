package net.gamerfer.tutorial_mod.block;


import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.gamerfer.tutorial_mod.TUTORIAL;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block FATASS_BLOCK = registerBlock("fatass_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.MOSS_BLOCK)));

    public static final Block RAW_FATASS_BLOCK = registerBlock("raw_fatass_block",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
            AbstractBlock.Settings.create().strength(3f)
            .requiresTool().sounds(BlockSoundGroup.MOSS_BLOCK)));

    public static final Block FATASS_ORE = registerBlock("fatass_ore",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.ANVIL)));

    public static final Block FATASS_DEEPSLATE_ORE = registerBlock("fatass_deepslate_ore",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.ANVIL)));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TUTORIAL.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(TUTORIAL.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){

        TUTORIAL.LOGGER.info("Registrando Bloques del mod " + TUTORIAL.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.FATASS_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.RAW_FATASS_BLOCK);

            fabricItemGroupEntries.add(ModBlocks.FATASS_ORE);
            fabricItemGroupEntries.add(ModBlocks.FATASS_DEEPSLATE_ORE);
        });
    }
}
