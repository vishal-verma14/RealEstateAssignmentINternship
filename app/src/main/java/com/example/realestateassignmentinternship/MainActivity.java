package com.example.realestateassignmentinternship;

import android.os.Bundle;

import com.example.realestateassignmentinternship.Adapter.ResultAdapter;
import com.example.realestateassignmentinternship.Interface.ApiInterface;
import com.example.realestateassignmentinternship.Model.M_Model;
import com.example.realestateassignmentinternship.Model.Name;
import com.example.realestateassignmentinternship.Model.Result;
import com.example.realestateassignmentinternship.api_Call.ApiClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


     RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        callApi();

    }

    private void callApi() {

        ApiInterface apiCall = ApiClient.getClient().create(ApiInterface.class);

        Call<M_Model> call = apiCall.getData();

        call.enqueue(new Callback<M_Model>() {
            @Override
            public void onResponse(Call<M_Model> call, Response<M_Model> response) {
                List<Result> s = response.body().getResults();

                recyclerView.setAdapter(new ResultAdapter(s, R.layout.item, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<M_Model> call, Throwable t) {
                Log.e(MainActivity.this.getLocalClassName(), t.toString());
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
