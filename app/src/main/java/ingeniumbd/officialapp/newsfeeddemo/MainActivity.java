package ingeniumbd.officialapp.newsfeeddemo;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

    private CardView cardView;
    private CardView secondCard;
    private CardView thirdCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        card();
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drwer = (DrawerLayout) findViewById(R.id.drawer_layout_id);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drwer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        );

        drwer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        displaySelectedScreen(R.id.nav_menu1);
    }


    @Override
    public void onBackPressed() {

        DrawerLayout drwer = (DrawerLayout) findViewById(R.id.drawer_layout_id);

        if (drwer.isDrawerOpen(GravityCompat.START)) {
            drwer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }


    private void displaySelectedScreen(int itemId) {

        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_menu1:
               // fragment=new OneFragment();
                break;
            case R.id.nav_menu2:
               // fragment=new TwoFragment();
                break;
            case R.id.nav_menu3:
              //  fragment=new ThreeFragment();
                break;
            case R.id.nav_menu4:
              //  fragment = new FourFragment();
                break;
        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame_content, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_id);
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        displaySelectedScreen(item.getItemId());

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu_item,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void card(){

        cardView=(CardView)findViewById(R.id.card_click);
        secondCard=(CardView)findViewById(R.id.card_second_click_xml);
        thirdCard=(CardView)findViewById(R.id.card_third_click_xml);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });


        secondCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });


        thirdCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });


    }


}
