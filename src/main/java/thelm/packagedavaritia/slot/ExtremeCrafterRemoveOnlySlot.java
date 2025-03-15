package thelm.packagedavaritia.slot;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.SlotItemHandler;
import thelm.packagedavaritia.block.entity.ExtremeCrafterBlockEntity;

//Code from CoFHCore
public class ExtremeCrafterRemoveOnlySlot extends SlotItemHandler {

	public final ExtremeCrafterBlockEntity blockEntity;

	public ExtremeCrafterRemoveOnlySlot(ExtremeCrafterBlockEntity blockEntity, int index, int x, int y) {
		super(blockEntity.getItemHandler(), index, x, y);
		this.blockEntity = blockEntity;
	}

	@Override
	public boolean mayPickup(Player player) {
		return !blockEntity.isWorking;
	}

	@Override
	public boolean mayPlace(ItemStack stack) {
		return false;
	}
}
