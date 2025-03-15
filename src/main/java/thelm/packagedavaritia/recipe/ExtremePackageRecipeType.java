package thelm.packagedavaritia.recipe;

import java.util.List;
import java.util.stream.IntStream;

import avaritia.block.ModBlocks;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntRBTreeSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import thelm.packagedauto.api.IPackageRecipeInfo;
import thelm.packagedauto.api.IPackageRecipeType;
import thelm.packagedauto.api.IRecipeSlotViewWrapper;
import thelm.packagedauto.api.IRecipeSlotsViewWrapper;

public class ExtremePackageRecipeType implements IPackageRecipeType {

	public static final ExtremePackageRecipeType INSTANCE = new ExtremePackageRecipeType();
	public static final ResourceLocation NAME = new ResourceLocation("packagedavaritia:extreme");
	public static final IntSet SLOTS;
	public static final List<ResourceLocation> CATEGORIES = List.of(new ResourceLocation("avaritia:extreme_crafting"));
	public static final Vec3i COLOR = new Vec3i(139, 139, 139);
	public static final Vec3i COLOR_DISABLED = new Vec3i(64, 64, 64);

	static {
		SLOTS = new IntRBTreeSet();
		IntStream.range(0, 81).forEachOrdered(SLOTS::add);
	}

	protected ExtremePackageRecipeType() {}

	@Override
	public ResourceLocation getName() {
		return NAME;
	}

	@Override
	public MutableComponent getDisplayName() {
		return new TranslatableComponent("recipe.packagedavaritia.extreme");
	}

	@Override
	public MutableComponent getShortDisplayName() {
		return new TranslatableComponent("recipe.packagedavaritia.extreme.short");
	}

	@Override
	public IPackageRecipeInfo getNewRecipeInfo() {
		return new ExtremePackageRecipeInfo();
	}

	@Override
	public IntSet getEnabledSlots() {
		return SLOTS;
	}

	@Override
	public List<ResourceLocation> getJEICategories() {
		return CATEGORIES;
	}

	@Override
	public Int2ObjectMap<ItemStack> getRecipeTransferMap(IRecipeSlotsViewWrapper recipeLayoutWrapper) {
		Int2ObjectMap<ItemStack> map = new Int2ObjectOpenHashMap<>();
		List<IRecipeSlotViewWrapper> slotViews = recipeLayoutWrapper.getRecipeSlotViews();
		int index = 0;
		int[] slotArray = SLOTS.toIntArray();
		for(IRecipeSlotViewWrapper slotView : slotViews) {
			if(slotView.isInput()) {
				Object displayed = slotView.getDisplayedIngredient().orElse(null);
				if(displayed instanceof ItemStack stack && !stack.isEmpty()) {
					map.put(slotArray[index], stack);
				}
				++index;
			}
			if(index >= 81) {
				break;
			}
		}
		return map;
	}

	@Override
	public Object getRepresentation() {
		return new ItemStack(ModBlocks.extreme_crafting_table.get());
	}

	@Override
	public Vec3i getSlotColor(int slot) {
		if(slot >= 81 && slot != 81 && slot < 90) {
			return COLOR_DISABLED;
		}
		return COLOR;
	}
}
