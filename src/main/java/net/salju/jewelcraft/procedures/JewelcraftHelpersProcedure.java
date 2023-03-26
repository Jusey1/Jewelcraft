package net.salju.jewelcraft.procedures;

import net.salju.jewelcraft.init.JewelryItems;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraft.world.level.storage.loot.functions.SetNameFunction;
import net.minecraft.world.level.storage.loot.functions.SetEnchantmentsFunction;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;
import java.util.List;
import java.util.ArrayList;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import com.google.common.collect.ImmutableMap;

public class JewelcraftHelpersProcedure {
	public static final Int2ObjectMap<VillagerTrades.ItemListing[]> JEWELRY_TRADES = toIntMap(ImmutableMap.of(1,
			new VillagerTrades.ItemListing[]{new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.GOLDEN_AMULET_AMETHYST.get())), new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.GOLDEN_AMULET_EMERALD.get())),
					new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.GOLDEN_AMULET_DIAMOND.get())), new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.GOLDEN_AMULET_LAPIS.get())),
					new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.GOLDEN_AMULET_REDSTONE.get())), new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.GOLDEN_AMULET_QUARTZ.get())),
					new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.GOLDEN_AMULET_ONYX.get())), new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.GOLDEN_AMULET_SHADOW.get())),
					new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.GOLDEN_AMULET_ROSE.get())), new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.GOLDEN_RING_AMETHYST.get())),
					new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.GOLDEN_RING_EMERALD.get())), new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.GOLDEN_RING_DIAMOND.get())),
					new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.GOLDEN_RING_LAPIS.get())), new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.GOLDEN_RING_REDSTONE.get())),
					new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.GOLDEN_RING_QUARTZ.get())), new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.GOLDEN_RING_ONYX.get())),
					new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.GOLDEN_RING_SHADOW.get())), new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.GOLDEN_RING_ROSE.get())),
					new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.IRON_AMULET_AMETHYST.get())), new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.IRON_AMULET_EMERALD.get())),
					new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.IRON_AMULET_DIAMOND.get())), new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.IRON_AMULET_LAPIS.get())),
					new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.IRON_AMULET_REDSTONE.get())), new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.IRON_AMULET_QUARTZ.get())),
					new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.IRON_AMULET_ONYX.get())), new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.IRON_AMULET_SHADOW.get())),
					new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.IRON_AMULET_ROSE.get())), new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.IRON_RING_AMETHYST.get())),
					new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.IRON_RING_EMERALD.get())), new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.IRON_RING_DIAMOND.get())),
					new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.IRON_RING_LAPIS.get())), new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.IRON_RING_REDSTONE.get())),
					new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.IRON_RING_QUARTZ.get())), new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.IRON_RING_ONYX.get())),
					new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.IRON_RING_SHADOW.get())), new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.IRON_RING_ROSE.get())),
					new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.COPPER_AMULET_AMETHYST.get())), new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.COPPER_AMULET_EMERALD.get())),
					new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.COPPER_AMULET_DIAMOND.get())), new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.COPPER_AMULET_LAPIS.get())),
					new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.COPPER_AMULET_REDSTONE.get())), new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.COPPER_AMULET_QUARTZ.get())),
					new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.COPPER_AMULET_ONYX.get())), new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.COPPER_AMULET_SHADOW.get())),
					new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.COPPER_AMULET_ROSE.get())), new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.COPPER_RING_AMETHYST.get())),
					new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.COPPER_RING_EMERALD.get())), new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.COPPER_RING_DIAMOND.get())),
					new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.COPPER_RING_LAPIS.get())), new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.COPPER_RING_REDSTONE.get())),
					new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.COPPER_RING_QUARTZ.get())), new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.COPPER_RING_ONYX.get())),
					new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.COPPER_RING_SHADOW.get())), new JewelcraftHelpersProcedure.JewelryTrade(new ItemStack(JewelryItems.COPPER_RING_ROSE.get()))}));

	private static Int2ObjectMap<VillagerTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ItemListing[]> stuffs) {
		return new Int2ObjectOpenHashMap<>(stuffs);
	}

	public static LootPoolSingletonContainer.Builder<?> getUnique(Item gem, @Nullable String name, Enchantment one, @Nullable Enchantment two) {
		LootPoolSingletonContainer.Builder<?> stack = LootItem.lootTableItem(gem);
		stack.setWeight(7);
		if (name != null)
			stack.apply(SetNameFunction.setName(Component.translatable(name)));
		stack.apply(JewelcraftHelpersProcedure.enchantItem().withEnchantment(one, UniformGenerator.between(1.0F, 1.0F)));
		if (two != null)
			stack.apply(JewelcraftHelpersProcedure.enchantItem().withEnchantment(two, UniformGenerator.between(1.0F, 1.0F)));
		return stack;
	}

	public static SetEnchantmentsFunction.Builder enchantItem() {
		return new SetEnchantmentsFunction.Builder();
	}

	public static LootPool setUnique(String name, float low, float max, @Nullable LootPoolEntryContainer.Builder<?>... targets) {
		LootPool.Builder newbie = LootPool.lootPool();
		newbie.name(name);
		newbie.setRolls(UniformGenerator.between(low, max));
		for (LootPoolEntryContainer.Builder<?> target : targets) {
			if (target != null) {
				newbie.add(target);
			}
		}
		LootPool done = newbie.build();
		return done;
	}

	public static List<ResourceLocation> getVillages() {
		List<ResourceLocation> village = new ArrayList<ResourceLocation>();
		village.add(BuiltInLootTables.VILLAGE_TOOLSMITH);
		village.add(BuiltInLootTables.VILLAGE_CARTOGRAPHER);
		village.add(BuiltInLootTables.VILLAGE_TEMPLE);
		village.add(BuiltInLootTables.VILLAGE_DESERT_HOUSE);
		village.add(BuiltInLootTables.VILLAGE_PLAINS_HOUSE);
		village.add(BuiltInLootTables.VILLAGE_TAIGA_HOUSE);
		village.add(BuiltInLootTables.VILLAGE_SNOWY_HOUSE);
		village.add(BuiltInLootTables.VILLAGE_SAVANNA_HOUSE);
		return village;
	}

	public static void useBox(Level world, Player player) {
		double x = player.getX();
		double y = player.getY();
		double z = player.getZ();
		if (world instanceof ServerLevel lvl) {
			lvl.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, lvl, 4, "", Component.literal(""), lvl.getServer(), null).withSuppressedOutput(),
					"/loot give @p loot jewelcraft:gameplay/jewelry_loot");
		}
	}

	static class JewelryTrade implements VillagerTrades.ItemListing {
		private final ItemStack jewelry;
		private final int emeraldCost;
		private final ItemStack newbox;
		private final int maxUses;
		private final int villagerXp;
		private final float priceMultiplier;

		public JewelryTrade(ItemStack gem) {
			this(gem, Mth.nextInt(RandomSource.create(), 6, 12), new ItemStack(JewelryItems.JEWELRY_BOX.get()), Mth.nextInt(RandomSource.create(), 2, 8), 5);
		}

		public JewelryTrade(ItemStack gem, int cost, ItemStack box, int max, int xp) {
			this.jewelry = gem;
			this.emeraldCost = cost;
			this.newbox = box;
			this.maxUses = max;
			this.villagerXp = xp;
			this.priceMultiplier = 0.05F;
		}

		@Nullable
		public MerchantOffer getOffer(Entity target, RandomSource randy) {
			return new MerchantOffer(new ItemStack(Items.EMERALD, this.emeraldCost), new ItemStack(this.jewelry.getItem()), new ItemStack(this.newbox.getItem()), this.maxUses, this.villagerXp, this.priceMultiplier);
		}
	}
}