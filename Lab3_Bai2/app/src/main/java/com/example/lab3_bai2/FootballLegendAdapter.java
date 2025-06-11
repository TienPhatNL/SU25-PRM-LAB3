package com.example.lab3_bai2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FootballLegendAdapter extends ArrayAdapter<FootballLegend> {
    private final Context context;
    private final List<FootballLegend> legends;

    public FootballLegendAdapter(Context context, int resource, List<FootballLegend> legends) {
        super(context, resource, legends);
        this.context = context;
        this.legends = legends;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item_legend, parent, false);
        }

        FootballLegend legend = legends.get(position);

        ImageView imgProfile = view.findViewById(R.id.imgProfile);
        ImageView imgFlag = view.findViewById(R.id.imgFlag);
        TextView txtName = view.findViewById(R.id.txtName);
        TextView txtBirthDate = view.findViewById(R.id.txtBirthDate);

        imgProfile.setImageResource(legend.getProfileImageResId());
        imgFlag.setImageResource(legend.getCountryFlagResId());
        txtName.setText(legend.getName());
        txtBirthDate.setText(legend.getBirthDate());

        return view;
    }
}