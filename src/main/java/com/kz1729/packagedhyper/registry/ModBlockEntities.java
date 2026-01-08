package com.kz1729.packagedhyper.registry;

import com.kz1729.packagedhyper.PackagedHyper;
import com.kz1729.packagedhyper.blockentity.HyperCrafterBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, PackagedHyper.MODID);

    public static final RegistryObject<BlockEntityType<HyperCrafterBlockEntity>> HYPER_CRAFTER =
            BLOCK_ENTITIES.register("hyper_crafter",
                    () -> BlockEntityType.Builder.of(
                            HyperCrafterBlockEntity::new,
                            ModBlocks.HYPER_CRAFTER.get()
                    ).build(null));
}
