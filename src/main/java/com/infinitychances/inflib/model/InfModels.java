package com.infinitychances.inflib.model;

import com.infinitychances.inflib.InfLib;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

public class InfModels {
    public static void createBlockModel(InfModel infModel, Block block, TextureMap textures,  BlockStateModelGenerator blockStateModelGenerator) {
        infModel.model.upload(block, textures, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.registerParentedItemModel(block, Identifier.of(infModel.modOrigin, infModel.path));
    }

    public static final InfModel INTERACT_TOP = new InfModel(InfLib.MOD_ID, InfModelType.BLOCK,
            "interact_top",
            TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE, TextureKey.PARTICLE);

    public static final InfModel JUST_TOP = new InfModel(InfLib.MOD_ID, InfModelType.BLOCK, "just_top",
            TextureKey.TOP, TextureKey.SIDE, TextureKey.PARTICLE);

    public static final InfModel INTERACT_TOP_NORTH_SOUTH = new InfModel(InfLib.MOD_ID,
            InfModelType.BLOCK_VARIANT,
            "interact_top_north_south", "_north_south",
            TextureKey.BOTTOM, TextureKey.TOP, TextureKey.FRONT, TextureKey.PARTICLE, TextureKey.SIDE);

    public static final InfModel INTERACT_TOP_EAST_WEST = new InfModel(InfLib.MOD_ID,
            InfModelType.BLOCK_VARIANT,
            "interact_top_east_west", "_east_west",
            TextureKey.BOTTOM, TextureKey.TOP, TextureKey.FRONT, TextureKey.PARTICLE, TextureKey.SIDE);
}

