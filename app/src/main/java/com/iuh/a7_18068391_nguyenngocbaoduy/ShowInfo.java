package com.iuh.a7_18068391_nguyenngocbaoduy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ShowInfo extends AppCompatActivity {
    RecyclerView rcvEmployee;
    List<Employee> employees;
    EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);
        rcvEmployee = findViewById(R.id.rcvEmployee);
        employees = new ArrayList<>();
        String url = "https://60b4fcd3fe923b0017c83616.mockapi.io/api/employees";
        showEmployee(url);

    }

    private void showEmployee(String url) {

        JsonArrayRequest  jsonArrayRequest =new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = response.getJSONObject(i);
                        Employee employee = new Employee(object.getInt("id"), object.getString("name").toString(), object.getInt("age"), object.getString("detail").toString());
                        employees.add(employee);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                rcvEmployee.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new EmployeeAdapter(getApplicationContext(),employees);
                rcvEmployee.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ShowInfo.this, "Error by Json Object....", Toast.LENGTH_SHORT).show();
            }
    });
        RequestQueue queue = Volley.newRequestQueue(this);
    queue.add(jsonArrayRequest);
    }
}