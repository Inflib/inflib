package com.infinitychances.inflib.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.passive.AbstractCowEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;

public interface BreedAnimalCallback {

    Event<BreedAnimalCallback> EVENT = EventFactory.createArrayBacked(BreedAnimalCallback.class,
            (listeners) -> (player, animal, other, baby) -> {
                for (BreedAnimalCallback listener : listeners) {
                    ActionResult result = listener.interact(player, animal, other, baby);

                    if (result != ActionResult.PASS) {
                        return result;
                    }
                }

                return ActionResult.PASS;
            });

    /**
     * Callback for breeding animals.
     * Called before
     *
     * @param player the player causing the callback, or the player nearest to the animals breeding
     * @param animal the animal being bred
     * @param other  the other animal being bred
     * @param baby   the child of the two animals
     *
     * @apiNote {@code ActionResult.SUCCESS} cancels further processing and continues with normal breeding behavior.<br>
     * {@code ActionResult.PASS} falls back to further processing and defaults to SUCCESS if no other listeners are available.<br>
     * {@code ActionResult.FAIL} cancels further processing and does not cause breeding (unless manually done inside listeners).
     */
    ActionResult interact(PlayerEntity player, AnimalEntity animal, AnimalEntity other, PassiveEntity baby);
}
