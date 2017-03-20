package example.codeclan.com.veggiecompanion;


/**
 * Created by user on 17/03/2017.
 */

public class RestaurantModel {

    //favourite is either 1 or 0

    public int id;
    public String name;
    public String address;
    public String description;
    public int favourite;
    public double lat;
    public double lng;

    public RestaurantModel(){

    }

    public RestaurantModel(String name, String address, String description, int favourite, double lat, double lng) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.favourite = favourite;
        this.lat = lat;
        this.lng = lng;
    }

    public RestaurantModel(int id, String name, String address, String description, int favourite, double lat, double lng) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.favourite = favourite;
        this.lat = lat;
        this.lng = lng;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int isFavourite() {
        return favourite;
    }

    public void setFavourite(int favourite) {
        this.favourite = favourite;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(int lng) {
        this.lng = lng;
    }

}
