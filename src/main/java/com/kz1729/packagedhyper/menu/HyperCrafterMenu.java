package com.kz1729.packagedhyper.menu;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraft.world.inventory.Slot;
import net.minecraft.network.FriendlyByteBuf;
import com.kz1729.packagedhyper.blockentity.HyperCrafterBlockEntity;
import com.kz1729.packagedhyper.registry.ModMenus;


public class HyperCrafterMenu extends AbstractContainerMenu {

    private final HyperCrafterBlockEntity blockEntity;
    private final Level level;
    private final IItemHandler itemHandler;

    // ===== クライアント側（Packet経由）=====
    public HyperCrafterMenu(int id, Inventory inv, FriendlyByteBuf buf) {
        this(
                id,
                inv,
                (HyperCrafterBlockEntity) inv.player.level()
                        .getBlockEntity(buf.readBlockPos())
        );
    }

    // ===== サーバー側（実体）=====
    public HyperCrafterMenu(int id, Inventory inv, HyperCrafterBlockEntity be) {
        super(ModMenus.HYPER_CRAFTER.get(), id);

        this.blockEntity = be;
        this.level = inv.player.level();
        this.itemHandler = be.getItemHandler();

        addSlots(inv);
    }

    private void addSlots(Inventory playerInv) {
        int startX = 8;
        int startY = 18;
        int slotSize = 18;

        // 9×9 クラフト
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int index = row * 9 + col;
                this.addSlot(new SlotItemHandler(
                        itemHandler,
                        index,
                        startX + col * slotSize,
                        startY + row * slotSize
                ));
            }
        }

        int invStartY = startY + 9 * slotSize + 14;

        // プレイヤーインベントリ
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(
                        playerInv,
                        col + row * 9 + 9,
                        startX + col * slotSize,
                        invStartY + row * slotSize
                ));
            }
        }

        // ホットバー
        int hotbarY = invStartY + 3 * slotSize + 4;
        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(
                    playerInv,
                    col,
                    startX + col * slotSize,
                    hotbarY
            ));
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return ItemStack.EMPTY;
    }
}
