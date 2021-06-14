package com.example.onandroidck_sqllite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ManagerActivity extends AppCompatActivity {
    private Button btnShow,btnAddProduct,btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_manager);

        btnShow=findViewById(R.id.btnShow);
        btnAddProduct=findViewById(R.id.btnAddProduct);
        btnLogout =findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ManagerActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ManagerActivity.this, ProductAddActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ManagerActivity.this, ListProductActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
