package com.infinitychances.inflib.mixin;

import com.infinitychances.inflib.events.BreedAnimalCallback;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Mixin(AnimalEntity.class)
public abstract class BreedAnimalMixin {

    @Inject(method = "breed(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/passive/AnimalEntity;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/passive/AnimalEntity;breed(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/passive/AnimalEntity;Lnet/minecraft/entity/passive/PassiveEntity;)V"),
    cancellable = true)
    private void onBreed(final ServerWorld world, final AnimalEntity other, final CallbackInfo ci, final @Local PassiveEntity baby) {
        AnimalEntity inst = (AnimalEntity) (Object) this;
        ServerPlayerEntity player = Optional.ofNullable(inst.getLovingPlayer()).or(() ->
                Optional.ofNullable(other.getLovingPlayer())).orElse((ServerPlayerEntity) world.getClosestPlayer(inst, 10));
        ActionResult result = BreedAnimalCallback.EVENT.invoker().interact(player,inst, other, baby, inst.getType());

        if(result == ActionResult.FAIL) {
            ci.cancel();
        }
    }
}
