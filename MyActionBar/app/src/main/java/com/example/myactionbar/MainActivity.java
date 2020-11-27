package com.example.myactionbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.options_menu,menu);

        MenuItem search=menu.findItem(R.id.search);

        SearchView searchView=(SearchView) search.getActionView();
        searchView.setQueryHint(getResources().getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this,query,Toast.LENGTH_SHORT).show();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu1:
                MenuFragment menuFragment=new MenuFragment();
                FragmentManager mFragmentManager=getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction=mFragmentManager.beginTransaction();

                mFragmentTransaction.replace(R.id.fragment_container,menuFragment);
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();

                return true;

            case R.id.menu2:
                Intent i=new Intent(this,MenuActivity.class);
                startActivity(i);

                return true;

            default:
                return true;
        }
    }
}
