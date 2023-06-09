package net.salju.jewelcraft.init;

import net.salju.jewelcraft.item.*;
import net.salju.jewelcraft.JewelcraftMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class JewelryItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, JewelcraftMod.MODID);
	public static final RegistryObject<Item> JEWELRY_BOX = REGISTRY.register("jewelry_box", () -> new BoxItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
	public static final RegistryObject<Item> GOLDEN_AMULET_AMETHYST = REGISTRY.register("golden_amulet_amethyst", () -> new AmuletItem());
	public static final RegistryObject<Item> GOLDEN_AMULET_EMERALD = REGISTRY.register("golden_amulet_emerald", () -> new AmuletItem());
	public static final RegistryObject<Item> GOLDEN_AMULET_DIAMOND = REGISTRY.register("golden_amulet_diamond", () -> new AmuletItem());
	public static final RegistryObject<Item> GOLDEN_AMULET_LAPIS = REGISTRY.register("golden_amulet_lapis", () -> new AmuletItem());
	public static final RegistryObject<Item> GOLDEN_AMULET_REDSTONE = REGISTRY.register("golden_amulet_redstone", () -> new AmuletItem());
	public static final RegistryObject<Item> GOLDEN_AMULET_QUARTZ = REGISTRY.register("golden_amulet_quartz", () -> new AmuletItem());
	public static final RegistryObject<Item> GOLDEN_AMULET_ONYX = REGISTRY.register("golden_amulet_onyx", () -> new AmuletItem());
	public static final RegistryObject<Item> GOLDEN_AMULET_SHADOW = REGISTRY.register("golden_amulet_shadow", () -> new AmuletItem());
	public static final RegistryObject<Item> GOLDEN_AMULET_ROSE = REGISTRY.register("golden_amulet_rose", () -> new AmuletItem());
	public static final RegistryObject<Item> GOLDEN_RING_AMETHYST = REGISTRY.register("golden_ring_amethyst", () -> new RingItem());
	public static final RegistryObject<Item> GOLDEN_RING_EMERALD = REGISTRY.register("golden_ring_emerald", () -> new RingItem());
	public static final RegistryObject<Item> GOLDEN_RING_DIAMOND = REGISTRY.register("golden_ring_diamond", () -> new RingItem());
	public static final RegistryObject<Item> GOLDEN_RING_LAPIS = REGISTRY.register("golden_ring_lapis", () -> new RingItem());
	public static final RegistryObject<Item> GOLDEN_RING_REDSTONE = REGISTRY.register("golden_ring_redstone", () -> new RingItem());
	public static final RegistryObject<Item> GOLDEN_RING_QUARTZ = REGISTRY.register("golden_ring_quartz", () -> new RingItem());
	public static final RegistryObject<Item> GOLDEN_RING_ONYX = REGISTRY.register("golden_ring_onyx", () -> new RingItem());
	public static final RegistryObject<Item> GOLDEN_RING_SHADOW = REGISTRY.register("golden_ring_shadow", () -> new RingItem());
	public static final RegistryObject<Item> GOLDEN_RING_ROSE = REGISTRY.register("golden_ring_rose", () -> new RingItem());
	public static final RegistryObject<Item> IRON_AMULET_AMETHYST = REGISTRY.register("iron_amulet_amethyst", () -> new AmuletItem());
	public static final RegistryObject<Item> IRON_AMULET_EMERALD = REGISTRY.register("iron_amulet_emerald", () -> new AmuletItem());
	public static final RegistryObject<Item> IRON_AMULET_DIAMOND = REGISTRY.register("iron_amulet_diamond", () -> new AmuletItem());
	public static final RegistryObject<Item> IRON_AMULET_LAPIS = REGISTRY.register("iron_amulet_lapis", () -> new AmuletItem());
	public static final RegistryObject<Item> IRON_AMULET_REDSTONE = REGISTRY.register("iron_amulet_redstone", () -> new AmuletItem());
	public static final RegistryObject<Item> IRON_AMULET_QUARTZ = REGISTRY.register("iron_amulet_quartz", () -> new AmuletItem());
	public static final RegistryObject<Item> IRON_AMULET_ONYX = REGISTRY.register("iron_amulet_onyx", () -> new AmuletItem());
	public static final RegistryObject<Item> IRON_AMULET_SHADOW = REGISTRY.register("iron_amulet_shadow", () -> new AmuletItem());
	public static final RegistryObject<Item> IRON_AMULET_ROSE = REGISTRY.register("iron_amulet_rose", () -> new AmuletItem());
	public static final RegistryObject<Item> IRON_RING_AMETHYST = REGISTRY.register("iron_ring_amethyst", () -> new RingItem());
	public static final RegistryObject<Item> IRON_RING_EMERALD = REGISTRY.register("iron_ring_emerald", () -> new RingItem());
	public static final RegistryObject<Item> IRON_RING_DIAMOND = REGISTRY.register("iron_ring_diamond", () -> new RingItem());
	public static final RegistryObject<Item> IRON_RING_LAPIS = REGISTRY.register("iron_ring_lapis", () -> new RingItem());
	public static final RegistryObject<Item> IRON_RING_REDSTONE = REGISTRY.register("iron_ring_redstone", () -> new RingItem());
	public static final RegistryObject<Item> IRON_RING_QUARTZ = REGISTRY.register("iron_ring_quartz", () -> new RingItem());
	public static final RegistryObject<Item> IRON_RING_ONYX = REGISTRY.register("iron_ring_onyx", () -> new RingItem());
	public static final RegistryObject<Item> IRON_RING_SHADOW = REGISTRY.register("iron_ring_shadow", () -> new RingItem());
	public static final RegistryObject<Item> IRON_RING_ROSE = REGISTRY.register("iron_ring_rose", () -> new RingItem());
	public static final RegistryObject<Item> COPPER_AMULET_AMETHYST = REGISTRY.register("copper_amulet_amethyst", () -> new AmuletItem());
	public static final RegistryObject<Item> COPPER_AMULET_EMERALD = REGISTRY.register("copper_amulet_emerald", () -> new AmuletItem());
	public static final RegistryObject<Item> COPPER_AMULET_DIAMOND = REGISTRY.register("copper_amulet_diamond", () -> new AmuletItem());
	public static final RegistryObject<Item> COPPER_AMULET_LAPIS = REGISTRY.register("copper_amulet_lapis", () -> new AmuletItem());
	public static final RegistryObject<Item> COPPER_AMULET_REDSTONE = REGISTRY.register("copper_amulet_redstone", () -> new AmuletItem());
	public static final RegistryObject<Item> COPPER_AMULET_QUARTZ = REGISTRY.register("copper_amulet_quartz", () -> new AmuletItem());
	public static final RegistryObject<Item> COPPER_AMULET_ONYX = REGISTRY.register("copper_amulet_onyx", () -> new AmuletItem());
	public static final RegistryObject<Item> COPPER_AMULET_SHADOW = REGISTRY.register("copper_amulet_shadow", () -> new AmuletItem());
	public static final RegistryObject<Item> COPPER_AMULET_ROSE = REGISTRY.register("copper_amulet_rose", () -> new AmuletItem());
	public static final RegistryObject<Item> COPPER_RING_AMETHYST = REGISTRY.register("copper_ring_amethyst", () -> new RingItem());
	public static final RegistryObject<Item> COPPER_RING_EMERALD = REGISTRY.register("copper_ring_emerald", () -> new RingItem());
	public static final RegistryObject<Item> COPPER_RING_DIAMOND = REGISTRY.register("copper_ring_diamond", () -> new RingItem());
	public static final RegistryObject<Item> COPPER_RING_LAPIS = REGISTRY.register("copper_ring_lapis", () -> new RingItem());
	public static final RegistryObject<Item> COPPER_RING_REDSTONE = REGISTRY.register("copper_ring_redstone", () -> new RingItem());
	public static final RegistryObject<Item> COPPER_RING_QUARTZ = REGISTRY.register("copper_ring_quartz", () -> new RingItem());
	public static final RegistryObject<Item> COPPER_RING_ONYX = REGISTRY.register("copper_ring_onyx", () -> new RingItem());
	public static final RegistryObject<Item> COPPER_RING_SHADOW = REGISTRY.register("copper_ring_shadow", () -> new RingItem());
	public static final RegistryObject<Item> COPPER_RING_ROSE = REGISTRY.register("copper_ring_rose", () -> new RingItem());
}