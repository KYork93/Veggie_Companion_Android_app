package example.codeclan.com.veggiecompanion;

/**
 * Created by user on 17/03/2017.
 */

public class CrueltyFreeModel {

    public String name;
    public String description;
    public String type;
    public boolean favourite;
    public String image;

    public CrueltyFreeModel(String name, String description, String type, boolean favourite, String image) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.favourite = favourite;
        this.image = image;
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

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
