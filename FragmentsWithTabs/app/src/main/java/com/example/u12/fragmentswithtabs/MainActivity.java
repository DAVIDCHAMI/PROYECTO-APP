package com.example.u12.fragmentswithtabs;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabs_container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        tabs_container =findViewById(R.id.tabs_container);
        loadViewPager();

        // abrir componentes del dispositivo
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("wwww.google.com"));
        startActivity(intent);




    }

    // la encargada de  mandar el tabs al fragment
    private void loadViewPager() {
        TabsAdapter  tabsAdapter= new TabsAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabsAdapter);
        //definir de que  color  va ser el indicador
        tabs_container.setSelectedTabIndicatorColor(ContextCompat.getColor(this,R.color.colorWhite));
        tabs_container.setTabTextColors(ColorStateList.valueOf(ContextCompat.getColor(this,R.color.colorWhite)));
        tabs_container.setupWithViewPager(viewPager);
    }
}
