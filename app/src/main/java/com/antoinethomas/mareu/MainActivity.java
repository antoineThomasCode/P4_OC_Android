package com.antoinethomas.mareu;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.antoinethomas.mareu.databinding.ActivityMainBinding;
import com.antoinethomas.mareu.ui.addMeeting.AddMeetingFragment;
import com.antoinethomas.mareu.ui.meetingList.MeetingListFragment;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fabAddMeeting.setOnClickListener(view -> onFabButtonClicked());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void onFabButtonClicked() {
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_content_main);
        Fragment currentFragment = navHostFragment.getChildFragmentManager().getPrimaryNavigationFragment();
        if (currentFragment != null ) {

            if (currentFragment instanceof AddMeetingFragment) {
                ((AddMeetingFragment)currentFragment).createNewMeeting();
            } else if (currentFragment instanceof MeetingListFragment) {
                Navigation.findNavController(this, R.id.nav_host_fragment_content_main)
                        .navigate(R.id.action_FirstFragment_to_addMeetingFragment);
            }
        }

    }


}
