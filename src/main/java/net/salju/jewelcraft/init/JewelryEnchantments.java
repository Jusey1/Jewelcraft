package net.salju.jewelcraft.init;

import net.salju.jewelcraft.enchantment.*;
import net.salju.jewelcraft.JewelcraftMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

public class JewelryEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, JewelcraftMod.MODID);
	public static final RegistryObject<Enchantment> MAGNETIC = REGISTRY.register("magnetic", () -> new AmuletEnchantment());
	public static final RegistryObject<Enchantment> DEFLECT = REGISTRY.register("deflect", () -> new AmuletEnchantment());
	public static final RegistryObject<Enchantment> SATISFICATION = REGISTRY.register("satisfication", () -> new AmuletEnchantment());
	public static final RegistryObject<Enchantment> AQUAMARINE = REGISTRY.register("aquamarine", () -> new AmuletEnchantment());
	public static final RegistryObject<Enchantment> ZILLYAURA = REGISTRY.register("healing_aura", () -> new AmuletEnchantment());
	public static final RegistryObject<Enchantment> BLOODY = REGISTRY.register("bloody", () -> new RingEnchantment());
	public static final RegistryObject<Enchantment> INFUSED = REGISTRY.register("infused", () -> new RingEnchantment());
	public static final RegistryObject<Enchantment> ZOMBIE = REGISTRY.register("zombie", () -> new RingEnchantment());
	public static final RegistryObject<Enchantment> CRITICAL = REGISTRY.register("critical", () -> new RingEnchantment());
	public static final RegistryObject<Enchantment> SODALITE = REGISTRY.register("sodalite", () -> new JewelryEnchantment());
	public static final RegistryObject<Enchantment> HELIODOR = REGISTRY.register("heliodor", () -> new JewelryEnchantment());
	public static final RegistryObject<Enchantment> ALEXANDRITE = REGISTRY.register("alexandrite", () -> new JewelryEnchantment());
	public static final RegistryObject<Enchantment> RAINBOW = REGISTRY.register("rainbow", () -> new JewelryEnchantment());
	public static final RegistryObject<Enchantment> TOTEM = REGISTRY.register("totem", () -> new JewelryEnchantment());
	public static final RegistryObject<Enchantment> KYANITE = REGISTRY.register("kyanite", () -> new JewelryEnchantment());
}