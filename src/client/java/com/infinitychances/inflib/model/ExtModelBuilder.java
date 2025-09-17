package com.infinitychances.inflib.model;

import com.infinitychances.inflib.InfLib;
import net.minecraft.client.data.TextureKey;

/**
 * Builder for ExtModel
 */
public final class ExtModelBuilder {
    private String name;
    private String variant;
    private ExtModelType type;
    private String modOrigin;
    private TextureKey[] requiredKeys;

    private ExtModelBuilder() {
        this.name = null;
        this.variant = null;
        this.type = null;
        this.modOrigin = null;
        this.requiredKeys = null;
    }

    public static ExtModelBuilder create() {
        return new ExtModelBuilder();
    }

    public ExtModelBuilder modOrigin(String modOrigin) {
        this.modOrigin = modOrigin;
        return this;
    }

    //required
    public ExtModelBuilder type(ExtModelType type) {
        this.type = type;
        return this;
    }

    public ExtModelBuilder variant(String variant) {
        this.variant = variant;
        return this;
    }

    //required
    public ExtModelBuilder name(String name) {
        this.name = name;
        return this;
    }

    //required
    public ExtModelBuilder requiredKeys(TextureKey... textureKeys) {
        this.requiredKeys = textureKeys;
        return this;
    }

    public ExtModel build() {
        if(this.name == null || this.type == null || this.requiredKeys == null) {
            throw new RuntimeException("Need more information about the ExtModel");
        }
        if(this.variant == null) {
            if (this.modOrigin == null) {
                InfLib.LOGGER.warn("Model being made has namespace of 'minecraft', model may not function properly!");
                return ExtModel.of(this.type, this.name, this.requiredKeys);
            }
            return ExtModel.of(this.modOrigin, this.type, this.name, this.requiredKeys);
        } else {
            if (this.modOrigin == null) {
                InfLib.LOGGER.warn("Model being made has namespace of 'minecraft', model may not function properly!");
                return ExtModel.of(this.type, this.name, this.variant, this.requiredKeys);
            }
            return ExtModel.of(this.modOrigin, this.type, this.name, this.variant, this.requiredKeys);
        }


    }

}
