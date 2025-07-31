package thelm.packagedavaritia.event;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import thelm.packagedauto.util.ApiImpl;
import thelm.packagedavaritia.block.ExtremeCrafterBlock;
import thelm.packagedavaritia.block.entity.ExtremeCrafterBlockEntity;
import thelm.packagedavaritia.config.PackagedAvaritiaConfig;
import thelm.packagedavaritia.menu.ExtremeCrafterMenu;
import thelm.packagedavaritia.recipe.ExtremePackageRecipeType;
import thelm.packagedavaritia.variant.VariantChecker;

public class CommonEventHandler {

	public static final CommonEventHandler INSTANCE = new CommonEventHandler();

	public static CommonEventHandler getInstance() {
		return INSTANCE;
	}

	public void onConstruct() {
		@SuppressWarnings("removal")
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.register(this);
		PackagedAvaritiaConfig.registerConfig();

		DeferredRegister<Block> blockRegister = DeferredRegister.create(Registries.BLOCK, "packagedavaritia");
		blockRegister.register(modEventBus);
		blockRegister.register("extreme_crafter", ()->ExtremeCrafterBlock.INSTANCE);

		DeferredRegister<Item> itemRegister = DeferredRegister.create(Registries.ITEM, "packagedavaritia");
		itemRegister.register(modEventBus);
		itemRegister.register("extreme_crafter", ()->ExtremeCrafterBlock.ITEM_INSTANCE);

		DeferredRegister<BlockEntityType<?>> blockEntityRegister = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, "packagedavaritia");
		blockEntityRegister.register(modEventBus);
		blockEntityRegister.register("extreme_crafter", ()->ExtremeCrafterBlockEntity.TYPE_INSTANCE);

		DeferredRegister<MenuType<?>> menuRegister = DeferredRegister.create(Registries.MENU, "packagedavaritia");
		menuRegister.register(modEventBus);
		menuRegister.register("extreme_crafter", ()->ExtremeCrafterMenu.TYPE_INSTANCE);

		DeferredRegister<CreativeModeTab> creativeTabRegister = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "packagedavaritia");
		creativeTabRegister.register(modEventBus);
		creativeTabRegister.register("tab",
				()->CreativeModeTab.builder().
				title(Component.translatable("itemGroup.packagedavaritia")).
				icon(()->new ItemStack(ExtremeCrafterBlock.ITEM_INSTANCE)).
				displayItems((parameters, output)->{
					output.accept(ExtremeCrafterBlock.ITEM_INSTANCE);
				}).
				build());
	}

	@SubscribeEvent
	public void onConstructMod(FMLConstructModEvent event) {
		VariantChecker.check();
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
