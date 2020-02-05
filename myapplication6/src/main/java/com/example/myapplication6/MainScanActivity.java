package com.example.myapplication6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication6.ui.main.SectionsPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainScanActivity extends AppCompatActivity implements View.OnClickListener {
    String[] scanTags = {"扫码", "扫证件", "翻译"};
    String[] tipTags = {"通用", "地标"};
    String [][]tags={scanTags,tipTags};
    int position;
    Button button1, button2;
    TabLayout tabs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan_main);

        tabs = findViewById(R.id.tabs);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence text = tabs.getTabAt(tabs.getSelectedTabPosition()).getText();
                Snackbar.make(view, ""+text, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                if (position!=0){
                    position=0;
                    onBottomCheckChanged();
                }
                break;
            case R.id.button2:
                if (position!=1){
                    position=1;
                    onBottomCheckChanged();
                }
                break;

        }
    }
   void onBottomCheckChanged(){
       tabs.removeAllTabs();
       String[] currentTags = tags[position];
       for (int i = 0; i< currentTags.length; i++){
           TabLayout.Tab tab = new TabLayout.Tab();
           tab.setText(currentTags[i]);
           tabs.addTab(tab);
       }
   }
}