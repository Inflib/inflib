package com.infinitychances.inflib.model;

import com.infinitychances.inflib.InfLib;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;

public class InfModels extends Models {
    public static void createBlockModel(Model model, Block block, TextureMap textures,  BlockStateModelGenerator blockStateModelGenerator) {
        model.upload(block, textures, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.registerItemModel(block);
    }

    public static final InfModel INTERACT_TOP = new InfModel(InfLib.MOD_ID, InfModelType.BLOCK,
            "interact_top",
            TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE, TextureKey.PARTICLE);

    public static final InfModel JUST_TOP = new InfModel(InfLib.MOD_ID, InfModelType.BLOCK, "just_top",
            TextureKey.TOP, TextureKey.SIDE, TextureKey.PARTICLE);

    public static final InfModel INTERACT_TOP_DIRECTIONAL = new InfModel(InfLib.MOD_ID,
            InfModelType.BLOCK_VARIANT,
            "interact_top_directional", "_directional",
            TextureKey.BOTTOM, TextureKey.TOP, TextureKey.FRONT, TextureKey.PARTICLE, TextureKey.SIDE);
}

