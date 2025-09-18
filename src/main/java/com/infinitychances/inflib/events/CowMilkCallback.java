package com.infinitychances.inflib.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.passive.AbstractCowEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;

public interface CowMilkCallback {

    Event<CowMilkCallback> EVENT = EventFactory.createArrayBacked(CowMilkCallback.class,
            (listeners) -> (player, cow) -> {
                for (CowMilkCallback listener : listeners) {
                    ActionResult result = listener.interact(player, cow);

                    if (result != ActionResult.PASS) {
                        return result;
                    }
                }

                return ActionResult.PASS;
            });

    /**
     * Callback for milking a cow.
     * Called before the cow is milked, sound is played, and before the bucket becomes a milk bucket
     * @param player the player causing the callback
     * @param cow the cow that is being interacted with
     * @apiNote {@code ActionResult.SUCCESS} cancels further processing and continues with normal milking behavior.<br>
     * {@code ActionResult.PASS} falls back to further processing and defaults to SUCCESS if no other listeners are available.<br>
     * {@code ActionResult.FAIL} cancels further processing and does not milk the cow (unless manually done inside listeners).
     */
    ActionResult interact(PlayerEntity player, AbstractCowEntity cow);
}
