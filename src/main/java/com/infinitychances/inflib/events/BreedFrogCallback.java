package com.infinitychances.inflib.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.FrogEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;

public interface BreedFrogCallback {

    Event<BreedFrogCallback> EVENT = EventFactory.createArrayBacked(BreedFrogCallback.class,
            (listeners) -> (player, frog, other) -> {
                for (BreedFrogCallback listener : listeners) {
                    ActionResult result = listener.interact(player, frog, other);

                    if (result != ActionResult.PASS) {
                        return result;
                    }
                }

                return ActionResult.PASS;
            });

    /**
     * Callback for breeding frogs.
     * Called before basic breeding logic is called
     *
     * @param player the player causing the callback, or the player nearest to the animals breeding
     * @param frog the frog being bred
     * @param other  the other animal being bred
     *
     * @apiNote {@code ActionResult.SUCCESS} cancels further processing and continues with normal breeding behavior.<br>
     * {@code ActionResult.PASS} falls back to further processing and defaults to SUCCESS if no other listeners are available.<br>
     * {@code ActionResult.FAIL} cancels further processing and does not cause breeding (unless manually done inside listeners).
     */
    ActionResult interact(PlayerEntity player, FrogEntity frog, FrogEntity other);
}
