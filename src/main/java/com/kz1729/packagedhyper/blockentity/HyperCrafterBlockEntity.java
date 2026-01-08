package com.kz1729.packagedhyper.blockentity;

import com.kz1729.packagedhyper.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraft.world.MenuProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import com.kz1729.packagedhyper.menu.HyperCrafterMenu;

import javax.annotation.Nullable;


public class HyperCrafterBlockEntity extends BlockEntity implements MenuProvider {

    private final ItemStackHandler itemHandler = new ItemStackHandler(81);

    public HyperCrafterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.HYPER_CRAFTER.get(), pos, state);
    }

    public IItemHandler getItemHandler() {
        return itemHandler;
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.packagedhyper.hyper_crafter");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return new HyperCrafterMenu(id, inv, this);
    }


}
