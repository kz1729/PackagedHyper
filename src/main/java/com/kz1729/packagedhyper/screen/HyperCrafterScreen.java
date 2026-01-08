package com.kz1729.packagedhyper.screen;

import com.kz1729.packagedhyper.menu.HyperCrafterMenu;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class HyperCrafterScreen
        extends AbstractContainerScreen<HyperCrafterMenu> {

    public HyperCrafterScreen(
            HyperCrafterMenu menu,
            Inventory playerInv,
            Component title
    ) {
        super(menu, playerInv, title);
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void renderBg(
            net.minecraft.client.gui.GuiGraphics guiGraphics,
            float partialTick,
            int mouseX,
            int mouseY
    ) {
        // とりあえず何もしない（背景なし）
    }
}
