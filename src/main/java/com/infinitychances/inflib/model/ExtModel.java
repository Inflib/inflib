package com.infinitychances.inflib.model;

import com.infinitychances.inflib.exceptions.InvalidInputException;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.Model;

import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Optional;

import static com.infinitychances.inflib.InfLib.LOGGER;

public class ExtModel {
    private static HashMap<String, ExtModel> idMap = new HashMap<>();
    private static ArrayList<String> usedIds = new ArrayList<>();

    public Model model;
    public String path;
    public ExtModelType type;
    public String id;
    public String modOrigin;
    public TextureKey[] requiredKeys;

    //constructor for an ExtModel without a need for a variant
    public ExtModel(String ModOrigin, ExtModelType type, String parent, TextureKey... textures) {
        if(parent.contains("/")) {
            LOGGER.error("Invalid Parent Model");
            throw new IllegalArgumentException("Parent Model Cannot contain a /!");
        }
        switch (type) {
            case BLOCK_VARIANT:
                LOGGER.error("NEEDS VARIANT");
                break;
            case BLOCK:
                this.model = block(ModOrigin, parent, textures);
                this.path = "block/" + parent;
                break;
            case ITEM:
                this.model = item(ModOrigin, parent, textures);
                this.path = "item/" + parent;
                break;
            case NORMAL:
                this.model = make(textures);
                this.path = "unavailable/"+parent;
                break;
            default:
                LOGGER.error("Invalid Type");
        }
        String tempId = getID(type, parent);
        if (!checkId(tempId)){
            throw new InvalidInputException("DUPLICATE MODEL BEING CREATED", type + " " + parent);
        }
        this.id = tempId;
        idMap.put(this.id, this);

        this.requiredKeys = textures;
        this.modOrigin = ModOrigin;
        this.type = type;
    }

    //constructor if there is a variant
    public ExtModel(String ModOrigin, ExtModelType type, String parent, String variant, TextureKey... textures) {
        if(parent.contains("/")) {
            LOGGER.error("Invalid Parent Model");
            throw new IllegalArgumentException("Parent Model Cannot contain a /!");
        }
        if (type == ExtModelType.BLOCK_VARIANT) {
            this.model = block(ModOrigin, parent, variant, textures);
            this.path = "block/" + parent;
        } else {
            LOGGER.error("Variant Not Supported With this type");
        }
        String tempId = getID(type, parent);
        if (!checkId(tempId)){
            throw new InvalidInputException("DUPLICATE MODEL BEING CREATED", type + "§" + parent);
        }
        this.id = tempId;
        idMap.put(this.id, this);

        this.requiredKeys = textures;
        this.modOrigin = ModOrigin;
        this.type = type;
    }

    private static Model make(TextureKey... requiredTextureKeys) {
        return new Model(Optional.empty(), Optional.empty(), requiredTextureKeys);
    }

    private static Model block(String ModOrigin, String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(Identifier.of(ModOrigin, "block/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    private static Model item(String ModOrigin, String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(Identifier.of(ModOrigin, "item/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    private static Model block(String ModOrigin, String parent, String variant, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(Identifier.of(ModOrigin, "block/" + parent)), Optional.of(variant), requiredTextureKeys);
    }

    //returns the ExtModel of the id
    //This is probably a useless function
    public static ExtModel getExtModelFromId(String id) {
        return idMap.get(id);
    }

    //Returns the section of the path variable that states the name of the model json file.
    public String parsePath(){
        return parsePath(this.path);
    }

    public static String parsePath(String path){
        return (path.split("/"))[1];
    }

    public HashMap<ExtModelType, String> parseId() {
        return parseId(this.id);
    }

    public static HashMap<ExtModelType, String> parseId(String id) {
        String[] idArray = decodeId(id).split("§");
        HashMap<ExtModelType, String> map = new HashMap<>();
        map.put(ExtModelType.valueOf(idArray[0]), idArray[1]);
        return map;
    }

    //Gives the id from the name.
    private static String getID(@NotNull ExtModelType type, String parent) {
        String str = type.name() +"§"+ parent;
        return Base64.getEncoder().encodeToString(str.getBytes());
    }

    //checks if an id is a duplicate
    private static boolean checkId(String id) {
        if(usedIds.contains(id)) {
            LOGGER.error("DUPLICATE MODEL FOUND");
            return false;
        }
        usedIds.add(id);
        return true;
    }

    protected static String decodeId(String id) {
        return Base64.getDecoder().decode(id).toString();
    }

    public void createBlockModel(Block block, TextureMap textures, BlockStateModelGenerator blockStateModelGenerator,  String modId) {
        ExtModels.createBlockModel(this, block, textures, blockStateModelGenerator, modId);
    }

    public void createBlockModel(Block block, TextureMap textures, BlockStateModelGenerator blockStateModelGenerator) {
        ExtModels.createBlockModel(this, block, textures, blockStateModelGenerator);
    }
}


