package net.salju.jewelcraft;

import net.salju.jewelcraft.events.*;
import net.salju.jewelcraft.init.*;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.common.MinecraftForge;

@Mod("jewelcraft")
public class JewelcraftMod {
	public static final String MODID = "jewelcraft";

	public JewelcraftMod() {
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new JewelcraftLoot());
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		JewelryItems.REGISTRY.register(bus);
		JewelryEnchantments.REGISTRY.register(bus);
		JewelryTabs.REGISTRY.register(bus);
	}
}