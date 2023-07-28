package net.salju.jewelcraft.enchantment;

import net.salju.jewelcraft.item.JewelryItem;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;

public class JewelryEnchantment extends Enchantment {
	public JewelryEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.WEARABLE, slots);
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return (!(ench instanceof JewelryEnchantment));
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return (stack.getItem() instanceof JewelryItem);
	}

	@Override
	public int getMinCost(int i) {
		return 1;
	}

	@Override
	public int getMaxCost(int i) {
		return this.getMinCost(i) + 76;
	}
}