package net.salju.jewelcraft.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.CreativeModeTabEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JewelryTabs {
	@SubscribeEvent
	public static void buildTabContentsModded(CreativeModeTabEvent.Register event) {
		event.registerCreativeModeTab(new ResourceLocation("jewelcraft_tab"),
				builder -> builder.title(Component.translatable("itemGroup.jewelcraft_tab")).icon(() -> new ItemStack(JewelryItems.JEWELRY_BOX.get())).displayItems((parameters, tabData) -> {
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
				}));
	}
}
