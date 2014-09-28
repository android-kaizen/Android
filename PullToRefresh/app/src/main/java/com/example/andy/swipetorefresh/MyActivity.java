package com.example.andy.swipetorefresh;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MyActivity extends Activity {

    // Define the Constants
    SwipeRefreshLayout swipeLayout;
    ListView listView;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Set our dummy data
        final String[] array = new String[]{"Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2"};

        // Inflate our ListView with the dummy data
        List<String> arrayList = new ArrayList<String>(Arrays.asList(array));
        listView = (ListView) findViewById(R.id.listview);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);

        // Get the reference to our SwipeLayout and set some colors for the animation
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        swipeLayout.setColorScheme(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        // Set a Listener on the SwipeLayout
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Begin animation
                swipeLayout.setRefreshing(true);
                Toast.makeText(getApplicationContext(), getString(R.string.Toast), Toast.LENGTH_LONG).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Call the method that updates our ListView
                        updateListView();
                        // Stop the animation
                        swipeLayout.setRefreshing(false);
                        Toast.makeText(getApplicationContext(), "List Updated", Toast.LENGTH_LONG).show();
                    }
                 // Below is the duration of the animation
                }, 5000);
            }

            // Method updating the ListView
            private void updateListView() {
                final String[] array = new String[]{"Afghanistan",
                        "Albania", "Algeria", "American Samoa", "Andorra", "Angola",
                        "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina",
                        "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan",
                        "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus",
                        "Belgium", "Belize", "Benin", "Bermuda", "Bhutan",
                        "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil",
                        "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi",
                        "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands",
                        "Central African Republic", "Chad", "Chile", "China",
                        "Christmas Island", "Cocos (Keeling) Islands", "Colombia",
                        "Comoros", "Democratic Republic of the Congo (Kinshasa)",
                        "Congo, Republic of Brazzaville", "Cook Islands", "Costa Rica",
                        "Ivory Coast", "Croatia", "Cuba", "Cyprus", "Czech Republic",
                        "Denmark", "Djibouti", "Dominica", "Dominican Republic",
                        "East Timor (Timor-Leste)", "Ecuador", "Egypt",
                        "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia",
                        "Falkland Islands", "Faroe Islands", "Fiji", "Finland", "France"};

                adapter.clear();
                adapter.addAll(array);
                adapter.notifyDataSetChanged();
            }

        });
    }
}
