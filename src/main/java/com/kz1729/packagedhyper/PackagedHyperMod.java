package com.kz1729.packagedhyper;

import com.kz1729.packagedhyper.registry.ModBlockEntities;
import com.kz1729.packagedhyper.registry.ModBlocks;
import com.kz1729.packagedhyper.registry.ModItems;
import com.kz1729.packagedhyper.registry.ModMenus;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(PackagedHyperMod.MODID)
public class PackagedHyperMod {

    public static final String MODID = "packagedhyper"; // ← ★これを追加

    public PackagedHyperMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.BLOCKS.register(bus);
        ModItems.ITEMS.register(bus);
        ModBlockEntities.BLOCK_ENTITIES.register(bus);
        ModMenus.MENUS.register(bus);
    }
}
