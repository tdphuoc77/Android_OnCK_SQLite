package com.example.onandroidck_sqllite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListProductActivity extends AppCompatActivity {
    private RecyclerView recycle;
    private ListProductAdaper adapter;

    public static ArrayList<Product> arraylist= new ArrayList<Product>();
    private Button btnBack;
    private List<Product> list= new ArrayList<Product>();
    private DatabaseHandler db= new DatabaseHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_listitem);
        recycle = findViewById(R.id.recycler);

        list=db.getAll();

        adapter=  new ListProductAdaper(ListProductActivity.this,list);
        LinearLayoutManager manager= new LinearLayoutManager(this);
        recycle.setLayoutManager(manager);
        recycle.setAdapter(adapter);


        btnBack= findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ListProductActivity.this,ManagerActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
