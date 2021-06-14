package com.example.onandroidck_sqllite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ProductAddActivity extends AppCompatActivity {
    private EditText txttype,txtPrice,txtCountry;
    private Button btnCreate,btnBack;
    private DatabaseHandler db= new DatabaseHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_addproduct);
        txttype = findViewById(R.id.txtTypeAdd);
        txttype.requestFocus();
        txtPrice = findViewById(R.id.txtPriceAdd);
        txtCountry = findViewById(R.id.txtCountryAdd);
        btnCreate = findViewById(R.id.btnCreate);
        btnBack = findViewById(R.id.btnBackAdd);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductAddActivity.this, ManagerActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addProduct(new Product(txttype.getText().toString(),Double.parseDouble(txtPrice.getText().toString()),txtCountry.getText().toString()));
                Intent intent= new Intent(ProductAddActivity.this,ListProductActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

}
