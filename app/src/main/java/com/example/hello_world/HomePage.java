package com.example.hello_world;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager2.widget.ViewPager2;
import com.example.hello_world.bottombar.homeAdaptor;
import com.example.hello_world.databinding.ActivityHomePageBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomePage extends AppCompatActivity {
    private ViewPager2 viewPager;
    private ActivityHomePageBinding binding;
    private FloatingActionButton fab;
    private BottomNavigationView bottomNavigationView;
    private boolean isFabRotated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);

        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        binding = ActivityHomePageBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.bottomAppBar, (v, insets) -> {
            v.setPadding(0, 0, 0, 0);
            return insets;
        });

        viewPager = findViewById(R.id.viewPager);
        viewPager.setUserInputEnabled(false);
        bottomNavigationView = findViewById(R.id.nav_view);
        fab = findViewById(R.id.fab);

        // Setup ViewPager
        homeAdaptor adapter = new homeAdaptor(this);
        viewPager.setAdapter(adapter);

        // Sync ViewPager with BottomNavigationView
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.list) {
                viewPager.setCurrentItem(0, false);
                return true;
            } else if (item.getItemId() == R.id.infoButton) {
                viewPager.setCurrentItem(1, false);

                Intent intent=new Intent(HomePage.this, info.class);
                startActivity(intent);
                return true;
            }
            return false;
        });

        // FAB Click - goes to first page (doesn't rotate)
        fab.setOnClickListener(v -> {
            viewPager.setCurrentItem(0, true);
        });

        // FAB Long Click - rotates 180 degrees and shows popup
        fab.setOnLongClickListener(v -> {
            // Rotate the FAB 180 degrees
            rotateFab();

            // Show popup menu with 4 options
            showPopupMenu();

            return true;
        });

        // Sync BottomNavigation when swiping ViewPager
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        viewPager.getCurrentItem();
                        break;
                    case 1:
                        viewPager.getCurrentItem();
                        break;
                }
            }
        });
    }

    // Method to rotate the FAB 180 degrees
    private void rotateFab() {
        float targetRotation = isFabRotated ? 0f : 180f;

        ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(fab, "rotation",
                fab.getRotation(), targetRotation);
        rotationAnimator.setDuration(300);
        rotationAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        rotationAnimator.start();

        isFabRotated = !isFabRotated;
    }

    // Method to show popup menu with 4 options
    private void showPopupMenu() {
        PopupMenu popup = new PopupMenu(HomePage.this, fab);
        popup.getMenuInflater().inflate(R.menu.attendance_menu, popup.getMenu());

        popup.setOnMenuItemClickListener(item -> {
            int id = item.getItemId();

            if (id == R.id.menu_leave) {
                Toast.makeText(HomePage.this, "Leave", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomePage.this, fab_leave.class);
                startActivity(intent);
                return true;
            } else if (id == R.id.menu_obt) {
                Toast.makeText(HomePage.this, "OBT", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(HomePage.this, fab_obt.class);
                startActivity(intent);

                return true;



            } else if (id == R.id.menu_offset) {
                Toast.makeText(HomePage.this, "OFF Set", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomePage.this, Off_Set.class);
                startActivity(intent);

                return true;
            } else if (id == R.id.menu_ot) {
                Toast.makeText(HomePage.this, "Overtime", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(HomePage.this, fab_overtime.class);
                startActivity(intent);
                return true;
            }
            return false;
        });

        // Dismiss the popup and rotate back when dismissed
        popup.setOnDismissListener(menu -> {
            // Rotate back to original position if it's rotated
            if (isFabRotated) {
                rotateFab();
            }
        });

        popup.show();
    }

    // Optional: Reset rotation when activity is paused
    @Override
    protected void onPause() {
        super.onPause();
        // Reset rotation to 0 when activity is paused
        if (isFabRotated) {
            fab.setRotation(0f);
            isFabRotated = false;
        }
    }
}