package com.infinitychances.inflib.model;

import com.infinitychances.inflib.exceptions.InvalidInputException;
import net.minecraft.data.client.Model;

import net.minecraft.data.client.TextureKey;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Optional;

import static com.infinitychances.inflib.InfLib.LOGGER;

public class InfModel {
    private static HashMap<String, InfModel> idMap = new HashMap<>();
    private static ArrayList<String> usedIds = new ArrayList<>();

    public Model model;
    public String path;
    public InfModelType type;
    public String id;
    public String modOrigin;
    public TextureKey[] requiredKeys;

    //constructor for an InfModel without a need for a variant
    public InfModel(String ModOrigin, InfModelType type, String parent, TextureKey... textures) {
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
            throw new InvalidInputException("DUPLICATE MODEL BEING CREATED ", type + " " + parent);
        }
        this.id = tempId;
        idMap.put(this.id, this);

        this.requiredKeys = textures;
        this.modOrigin = ModOrigin;
        this.type = type;
    }

    //constructor if there is a variant
    public InfModel(String ModOrigin, InfModelType type, String parent, String variant, TextureKey... textures) {
        if(parent.contains("/")) {
            LOGGER.error("Invalid Parent Model");
            throw new IllegalArgumentException("Parent Model Cannot contain a /!");
        }
        if (type == InfModelType.BLOCK_VARIANT) {
            this.model = block(ModOrigin, parent, variant, textures);
            this.path = "block/" + parent;
        } else {
            LOGGER.error("Variant Not Supported With this type");
        }
        String tempId = getID(type, parent);
        if (!checkId(tempId)){
            throw new InvalidInputException("DUPLICATE MODEL BEING CREATED ", type + "§" + parent);
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

    //returns the InfModel of the id
    //This is probably a useless function
    public static InfModel getInfModelFromId(String id) {
        return idMap.get(id);
    }

    //Returns the section of the path variable that states the name of the model json file.
    public String parsePath(){
        return parsePath(this.path);
    }

    public static String parsePath(String path){
        return (path.split("/"))[1];
    }

    public HashMap<InfModelType, String> parseId() {
        return parseId(this.id);
    }

    public static HashMap<InfModelType, String> parseId(String id) {
        String[] idArray = decodeId(id).split("§");
        HashMap<InfModelType, String> map = new HashMap<>();
        map.put(InfModelType.valueOf(idArray[0]), idArray[1]);
        return map;
    }

    //Gives the id from the name.
    private static String getID(InfModelType type, String parent) {
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
}


