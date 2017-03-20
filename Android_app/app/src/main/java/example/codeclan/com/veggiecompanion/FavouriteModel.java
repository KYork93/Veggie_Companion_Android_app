package example.codeclan.com.veggiecompanion;

/**
 * Created by user on 17/03/2017.
 */

public class FavouriteModel {

    public int id;
    public String name;
    public String description;

    public FavouriteModel(){}

    public FavouriteModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public FavouriteModel(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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
}

