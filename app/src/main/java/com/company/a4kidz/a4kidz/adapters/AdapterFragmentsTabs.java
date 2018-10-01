package com.company.a4kidz.a4kidz.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.a4kidz.a4kidz.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fred Rueda on 27/09/2018
 * Developer Fred Rueda
 * Email fredjruedao@gmail.com
 */
public class AdapterFragmentsTabs extends FragmentPagerAdapter {
    private final List<Fragment> mFragments = new ArrayList<>();
    private final List<String> mFragmentTitles = new ArrayList<>();
    private int[] imageResId = { R.drawable.ic_list, R.drawable.ic_list };

    public AdapterFragmentsTabs(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment, String title) {
        mFragments.add(fragment);
        mFragmentTitles.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitles.get(position);
    }

    public View getTabView(int position,Context context) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_tab_view, null);
        TextView tv = (TextView) v.findViewById(R.id.textView);
        tv.setText(mFragmentTitles.get(position));
        ImageView img = (ImageView) v.findViewById(R.id.imageView);
        img.setImageResource(imageResId[position]);
        return v;
    }

}
