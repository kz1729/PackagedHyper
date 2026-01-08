package com.kz1729.packagedhyper.registry;

import com.kz1729.packagedhyper.PackagedHyperMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PackagedHyperMod.MODID);

    public static final RegistryObject<Item> HYPER_CRAFTER =
            ITEMS.register("hyper_crafter",
                    () -> new BlockItem(
                            ModBlocks.HYPER_CRAFTER.get(),
                            new Item.Properties()
                    ));
}
