package net.gamerfer.tutorial_mod.item.custom;

import net.gamerfer.tutorial_mod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class ChiselItem extends Item {

    private static final Map<Block, Block> CHISEL_MAP =
    Map.of(

            Blocks.STONE, ModBlocks.FATASS_BLOCK,
            Blocks.END_STONE, ModBlocks.RAW_FATASS_BLOCK,
            Blocks.OAK_LOG, ModBlocks.FATASS_ORE,
            Blocks.GOLD_BLOCK, ModBlocks.FATASS_DEEPSLATE_ORE

    );

    public ChiselItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(CHISEL_MAP.containsKey(clickedBlock)){
            if(!world.isClient()){

                world.setBlockState(context.getBlockPos(), CHISEL_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()), item -> {
                    assert context.getPlayer() != null;
                    context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND);

                    world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);
                });
            }
        }

        return ActionResult.SUCCESS;
    }
}
