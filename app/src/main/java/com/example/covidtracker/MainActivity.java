package com.example.covidtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.covidtracker.api.Apiutility;
import com.example.covidtracker.api.CountryData;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.lang.Long.parseLong;

public class MainActivity extends AppCompatActivity {
    private TextView totalConfirm,todayConfirm,active,recover,toadyRecover,todayDeath,totalDeath,tests;
    public  TextView dateTV;



    private List<CountryData> list;
    private PieChart pieChart;
    String country = "India";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();



        if (getIntent().getStringExtra("country") != null)
            country =getIntent().getStringExtra("country");


        init();

        TextView cname = findViewById(R.id.cname);
        cname.setText(country);

        cname.setOnClickListener(v->{
            startActivity(new Intent(MainActivity.this,CountryActivity.class));
        });

//       TextView cname = (TextView) findViewById(R.id.cname);
//        cname.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,CountryActivity.class);
//                startActivity(intent);
//            }
//        });
//




        Apiutility.getApiInterface().getCountryData()
                .enqueue(new Callback<List<CountryData>>() {
                    @Override
                    public void onResponse(Call<List<CountryData>>call, Response<List<CountryData>>response) {
                        assert response.body() != null;
                        list.addAll(response.body());

                        int i;
                        for(i = 0; i<list.size(); i++)
                         if (list.get(i).getCountry().equals(country)) {
                             int confirm = Integer.parseInt(list.get(i).getCases());
                             int totalactive = Integer.parseInt(list.get(i).getActive());
                             int totalrecover = Integer.parseInt(list.get(i).getRecovered());
                             int deaths = Integer.parseInt(list.get(i).getDeaths());


                             totalConfirm.setText(NumberFormat.getInstance().format(confirm));
                             totalDeath.setText(NumberFormat.getInstance().format(deaths));
                             active.setText(NumberFormat.getInstance().format(totalactive));
                             recover.setText(NumberFormat.getInstance().format(totalrecover));


                             todayDeath.setText(NumberFormat.getInstance().format(Integer.parseInt(list.get(i).getTodayDeaths())));
                             todayConfirm.setText(NumberFormat.getInstance().format(Integer.parseInt(list.get(i).getTodayCases())));
                             toadyRecover.setText(NumberFormat.getInstance().format(Integer.parseInt(list.get(i).getTodayRecovered())));
                             tests.setText(NumberFormat.getInstance().format(Integer.parseInt(list.get(i).getTests())));


                             setText(list.get(i).getUpdate());

                             pieChart.addPieSlice(new PieModel("Confirm", confirm, getResources().getColor(R.color.yellow)));
                             pieChart.addPieSlice(new PieModel("Active", totalactive, getResources().getColor(R.color.blue_pie)));
                             pieChart.addPieSlice(new PieModel("recover", totalrecover, getResources().getColor(R.color.green_pie)));
                             pieChart.addPieSlice(new PieModel("Deaths", deaths, getResources().getColor(R.color.red_pie)));

                         }
                    }

                    private void setText(String update) {
                        DateFormat format = new SimpleDateFormat(" MMM , dd , yyyy");

                       long millisecond = parseLong(update);
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(millisecond);
                        dateTV.setText("Updated at "+format.format(calendar.getTime()));
                    }

                    @Override
                    public void onFailure(Call<List<CountryData>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Error : "+t.getMessage() , Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void init() {
        totalConfirm = findViewById(R.id.totalConfirm);
        todayConfirm = findViewById(R.id.todayConfirm);
        active = findViewById(R.id.active);
        recover = findViewById(R.id.recover);
        toadyRecover = findViewById(R.id.todayRecover);
        todayDeath = findViewById(R.id.death);
        totalDeath= findViewById(R.id.todayDeath);
        tests= findViewById(R.id.tests);
        pieChart = findViewById(R.id.piechart);
        dateTV = findViewById(R.id.dates);
    }

}