package com.riku.land.cs.bousaiknowledge.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.riku.land.cs.bousaiknowledge.R;
import com.riku.land.cs.bousaiknowledge.fragment.CustomSlide;
import com.vlonjatg.android.apptourlibrary.AppTour;
import com.vlonjatg.android.apptourlibrary.MaterialSlide;

public class AppTourActivity extends AppTour {

    @Override
    public void init(Bundle savedInstanceState) {

        int firstColor = Color.parseColor("#0097A7");
        int secondColor = Color.parseColor("#FFA000");
        int thirdColor = Color.parseColor("#FF5722");
        int forthColor = Color.parseColor("#673AB7");
        int customSlideColor = Color.parseColor("#009866");

        //Create pre-created fragments
        Fragment firstSlide = MaterialSlide.newInstance(R.drawable.app_tour_1, "防災アプリとは？",
                "防災アプリは被災者の経験をもとに、災害への対策を考えられるSNSです。", Color.WHITE, Color.WHITE);

        Fragment secondSlide = MaterialSlide.newInstance(R.drawable.app_tour_2, "概要1",
                "被災経験のある方は、その経験を投稿して、被災経験のない方にその内容を活かしてもらえます。", Color.WHITE, Color.WHITE);

        Fragment thirdSlide = MaterialSlide.newInstance(R.drawable.app_tour_3, "概要2",
                "被災経験のない方は投稿された内容を参考に、災害に対しての備えを行うことができます。", Color.WHITE, Color.WHITE);

        Fragment forthSlide = MaterialSlide.newInstance(R.drawable.app_tour_4, "有事の際には",
                "このアプリは、いざという時にはハザードマップとなって安全に避難ができるよう支援します。", Color.WHITE, Color.WHITE);

        //Add slides
        addSlide(firstSlide, firstColor);
        addSlide(secondSlide, secondColor);
        addSlide(thirdSlide, thirdColor);
        addSlide(forthSlide, forthColor);

        //Custom slide
        addSlide(new CustomSlide(), customSlideColor);

        //Customize tour
        setSkipButtonTextColor(Color.WHITE);
        setNextButtonColorToWhite();
        setDoneButtonTextColor(Color.WHITE);
        setTheme(R.style.Theme_MyTheme1_Light_NoActionBar);
    }

    @Override
    public void onSkipPressed() {
        Toast.makeText(this, "Skip", Toast.LENGTH_SHORT).show();

        //Do something after clicking Skip button.
        //E.x: Go to the sign up slide.
        setCurrentSlide(4);
    }

    @Override
    public void onDonePressed() {
        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();

        //Do something after clicking Done button.
        //E.x: Finish the intro.
        Intent intent = new Intent(AppTourActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
