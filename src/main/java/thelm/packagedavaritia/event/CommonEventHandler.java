package thelm.packagedavaritia.event;

import net.minecraft.core.Registry;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import thelm.packagedauto.util.ApiImpl;
import thelm.packagedavaritia.block.ExtremeCrafterBlock;
import thelm.packagedavaritia.block.entity.ExtremeCrafterBlockEntity;
import thelm.packagedavaritia.config.PackagedAvaritiaConfig;
import thelm.packagedavaritia.menu.ExtremeCrafterMenu;
import thelm.packagedavaritia.recipe.ExtremePackageRecipeType;

public class CommonEventHandler {

	public static final CommonEventHandler INSTANCE = new CommonEventHandler();

	public static CommonEventHandler getInstance() {
		return INSTANCE;
	}

	public void onConstruct() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.register(this);
		PackagedAvaritiaConfig.registerConfig();

		DeferredRegister<Block> blockRegister = DeferredRegister.create(Registry.BLOCK_REGISTRY, "packagedavaritia");
		blockRegister.register(modEventBus);
		blockRegister.register("extreme_crafter", ()->ExtremeCrafterBlock.INSTANCE);

		DeferredRegister<Item> itemRegister = DeferredRegister.create(Registry.ITEM_REGISTRY, "packagedavaritia");
		itemRegister.register(modEventBus);
		itemRegister.register("extreme_crafter", ()->ExtremeCrafterBlock.ITEM_INSTANCE);

		DeferredRegister<BlockEntityType<?>> blockEntityRegister = DeferredRegister.create(Registry.BLOCK_ENTITY_TYPE_REGISTRY, "packagedavaritia");
		blockEntityRegister.register(modEventBus);
		blockEntityRegister.register("extreme_crafter", ()->ExtremeCrafterBlockEntity.TYPE_INSTANCE);

		DeferredRegister<MenuType<?>> menuRegister = DeferredRegister.create(Registry.MENU_REGISTRY, "packagedavaritia");
		menuRegister.register(modEventBus);
		menuRegister.register("extreme_crafter", ()->ExtremeCrafterMenu.TYPE_INSTANCE);
	}

	@SubscribeEvent
	public void onCommonSetup(FMLCommonSetupEvent event) {
		ApiImpl.INSTANCE.registerRecipeType(ExtremePackageRecipeType.INSTANCE);
	}

	@SubscribeEvent
	public void onModConfig(ModConfigEvent event) {
		switch(event.getConfig().getType()) {
		case SERVER -> PackagedAvaritiaConfig.reloadServerConfig();
		default -> {}
		}
	}
}
