package com.example.a20230305501;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CarDetail extends AppCompatActivity {

    private RecyclerView carRecyclerView;
    private CarAdapter carAdapter;
    private List<Car> carList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail);

        carRecyclerView = findViewById(R.id.carRecyclerView);

        carList = new ArrayList<>();
        carList.add(new Car("2018 Volkswagen Passat", "$180/day", R.drawable.passat));
        carList.add(new Car("2023 Mercedes Vito", "$140/day", R.drawable.vito));
        carList.add(new Car("2018 Renault Clio", "$40/day", R.drawable.reno));
        carList.add(new Car("2017 Volvo", "$140/day", R.drawable.volvo));
        carList.add(new Car("2006 Audi A3", "$150/day", R.drawable.audi));



        // Adapter ve LayoutManager
        carAdapter = new CarAdapter(carList);
        carRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        carRecyclerView.setAdapter(carAdapter);
    }
}