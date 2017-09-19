package com.example.myapplication;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 属性动画：ViewPropertyAnimator 》》ObjectAnimator 》》ValueAnimator
 */

public class MainActivity extends AppCompatActivity {
    List<View> viewList = new ArrayList<>();
    List<String> stringList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater inflater = LayoutInflater.from(this);
        viewList.add(inflater.inflate(R.layout.project_property_layout,null));
        viewList.add(inflater.inflate(R.layout.translate_xyz_layout,null));
        viewList.add(inflater.inflate(R.layout.sample1_layout,null));
        viewList.add(inflater.inflate(R.layout.interpolator_view1,null));
        viewList.add(inflater.inflate(R.layout.path_interpaolator_layout,null));
        viewList.add(inflater.inflate(R.layout.new_interpolator_layout,null));
        viewList.add(inflater.inflate(R.layout.evaluator_layout,null));
        viewList.add(inflater.inflate(R.layout.property_holder_view,null));
        viewList.add(inflater.inflate(R.layout.animation_set_view,null));
        viewList.add(inflater.inflate(R.layout.keyframe_layout,null));

        stringList.add("ProjecAnimaT1");
        stringList.add("TranslatXYZ");
        stringList.add("Sample1");
        stringList.add("Interpolator1");
        stringList.add("PathInterpolator");
        stringList.add("NewInterpolator");
        stringList.add("EvaluatorLayout");
        stringList.add("PropertyValuesHolder");
        stringList.add("AnimationSet");
        stringList.add("KeyFrameLayout");

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(viewList.get(position));
                return viewList.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(viewList.get(position));
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return stringList.get(position);
            }
        });

        viewPager.setCurrentItem(9);

    }
}
