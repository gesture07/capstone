package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.List;

public class DataAdapter extends ArrayAdapter<data> {

    public DataAdapter(Context context, int resource, List<data> dataList){
        super(context, resource, dataList);
    }
    public View getView(int position, @Nullable View convertView,@Nullable ViewGroup parent){
        data data = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.data_item, parent, false);
        }
        TextView tv = convertView.findViewById(R.id.data_name);

        tv.setText(data.getName());

        return convertView;
    }
}
