package example.codeclan.com.veggiecompanion;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 17/03/2017.
 */

public class FavouriteModelTest {

    private FavouriteModel favBlog;

    @Before
    public void before(){
        favBlog = new FavouriteModel("VegLife", "veg food and stuff");
    }

    @Test
    public void favHasName(){
        assertEquals("VegLife", favBlog.name);
    }

    @Test
    public void favHasDescription(){
        assertEquals("veg food and stuff", favBlog.description);
    }


}
