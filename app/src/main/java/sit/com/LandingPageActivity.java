package sit.com;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import sit.com.fragments.CalculatorFragment;
import sit.com.fragments.WebViewFragment;

public class LandingPageActivity extends AppCompatActivity {

    FragmentDrawer drawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        //intent.getStringExtra("test");
        setContentView(R.layout.ac_landing_page);
        Toolbar mToolbar = findViewById(R.id.toolbar);
        drawerFragment = (FragmentDrawer) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        //drawerFragment.setDrawerListener(this);
        switchFragment();
    }

    public void switchFragment() {
       CalculatorFragment calculatorFragment = CalculatorFragment.newInstance("Calculator", "");
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, calculatorFragment, calculatorFragment.getClass().getSimpleName());
        fragmentTransaction.commit();
    }
}
