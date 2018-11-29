package com.example.rafavrech.saara;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    getSupportActionBar().setTitle("Home");
                    Fragment homeFragment = HomeFragment.newInstance();
                    openFragment(homeFragment);
                    return true;
                case R.id.navigation_dashboard:
                    getSupportActionBar().setTitle("Aulas");
                    Fragment aulasFragment = AulasFragment.newInstance();
                    openFragment(aulasFragment);
                    return true;
                case R.id.navigation_notifications:
                    getSupportActionBar().setTitle("Anotações");
                    Fragment anotacoesFragment = AnotacoesFragment.newInstance();
                    openFragment(anotacoesFragment);
                    return true;
            }
            return false;
        }
    };

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = findViewById(R.id.textView);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportActionBar().setTitle("Home");
        Fragment homeFragment = HomeFragment.newInstance();
        openFragment(homeFragment);
    }

}
