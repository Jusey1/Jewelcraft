package net.salju.jewelcraft.procedures;

import net.salju.jewelcraft.init.JewelryItems;
import net.salju.jewelcraft.init.JewelryEnchantments;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.LootTableLoadEvent;

import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.item.Items;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JewelcraftLootEventProcedure {
	@SubscribeEvent
	public void onLoot(LootTableLoadEvent event) {
		if (event.getName().equals(BuiltInLootTables.SHIPWRECK_TREASURE)) {
			LootTable table = event.getTable();
			LootPool unique = JewelcraftHelpersProcedure.setUnique("captain_loot", -2.0F, 1.0F,
					JewelcraftHelpersProcedure.getUnique(JewelryItems.IRON_AMULET_REDSTONE.get(), "item.jewelcraft.captain_amulet", JewelryEnchantments.AQUAMARINE.get(), JewelryEnchantments.MAGNETIC.get()),
					JewelcraftHelpersProcedure.getUnique(JewelryItems.GOLDEN_RING_REDSTONE.get(), "item.jewelcraft.captain_ring", JewelryEnchantments.CRITICAL.get(), JewelryEnchantments.HELIODOR.get()),
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.AQUAMARINE.get(), null));
			table.addPool(unique);
			event.setTable(table);
		} else if (event.getName().equals(BuiltInLootTables.JUNGLE_TEMPLE)) {
			LootTable table = event.getTable();
			LootPool unique = JewelcraftHelpersProcedure.setUnique("jungle_loot", -2.0F, 1.0F,
					JewelcraftHelpersProcedure.getUnique(JewelryItems.COPPER_RING_ROSE.get(), "item.jewelcraft.sacrifice_ring", JewelryEnchantments.BLOODY.get(), JewelryEnchantments.ZOMBIE.get()),
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.BLOODY.get(), null),
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.ZOMBIE.get(), null),
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.ALEXANDRITE.get(), null));
			table.addPool(unique);
			event.setTable(table);
		} else if (event.getName().equals(BuiltInLootTables.BURIED_TREASURE)) {
			LootTable table = event.getTable();
			LootPool unique = JewelcraftHelpersProcedure.setUnique("treasure_loot", 0.65F, 1.0F,
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.CRITICAL.get(), null),
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.INFUSED.get(), null),
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.HELIODOR.get(), null));
			table.addPool(unique);
			event.setTable(table);
		} else if (event.getName().equals(BuiltInLootTables.WOODLAND_MANSION)) {
			LootTable table = event.getTable();
			LootPool unique = JewelcraftHelpersProcedure.setUnique("mansion_loot", -3.0F, 1.0F,
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.RAINBOW.get(), null),
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.SODALITE.get(), null),
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.DEFLECT.get(), null),
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.TOTEM.get(), null));
			table.addPool(unique);
			event.setTable(table);
		} else if (event.getName().equals(BuiltInLootTables.ABANDONED_MINESHAFT)) {
			LootTable table = event.getTable();
			LootPool unique = JewelcraftHelpersProcedure.setUnique("mineshaft_loot", -3.0F, 1.0F,
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.MAGNETIC.get(), null),
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.SODALITE.get(), null));
			table.addPool(unique);
			event.setTable(table);
		} else if (event.getName().equals(BuiltInLootTables.DESERT_PYRAMID)) {
			LootTable table = event.getTable();
			LootPool unique = JewelcraftHelpersProcedure.setUnique("desert_loot", -2.0F, 1.0F,
					JewelcraftHelpersProcedure.getUnique(JewelryItems.COPPER_AMULET_AMETHYST.get(), "item.jewelcraft.desert_amulet", JewelryEnchantments.SATISFICATION.get(), JewelryEnchantments.MAGNETIC.get()),
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.SATISFICATION.get(), null),
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.MAGNETIC.get(), null),
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.ALEXANDRITE.get(), null));
			table.addPool(unique);
			event.setTable(table);
		} else if (event.getName().equals(BuiltInLootTables.STRONGHOLD_LIBRARY)) {
			LootTable table = event.getTable();
			LootPool unique = JewelcraftHelpersProcedure.setUnique("stronghold_loot", -3.0F, 1.0F,
					JewelcraftHelpersProcedure.getUnique(JewelryItems.IRON_RING_LAPIS.get(), "item.jewelcraft.kyan_ring", JewelryEnchantments.KYANITE.get(), null),
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.SATISFICATION.get(), null),
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.BLOODY.get(), null),
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.ZOMBIE.get(), null),
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.RAINBOW.get(), null),
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.SODALITE.get(), null),
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.DEFLECT.get(), null),
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.AQUAMARINE.get(), null),
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.MAGNETIC.get(), null),
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.ALEXANDRITE.get(), null),
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.CRITICAL.get(), null),
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.INFUSED.get(), null),
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.HELIODOR.get(), null),
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.KYANITE.get(), null),
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.TOTEM.get(), null));
			table.addPool(unique);
			event.setTable(table);
		} else if (event.getName().equals(BuiltInLootTables.FISHING_TREASURE)) {
			LootTable table = event.getTable();
			LootPool unique = JewelcraftHelpersProcedure.setUnique("fish_loot", -24.0F, 0.45F,
					JewelcraftHelpersProcedure.getUnique(JewelryItems.GOLDEN_RING_ONYX.get(), "item.jewelcraft.fisher_ring", JewelryEnchantments.CRITICAL.get(), JewelryEnchantments.INFUSED.get()));
			table.addPool(unique);
			event.setTable(table);
		} else if (event.getName().equals(BuiltInLootTables.PILLAGER_OUTPOST)) {
			LootTable table = event.getTable();
			LootPool unique = JewelcraftHelpersProcedure.setUnique("pillager_loot", -4.0F, 1.0F,
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.MAGNETIC.get(), null),
					JewelcraftHelpersProcedure.getUnique(Items.BOOK, null, JewelryEnchantments.RAINBOW.get(), null));
			table.addPool(unique);
			event.setTable(table);
		} else if (event.getName().equals(BuiltInLootTables.SPAWN_BONUS_CHEST)) {
			LootTable table = event.getTable();
			LootPool unique = JewelcraftHelpersProcedure.setUnique("spawnbonus_loot", 1.0F, 1.0F,
					JewelcraftHelpersProcedure.getUnique(JewelryItems.IRON_AMULET_EMERALD.get(), "item.jewelcraft.bonus_amulet", JewelryEnchantments.SATISFICATION.get(), null));
			table.addPool(unique);
			event.setTable(table);
		} else if (JewelcraftHelpersProcedure.getVillages().contains(event.getName())) {
			LootTable table = event.getTable();
			LootPool unique = JewelcraftHelpersProcedure.setUnique("villager_loot", -4.0F, 1.0F,
					JewelcraftHelpersProcedure.getUnique(JewelryItems.GOLDEN_AMULET_EMERALD.get(), "item.jewelcraft.villager_amulet", JewelryEnchantments.ZILLYAURA.get(), JewelryEnchantments.SODALITE.get()));
			table.addPool(unique);
			event.setTable(table);
		}
	}
}