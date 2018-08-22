package com.cy.tabrv;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RVAdapter<String> rvAdapter;

    private CYTabLayout cyTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cyTabLayout = (CYTabLayout) findViewById(R.id.cytab);


        View view;
        String[] strings={"差滚","二个人体会","积极二个"};
//        cyTabLayout.setTabMode(CYTabLayout.FIXED);

        for (int i = 0; i < strings.length; i++) {
            view = LayoutInflater.from(this).inflate(R.layout.item_rv, null);

            TextView textView = (TextView) view.findViewById(R.id.tv);
            textView.setText(strings[i]);

            cyTabLayout.addTab(view);
        }

        GradientDrawable view_indicator = cyTabLayout.getView_indicator();

//        cyTabLayout.setWidth_indicator(100);
//        cyTabLayout.setHeight_indicator(30);

    }
}
