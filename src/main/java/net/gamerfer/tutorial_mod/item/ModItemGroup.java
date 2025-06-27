package net.gamerfer.tutorial_mod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.gamerfer.tutorial_mod.TUTORIAL;
import net.gamerfer.tutorial_mod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final ItemGroup FATASS_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TUTORIAL.MOD_ID, "fatass_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.FATASS))
            .displayName(Text.translatable("itemgroup.tutorial.fatass_items"))
            .entries((displayContext, entries) -> {

                entries.add(ModItems.FATASS);
                entries.add(ModItems.RAW_FATASS);

                entries.add(ModItems.CHISEL);

            })

            .build());

    public static final ItemGroup FATASS_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TUTORIAL.MOD_ID, "fatass_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.FATASS_BLOCK))
            .displayName(Text.translatable("itemgroup.tutorial.fatass_blocks"))
            .entries((displayContext, entries) -> {

                entries.add(ModBlocks.FATASS_BLOCK);
                entries.add(ModBlocks.RAW_FATASS_BLOCK);

            })

            .build());



    public static void registerItemGroups(){
        TUTORIAL.LOGGER.info("Registrando grupos de items para el mod " + TUTORIAL.MOD_ID);
    }

}
