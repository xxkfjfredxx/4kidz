package com.company.a4kidz.a4kidz.actitys;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.company.a4kidz.a4kidz.adapters.AdapterFragmentsTabs;
import com.company.a4kidz.a4kidz.fragments.AlbumPhotosFragment;
import com.company.a4kidz.a4kidz.fragments.ListPhotosFragment;
import com.company.a4kidz.a4kidz.R;

public class PrincipalActivity extends AppCompatActivity {

    private ViewPager pager;
    private AdapterFragmentsTabs adapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        pager = (ViewPager) findViewById(R.id.container);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        setTabLayout();
    }

    private void setTabLayout() {
        ListPhotosFragment listPhotosFragment = new ListPhotosFragment();
        AlbumPhotosFragment albumPhotosFragment = new AlbumPhotosFragment();
        adapter = new AdapterFragmentsTabs(getSupportFragmentManager());
        adapter.addFragment(listPhotosFragment, "Lista");
        adapter.addFragment(albumPhotosFragment, "Álbumes");
        adapter.notifyDataSetChanged();
        pager.setOffscreenPageLimit(2);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
    }

}
