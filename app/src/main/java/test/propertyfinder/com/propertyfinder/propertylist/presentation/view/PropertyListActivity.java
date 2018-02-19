package test.propertyfinder.com.propertyfinder.propertylist.presentation.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import common.ActivityUtils;
import common.Injector;
import test.propertyfinder.com.propertyfinder.R;
import test.propertyfinder.com.propertyfinder.propertylist.presentation.presenter.PropertyListPresenter;

public class PropertyListActivity extends BaseActivity {

    PropertyListPresenter presenter;

    Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.property_list_title));
        setSupportActionBar(toolbar);

        PropertyListFragment propertyListFragment = (PropertyListFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (propertyListFragment == null) {
            // Create the fragment
            propertyListFragment = PropertyListFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), propertyListFragment, R.id.contentFrame, PropertyListFragment.TAG);
        }

        // Create the presenter
        presenter = new PropertyListPresenter(propertyListFragment, Injector.providePropertyDataSource(getApplicationContext()));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_property_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sort:

                // Create the fragment
                SortFragment sortFragment = SortFragment.newInstance();
                ActivityUtils.addFragmentToActivityAnimated(getSupportFragmentManager(), sortFragment, R.id.contentFrame, SortFragment.TAG);

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }
}
