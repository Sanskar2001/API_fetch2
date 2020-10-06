package com.san22.api_fetch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.san22.api_fetch.model.Images;
import com.san22.api_fetch.model.MyPojo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.internal.connection.RealCall;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Images> mylist = new ArrayList<>();
    rvAdapter myAdapter = new rvAdapter(MainActivity.this, mylist);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = findViewById(R.id.rv);
        ExecutorService executorService= Executors.newFixedThreadPool(4);
        Call<MyPojo> userlist = client.getService().getitems();
        userlist.enqueue(new Callback<MyPojo>() {
            @Override
            public void onResponse(Call<MyPojo> call, Response<MyPojo> response) {
                MyPojo list = response.body();

                Log.i("SUCCESS", "OK");
                setRv(rv, list.getImages());
            }

            @Override
            public void onFailure(Call<MyPojo> call, Throwable t) {
                String error = t.toString();
                Log.i("FAILURE", error);

            }
        });


    }

    private void setRv(RecyclerView rv, List<Images> list) {
        ArrayList<Images> mylist = new ArrayList();
        mylist.addAll(list);
        myAdapter.sendtoadapter(mylist);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(myAdapter);
    }
}