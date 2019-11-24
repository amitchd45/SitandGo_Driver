package com.example.Activities;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.connekma_driver.R;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "HomeActivity";

    final Context context = this;
    ImageView mOpenSideNavigation;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    SwitchCompat mSwitchCompat;
    TextView mStatus;
    ImageButton mGetLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mGetLocation = findViewById(R.id.btn_current_location_search);
        mGetLocation.setOnClickListener(view -> {
            RequestDialog();
        });

        mStatus = findViewById(R.id.tv_driver_status);
        mStatus.setText("online");
        mSwitchCompat = findViewById(R.id.sc_switch);
        mSwitchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if(isChecked) {
                    Toast.makeText(HomeActivity.this, "ON", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(HomeActivity.this, "OFF", Toast.LENGTH_SHORT).show();
                }

            }
        });


        mOpenSideNavigation = findViewById(R.id.iv_drawer_icon);
        mOpenSideNavigation.setOnClickListener(view -> {
            drawerLayout.openDrawer(GravityCompat.START);
        });

        drawerLayout = findViewById(R.id.drawer_layout);


        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.getMenu().getItem(0).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(1).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(2).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(3).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(4).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(4).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(5).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(6).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(7).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(8).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(9).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(10).setActionView(R.layout.menu_image);

    }

    @Override
    public boolean onNavigationItemSelected(@Nullable MenuItem menuItem) {


        switch (menuItem.getItemId()) {

            case R.id.nav_profile: {
                Intent profile_intent = new Intent(HomeActivity.this, MyProfileActivity.class);
                startActivity(profile_intent);
                break;
            }
            case R.id.nav_trips: {

                Intent trips_intent = new Intent(HomeActivity.this, TripsActivity.class);
                startActivity(trips_intent);
                break;
            }
            case R.id.nav_payment: {
                Intent payment_intent = new Intent(HomeActivity.this, MyWalletActivity.class);
                startActivity(payment_intent);
                break;
            }

            case R.id.nav_booking: {
                Intent bookings_intent = new Intent(HomeActivity.this, MyBookingsActivity.class);
                startActivity(bookings_intent);
                break;
            }

            case R.id.nav_invite_friend: {
                Intent invite_intent = new Intent(HomeActivity.this, InviteFriendsActivity.class);
                startActivity(invite_intent);
                break;
            }

            case R.id.nav_feedback: {
                Intent invite_intent = new Intent(HomeActivity.this, RiderFeedbackActivity.class);
                startActivity(invite_intent);
                break;
            }

            case R.id.nav_setting: {
                Intent settings_intent = new Intent(HomeActivity.this, SettingsActivity.class);
                startActivity(settings_intent);
                break;
            }

            case R.id.nav_contact: {
                Intent contact_intent = new Intent(HomeActivity.this, ContactActivity.class);
                startActivity(contact_intent);
                break;
            }

            case R.id.nav_emergency: {
                CallingDialog();
                break;
            }

            case R.id.nav_help: {
                Intent help_intent = new Intent(HomeActivity.this, HelpActivity.class);
                startActivity(help_intent);
                break;
            }

            case R.id.nav_logout: {
                Toast.makeText(context, "Logout ...", Toast.LENGTH_SHORT).show();
                break;
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {

        drawerLayout = findViewById(R.id.drawer_layout);

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();
        }

    }

    private void RequestDialog() {

        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.request_dialog);

        Button mCancel = dialog.findViewById(R.id.btn_cancel);
        Button mAcept = dialog.findViewById(R.id.btn_accept);
        dialog.setCanceledOnTouchOutside(false);

        mAcept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Accept", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Cancel", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.show();

    }

    private void CallingDialog() {

        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.calling_dialog);

        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);

        ImageView dialogButton = (ImageView) dialog.findViewById(R.id.make_call);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                if(isPermissionGranted()){

                    makeCall();
                    Toast.makeText(context, "callCheck", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });

        dialog.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void makeCall() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + 198));
        if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(callIntent);
    }

    public  boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG","Permission is granted");
                return true;
            } else {

                Log.v("TAG","Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v("TAG","Permission is granted");
            return true;
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {

            case 1: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_SHORT).show();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        makeCall();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }


        }
    }

}
