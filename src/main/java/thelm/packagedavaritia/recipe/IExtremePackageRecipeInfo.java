package thelm.packagedavaritia.recipe;

import java.util.Collections;
import java.util.List;

import avaritia.recipe.ITableRecipe;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import thelm.packagedauto.api.IPackageRecipeInfo;

public interface IExtremePackageRecipeInfo extends IPackageRecipeInfo {

	ItemStack getOutput();

	ITableRecipe getRecipe();

	IInventory getMatrix();

	List<ItemStack> getRemainingItems();

	@Override
	default List<ItemStack> getOutputs() {
		ItemStack output = getOutput();
		return output.isEmpty() ? Collections.emptyList() : Collections.singletonList(output);
	}
}
