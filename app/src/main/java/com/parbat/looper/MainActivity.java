package com.parbat.looper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView)this.findViewById(R.id.myListView);
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,getData()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(position ==0) {
                    new ThreadLooper().runOtherLoop();
                }else if(position ==1){
                    new MainLooper().LooperMain();
                }else if(position ==2){
                    new MainLooper2().LooperMain();
                }
            }
        });
    }

    public List<String> getData(){
        List<String> list = new ArrayList<String>();
        list.add("ThreadLoop");
        list.add("mainThreadLoop");
        list.add("handleMessage");
        return list;
    }



}
