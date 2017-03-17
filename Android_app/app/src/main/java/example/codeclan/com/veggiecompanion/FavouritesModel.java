package example.codeclan.com.veggiecompanion;

/**
 * Created by user on 17/03/2017.
 */

public class FavouritesModel {

    public String name;
    public String description;

    public FavouritesModel(String name, String description) {
        this.name = name;
        this.description = description;
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
}

