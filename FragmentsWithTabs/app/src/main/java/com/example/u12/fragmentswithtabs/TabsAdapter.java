package com.example.u12.fragmentswithtabs;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabsAdapter extends FragmentStatePagerAdapter {


    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    //position es la posiccion del fragmen que se  seleccione
    public Fragment getItem(int position) {

        switch (position){
            case 0: return  new FragmentOne();
            case 1:return  new FragmentTwo();
            case 2:return  new FragmentThree();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

// poner titulos en los tabs
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:return "Estados";
            case 1:return "Chat";
            case 2:return  "Llamadas";
            default:
                return "";
        }
    }
}
