package example.codeclan.com.veggiecompanion;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 17/03/2017.
 */

public class CrueltyFreeModelTest {

    private CrueltyFreeModel crueltyFreeCompany;

    @Before
    public void before(){
        crueltyFreeCompany = new CrueltyFreeModel("NYX", "affordable vegan makeup", "cosmetics", 1, 123);
    }

    @Test
    public void companyHasName(){
        assertEquals("NYX", crueltyFreeCompany.name);
    }

    @Test
    public void companyHasDescription(){
        assertEquals("affordable vegan makeup", crueltyFreeCompany.description);
    }

    @Test
    public void companyHasType(){
        assertEquals("cosmetics", crueltyFreeCompany.type);
    }

    @Test
    public void companyIsFavourite(){
        assertEquals(true, crueltyFreeCompany.favourite);
    }

    @Test
    public void companyHasImage(){
        assertEquals(123, crueltyFreeCompany.image);
    }
}
