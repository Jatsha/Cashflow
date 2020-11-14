package com.example.foodtracker.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodtracker.R;
import com.example.foodtracker.objects.CEntry;
import com.example.foodtracker.util.MyAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class CashList extends AppCompatActivity implements CItemDialog.CItemDialogListener{
    private double sum;
    private RecyclerView recyclerView;
    private TextView textView_sum;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager layoutManager;
    ArrayList<CEntry> itemList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.cash_list);
        sum = 0;
        recyclerView = (RecyclerView) findViewById(R.id.first_recycler_view);
        textView_sum = (TextView) findViewById(R.id.textview_sum);
        FloatingActionButton fab = findViewById(R.id.fabAddElement);

        layoutManager = new LinearLayoutManager(CashList.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.recyclerview_deco));
        recyclerView.addItemDecoration(dividerItemDecoration);

        CEntry cEntry = new CEntry("Test",47123.43);
        CEntry cEntry1 = new CEntry("Ausgabe", 47);
        CEntry cEntry2 = new CEntry("239ajikowdoiajsdoiajwoidjhasudhiahbwdibabsjdbiajwbdiajbsdhahdiauhsiudgauhdwoiasdudhaiuhwdiahsdiuhawodhaosihjdoaiwdoiausdohaoiwdhjaishdoiawdihasuhdahdbzhadgbaasdadawdsadwasdadsadwasdadw",467273.92);
        itemList.add(cEntry);
        itemList.add(cEntry1);
        itemList.add(cEntry2);
        mAdapter = new MyAdapter(itemList);
        recyclerView.setAdapter(mAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEntryDialog();
                mAdapter = new MyAdapter(itemList);
                recyclerView.setAdapter(mAdapter);

            }
        });
    }

    public void openEntryDialog(){
        CItemDialog cItemDialog = new CItemDialog();
        cItemDialog.show(getSupportFragmentManager(), "Test");

    }

    @Override
    public void addItem(String name, String price) {
        double p = Double.parseDouble(price);
        CEntry n = new CEntry(name, p);
        itemList.add(n);
        sum = sum + p;
        textView_sum.setText(String.valueOf(sum));
    }
}
