package com.example.firebasepreoject;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private SearchView searchView;
    private Intent intent;
    private Button searchbutton;
    private TextView destinationtext,noloc;
    private ImageView icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Hotel");

        listView = findViewById(R.id.listviewId);
        searchView = findViewById(R.id.searchviewId);
        searchbutton = findViewById(R.id.searchbuttonId);
        destinationtext = findViewById(R.id.destinationId);
        icon = findViewById(R.id.iconId);

        final String[] districtNames = getResources().getStringArray(R.array.district_name);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.list_view,R.id.listId,districtNames);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                if(newText.length() > 0){
                    listView.setVisibility(View.VISIBLE);
                    searchbutton.setVisibility(View.GONE);
                    icon.setVisibility(View.GONE);
                    destinationtext.setVisibility(View.GONE);
                }
                else{
                    listView.setVisibility(View.GONE);
                    searchbutton.setVisibility(View.VISIBLE);
                    icon.setVisibility(View.VISIBLE);
                    destinationtext.setVisibility(View.VISIBLE);
                }
                return false;
            }
        });

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String value = adapter.getItem(position);
                if(value.equals("Bagerhat")) {
                    intent = new Intent(MainActivity.this,KhulnaActivity.class);
                    intent.putExtra("location", "Bagerhat");
                    startActivity(intent);
                }
                if(value.equals("Dhaka")) {
                    intent = new Intent(MainActivity.this,KhulnaActivity.class);
                    intent.putExtra("location", "Dhaka");
                    startActivity(intent);
                }
                if(value.equals("Jashore")) {
                    intent = new Intent(MainActivity.this,JashoreActivity.class);
                    intent.putExtra("location", "Jashore");
                    startActivity(intent);
                }
                if(value.equals("Khulna")) {
                    intent = new Intent(MainActivity.this,KhulnaActivity.class);
                    intent.putExtra("location", "Khulna");
                    startActivity(intent);
                }
                if(value.equals("Kushtia")) {
                    intent = new Intent(MainActivity.this,KhulnaActivity.class);
                    intent.putExtra("location", "Kushtia");
                    startActivity(intent);
                }
                if(value.equals("Satkhira")) {
                    intent = new Intent(MainActivity.this,KhulnaActivity.class);
                    intent.putExtra("location", "Satkhira");
                    startActivity(intent);
                }
            }
        });
    }


}
