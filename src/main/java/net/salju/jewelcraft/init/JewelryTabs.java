package net.salju.jewelcraft.init;

import net.salju.jewelcraft.enchantment.*;
import net.salju.jewelcraft.JewelcraftMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

public class JewelryTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JewelcraftMod.MODID);
	public static final RegistryObject<CreativeModeTab> JEWELRY = REGISTRY.register("jewelry",
			() -> CreativeModeTab.builder().title(Component.translatable("itemGroup.jewelry")).icon(() -> new ItemStack(JewelryItems.JEWELRY_BOX.get())).displayItems((parameters, tabData) -> {
				tabData.accept(JewelryItems.GOLDEN_AMULET_AMETHYST.get());
				tabData.accept(JewelryItems.GOLDEN_AMULET_EMERALD.get());
				tabData.accept(JewelryItems.GOLDEN_AMULET_DIAMOND.get());
				tabData.accept(JewelryItems.GOLDEN_AMULET_LAPIS.get());
				tabData.accept(JewelryItems.GOLDEN_AMULET_REDSTONE.get());
				tabData.accept(JewelryItems.GOLDEN_AMULET_QUARTZ.get());
				tabData.accept(JewelryItems.GOLDEN_AMULET_ONYX.get());
				tabData.accept(JewelryItems.GOLDEN_AMULET_SHADOW.get());
				tabData.accept(JewelryItems.GOLDEN_AMULET_ROSE.get());
				tabData.accept(JewelryItems.GOLDEN_RING_AMETHYST.get());
				tabData.accept(JewelryItems.GOLDEN_RING_EMERALD.get());
				tabData.accept(JewelryItems.GOLDEN_RING_DIAMOND.get());
				tabData.accept(JewelryItems.GOLDEN_RING_LAPIS.get());
				tabData.accept(JewelryItems.GOLDEN_RING_REDSTONE.get());
				tabData.accept(JewelryItems.GOLDEN_RING_QUARTZ.get());
				tabData.accept(JewelryItems.GOLDEN_RING_ONYX.get());
				tabData.accept(JewelryItems.GOLDEN_RING_SHADOW.get());
				tabData.accept(JewelryItems.GOLDEN_RING_ROSE.get());
				tabData.accept(JewelryItems.IRON_AMULET_AMETHYST.get());
				tabData.accept(JewelryItems.IRON_AMULET_EMERALD.get());
				tabData.accept(JewelryItems.IRON_AMULET_DIAMOND.get());
				tabData.accept(JewelryItems.IRON_AMULET_LAPIS.get());
				tabData.accept(JewelryItems.IRON_AMULET_REDSTONE.get());
				tabData.accept(JewelryItems.IRON_AMULET_QUARTZ.get());
				tabData.accept(JewelryItems.IRON_AMULET_ONYX.get());
				tabData.accept(JewelryItems.IRON_AMULET_SHADOW.get());
				tabData.accept(JewelryItems.IRON_AMULET_ROSE.get());
				tabData.accept(JewelryItems.IRON_RING_AMETHYST.get());
				tabData.accept(JewelryItems.IRON_RING_EMERALD.get());
				tabData.accept(JewelryItems.IRON_RING_DIAMOND.get());
				tabData.accept(JewelryItems.IRON_RING_LAPIS.get());
				tabData.accept(JewelryItems.IRON_RING_REDSTONE.get());
				tabData.accept(JewelryItems.IRON_RING_QUARTZ.get());
				tabData.accept(JewelryItems.IRON_RING_ONYX.get());
				tabData.accept(JewelryItems.IRON_RING_SHADOW.get());
				tabData.accept(JewelryItems.IRON_RING_ROSE.get());
				tabData.accept(JewelryItems.COPPER_AMULET_AMETHYST.get());
				tabData.accept(JewelryItems.COPPER_AMULET_EMERALD.get());
				tabData.accept(JewelryItems.COPPER_AMULET_DIAMOND.get());
				tabData.accept(JewelryItems.COPPER_AMULET_LAPIS.get());
				tabData.accept(JewelryItems.COPPER_AMULET_REDSTONE.get());
				tabData.accept(JewelryItems.COPPER_AMULET_QUARTZ.get());
				tabData.accept(JewelryItems.COPPER_AMULET_ONYX.get());
				tabData.accept(JewelryItems.COPPER_AMULET_SHADOW.get());
				tabData.accept(JewelryItems.COPPER_AMULET_ROSE.get());
				tabData.accept(JewelryItems.COPPER_RING_AMETHYST.get());
				tabData.accept(JewelryItems.COPPER_RING_EMERALD.get());
				tabData.accept(JewelryItems.COPPER_RING_DIAMOND.get());
				tabData.accept(JewelryItems.COPPER_RING_LAPIS.get());
				tabData.accept(JewelryItems.COPPER_RING_REDSTONE.get());
				tabData.accept(JewelryItems.COPPER_RING_QUARTZ.get());
				tabData.accept(JewelryItems.COPPER_RING_ONYX.get());
				tabData.accept(JewelryItems.COPPER_RING_SHADOW.get());
				tabData.accept(JewelryItems.COPPER_RING_ROSE.get());
				tabData.accept(JewelryItems.JEWELRY_BOX.get());
				for (Enchantment ench : ForgeRegistries.ENCHANTMENTS) {
					if (ench instanceof JewelryEnchantment || ench instanceof AmuletEnchantment || ench instanceof RingEnchantment) {
						tabData.accept(EnchantedBookItem.createForEnchantment(new EnchantmentInstance(ench, ench.getMaxLevel())), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
					}
				}
			}).build());
}
