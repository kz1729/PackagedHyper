package com.kz1729.packagedhyper.client;

import com.kz1729.packagedhyper.client.screen.HyperCrafterScreen;
import com.kz1729.packagedhyper.menu.HyperCrafterMenu;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = "packagedhyper", value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(
                    /* MenuType は後で登録 */ null,
                    HyperCrafterScreen::new
            );
        });
    }
}
