package net.salju.jewelcraft.mixins;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;

import net.salju.jewelcraft.procedures.JewelcraftHelpersProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.EntityType;

@Mixin(WanderingTrader.class)
public abstract class WanderingTraderMixin extends AbstractVillager {
	public WanderingTraderMixin(EntityType<? extends WanderingTrader> type, Level world) {
		super(type, world);
	}

	@Inject(method = {"updateTrades"}, at = {@At("RETURN")})
	protected void updateTrades(CallbackInfo info) {
		VillagerTrades.ItemListing[] avillagertrades$itemlisting2 = JewelcraftHelpersProcedure.JEWELRY_TRADES.get(1);
		if (avillagertrades$itemlisting2 != null) {
			MerchantOffers merchantoffers = this.getOffers();
			this.addOffersFromItemListings(merchantoffers, avillagertrades$itemlisting2, 1);
		}
	}
}