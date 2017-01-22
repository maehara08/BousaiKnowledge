package com.riku.land.cs.bousaiknowledge.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.riku.land.cs.bousaiknowledge.adaper.MyAdapter;
import com.riku.land.cs.bousaiknowledge.R;
import com.riku.land.cs.bousaiknowledge.model.MyItem;
import com.riku.land.cs.wanointernprototype.controller.BousaiService;

import kotlin.reflect.KType;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    public static final String TAG =MainActivity.class.getSimpleName();

    private ListView listView;
    private MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myAdapter = new MyAdapter(this);
        setUpMyAdapter();
//        for (int i = 0; i < 20; i++) {
//            MyItem item = new MyItem();
//            item.setTitle(item.getTitle() + i);
//            myAdapter.add(item);
//        }
        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(myAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this,PostActivity.class);
                startActivity(intent);

                // TODO: 17/01/22 post

            }
        });
    }

    private void setUpMyAdapter(){
        BousaiService service =new BousaiService();
        service.bousaiGetContentClient()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyItem>(){
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG + " onError", e.toString());

                    }

                    @Override
                    public void onNext(MyItem myItem) {
                        Log.d(TAG, "onNext"+myItem.getContens()[0].getContent());
                        MyItem.MyContent myContents[] = myItem.getContens();
                        for (int i = 0 ;i<myContents.length;i++){
                            myAdapter.add(myContents[i]);
                        }
                    }
                });
    }
}
