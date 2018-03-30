package com.example.pstrycz.bottomnav;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.pstrycz.bottomnav.databinding.ActivityMainBinding;
import com.example.pstrycz.bottomnav.fragments.First;
import com.example.pstrycz.bottomnav.fragments.Second;
import com.example.pstrycz.bottomnav.fragments.Third;

import static android.support.v4.app.FragmentManager.POP_BACK_STACK_INCLUSIVE;
import static android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Fragment first = First.newInstance();
    private Fragment second = Second.newInstance();
    private Fragment third = Third.newInstance();

    String NON_ROOT_FRAGMENT_TAG = "NON_ROOT_FRAGMENT_TAG";

    OnNavigationItemSelectedListener onNavigationItemSelectedListener = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                goBackToHomeFragment();
                return true;
            case R.id.navigation_dashboard:
                replaceFragment(second);
                return true;
            case R.id.navigation_notifications:
                replaceFragment(third);
                return true;
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setSupportActionBar(binding.toolbar);
        binding.navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        replaceFragment(first);
    }

    private void replaceFragment(Fragment fragment) {

        if (!fragment.isAdded()) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .addToBackStack(NON_ROOT_FRAGMENT_TAG)
                    .setTransition(TRANSIT_FRAGMENT_OPEN)
                    .commit();
        }
    }

    private void setBottomNavItemSelected(int i) {
        binding.navigation.getMenu().getItem(0).setChecked(true);
    }

    private void goBackToHomeFragment() {

        getSupportFragmentManager().popBackStackImmediate(NON_ROOT_FRAGMENT_TAG, POP_BACK_STACK_INCLUSIVE);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, first)
                .commit();

        setBottomNavItemSelected(0);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            goBackToHomeFragment();
        } else {
            super.onBackPressed();
        }
    }
}
