package demo.md.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
    /*    tabs.addTab(tabs.newTab().setText("TAB1"));
        tabs.addTab(tabs.newTab().setText("TAB2"));
        tabs.addTab(tabs.newTab().setText("TAB3"));
        tabs.addTab(tabs.newTab().setText("TAB4"));
        tabs.addTab(tabs.newTab().setText("TAB5"));
        tabs.addTab(tabs.newTab().setText("TAB6"));
        tabs.addTab(tabs.newTab().setText("TAB7"));*/


        List<String> titles = new ArrayList<String>();
        List<Fragment> fragments = new ArrayList<Fragment>();
        for (int i = 0; i < 10; i++) {
            String title = "TAB" + i;
            tabs.addTab(tabs.newTab().setText(title));
            titles.add(title);
            MyFragment fragment = new MyFragment();
            fragment.setTitle(title);
            fragments.add(fragment);
        }
        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager(), titles, fragments);
        final  ViewPager viewPager = (ViewPager) findViewById(R.id.vp);
        viewPager.setAdapter(myAdapter);
        tabs.setupWithViewPager(viewPager);
        tabs.setTabsFromPagerAdapter(myAdapter);
    }
}
