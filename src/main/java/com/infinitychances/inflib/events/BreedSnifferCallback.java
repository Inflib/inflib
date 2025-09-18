package com.infinitychances.inflib.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.passive.FrogEntity;
import net.minecraft.entity.passive.SnifferEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;

public interface BreedSnifferCallback {

    Event<BreedSnifferCallback> EVENT = EventFactory.createArrayBacked(BreedSnifferCallback.class,
            (listeners) -> (player, sniffer, other, itemEntity) -> {
                for (BreedSnifferCallback listener : listeners) {
                    ActionResult result = listener.interact(player, sniffer, other, itemEntity);

                    if (result != ActionResult.PASS) {
                        return result;
                    }
                }

                return ActionResult.PASS;
            });

    /**
     * Callback for breeding frogs.
     * Called before the animals breed and the sniffer egg is placed, yet after it is prepared.
     *
     * @param player the player causing the callback, or the player nearest to the animals breeding
     * @param sniffer the animal being bred
     * @param other  the other animal being bred
     * @param itemEntity the sniffer egg itemEntity
     *
     * @return {@code ActionResult} - the result of the action
     *
     * @apiNote {@code ActionResult.SUCCESS} cancels further processing and continues with normal breeding behavior.<br>
     * {@code ActionResult.PASS} falls back to further processing and defaults to SUCCESS if no other listeners are available.<br>
     * {@code ActionResult.FAIL} cancels further processing and does not cause breeding or placement of sniffer egg (unless manually done inside listeners).
     */
    ActionResult interact(PlayerEntity player, SnifferEntity sniffer, SnifferEntity other, ItemEntity itemEntity);
}
