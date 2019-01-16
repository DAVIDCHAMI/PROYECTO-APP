package com.example.u12.mydetailproduct.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.u12.mydetailproduct.R;
import com.example.u12.mydetailproduct.models.Product;

public class DetailActivity extends AppCompatActivity {

    private Product product;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getIntent().getSerializableExtra("product");

        product= (Product) getIntent().getSerializableExtra("product");


    }
}
