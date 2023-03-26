package net.salju.jewelcraft.item;

import net.salju.jewelcraft.procedures.JewelcraftHelpersProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;

import java.util.List;

public class BoxItem extends Item {
	public BoxItem(Item.Properties props) {
		super(props);
	}

	@Override
	public void appendHoverText(ItemStack stack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(stack, world, list, flag);
		list.add(Component.translatable("desc.jewelcraft.box").withStyle(ChatFormatting.BLUE));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, player, hand);
		ItemStack stack = ar.getObject();
		player.swing(hand, true);
		player.playSound(SoundEvents.ITEM_PICKUP);
		JewelcraftHelpersProcedure.useBox(world, player);
		if (!player.getAbilities().instabuild)
			stack.shrink(1);
		return ar;
	}
}