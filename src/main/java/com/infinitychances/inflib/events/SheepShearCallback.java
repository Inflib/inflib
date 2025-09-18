package com.infinitychances.inflib.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;

public interface SheepShearCallback {

    Event<SheepShearCallback> EVENT = EventFactory.createArrayBacked(SheepShearCallback.class,
            (listeners) -> (player, sheep) -> {
                for (SheepShearCallback listener : listeners) {
                    ActionResult result = listener.interact(player, sheep);

                    if (result != ActionResult.PASS) {
                        return result;
                    }
                }

                return ActionResult.PASS;
            });

    /**
     * Callback for shearing a sheep.
     * Called before the sheep is sheared, sound is played, items are dropped, and items are damaged.
     * @param player the player causing the callback
     * @param sheep the sheep that is being interacted with
     * @apiNote {@code ActionResult.SUCCESS} cancels further processing and continues with normal shearing behavior.<br>
     * {@code ActionResult.PASS} falls back to further processing and defaults to SUCCESS if no other listeners are available<br>
     * {@code ActionResult.FAIL} cancels further processing and does not shear the sheep (unless manually done inside listeners).
     */
    ActionResult interact(PlayerEntity player, SheepEntity sheep);
}
