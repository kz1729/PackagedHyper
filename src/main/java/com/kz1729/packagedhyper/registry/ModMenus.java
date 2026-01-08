package com.kz1729.packagedhyper.registry;

import com.kz1729.packagedhyper.PackagedHyper;
import com.kz1729.packagedhyper.menu.HyperCrafterMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenus {

    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, PackagedHyper.MODID);

    public static final RegistryObject<MenuType<HyperCrafterMenu>> HYPER_CRAFTER =
            MENUS.register("hyper_crafter",
                    () -> IForgeMenuType.create(HyperCrafterMenu::new));
}
