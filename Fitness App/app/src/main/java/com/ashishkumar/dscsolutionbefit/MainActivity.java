package com.ashishkumar.dscsolutionbefit;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener;
import com.ashishkumar.dscsolutionbefit.WalkandStep.utils.StepDetectionServiceHelper;
import com.ashishkumar.dscsolutionbefit.fragment.Fragment_Calculate;
import com.ashishkumar.dscsolutionbefit.fragment.Fragment_Reminder;
import com.ashishkumar.dscsolutionbefit.fragment.Fragment_Walk_and_Step;
import com.ashishkumar.dscsolutionbefit.fragment.Fragment_Workout;
import com.ashishkumar.dscsolutionbefit.fragment.MainFragment;

public class MainActivity extends AppCompatActivity implements OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigation;

    DrawerLayout drawer;
    ImageView imageView1;
    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        public boolean onNavigationItemSelected(MenuItem menuItem) {
            String str = "";
            switch (menuItem.getItemId()) {
                case R.id.navigation_home:


                    toolbar.setTitle(getString(R.string.app_name));
                    MainActivity.this.openFragment(MainFragment.newInstance(str, str,MainActivity.this));
                    return true;

                case R.id.navigation_map:
                    toolbar.setTitle("Workouts");
                    MainActivity.this.openFragment(Fragment_Workout.newInstance(str, str));
                    return true;

                case R.id.navigation_world:
                    toolbar.setTitle("Calculater");
                    MainActivity.this.openFragment(Fragment_Calculate.newInstance(str, str));
                    return true;

                case R.id.navigation_walk:
                    toolbar.setTitle("Walk & Step");
                    MainActivity.this.openFragment(Fragment_Walk_and_Step.newInstance(str, str));
                    return true;

                case R.id.navigation_news:
                    toolbar.setTitle("Reminders");
                    MainActivity.this.openFragment(Fragment_Reminder.newInstance(str, str));
                    return true;

                default:

                    return false;
            }
        }
    };

    NavigationView navigationView;
    Toolbar toolbar;


    @SuppressLint("ResourceType")
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT > 21) {
            StrictMode.setThreadPolicy(new Builder().permitAll().build());
        }
        setContentView((int) R.layout.activity_main);

//        StepDetectionServiceHelper.startAllIfEnabled(true, MainActivity.this);

        this.navigationView = (NavigationView) findViewById(R.id.nav_views);
//        bottomNavigation.setItemIconTintList(null);
        this.imageView1 = (ImageView) findViewById(R.id.setting);
        this.imageView1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
//                MainActivity.this.startActivity(new Intent(MainActivity.this, Setting_Activity.class));
            }
        });
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
//            window.setStatusBarColor(Color.parseColor("#EF5050"));
        }
        this.toolbar = initToolbar();
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.drawer = drawerLayout;
        ActionBarDrawerToggle actionBarDrawerToggle =
                new ActionBarDrawerToggle(this, drawerLayout, this.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        this.drawer.addDrawerListener(actionBarDrawerToggle);
        this.drawer.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            public void onDrawerClosed(View view) {
            }

            public void onDrawerOpened(View view) {
            }
        });
        actionBarDrawerToggle.syncState();
        this.navigationView.setNavigationItemSelectedListener(this);
        String str = "#ffffff";
//        this.toolbar.setTitleTextColor(Color.parseColor(str));
//        this.toolbar.getNavigationIcon().setColorFilter(Color.parseColor(str), Mode.MULTIPLY);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav_view);
        this.bottomNavigation = bottomNavigationView;

        bottomNavigationView.setOnNavigationItemSelectedListener(this.navigationItemSelectedListener);
        String str2 = "";

//        MainActivity mainActivity = null;
        openFragment(MainFragment.newInstance(str2 ,str2 ,this ));
       // ((AdView) findViewById(R.id.adView)).loadAd(new AdRequest.Builder().build());


    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.nav_host_fragment, fragment);
        beginTransaction.addToBackStack(null);
        beginTransaction.commit();
    }

    public void loadFragmentworkout(Fragment fragment) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.nav_host_fragment, fragment);
        beginTransaction.addToBackStack(null);
        beginTransaction.commit();
        toolbar.setTitle("workout");
        bottomNavigation.setSelectedItemId(R.id.navigation_map);
    }

    public void loadFragment_water(Fragment fragment) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.nav_host_fragment, fragment);
        beginTransaction.addToBackStack(null);
        beginTransaction.commit();
        toolbar.setTitle("Walk & Step");
        bottomNavigation.setSelectedItemId(R.id.navigation_walk);
    }

    private Toolbar initToolbar() {
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar2);


        return toolbar2;
    }

    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();

        String str = "android.intent.extra.TEXT";
        String str2 = "android.intent.extra.SUBJECT";


        if (itemId == R.id.nav_share) {

            finish();
            System.exit(0);

        }

        this.drawer.closeDrawer((int) GravityCompat.START);
        return true;
    }


    public void onBackPressed() {
        StepDetectionServiceHelper.stopAllIfNotRequired(this.getApplicationContext());
//        StepDetectionServiceHelper.startAllIfEnabled(true, MainActivity.this);

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.adview_layout_exit);
       // ((GifImageView) dialog.findViewById(R.id.GifImageView)).setGifImageResource(R.drawable.rate);
       // ((Button) dialog.findViewById(R.id.btnno)).setOnClickListener(new View.OnClickListener() {
        //    public void onClick(View view) {
         //       dialog.dismiss();
            }
       // });
       // ((Button) dialog.findViewById(R.id.btnrate)).setOnClickListener(new View.OnClickListener() {
       //     public void onClick(View view) {
        //        try {
           //         MainActivity mainActivity = MainActivity.this;
           //         mainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + MainActivity.this.getPackageName())));
           //     } catch (ActivityNotFoundException unused) {
              //      MainActivity mainActivity2 = MainActivity.this;
              //      mainActivity2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + MainActivity.this.getPackageName())));
              //  }
          //  }
       // });
      //  ((Button) dialog.findViewById(R.id.btnyes)).setOnClickListener(new View.OnClickListener() {
      //      public void onClick(View view) {
        //        dialog.dismiss();
          //      MainActivity.this.finish();
          //      System.exit(1);


        //    }
       // });
       // dialog.show();
  //  }
}
