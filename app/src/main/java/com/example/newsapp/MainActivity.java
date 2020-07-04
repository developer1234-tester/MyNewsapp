package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.newsapp.model.HeadlineResponse;
import com.google.android.material.navigation.NavigationView;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    RecyclerView recyclerView,mrecylerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");
        recyclerView=findViewById(R.id.rcyclr1);
      //  mrecylerview=findViewById(R.id.rcyclr3);
        getHeadlines();
       // getNews();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        try {
            getSupportFragmentManager().beginTransaction().replace(R.id.flay, new CategoryFragment()).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        ((NavigationView) findViewById(R.id.nav_view)).setNavigationItemSelectedListener(this);
    }
    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();


        }
    }


    private void getHeadlines() {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager =
                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(mLayoutManager);

        GetDataService service = RetrofirClientInstance.getRetrofit().create(GetDataService.class);
        Call<HeadlineResponse> call = service.getHeadline();
        call.enqueue(new Callback<HeadlineResponse>() {
            @Override
            public void onResponse(Call<HeadlineResponse> call, Response<HeadlineResponse> response) {


                List<HeadlineResponse.Article> prolist= response.body().getArticles();
                recyclerView.setAdapter(new HeadAdapter(MainActivity.this,prolist));
                }
                @Override
                public void onFailure(Call<HeadlineResponse> call, Throwable t) {

                    //  Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                    if (t instanceof IOException) {
                        Toast.makeText(MainActivity.this, "this is an actual network failure :( inform the user and possibly retry", Toast.LENGTH_SHORT).show();
                        // logging probably not necessary
                    }
                    else {
                        Toast.makeText(MainActivity.this, "conversion issue! big problems :(", Toast.LENGTH_SHORT).show();
                        // todo log to some central bug tracking service
                    }
                }
            });
        }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Class fragmentClass = null;
        Fragment fragment = null;

        int itemId=menuItem.getItemId();
        if (itemId == R.id.gen) {
            replacefragment(new GenFragment());

        }else if(itemId == R.id.busi){
            replacefragment(new BusFragment());
        }  else if(itemId == R.id.enter){
            replacefragment(new EnterFragment());
        }else if(itemId == R.id.helth){
            replacefragment(new HealthFragment());
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ((DrawerLayout) findViewById(R.id.drawer_layout)).closeDrawer((int) GravityCompat.START);
        return true;
    }
    private void replacefragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.flay, fragment).addToBackStack(null).commit();
    }
}

