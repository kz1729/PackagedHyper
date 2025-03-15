package thelm.packagedavaritia.event;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
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
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
		PackagedAvaritiaConfig.registerConfig();
	}

	@SubscribeEvent
	public void onBlockRegister(RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> registry = event.getRegistry();
		registry.register(ExtremeCrafterBlock.INSTANCE);
	}

	@SubscribeEvent
	public void onItemRegister(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();
		registry.register(ExtremeCrafterBlock.ITEM_INSTANCE);
	}

	@SubscribeEvent
	public void onBlockEntityRegister(RegistryEvent.Register<BlockEntityType<?>> event) {
		IForgeRegistry<BlockEntityType<?>> registry = event.getRegistry();
		registry.register(ExtremeCrafterBlockEntity.TYPE_INSTANCE);
	}

	@SubscribeEvent
	public void onMenuRegister(RegistryEvent.Register<MenuType<?>> event) {
		IForgeRegistry<MenuType<?>> registry = event.getRegistry();
		registry.register(ExtremeCrafterMenu.TYPE_INSTANCE);
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
