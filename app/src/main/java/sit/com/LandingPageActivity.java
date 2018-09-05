package sit.com;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import sit.com.fragments.CalculatorFragment;
import sit.com.fragments.ComingSoonFragment;
import sit.com.fragments.WebViewFragment;

public class LandingPageActivity extends AppCompatActivity implements FragmentDrawer.OnDrawerListener{

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
        drawerFragment.setOnDrawerListener(this);
    }

    public void switchFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment, fragment.getClass().getSimpleName());
        fragmentTransaction.commit();
    }

    @Override
    public void onDrawerItemClick(String menu, int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = WebViewFragment.newInstance();
                break;
            case 1:
                fragment = CalculatorFragment.newInstance("Calculator", "");
                break;
            default:
                fragment = ComingSoonFragment.newInstance();
                break;
        }
        switchFragment(fragment);
    }
}
