package net.salju.jewelcraft.item;

import top.theillusivec4.curios.api.SlotContext;
import net.salju.jewelcraft.init.JewelryConfig;
import net.salju.jewelcraft.init.JewelryEnchantments;
import net.salju.jewelcraft.events.JewelcraftHelpers;
import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;

import java.util.UUID;
import java.util.List;
import com.google.common.collect.Multimap;
import com.google.common.collect.HashMultimap;

public class AmuletItem extends JewelryItem {
	public AmuletItem(int value) {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON), value);
	}

	@Override
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slot, UUID id, ItemStack stack) {
		LivingEntity target = slot.entity();
		Multimap<Attribute, AttributeModifier> stats = HashMultimap.create();
		if (isCopper(stack))
			stats.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.fromString("929c9214-b9f9-11ed-afa1-0242ac120002"), "S-KB-A", JewelryConfig.COPPER.get(), AttributeModifier.Operation.ADDITION));
		if (isIron(stack))
			stats.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(UUID.fromString("5a1035e8-b7f8-11ed-afa1-0242ac120002"), "S-Armor-A", JewelryConfig.IRON.get(), AttributeModifier.Operation.ADDITION));
		if (JewelcraftHelpers.hasEnchantment(JewelryEnchantments.HELIODOR.get(), stack))
			stats.put(Attributes.LUCK, new AttributeModifier(UUID.fromString("1f7c25ec-b9f9-11ed-afa1-0242ac120002"), "S-Luck-A", JewelryConfig.LUCK.get(), AttributeModifier.Operation.ADDITION));
		if (JewelcraftHelpers.hasEnchantment(JewelryEnchantments.AQUAMARINE.get(), stack))
			stats.put(ForgeMod.SWIM_SPEED.get(), new AttributeModifier(UUID.fromString("f7be8916-b85c-11ed-afa1-0242ac120002"), "S-Swim-A", ((float) JewelryConfig.SWMSPD.get() / 100), AttributeModifier.Operation.MULTIPLY_TOTAL));
		if (JewelcraftHelpers.hasEnchantment(JewelryEnchantments.ALEXANDRITE.get(), stack)) {
			stats.put(ForgeMod.STEP_HEIGHT_ADDITION.get(), new AttributeModifier(UUID.fromString("1fbdd7e8-ba09-11ed-afa1-0242ac120002"), "S-StepUp-A", JewelryConfig.STEP.get(), AttributeModifier.Operation.ADDITION));
			stats.put(ForgeMod.BLOCK_REACH.get(), new AttributeModifier(UUID.fromString("19260e62-b85d-11ed-afa1-0242ac120002"), "S-Reach-A", JewelryConfig.REACH.get(), AttributeModifier.Operation.ADDITION));
		}
		return stats;
	}

	@Override
	public void curioTick(SlotContext slot, ItemStack stack) {
		LivingEntity target = slot.entity();
		double x = target.getX();
		double y = target.getY() + 0.75;
		double z = target.getZ();
		if (target instanceof ServerPlayer player) {
			if (JewelcraftHelpers.hasEnchantment(JewelryEnchantments.MAGNETIC.get(), stack) && target.isShiftKeyDown()) {
				List<ItemEntity> items = target.level().getEntitiesOfClass(ItemEntity.class, target.getBoundingBox().inflate(JewelryConfig.MAGN.get()));
				for (ItemEntity item : items)
					if (canPullItem(item)) {
						if (!canPickStack((Player) target, item.getItem())) {
							continue;
						}
						item.setNoPickUpDelay();
						item.teleportTo(x, y, z);
					}
			}
			if (JewelcraftHelpers.hasEnchantment(JewelryEnchantments.SATISFICATION.get(), stack)) {
				if (player.getFoodData().getFoodLevel() < JewelryConfig.FOOD.get()) {
					player.getFoodData().setFoodLevel(JewelryConfig.FOOD.get());
				}
			}
			if (JewelcraftHelpers.hasEnchantment(JewelryEnchantments.AQUAMARINE.get(), stack)) {
				if (target.isEyeInFluid(FluidTags.WATER)) {
					if (target.getAirSupply() < 300) {
						target.setAirSupply(target.getAirSupply() + 1);
					} else {
						target.setAirSupply(300);
					}
				}
			}
			if (JewelcraftHelpers.hasEnchantment(JewelryEnchantments.ZILLYAURA.get(), stack)) {
				for (LivingEntity aura : target.level().getEntitiesOfClass(LivingEntity.class, target.getBoundingBox().inflate(7.0D))) {
					if (aura instanceof Animal || aura instanceof Villager) {
						if (aura != target && !(aura.hasEffect(MobEffects.REGENERATION)) && (aura.getHealth() < aura.getMaxHealth())) {
							aura.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1));
						}
					}
				}
			}
		}
	}

	@Override
	public int getLootingLevel(SlotContext slot, DamageSource source, LivingEntity target, int loot, ItemStack stack) {
		return (JewelcraftHelpers.hasEnchantment(JewelryEnchantments.HELIODOR.get(), stack) ? super.getLootingLevel(slot, source, target, loot, stack) + JewelryConfig.LOOT.get() : super.getLootingLevel(slot, source, target, loot, stack));
	}

	private boolean canPullItem(ItemEntity item) {
		ItemStack stack = item.getItem();
		return (item.isAlive() && !stack.isEmpty());
	}

	private boolean canPickStack(Player target, ItemStack stack) {
		return target.getInventory().getFreeSlot() >= 0;
	}
}