package net.gamerfer.tutorial_mod.item;


import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.gamerfer.tutorial_mod.TUTORIAL;
import net.gamerfer.tutorial_mod.item.custom.ChiselItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item FATASS = registerItem("fatass", new Item(new Item.Settings()));
    public static final Item RAW_FATASS = registerItem("raw_fatass", new Item(new Item.Settings()));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(TUTORIAL.MOD_ID, name), item);
    }

    public static void registerModItem(){
        TUTORIAL.LOGGER.info("Registrando items del mod para" + TUTORIAL.MOD_ID);


        //No se si esto esta bien
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {

            fabricItemGroupEntries.add(FATASS);
            fabricItemGroupEntries.add(RAW_FATASS);

        });
    }
}
