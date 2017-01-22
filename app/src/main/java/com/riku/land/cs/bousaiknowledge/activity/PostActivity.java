package com.riku.land.cs.bousaiknowledge.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.riku.land.cs.bousaiknowledge.R;
import com.riku.land.cs.bousaiknowledge.model.MyItem;
import com.riku.land.cs.wanointernprototype.controller.BousaiService;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by riku_maehara on 17/01/22.
 */
public class PostActivity extends AppCompatActivity {
    public static final  String TAG = PostActivity.class.getSimpleName();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.send_fab);
        final EditText content_editText = (EditText) findViewById(R.id.content_editText);
        final EditText opinion_editText = (EditText) findViewById(R.id.opinion_editText);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BousaiService service=new BousaiService();
                service.bousaiClient(opinion_editText.getText().toString(),content_editText.getText().toString()).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<MyItem>(){
                            @Override
                            public void onCompleted() {
                                Log.d(TAG, "onCompleted");
                                finish();
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e(TAG + " onError", e.toString());
                                finish();

                            }

                            @Override
                            public void onNext(MyItem myItem) {
                                Log.d(TAG, "onNext");
                            }
                        });
            }
        });
    }

}
