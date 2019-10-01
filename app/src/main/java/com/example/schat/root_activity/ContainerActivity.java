package com.example.schat.root_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.schat.R;
import com.example.schat.constants.GlobalConstants;
import com.example.schat.root_activity.my_connects.MyConnect;
import com.example.schat.root_activity.open_connects.OpenConnect;
import com.example.schat.root_activity.profile.Profile;

public class ContainerActivity extends AppCompatActivity {

    private ViewPager mViewpager;
    private CardView tabHead_OpenConnect,tabHead_MyConnect,tabHead_Profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        mViewpager = findViewById(R.id.viewpager);
        tabHead_OpenConnect = findViewById(R.id.open_connect_tab_head);
        tabHead_MyConnect = findViewById(R.id.my_connect_tab_head);
        tabHead_Profile = findViewById(R.id.profile_tab_head);

        mViewpager.setAdapter(new SectionPagerAdapter(getSupportFragmentManager()));



        mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
              activateTabHeader(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //TODO: should be from view model
        mViewpager.setCurrentItem(SectionPagerAdapter.OPEN_CONNECTS);
        activateTabHeader(SectionPagerAdapter.OPEN_CONNECTS);

        tabHead_OpenConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewpager.setCurrentItem(SectionPagerAdapter.OPEN_CONNECTS);

            }

        });
        tabHead_MyConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewpager.setCurrentItem(SectionPagerAdapter.MY_CONNECTS);
            }

        });
        tabHead_Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewpager.setCurrentItem(SectionPagerAdapter.PROFILE);
            }

        });
    }
    private void activateTabHeader(int position){
        ImageView im1,im2,im3;
        TextView t1,t2,t3;
        switch(position){

            case SectionPagerAdapter.OPEN_CONNECTS:
                im1 = findViewById(R.id.open_connect_im_view);
                im1.setImageResource(R.drawable.open_connect_tab_head_ic_enabled_1);
                t1= findViewById(R.id.openconnect_txtview);
                t1.setTextColor(getResources().getColor(R.color.colorPrimary));

                im2 = findViewById(R.id.my_connect_im_view);
                im2.setImageResource(R.drawable.my_connect_tab_head_ic_disabled_1);
                t2= findViewById(R.id.myconnect_txtview);
                t2.setTextColor(getResources().getColor(R.color.colorDisable));

                im3 = findViewById(R.id.profile_im_view);
                im3.setImageResource(R.drawable.profile_tab_head_ic_disabled_1);
                t3= findViewById(R.id.profile_txtview);
                t3.setTextColor(getResources().getColor(R.color.colorDisable));

                break;

            case SectionPagerAdapter.MY_CONNECTS:

                im1 = findViewById(R.id.open_connect_im_view);
                im1.setImageResource(R.drawable.open_connect_tab_head_ic_disabled_1);
                t1= findViewById(R.id.openconnect_txtview);
                t1.setTextColor(getResources().getColor(R.color.colorDisable));

                im2 = findViewById(R.id.my_connect_im_view);
                im2.setImageResource(R.drawable.my_connect_tab_head_ic_enabled_1);
                t2= findViewById(R.id.myconnect_txtview);
                t2.setTextColor(getResources().getColor(R.color.colorPrimary));

                im3 = findViewById(R.id.profile_im_view);
                im3.setImageResource(R.drawable.profile_tab_head_ic_disabled_1);
                t3= findViewById(R.id.profile_txtview);
                t3.setTextColor(getResources().getColor(R.color.colorDisable));

                break;

            case SectionPagerAdapter.PROFILE:

                im1 = findViewById(R.id.open_connect_im_view);
                im1.setImageResource(R.drawable.open_connect_tab_head_ic_disabled_1);
                t1= findViewById(R.id.openconnect_txtview);
                t1.setTextColor(getResources().getColor(R.color.colorDisable));

                im2 = findViewById(R.id.my_connect_im_view);
                im2.setImageResource(R.drawable.my_connect_tab_head_ic_disabled_1);
                t2= findViewById(R.id.myconnect_txtview);
                t2.setTextColor(getResources().getColor(R.color.colorDisable));

                im3 = findViewById(R.id.profile_im_view);
                im3.setImageResource(R.drawable.profile_tab_head_ic_enabled_1);
                t3= findViewById(R.id.profile_txtview);
                t3.setTextColor(getResources().getColor(R.color.colorPrimary));

                break;

        }

    }

    class SectionPagerAdapter extends FragmentPagerAdapter{

        private static final int OPEN_CONNECTS = 0;
        private static final int MY_CONNECTS = 1;
        private static final int PROFILE = 2;

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position){
                case OPEN_CONNECTS:
                    return OpenConnect.newInstance();
                case MY_CONNECTS:
                    return MyConnect.newInstance();
                case PROFILE:
                    return Profile.newInstance();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return GlobalConstants.TABCOUNT;
        }
    }

}
