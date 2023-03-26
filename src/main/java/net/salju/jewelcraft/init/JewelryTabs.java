package net.salju.jewelcraft.init;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class JewelryTabs {
	public static CreativeModeTab JEWELCRAFT_TAB;

	public static void load() {
		JEWELCRAFT_TAB = new CreativeModeTab("jewelcraft_tab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(Items.DIAMOND);
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}