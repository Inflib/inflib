package com.infinitychances.inflib.model;


import com.infinitychances.inflib.InfLib;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TextureKey;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class InfModels extends Models {
    public static final Model INTERACT_TOP = block("interact_top", TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE, TextureKey.PARTICLE);
    public static final Model JUST_TOP = block("just_top",TextureKey.TOP, TextureKey.SIDE, TextureKey.PARTICLE);


    private static Model make(TextureKey... requiredTextureKeys) {
        return new Model(Optional.empty(), Optional.empty(), requiredTextureKeys);
    }

    private static Model block(String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(Identifier.of(InfLib.MOD_ID, "block/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    private static Model item(String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(Identifier.of(InfLib.MOD_ID, "item/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    private static Model block(String parent, String variant, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(Identifier.of(InfLib.MOD_ID, "block/" + parent)), Optional.of(variant), requiredTextureKeys);
    }
}
