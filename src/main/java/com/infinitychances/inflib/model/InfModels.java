package com.infinitychances.inflib.model;

import com.infinitychances.inflib.InfLib;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

public class InfModels {

    //creates a custom block model with corresponding item model. Mod id defaults to minecraft.
    public static void createBlockModel(InfModel infModel, Block block, TextureMap textures, BlockStateModelGenerator blockStateModelGenerator, String modId) {
        infModel.model.upload(block, textures, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.registerParentedItemModel(block, Identifier.of(modId, "blocks/" + block.getName()));
    }

    public static void createBlockModel(InfModel infModel, Block block, TextureMap textures, BlockStateModelGenerator blockStateModelGenerator) {
        createBlockModel(infModel, block, textures, blockStateModelGenerator, "minecraft");
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

