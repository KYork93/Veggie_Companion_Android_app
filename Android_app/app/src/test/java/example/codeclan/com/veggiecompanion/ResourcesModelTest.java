package example.codeclan.com.veggiecompanion;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 17/03/2017.
 */

public class ResourcesModelTest {

    private ResourcesModel blog;

    @Before
    public void before(){
        blog = new ResourcesModel("VegLife", "veglife.com", "veg food and lifestyle", false, "food");
    }

    @Test
    public void blogHasName(){
        assertEquals("VegLife", blog.name);
    }

    @Test
    public void blogHasWebsite(){
        assertEquals("veglife.com", blog.website);
    }

    @Test
    public void blogHasDescription(){
        assertEquals("veg food and lifestyle", blog.description);
    }

    @Test
    public void blogIsNotfavourite(){
        assertEquals(false, blog.favourite);
    }

    @Test
    public void blogHasType(){
        assertEquals("food", blog.type);
    }


}
