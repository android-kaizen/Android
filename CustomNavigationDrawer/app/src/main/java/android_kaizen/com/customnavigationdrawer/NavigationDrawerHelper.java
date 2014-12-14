package android_kaizen.com.customnavigationdrawer;

import android.app.ActionBar;
import android.app.Activity;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import android_kaizen.com.customnavigationdrawer.model.ObjectDrawerItem;

/**
 * Created by Andy on 10-Dec-14.
 */
public class NavigationDrawerHelper {

    DrawerLayout mDrawerLayout;
    ListView mDrawerListView;
    private ActionBarDrawerToggle mDrawerToggle;


    // Method to initialize our NavigationDrawer from the hosting Activity.
    // We pass the Activity and the OnItemClickListener
    public void init(Activity activity, ListView.OnItemClickListener listener) {

        // We define our constant variables
        mDrawerLayout = (DrawerLayout) activity.findViewById(R.id.drawer_layout);
        mDrawerListView = (ListView) activity.findViewById(R.id.left_drawer);

        // List the Drawer Items
        ObjectDrawerItem[] drawerItem = new ObjectDrawerItem[4];

        drawerItem[0] = new ObjectDrawerItem(R.drawable.ic_action_email, "Email");
        drawerItem[1] = new ObjectDrawerItem(R.drawable.ic_action_web_site, "Web");
        drawerItem[2] = new ObjectDrawerItem(R.drawable.ic_action_headphones, "Music");
        drawerItem[3] = new ObjectDrawerItem(R.drawable.ic_action_settings, "Settings");


        // Declare a new instance of our Custom drawer Adapter
        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(activity, R.layout.listview_drawer_item_row, drawerItem);

        // Set the Adapter and the Listener on the ListView
        mDrawerListView.setAdapter(adapter);
        mDrawerListView.setOnItemClickListener(listener);

        // Set shadow and the default item selected in the ListView to be the first one
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        mDrawerListView.setItemChecked(0,true);

        // Call the next method
        setupActionBar(activity);
    }

    // This method to setup the ActionBar and enable the toggle
    // (opening/closing) of the drawer when the User taps the Menu Icon.
    private void setupActionBar(final Activity theActivity) {
        final Activity activity = theActivity;

        ActionBar actionBar = theActivity.getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        mDrawerToggle = new ActionBarDrawerToggle(
                theActivity,
                mDrawerLayout,
                R.drawable.ic_drawer,
                R.string.DrawerOpen,
                R.string.DrawerClosed
        ){
            @Override
            public void onDrawerOpened(View drawerView) {
                activity.invalidateOptionsMenu();
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                activity.invalidateOptionsMenu();
                super.onDrawerClosed(drawerView);
            }
        };

    }

    // To highlight at selection, the list item selected and close the Drawer
    // Will be called in the OnItemClick() method of the hosting Activity
    public void handleSelect(int option) {
        mDrawerListView.setItemChecked(option,true);
        mDrawerLayout.closeDrawer(mDrawerListView);

    }

    // It checks if the Drawer is Open and it loops through the Menu option and disables all of them.
    // If the Drawer is closed, it enables all of them
    public void handleOnPrepareOptionMenu(Menu menu) {
        boolean itemVisible = !mDrawerLayout.isDrawerOpen(mDrawerListView);
        for (int index = 0; index < menu.size(); index++) {
            MenuItem item = menu.getItem(index);
            item.setEnabled(itemVisible);
        }

    }

    // To delegate the Open/Close when the User taps the menu icon
    public void handleOnOptionsItemSelected(MenuItem menuItem) {
        mDrawerToggle.onOptionsItemSelected(menuItem);

    }

    // Tells the Drawer Toggle to check everything is checked and layed out the way it should be after configuration change
    public void syncState() {
        mDrawerToggle.syncState();
    }

    public void setSelection(int option) {
        mDrawerListView.setItemChecked(option,true);
    }

}
