package com.kz1729.packagedhyper.registry;

import com.kz1729.packagedhyper.PackagedHyper;
import com.kz1729.packagedhyper.block.HyperCrafterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PackagedHyper.MODID);

    public static final RegistryObject<Block> HYPER_CRAFTER =
            BLOCKS.register("hyper_crafter",
                    () -> new HyperCrafterBlock(
                            BlockBehaviour.Properties.of()
                                    .strength(3.0f)
                    ));
}
