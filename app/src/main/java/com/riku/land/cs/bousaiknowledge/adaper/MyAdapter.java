package com.riku.land.cs.bousaiknowledge.adaper;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.riku.land.cs.bousaiknowledge.R;
import com.riku.land.cs.bousaiknowledge.activity.MainActivity;
import com.riku.land.cs.bousaiknowledge.model.MyItem;
import com.riku.land.cs.wanointernprototype.controller.BousaiService;
import com.squareup.picasso.Picasso;

/**
 * Created by riku_maehara on 17/01/22.
 */
public class MyAdapter extends ArrayAdapter<MyItem.MyContent> {
    public static final String TAG=MyAdapter.class.getSimpleName();
    private Context context;

    public MyAdapter(Context context) {
        super(context, R.layout.item_list);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 特定の行(position)のデータを得る
        MyItem.MyContent item =  getItem(position);


        // convertViewは使い回しされている可能性があるのでnullの時だけ新しく作る
//        if (null == convertView) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list,parent,false);
//        }
        if (item.getGraph_image_url()==null) {
            Log.d(TAG, "getView: noooooooooo");
            convertView.findViewById(R.id.graph_imageview).setVisibility(View.GONE);
            // CustomDataのデータをViewの各Widgetにセットする
//            convertView.findViewById(R.id.item_textview).setVisibility(View.GONE);
            TextView nameTextView;
            TextView opinionTextView;
            nameTextView = (TextView) convertView.findViewById(R.id.name_textview);
            opinionTextView = (TextView) convertView.findViewById(R.id.opinion_textview);
            nameTextView.setText("name: "+item.getName());
            opinionTextView.setText("opinion: "+item.getOpinion());
        }
        else {
            Log.d(TAG, "getView: nullll");
            ImageView imageView = (ImageView) convertView.findViewById(R.id.graph_imageview);
            convertView.findViewById(R.id.container).setVisibility(View.GONE);
            Log.d(TAG, "getView: "+BousaiService.Companion.getBASE_URL()+item.getGraph_image_url());
            Picasso.with(context).load(BousaiService.Companion.getBASE_URL()+item.getGraph_image_url()).into(imageView);
        }


//        TextView contentTextview ;
//        contentTextview = (TextView)convertView.findViewById(R.id.content_textview);
//        contentTextview.setText(item.getContent());
        return convertView;
    }
}
