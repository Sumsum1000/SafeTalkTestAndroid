package com.example.safetalk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.safetalk.Item;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private TextView tvText;
    private Item item;
    private ArrayAdapter<String> arrayAdapter;
    private ListView listView;
    public ArrayList<Item> arrayList;
    ItemArrayAdaper itemAdapter;
    //private ArrayList<String> tasksList = new ArrayList<>();
    //private ArrayList<String> tasksList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.list_view);

        arrayList = new ArrayList<>();
        //arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, tasksList);
        itemAdapter = new ItemArrayAdaper(this, R.layout.activity_custom_item, arrayList);
        //listView.setAdapter(arrayAdapter);
        listView.setAdapter(itemAdapter);

        getRequest();
    }

    private void getRequest() {
        RetrofitClient.getRetrofitClient().getTasks().enqueue(new Callback<TaskResponse>() {
            @Override
            public void onResponse(Call<TaskResponse> call, Response<TaskResponse> response) {
                if (response.isSuccessful()) {
                    List<Item> tasks = response.body().getTasks();
                    for (Item task : tasks) {
                        arrayList.add(new Item(task + ""));


                        //tasksList.add(task.getText());
                    }
                    //arrayAdapter.notifyDataSetChanged();
                    itemAdapter.notifyDataSetChanged();
                } else {
                    Log.e("API_ERROR", "Failed to fetch tasks: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<TaskResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void deleteItemById(int id) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getId() == id) {
                arrayList.remove(i);
                itemAdapter.notifyDataSetChanged();
                break;
            }
        }
    }

}