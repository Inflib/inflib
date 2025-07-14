package com.infinitychances.inflib.model;

import com.infinitychances.inflib.InfLib;
import com.infinitychances.inflib.texture.InflibTextureKeys;
import net.minecraft.block.Block;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.TextureMap;
import net.minecraft.client.data.*;
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

    public static final ExtModel DIRECTIONAL_END_CUBE = ExtModelBuilder.create()
            .modOrigin(InfLib.MOD_ID)
            .name("directional_end_cube")
            .type(ExtModelType.BLOCK)
            .requiredKeys(TextureKey.FRONT, TextureKey.BACK, TextureKey.END, InflibTextureKeys.LEFT, InflibTextureKeys.RIGHT)
            .build();
}

