package net.salju.jewelcraft.enchantment;

import net.salju.jewelcraft.item.AmuletItem;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;

public class AmuletEnchantment extends Enchantment {
	public AmuletEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.WEARABLE, slots);
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return (!(ench instanceof AmuletEnchantment));
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return (stack.getItem() instanceof AmuletItem);
	}

	@Override
	public int getMinCost(int i) {
		return 1 + (i * 10);
	}

	@Override
	public int getMaxCost(int i) {
		return this.getMinCost(i) + 76;
	}
}