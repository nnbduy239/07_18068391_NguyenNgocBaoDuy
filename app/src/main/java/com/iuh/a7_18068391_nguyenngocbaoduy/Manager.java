package com.iuh.a7_18068391_nguyenngocbaoduy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Manager extends AppCompatActivity {
    Button btnShow,btnAdd,btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        btnShow = (Button)findViewById(R.id.btnShow);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnLogout =(Button)findViewById(R.id.btnLogout);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Manager.this,AddInfo.class);
                startActivity(intent);
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Manager.this,ShowInfo.class);
                startActivity(intent);
            }
        });
    }
}