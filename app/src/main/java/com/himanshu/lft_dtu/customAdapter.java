package com.himanshu.lft_dtu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Himanshu on 1/26/2016.
 */
public class customAdapter extends ArrayAdapter {
    public customAdapter(Context context, String[] names) {
        super(context, R.layout.custom_row, names);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater teamInflater = LayoutInflater.from(getContext());
        View customView = teamInflater.inflate(R.layout.custom_row, parent, false);

        String singleMember = (String) getItem(position);
        TextView member = (TextView) customView.findViewById(R.id.tvName);
        ImageView memberPic = (ImageView) customView.findViewById(R.id.ivPic);

        member.setText(singleMember);
        memberPic.setImageResource(R.drawable.himanshu);
        return customView;
    }
}
