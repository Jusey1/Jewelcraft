package net.salju.jewelcraft.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;
import net.salju.jewelcraft.init.JewelryConfig;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
import java.util.List;

public class JewelryItem extends Item implements ICurioItem, Vanishable {
	private final int ench;

	public JewelryItem(Item.Properties props, int value) {
		super(props);
		this.ench = value;
	}

	@Override
	public void appendHoverText(ItemStack stack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(stack, world, list, flag);
		if (isGold(stack)) {
			list.add(Component.translatable("desc.jewelcraft.gold").withStyle(ChatFormatting.DARK_PURPLE));
		}
	}

	@Override
	public boolean isEnchantable(ItemStack stack) {
		return true;
	}

	@Override
	public int getEnchantmentValue() {
		return ench;
	}

	@Override
	public boolean canEquipFromUse(SlotContext slot, ItemStack stack) {
		return true;
	}

	@Override
	public boolean makesPiglinsNeutral(SlotContext slot, ItemStack stack) {
		return isGold(stack);
	}

	public boolean isGold(ItemStack stack) {
		return (stack.is(ItemTags.create(new ResourceLocation("jewelcraft:is_gold"))) && JewelryConfig.GOLDEN.get());
	}

	public boolean isIron(ItemStack stack) {
		return (stack.is(ItemTags.create(new ResourceLocation("jewelcraft:is_iron"))));
	}

	public boolean isCopper(ItemStack stack) {
		return (stack.is(ItemTags.create(new ResourceLocation("jewelcraft:is_copper"))));
	}
}