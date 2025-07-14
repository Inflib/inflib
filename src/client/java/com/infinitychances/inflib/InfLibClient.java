package com.infinitychances.inflib;

import com.infinitychances.inflib.texture.InflibTextureKeys;
import net.fabricmc.api.ClientModInitializer;

public class InfLibClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		InflibTextureKeys.init();
	}
}