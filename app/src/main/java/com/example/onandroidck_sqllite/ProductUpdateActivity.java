package com.example.onandroidck_sqllite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ProductUpdateActivity extends AppCompatActivity {
    private EditText txttype,txtPrice,txtCountry;
    private Button btnUpdate,btnBack;
    private DatabaseHandler db= new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_update);
        txttype = findViewById(R.id.txtTypeUpdate);
        txttype.requestFocus();
        txtCountry = findViewById(R.id.txtCountryUpdate);
        txtPrice = findViewById(R.id.txtPriceUpdate);
        btnUpdate = findViewById(R.id.btnUpdateSave);
        btnBack = findViewById(R.id.btnBackUpdate);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("BUNDLE");
        int id = bundle.getInt("id");
        Product product= db.getProductByID(id);
        txttype.setText(product.getType());
        txtPrice.setText(String.valueOf(product.getPrice()));
        txtCountry.setText(product.getCountry());
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListProductActivity.arraylist.clear();
                Intent intent1= new Intent(ProductUpdateActivity.this,ListProductActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product.setType(txttype.getText().toString());
                product.setPrice(Double.parseDouble(txtPrice.getText().toString()));
                product.setCountry(txtCountry.getText().toString());
                db.updateProduct(product);
                Intent intent= new Intent(ProductUpdateActivity.this,ListProductActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
