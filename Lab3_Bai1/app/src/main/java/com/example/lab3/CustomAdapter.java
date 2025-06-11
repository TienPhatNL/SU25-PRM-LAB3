package com.example.lab3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final List<String> items;

    public CustomAdapter(Context context, int resource, List<String> items) {
        super(context, resource, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_list_item, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.textViewItem);
        TextView textViewIndex = convertView.findViewById(R.id.textViewIndex);

        textView.setText(items.get(position));
        textViewIndex.setText(String.valueOf(position + 1));

        return convertView;
    }
}