package com.infinitychances.inflib.mixin;

import com.infinitychances.inflib.events.CowMilkCallback;
import net.minecraft.entity.passive.AbstractCowEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractCowEntity.class)
public class CowMilkMixin {

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;playSound(Lnet/minecraft/sound/SoundEvent;FF)V"), method = "interactMob", cancellable = true)
    private void onMilk(final PlayerEntity player, final Hand hand, final CallbackInfoReturnable<Boolean> info) {
        ActionResult result = CowMilkCallback.EVENT.invoker().interact(player, (AbstractCowEntity) (Object) this);

        if (result == ActionResult.FAIL) {
            info.cancel();
        }
    }
}
