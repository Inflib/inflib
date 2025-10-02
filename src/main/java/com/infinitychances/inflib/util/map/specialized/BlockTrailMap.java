package com.infinitychances.inflib.util.map.specialized;

import com.infinitychances.inflib.util.map.SingleTrailMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;

public class BlockTrailMap extends SingleTrailMap<Block> {
    public BlockTrailMap() {
        super();
    }

    public BlockTrailMap(String key) {
        super(key);
    }

    public Float getBlastResistancefromId(Integer id) {
        return getFromId(id).getBlastResistance();
    }

    public Float getSlipperinessfromId(Integer id) {
        return getFromId(id).getSlipperiness();
    }

    public Float getVelocityMultiplierfromId(Integer id) {
        return getFromId(id).getVelocityMultiplier();
    }

    public BlockState getDefaultStatefromId(Integer id) {
        return getFromId(id).getDefaultState();
    }

    public Item getBlockItemfromId(Integer id) {
        return getFromId(id).asItem();
    }

    public RegistryEntry<Block> getBlockRegistryEntryfromId(Integer id) {
        return Registries.BLOCK.getEntry(getFromId(id));
    }

    /*
    getBlastResistance
    getSlipperiness
    getVelocityMultiplier
    getJumpVelocityMultiplier
    getDefaultState
    asItem
    getRegistryEntry
    //Abstract Block
    getCodec
    getRenderType
    hasComparatorOutput
    getMaxHorizontalModelOffset
    getVerticalModelOffsetMultiplier
    getRequiredFeatures
    getOpacity
    getLootTableKey
    getTranslationKey
    getHardness
     */
}