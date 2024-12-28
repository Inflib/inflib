package com.infinitychances.inflib.model;

import com.infinitychances.inflib.InfLib;
import com.infinitychances.inflib.exceptions.InvalidInputException;
import net.minecraft.data.client.Model;

import net.minecraft.data.client.TextureKey;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Optional;

public class InfModel {
    private static HashMap<String, InfModel> idMap = new HashMap<>();
    private static ArrayList<String> usedIds = new ArrayList<>();


    public Model model;
    public String path;
    public InfModelType type;
    public String id;
    public String modOrigin;


    //Returns the section of the path variable that states the name of the model json file.
    public String parsePath(){
        return (this.path.split("/"))[1];
    }

    //Gives the id from the name. If an id is a duplicate, then the program returns a string to run the error.
    private static String getID(InfModelType type, String parent) {
        String str = type.name() +"§"+ parent;
        String id = Base64.getEncoder().encodeToString(str.getBytes());
        return id;
    }

    private static String checkId(String id) {
        if(usedIds.contains(id)) {
            InfLib.LOGGER.error("DUPLICATE MODEL FOUND");
            return null;
        }
        usedIds.add(id);
        return "WORKED";
    }

    //constructor for an InfModel without a need for a variant
    public InfModel(String ModOrigin, InfModelType type, String parent, TextureKey ... textures) {
        switch (type) {
            case BLOCK_VARIANT:
                InfLib.LOGGER.error("NEEDS VARIANT");
                break;
            case BLOCK:
                this.model = block(ModOrigin, parent, textures);
                this.path = "block/" + parent;
                break;
            case ITEM:
                this.model = item(ModOrigin, parent, textures);
                this.path = "item/" + parent;
                break;
            default:
                InfLib.LOGGER.error("Invalid Type");
        }
        String tempId = getID(type, parent);
        if (checkId(tempId) == null){
            throw new InvalidInputException("DUPLICATE MODEL BEING CREATED", type + "§" + parent);
        }
        this.id = tempId;
        idMap.put(this.id, this);

        this.modOrigin = ModOrigin;
        this.type = type;
    }

    //constructor if there is a variant
    public InfModel(String ModOrigin, InfModelType type, String parent, String variant, TextureKey ... textures) {
        if (type == InfModelType.BLOCK_VARIANT) {
            this.model = block(ModOrigin, parent, variant, textures);
            this.path = "block/" + parent;
        } else {
            InfLib.LOGGER.error("Variant Not Supported With this type");
        }
        String tempId = getID(type, parent);
        if (checkId(tempId) == null){
            throw new InvalidInputException("DUPLICATE MODEL BEING CREATED", type + "§" + parent);
        }
        this.id = tempId;
        idMap.put(this.id, this);

        this.modOrigin = ModOrigin;
        this.type = type;
    }


    //unused section
    /*private static Model make(TextureKey... requiredTextureKeys) {
        return new Model(Optional.empty(), Optional.empty(), requiredTextureKeys);
    }*/

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
    public static InfModel getInfModelFromId(String id) {
        return idMap.get(id);
    }
}


