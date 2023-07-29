package net.salju.jewelcraft.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.type.capability.ICurio.DropRule;
import top.theillusivec4.curios.api.SlotContext;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;

import java.util.List;

public class JewelryItem extends Item implements ICurioItem, Vanishable {
	public JewelryItem(Item.Properties props) {
		super(props);
	}

	@Override
	public void appendHoverText(ItemStack stack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(stack, world, list, flag);
		if (stack.is(ItemTags.create(new ResourceLocation("jewelcraft:is_gold"))))
			list.add(Component.translatable("desc.jewelcraft.gold").withStyle(ChatFormatting.DARK_PURPLE));
	}

	@Override
	public boolean isEnchantable(ItemStack stack) {
		return true;
	}

	@Override
	public int getEnchantmentValue() {
		return 1;
	}

	@Override
	public boolean canEquipFromUse(SlotContext slot, ItemStack stack) {
		return true;
	}

	@Override
	public DropRule getDropRule(SlotContext slot, DamageSource source, int lootingLevel, boolean recentlyHit, ItemStack stack) {
		if ((stack).isEnchanted())
			return DropRule.ALWAYS_KEEP;
		return DropRule.DEFAULT;
	}

	@Override
	public boolean makesPiglinsNeutral(SlotContext slot, ItemStack stack) {
		return (stack.is(ItemTags.create(new ResourceLocation("jewelcraft:is_gold"))));
	}
}
