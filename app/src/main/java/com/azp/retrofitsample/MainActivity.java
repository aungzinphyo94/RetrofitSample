package com.azp.retrofitsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.azp.retrofitsample.adapter.UserAdapter;
import com.azp.retrofitsample.api.ApiInterface;
import com.azp.retrofitsample.model.Users;
import com.azp.retrofitsample.utils.ApiUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private UserAdapter userAdapter;
    private RecyclerView recyclerView;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = ApiUtils.getApi();

        Call<List<Users>> getUsers = apiInterface.getAllUsers();

        getUsers.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                loadUserList(response.body());
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Unable to load users", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void loadUserList(List<Users> usersList) {

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        userAdapter = new UserAdapter(usersList);
        recyclerView.setAdapter(userAdapter);
    }
}
