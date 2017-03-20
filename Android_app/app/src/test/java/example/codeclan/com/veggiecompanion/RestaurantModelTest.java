package example.codeclan.com.veggiecompanion;

import org.junit.Before;
import org.junit.Test;



import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 17/03/2017.
 */

public class RestaurantModelTest {

    private RestaurantModel restaurant;

    @Before
    public void before() {
        restaurant = new RestaurantModel(1, "Paradise Palms", "6 Great St", "It\'s damn good", 1, 53.1, -13.3);
    }

    @Test
    public void restaurantHasId(){ assertEquals(1, restaurant.id); }

    @Test
    public void restaurantHasName(){
        assertEquals("Paradise Palms", restaurant.name);
    }

    @Test
    public void restaurantHasAddress(){
        assertEquals("6 Great St", restaurant.address);
    }

    @Test
    public void restaurantHasDescription(){
        assertEquals("It\'s damn good", restaurant.description);
    }

    @Test
    public void restaurantIsAFavourite(){
        assertEquals(1, restaurant.favourite);
    }

    @Test
    public void restaurantHasLatCode(){
        assertEquals(53.1, restaurant.lat);
    }

    @Test
    public void restaurantHasLngCode(){
        assertEquals(-13.3, restaurant.lng);
    }
}
