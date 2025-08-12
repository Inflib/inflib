package com.infinitychances.inflib.mixin;

import com.infinitychances.inflib.events.BreedFrogCallback;
import com.infinitychances.inflib.events.BreedSnifferCallback;
import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.FrogEntity;
import net.minecraft.entity.passive.SnifferEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Mixin(SnifferEntity.class)
public class BreedSnifferMixin {


    @Inject(method = "breed",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/passive/SnifferEntity;breed(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/passive/AnimalEntity;Lnet/minecraft/entity/passive/PassiveEntity;)V"),
    cancellable = true)
    private void onBreed(final ServerWorld world, final AnimalEntity other, final CallbackInfo ci, @Local LocalRef<ItemEntity> itemEntity) {
        var inst = (SnifferEntity) (Object) this;
        var player = Optional.ofNullable(inst.getLovingPlayer()).or(() -> Optional.ofNullable(other.getLovingPlayer())).orElse((ServerPlayerEntity) world.getClosestPlayer(inst, 10));
        ActionResult result = BreedSnifferCallback.EVENT.invoker().interact(player,inst, (SnifferEntity) other, itemEntity.get());

        if(result == ActionResult.FAIL) {
            ci.cancel();
        }
    }
}
