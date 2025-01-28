package com.infinitychances.inflib.model;

import com.infinitychances.inflib.InfLib;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

public class ExtModels {

    //creates a custom block model with corresponding item model. Mod id defaults to minecraft.
    public static void createBlockModel(ExtModel extModel, Block block, TextureMap textures, BlockStateModelGenerator blockStateModelGenerator, String modId) {
        extModel.model.upload(block, textures, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.registerParentedItemModel(block, Identifier.of(modId, "blocks/" + block.getName()));
    }

    public static void createBlockModel(ExtModel extModel, Block block, TextureMap textures, BlockStateModelGenerator blockStateModelGenerator) {
        createBlockModel(extModel, block, textures, blockStateModelGenerator, "minecraft");
    }

    public static final ExtModel INTERACT_TOP = ExtModel.of(InfLib.MOD_ID, ExtModelType.BLOCK,
            "interact_top",
            TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE, TextureKey.PARTICLE);

    public static final ExtModel JUST_TOP = ExtModel.of(InfLib.MOD_ID, ExtModelType.BLOCK, "just_top",
            TextureKey.TOP, TextureKey.SIDE, TextureKey.PARTICLE);

    public static final ExtModel INTERACT_TOP_NORTH_SOUTH = ExtModel.of(InfLib.MOD_ID,
            ExtModelType.BLOCK_VARIANT,
            "interact_top_north_south", "_north_south",
            TextureKey.BOTTOM, TextureKey.TOP, TextureKey.FRONT, TextureKey.PARTICLE, TextureKey.SIDE);

    public static final ExtModel INTERACT_TOP_EAST_WEST = ExtModel.of(InfLib.MOD_ID,
            ExtModelType.BLOCK_VARIANT,
            "interact_top_east_west", "_east_west",
            TextureKey.BOTTOM, TextureKey.TOP, TextureKey.FRONT, TextureKey.PARTICLE, TextureKey.SIDE);
}

