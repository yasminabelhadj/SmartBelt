package com.example.hp.ournetwork;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class EvtAdapter extends ArrayAdapter<evt> {

    public EvtAdapter(Context context, List<evt> evts) {
        super(context, 0, evts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.evaynet,parent, false);
        }

        EvtViewHolder viewHolder = (EvtViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new EvtViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.date = (TextView) convertView.findViewById(R.id.date);
            viewHolder.photo = (ImageView) convertView.findViewById(R.id.photo);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        evt evt = getItem(position);
        viewHolder.name.setText(evt.getname());
        viewHolder.date.setText(evt.getdate());
        viewHolder.photo.setImageDrawable(new ColorDrawable(evt.getphoto()));

        return convertView;
    }

    private class EvtViewHolder{
        public TextView name;
        public TextView date;

        public ImageView photo;

    }
}
