package com.infinitychances.inflib.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.passive.AbstractCowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.AbstractBoatEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public interface EnterBoatCallback {

    Event<EnterBoatCallback> EVENT = EventFactory.createArrayBacked(EnterBoatCallback.class,
            (listeners) -> (player, hand, boat) -> {
                for (EnterBoatCallback listener : listeners) {
                    ActionResult result = listener.interact(player, hand, boat);

                    if (result != ActionResult.PASS) {
                        return result;
                    }
                }

                return ActionResult.PASS;
            });

    /**
     * Callback for entering a boat
     *
     * @Bug: when a boat is falling due to magma, the callback is still called.
     *
     * @apiNote {@code ActionResult.SUCCESS} cancels further processing and continues with normal milking behavior.<br>
     * {@code ActionResult.PASS} falls back to further processing and defaults to SUCCESS if no other listeners are available.<br>
     * {@code ActionResult.FAIL} cancels further processing and does not milk the cow (unless manually done inside listeners).
     */
    ActionResult interact(PlayerEntity player, Hand hand, AbstractBoatEntity boat);
}
