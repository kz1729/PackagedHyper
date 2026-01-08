package com.kz1729.packagedhyper.block;

import com.kz1729.packagedhyper.blockentity.HyperCrafterBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.network.chat.Component;
import com.kz1729.packagedhyper.menu.HyperCrafterMenu;
import net.minecraftforge.network.NetworkHooks;
import net.minecraft.server.level.ServerPlayer;


public class HyperCrafterBlock extends Block implements EntityBlock {

    public HyperCrafterBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof HyperCrafterBlockEntity crafter) {
                NetworkHooks.openScreen(
                        (ServerPlayer) player,
                        crafter,
                        pos
                );
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }


    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new HyperCrafterBlockEntity(pos, state);
    }
}
