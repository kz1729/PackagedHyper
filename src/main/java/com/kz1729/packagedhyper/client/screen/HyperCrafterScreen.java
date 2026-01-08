package com.kz1729.packagedhyper.client.screen;

import com.kz1729.packagedhyper.menu.HyperCrafterMenu;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class HyperCrafterScreen extends AbstractContainerScreen<HyperCrafterMenu> {

    public HyperCrafterScreen(HyperCrafterMenu menu, Inventory inv, Component title) {
        super(menu, inv, title);
        this.imageWidth = 176;
        this.imageHeight = 222; // 9×9用に少し大きめ
    }

    @Override
    protected void renderBg(net.minecraft.client.gui.GuiGraphics graphics, float partialTicks, int mouseX, int mouseY) {
        // 今は背景なし（後でテクスチャを貼る）
    }
}
