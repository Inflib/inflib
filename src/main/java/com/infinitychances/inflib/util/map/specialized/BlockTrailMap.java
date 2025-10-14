package com.infinitychances.inflib.util.map.specialized;

import com.infinitychances.inflib.util.map.SingleTrailMap;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
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

    //---------------------------------------------------------------------------------------------------------

    public Float getNextBlastResistanceFromId(Integer id) {
        return getNextFromId(id).getBlastResistance();
    }

    public Float getNextBlastResistance(Block block) {
        return getNext(block).getBlastResistance();
    }

    public Float getBlastResistanceFromId(Integer id) {
        return getFromId(id).getBlastResistance();
    }

    public Float getPreviousBlastResistanceFromId(Integer id) {
        return getPreviousFromId(id).getBlastResistance();
    }

    public Float getPreviousBlastResistance(Block block) {
        return getPrevious(block).getBlastResistance();
    }

    //---------------------------------------------------------------------------------------------------------

    public Float getNextSlipperinessFromId(Integer id) {
        return getNextFromId(id).getSlipperiness();
    }
    
    public Float getNextSlipperiness(Block block) {
        return getNext(block).getSlipperiness();
    }

    public Float getSlipperinessFromId(Integer id) {
        return getFromId(id).getSlipperiness();
    }

    public Float getPreviousSlipperinessFromId(Integer id) {
        return getPreviousFromId(id).getSlipperiness();
    }

    public Float getPreviousSlipperiness(Block block) {
        return getPrevious(block).getSlipperiness();
    }

    //---------------------------------------------------------------------------------------------------------

    public Float getNextVelocityMultiplierFromId(Integer id) {
        return getNextFromId(id).getVelocityMultiplier();
    }

    public Float getNextVelocityMultiplier(Block block) {
        return getNext(block).getVelocityMultiplier();
    }

    public Float getVelocityMultiplierFromId(Integer id) {
        return getFromId(id).getVelocityMultiplier();
    }

    public Float getPreviousVelocityMultiplierFromId(Integer id) {
        return getPreviousFromId(id).getVelocityMultiplier();
    }

    public Float getPreviousVelocityMultiplier(Block block) {
        return getPrevious(block).getVelocityMultiplier();
    }

    //---------------------------------------------------------------------------------------------------------

    public BlockState getNextDefaultStateFromId(Integer id) {
        return getNextFromId(id).getDefaultState();
    }

    public BlockState getNextDefaultState(Block block) {
        return getNext(block).getDefaultState();
    }

    public BlockState getDefaultStateFromId(Integer id) {
        return getFromId(id).getDefaultState();
    }

    public BlockState getPreviousDefaultStateFromId(Integer id) {
        return getPreviousFromId(id).getDefaultState();
    }

    public BlockState getPreviousDefaultState(Block block) {
        return getPrevious(block).getDefaultState();
    }

    //---------------------------------------------------------------------------------------------------------

    public Item getNextBlockItemFromId(Integer id) {
        return getNextFromId(id).asItem();
    }

    public Item getNextBlockItem(Block block) {
        return getNext(block).asItem();
    }

    public Item getBlockItemFromId(Integer id) {
        return getFromId(id).asItem();
    }

    public Item getPreviousBlockItemFromId(Integer id) {
        return getPreviousFromId(id).asItem();
    }

    public Item getPreviousBlockItem(Block block) {
        return getPrevious(block).asItem();
    }

    //---------------------------------------------------------------------------------------------------------

    public RegistryEntry<Block> getNextBlockRegistryEntryFromId(Integer id) {
        return Registries.BLOCK.getEntry(getNextFromId(id));
    }

    public RegistryEntry<Block> getNextBlockRegistryEntry(Block block) {
        return Registries.BLOCK.getEntry(getNext(block));
    }

    public RegistryEntry<Block> getBlockRegistryEntryFromId(Integer id) {
        return Registries.BLOCK.getEntry(getFromId(id));
    }

    public RegistryEntry<Block> getPreviousBlockRegistryEntryFromId(Integer id) {
        return Registries.BLOCK.getEntry(getPreviousFromId(id));
    }

    public RegistryEntry<Block> getPreviousBlockRegistryEntry(Block block) {
        return Registries.BLOCK.getEntry(getPrevious(block));
    }

    //---------------------------------------------------------------------------------------------------------

    @SuppressWarnings("AccessStaticViaInstance")
    public MapCodec<? extends Block> getNextCodecFromId(Integer id) {
        return getNextFromId(id).CODEC;
    }

    @SuppressWarnings("AccessStaticViaInstance")
    public MapCodec<? extends Block> getNextCodec(Block block) {
        return getNext(block).CODEC;
    }

    @SuppressWarnings("AccessStaticViaInstance")
    public MapCodec<? extends Block> getCodecFromId(Integer id) {
        return getFromId(id).CODEC;
    }

    @SuppressWarnings("AccessStaticViaInstance")
    public MapCodec<? extends Block> getPreviousCodecFromId(Integer id) {
        return getPreviousFromId(id).CODEC;
    }

    @SuppressWarnings("AccessStaticViaInstance")
    public MapCodec<? extends Block> getPreviousCodec(Block block) {
        return getPrevious(block).CODEC;
    }

    //---------------------------------------------------------------------------------------------------------

    public BlockRenderType getNextRenderTypeFromId(Integer id) {
        return getNextFromId(id).getDefaultState().getRenderType();
    }

    public BlockRenderType getNextRenderType(Block block) {
        return getNext(block).getDefaultState().getRenderType();
    }

    public BlockRenderType getRenderTypeFromId(Integer id) {
        return getFromId(id).getDefaultState().getRenderType();
    }

    public BlockRenderType getPreviousRenderTypeFromId(Integer id) {
        return getPreviousFromId(id).getDefaultState().getRenderType();
    }

    public BlockRenderType getPreviousRenderType(Block block) {
        return getPrevious(block).getDefaultState().getRenderType();
    }

    //---------------------------------------------------------------------------------------------------------

    public Boolean getNextHasComparatorOutputFromId(Integer id) {
        return getNextFromId(id).getDefaultState().hasComparatorOutput();
    }

    public Boolean getNextHasComparatorOutput(Block block) {
        return getNext(block).getDefaultState().hasComparatorOutput();
    }

    public Boolean getHasComparatorOutputFromId(Integer id) {
        return getFromId(id).getDefaultState().hasComparatorOutput();
    }

    public Boolean getPreviousHasComparatorOutputFromId(Integer id) {
        return getPreviousFromId(id).getDefaultState().hasComparatorOutput();
    }

    public Boolean getPreviousHasComparatorOutput(Block block) {
        return getPrevious(block).getDefaultState().hasComparatorOutput();
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