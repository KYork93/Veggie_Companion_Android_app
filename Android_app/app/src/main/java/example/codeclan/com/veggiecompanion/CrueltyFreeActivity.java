package example.codeclan.com.veggiecompanion;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by user on 22/03/2017.
 */

public class CrueltyFreeActivity extends AppCompatActivity{

    //seeds
    CrueltyFreeModel nyx = new CrueltyFreeModel("NYX", "Nyx is an affordable make up brand who are increasing in popularity due to their cruelty free and mainly vegan status.  The quality of their make up is high and has not affected their price, their colours are highly pigmented and lipsticks last longer than the high end brands.",
            "cosmetics", 0, R.mipmap.nyxbanner);
    CrueltyFreeModel lush = new CrueltyFreeModel("Lush", "This high street store specialises in making their own products, totally " +
            "vegetarian with a lot of vegan products from bath bombs to make up.  There's something " +
            "for everyone here and the staff are friendly, often you can ask for take away samples." +
            "They have now also opened spas.", "cosmetics", 0, R.mipmap.lush_cosmetics_banner);
    CrueltyFreeModel ecover = new CrueltyFreeModel("Ecover", "This company produces household cleaning products from washing up liquid " +
            "to bathroom cleaner using natural based products which will not harm the environment, no " +
            "animal testing is involved they are stored in recycled plastic bottles and even the factory " +
            "was build with ecology in mind.  To top it all of these products are available in most " +
            "major supermarkets at inexpensive prices!", "household", 0, R.mipmap.ecover_banner);
    CrueltyFreeModel superdrug = new CrueltyFreeModel("Superdrug", "Superdrugs own products from toothpaste to their makeup brand B. are all cruelty free, " +
            "with labels marking suitability for vegetarians and vegans.  All of their products are very " +
            "affordable and just as good as the brand names.", "cosmetics", 0, R.mipmap.super_drug_banner);


    ListView companyList;
    Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cruelty_free_activity);

        this.showAllCFCompanies();
    }

    public void addToTheCrueltyFreeDatabase(){
        CrueltyFreeDBHandler db = new CrueltyFreeDBHandler(this);
        db.deleteAllCompanies();

        db.addToCrueltyFreeTable(nyx);
        db.addToCrueltyFreeTable(lush);
        db.addToCrueltyFreeTable(ecover);
        db.addToCrueltyFreeTable(superdrug);
    }

    public void showAllCFCompanies(){
        addToTheCrueltyFreeDatabase();
        CrueltyFreeDBHandler db = new CrueltyFreeDBHandler(this);

        ArrayList<CrueltyFreeModel> allCompanies = db.getAllCrueltyFree();

        for(CrueltyFreeModel company : allCompanies){
            String log = "ID: " + company.getId() + " Name: " + company.getName();
            Log.d("Seeding: ", log);
        }

        companyList = (ListView) findViewById(R.id.cruelty_free_list);
        CrueltyFreeAdapter adapter = new CrueltyFreeAdapter(CrueltyFreeActivity.this, R.id.company_id, allCompanies);
        companyList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.home){
            intent = new Intent(CrueltyFreeActivity.this, RestaurantMainActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.favourites_menu){
            intent = new Intent(CrueltyFreeActivity.this, FavouritesActivityPage.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


}
