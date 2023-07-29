package net.salju.jewelcraft.events;

import top.theillusivec4.curios.api.type.inventory.IDynamicStackHandler;
import top.theillusivec4.curios.api.type.inventory.ICurioStacksHandler;
import top.theillusivec4.curios.api.CuriosApi;

import net.salju.jewelcraft.item.RingItem;
import net.salju.jewelcraft.item.AmuletItem;
import net.salju.jewelcraft.init.JewelryEnchantments;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.event.entity.living.ShieldBlockEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.SugarCaneBlock;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.CactusBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.BambooStalkBlock;
import net.minecraft.world.level.block.BambooSaplingBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;
import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber
public class JewelcraftEvents {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			LivingEntity target = event.getEntity();
			if (target instanceof Player player) {
				ItemStack amulet = getAmulet(player);
				Level world = player.level();
				if (!world.isClientSide) {
					if (amulet != null) {
						if (EnchantmentHelper.getItemEnchantmentLevel(JewelryEnchantments.DEFLECT.get(), amulet) != 0 && event.getSource().getDirectEntity() != null) {
							Entity direct = event.getSource().getDirectEntity();
							if (direct instanceof AbstractArrow arrow && !(player.isBlocking())) {
								if ((arrow.getOwner() instanceof Player && Math.random() <= 0.2) || (!(arrow.getOwner() instanceof Player) && Math.random() <= 0.65)) {
									event.setCanceled(true);
									float x = ((float) Mth.nextDouble(RandomSource.create(), 175, 185));
									float y = ((float) Mth.nextDouble(RandomSource.create(), -8, 8));
									ArrowItem item = (ArrowItem) (Items.ARROW);
									ItemStack stack = new ItemStack(Items.ARROW);
									AbstractArrow newbie = item.createArrow(world, stack, player);
									newbie.shootFromRotation(player, (arrow.getOwner().getXRot() - x), (arrow.getOwner().getYRot() + y), 0.0F, 0.65F * 3.0F, 1.0F);
									newbie.setCritArrow(true);
									arrow.discard();
									world.addFreshEntity(newbie);
								}
							}
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public static void onDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null && event.getSource() != null) {
			LivingEntity target = event.getEntity();
			DamageSource source = event.getSource();
			if (target instanceof Player player && !source.is(DamageTypes.FELL_OUT_OF_WORLD)) {
				if (player.getInventory().contains(new ItemStack(Items.TOTEM_OF_UNDYING))) {
					ItemStack totem = new ItemStack(Items.TOTEM_OF_UNDYING);
					ItemStack amulet = getAmulet(player);
					List<ItemStack> rings = getRings(player);
					boolean task = false;
					if (amulet != null) {
						if (EnchantmentHelper.getItemEnchantmentLevel(JewelryEnchantments.TOTEM.get(), amulet) != 0) {
							player.getInventory().clearOrCountMatchingItems(p -> totem.getItem() == p.getItem(), 1, player.inventoryMenu.getCraftSlots());
							player.setHealth(1.0F);
							player.removeAllEffects();
							player.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 1));
							player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 800, 0));
							player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0));
							player.level().broadcastEntityEvent(player, (byte) 35);
							task = true;
							event.setCanceled(true);
						}
					}
					if (rings.size() > 0) {
						for (ItemStack ring : rings) {
							if (EnchantmentHelper.getItemEnchantmentLevel(JewelryEnchantments.TOTEM.get(), ring) != 0 && (task == false)) {
								player.getInventory().clearOrCountMatchingItems(p -> totem.getItem() == p.getItem(), 1, player.inventoryMenu.getCraftSlots());
								player.setHealth(1.0F);
								player.removeAllEffects();
								player.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 0));
								player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 600, 0));
								player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 0));
								player.level().broadcastEntityEvent(player, (byte) 35);
								task = true;
								event.setCanceled(true);
							}
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public static void onLivingDropXp(LivingExperienceDropEvent event) {
		if (event != null && event.getEntity() != null && event.getAttackingPlayer() != null) {
			Player player = event.getAttackingPlayer();
			int xp = event.getDroppedExperience();
			ItemStack amulet = getAmulet(player);
			if (amulet != null) {
				if (EnchantmentHelper.getItemEnchantmentLevel(JewelryEnchantments.KYANITE.get(), amulet) != 0) {
					event.setDroppedExperience(xp * 5);
				}
			}
		}
	}

	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		if (event != null && event.getEntity() != null && event.getItemStack() != null) {
			Player player = event.getEntity();
			ItemStack book = event.getItemStack();
			ItemStack item = player.getOffhandItem();
			List<ItemStack> rings = getRings(player);
			boolean task = false;
			if (book.getItem() == Items.BOOK && book != item && item.isEnchanted()) {
				if (rings.size() > 0) {
					for (ItemStack ring : rings) {
						if (EnchantmentHelper.getItemEnchantmentLevel(JewelryEnchantments.KYANITE.get(), ring) != 0 && (task == false)) {
							if (player.experienceLevel > 5 || player.getAbilities().instabuild) {
								if (!player.getAbilities().instabuild)
									player.giveExperienceLevels(-5);
								player.playSound(SoundEvents.ENCHANTMENT_TABLE_USE, 1.0F, 1.0F);
								ItemStack newbie = new ItemStack(Items.ENCHANTED_BOOK);
								EnchantmentHelper.setEnchantments(EnchantmentHelper.getEnchantments(item), newbie);
								player.playSound(SoundEvents.ITEM_BREAK, 1.0F, 1.0F);
								player.setItemSlot(EquipmentSlot.OFFHAND, ItemStack.EMPTY);
								ItemHandlerHelper.giveItemToPlayer(player, newbie);
								book.shrink(1);
							} else {
								player.displayClientMessage(Component.translatable("desc.jewelcraft.kyanite_xp"), (true));
							}
							task = true;
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public static void onBlock(ShieldBlockEvent event) {
		if (event != null && event.getEntity() != null && event.getDamageSource().getDirectEntity() != null) {
			LivingEntity target = event.getEntity();
			Entity direct = event.getDamageSource().getDirectEntity();
			if (target instanceof Player player) {
				List<ItemStack> rings = getRings(player);
				boolean task = false;
				if (rings.size() > 0) {
					for (ItemStack ring : rings) {
						if (EnchantmentHelper.getItemEnchantmentLevel(JewelryEnchantments.ZOMBIE.get(), ring) != 0 && (task == false)) {
							if (direct instanceof LivingEntity bob && !(bob instanceof Zombie)) {
								for (Zombie billy : player.level().getEntitiesOfClass(Zombie.class, player.getBoundingBox().inflate(32.0D))) {
									if (bob.isAlive() && !(billy instanceof ZombifiedPiglin)) {
										billy.setTarget(bob);
									}
								}
								task = true;
							}
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public static void onEffect(MobEffectEvent.Applicable event) {
		if (event != null && event.getEntity() != null && event.getEffectInstance() != null) {
			LivingEntity target = event.getEntity();
			MobEffectInstance potion = event.getEffectInstance();
			if (target instanceof Player player) {
				ItemStack amulet = getAmulet(player);
				List<ItemStack> rings = getRings(player);
				boolean task = false;
				if (amulet != null) {
					if (EnchantmentHelper.getItemEnchantmentLevel(JewelryEnchantments.RAINBOW.get(), amulet) != 0) {
						if (potion.getEffect() == MobEffects.POISON) {
							player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, potion.getDuration(), potion.getAmplifier()));
							event.setResult(Result.DENY);
						} else if (potion.getEffect() == MobEffects.MOVEMENT_SLOWDOWN) {
							player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, potion.getDuration(), potion.getAmplifier()));
							event.setResult(Result.DENY);
						} else if (potion.getEffect() == MobEffects.BLINDNESS) {
							player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, potion.getDuration(), potion.getAmplifier()));
							event.setResult(Result.DENY);
						}
					}
					if (EnchantmentHelper.getItemEnchantmentLevel(JewelryEnchantments.SATISFICATION.get(), amulet) != 0) {
						if (potion.getEffect() == MobEffects.HUNGER) {
							event.setResult(Result.DENY);
						}
					}
				}
				if (rings.size() > 0) {
					for (ItemStack ring : rings) {
						if (EnchantmentHelper.getItemEnchantmentLevel(JewelryEnchantments.RAINBOW.get(), ring) != 0 && (task == false)) {
							if (potion.getEffect() == MobEffects.WEAKNESS) {
								player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, potion.getDuration(), potion.getAmplifier()));
								event.setResult(Result.DENY);
							} else if (potion.getEffect() == MobEffects.DIG_SLOWDOWN) {
								player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, potion.getDuration(), potion.getAmplifier()));
								event.setResult(Result.DENY);
							}
							task = true;
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public static void onCrops(BlockEvent.CropGrowEvent.Pre event) {
		if (event != null && event.getState() != null) {
			BlockState crops = event.getState();
			BlockPos pos = event.getPos();
			LevelAccessor world = event.getLevel();
			boolean task = false;
			for (Player player : world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(pos.getX(), pos.getY(), pos.getZ()), 8, 2, 8))) {
				ItemStack amulet = getAmulet(player);
				List<ItemStack> rings = getRings(player);
				if (amulet != null) {
					if (EnchantmentHelper.getItemEnchantmentLevel(JewelryEnchantments.SODALITE.get(), amulet) != 0) {
						if (crops.getBlock() instanceof CactusBlock && world.isEmptyBlock(pos)) {
							world.setBlock(pos, crops, 3);
							world.levelEvent(1505, pos, 0);
						} else if (crops.getBlock() instanceof BushBlock && !(crops.getBlock() instanceof CropBlock)) {
							BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), player.level(), pos, player);
							world.levelEvent(1505, pos, 0);
						}
					}
				}
				if (rings.size() > 0) {
					for (ItemStack ring : rings) {
						if (EnchantmentHelper.getItemEnchantmentLevel(JewelryEnchantments.SODALITE.get(), ring) != 0 && (task == false)) {
							BlockPos upper = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
							task = true;
							if (crops.getBlock() instanceof SugarCaneBlock && world.isEmptyBlock(upper)) {
								world.setBlock(upper, crops, 3);
								world.levelEvent(1505, pos, 0);
							} else if ((crops.getBlock() instanceof CropBlock blok && blok.canSurvive(crops, world, pos)) || (crops.getBlock() instanceof BambooStalkBlock) || (crops.getBlock() instanceof BambooSaplingBlock)) {
								BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), player.level(), pos, player);
								world.levelEvent(1505, pos, 0);
							}
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public static void onTramply(BlockEvent.FarmlandTrampleEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity target = event.getEntity();
			boolean task = false;
			if (target instanceof Player player) {
				ItemStack amulet = getAmulet(player);
				List<ItemStack> rings = getRings(player);
				if (amulet != null) {
					if (EnchantmentHelper.getItemEnchantmentLevel(JewelryEnchantments.SODALITE.get(), amulet) != 0 && (task == false)) {
						task = true;
						event.setCanceled(true);
					}
				}
				if (rings.size() > 0) {
					for (ItemStack ring : rings) {
						if (EnchantmentHelper.getItemEnchantmentLevel(JewelryEnchantments.SODALITE.get(), ring) != 0 && (task == false)) {
							task = true;
							event.setCanceled(true);
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public static void onCritical(CriticalHitEvent event) {
		if (event != null && event.getEntity() != null) {
			Player player = event.getEntity();
			List<ItemStack> rings = getRings(player);
			boolean task = false;
			if (rings.size() > 0) {
				for (ItemStack ring : rings) {
					if (EnchantmentHelper.getItemEnchantmentLevel(JewelryEnchantments.CRITICAL.get(), ring) != 0 && (task == false)) {
						if (Math.random() <= 0.15 && !(event.isVanillaCritical())) {
							event.setResult(Result.ALLOW);
						}
						event.setDamageModifier(event.getDamageModifier() + 0.25F);
						task = true;
					}
				}
			}
		}
	}

	@Nullable
	public static ItemStack getAmulet(final LivingEntity target) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		CuriosApi.getCuriosHelper().getCuriosHandler(target).ifPresent(handler -> {
			ICurioStacksHandler stacks = handler.getCurios().get("charm");
			if (stacks != null) {
				IDynamicStackHandler dyn = stacks.getStacks();
				if (dyn != null) {
					for (int i = 0; i < stacks.getSlots(); i++) {
						if (dyn.getStackInSlot(i) != null && dyn.getStackInSlot(i).getItem() instanceof AmuletItem) {
							stack.add(dyn.getStackInSlot(i));
							break;
						}
					}
				}
			}
		});
		return stack.isEmpty() ? null : stack.get(0);
	}

	@Nullable
	public static List<ItemStack> getRings(final LivingEntity target) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		CuriosApi.getCuriosHelper().getCuriosHandler(target).ifPresent(handler -> {
			ICurioStacksHandler stacks = handler.getCurios().get("ring");
			if (stacks != null) {
				IDynamicStackHandler dyn = stacks.getStacks();
				if (dyn != null) {
					for (int i = 0; i < stacks.getSlots(); i++) {
						if (dyn.getStackInSlot(i) != null && dyn.getStackInSlot(i).getItem() instanceof RingItem) {
							stack.add(dyn.getStackInSlot(i));
						}
					}
				}
			}
		});
		return stack;
	}
}