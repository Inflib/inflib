package com.infinitychances.inflib.mixin;

import com.infinitychances.inflib.InfLib;
import com.infinitychances.inflib.events.EnterBoatCallback;
import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.AbstractBoatEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBoatEntity.class)
public abstract class EnterBoatMixin {

    @Inject(method = "interact", at = @At(value = "RETURN"), cancellable = true)
    private void injected(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        AbstractBoatEntity newThis = (AbstractBoatEntity)(Object)this;
        ActionResult result = ActionResult.FAIL;
        if(cir.getReturnValue() == ActionResult.SUCCESS) {
             result = EnterBoatCallback.EVENT.invoker().interact(player, hand, newThis);
        }
        if(result == ActionResult.FAIL) {
            cir.cancel();
        }
    }

}
