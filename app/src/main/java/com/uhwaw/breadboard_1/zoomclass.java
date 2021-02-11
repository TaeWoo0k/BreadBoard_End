package com.uhwaw.breadboard_1;
import android.content.Context;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;

import android.widget.LinearLayout;
import pl.polidea.view.ZoomView;
public class zoomclass extends  AppCompatActivity{
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        View v = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.activity_bread_board, null, false);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);



        ZoomView zoomView = new ZoomView(this);

        zoomView.addView(v);

        zoomView.setLayoutParams(layoutParams);

        zoomView.setMiniMapEnabled(true); // 좌측 상단 검은색 미니맵 설정

        zoomView.setMaxZoom(4f); // 줌 Max 배율 설정  1f 로 설정하면 줌 안됩니다.

        zoomView.setMiniMapCaption("Mini Map Test"); //미니 맵 내용

        zoomView.setMiniMapCaptionSize(20); // 미니 맵 내용 글씨 크기 설정



        LinearLayout container = (LinearLayout) findViewById(R.id.container);

        container.addView(zoomView);

    }

}
