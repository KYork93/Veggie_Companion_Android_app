package example.codeclan.com.veggiecompanion;

/**
 * Created by user on 17/03/2017.
 */

public class CrueltyFreeModel {

    public int id;
    public String name;
    public String description;
    public String type;
    public int favourite;
    public int image;

    public CrueltyFreeModel(){}

    public CrueltyFreeModel(String name, String description, String type, int favourite, int image) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.favourite = favourite;
        this.image = image;
    }

    public CrueltyFreeModel(int id, String name, String description, String type, int favourite, int image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.favourite = favourite;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int isFavourite() {
        return favourite;
    }

    public void setFavourite(int favourite) {
        this.favourite = favourite;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
