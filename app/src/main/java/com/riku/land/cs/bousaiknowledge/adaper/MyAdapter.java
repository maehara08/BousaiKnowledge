package com.riku.land.cs.bousaiknowledge.adaper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.riku.land.cs.bousaiknowledge.R;
import com.riku.land.cs.bousaiknowledge.model.MyItem;

/**
 * Created by riku_maehara on 17/01/22.
 */
public class MyAdapter extends ArrayAdapter<MyItem.MyContent> {

    public MyAdapter(Context context) {
        super(context, R.layout.item_list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 特定の行(position)のデータを得る
        MyItem.MyContent item =  getItem(position);

        // convertViewは使い回しされている可能性があるのでnullの時だけ新しく作る
        if (null == convertView) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list,parent,false);
        }

        // CustomDataのデータをViewの各Widgetにセットする
        convertView.findViewById(R.id.item_textview).setVisibility(View.GONE);
        TextView nameTextView;
        TextView opinionTextView;
        nameTextView = (TextView)convertView.findViewById(R.id.name_textview);
        opinionTextView = (TextView)convertView.findViewById(R.id.opinion_textview);
        nameTextView.setText(item.getName());
        opinionTextView.setText(item.getOpinion());

//        TextView contentTextview ;
//        contentTextview = (TextView)convertView.findViewById(R.id.content_textview);
//        contentTextview.setText(item.getContent());
        return convertView;
    }
}
