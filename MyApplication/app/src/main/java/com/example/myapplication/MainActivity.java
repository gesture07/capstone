package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public static ArrayList<data> dataList = new ArrayList<data>();

    ListView listView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchData();

        setUpData();

        setUpList();

        setUpOnClickListener();



        /*lv_list = findViewById(R.id.lv_list);*/
        /*sv_list = findViewById(R.id.sv_list);*/

    }

    private void searchData(){
        SearchView searchView = findViewById(R.id.sv_list);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            public boolean onQueryTextSubmit(String query){
                return false;
            }
            public boolean onQueryTextChange(String newText){
                ArrayList<data> filterData = new ArrayList<>();
                for(int i = 0; i < dataList.size(); i++){
                    data data = dataList.get(i);
                    if(data.getName().toLowerCase().contains(newText.toLowerCase())){
                        filterData.add(data);
                    }
                }
                DataAdapter adapter = new DataAdapter(getApplicationContext(), 0, filterData);
                listView.setAdapter(adapter);
                return false;
            }
        });
    }


    private void setUpData(){
        data elephant = new data("0", "elephant");
        dataList.add(elephant);

        data lion = new data("1", "lion");
        dataList.add(lion);

        data monkey = new data("3", "monkey");
        dataList.add(monkey);
    }


    private void setUpList(){
        listView = findViewById(R.id.lv_list);

        DataAdapter adapter = new DataAdapter(getApplicationContext(), 0, dataList);
        listView.setAdapter(adapter);
    }


    private void setUpOnClickListener(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long I) {
                data selectdata = (data) listView.getItemAtPosition(position);
                Intent showDetail = new Intent(getApplicationContext(), DetailActivity.class);
                showDetail.putExtra("id", selectdata.getId());
                startActivity(showDetail);
            }
        });
    }

}