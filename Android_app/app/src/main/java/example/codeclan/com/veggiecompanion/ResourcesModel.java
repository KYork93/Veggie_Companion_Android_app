package example.codeclan.com.veggiecompanion;

/**
 * Created by user on 17/03/2017.
 */

public class ResourcesModel {

    public String name;
    public String website;
    public String description;
    public boolean favourite;
    public String type;

    public ResourcesModel(String name, String website, String description, boolean favourite, String type) {
        this.name = name;
        this.website = website;
        this.description = description;
        this.favourite = favourite;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
