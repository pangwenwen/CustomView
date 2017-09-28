package com.example.myapplication;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 继承自View的View：由于其onDraw空实现，so,写在super的方法前后无区别
 * 2. 继承自次View 如TextView,ImageView
 *     写在onDraw super下面，覆盖原有内容的绘制 BeforeOnDraw
 *     写在onDraw super上面，被原有内容覆盖 AfterOnDraw
 *
 * 3. dispatchDraw:绘制子view onDraw-->dispatchDraw
 *     写在dispatchDraw super下面， 覆盖子view的绘制
 *
 * 4. 绘制过程：drawbackground(private 方法，不可被重写)--》onDraw(本体的绘制)--》dispatchdraw（绘制子view）--》onDrawForeground(滑动边缘渐变、滚动条、前景 API23引入的)
 *    ##这些方法在view 的draw方法中规定了顺序，其为总方法##
 *注意：
 * 5. 出于效率的考虑，ViewGroup 默认会绕过 draw() 方法，换而直接执行 dispatchDraw()，以此来简化绘制流程。
 *    所以如果你自定义了某个 ViewGroup 的子类（比如 LinearLayout）并且需要在它的除  dispatchDraw() 以外的任何一个绘制方法内绘制内容，
 *    你可能会需要调用 View.setWillNotDraw(false) 这行代码来切换到完整的绘制流程（是「可能」而不是「必须」的原因是，
 *    有些 ViewGroup 是已经调用过 setWillNotDraw(false) 了的，例如 ScrollView）。
 * 6. 有的时候，一段绘制代码写在不同的绘制方法中效果是一样的，这时你可以选一个自己喜欢或者习惯的绘制方法来重写。
 *    但有一个例外：如果绘制代码既可以写在 onDraw() 里，也可以写在其他绘制方法里，那么优先写在 onDraw() ，
 *    因为 Android 有相关的优化，可以在不需要重绘的时候自动跳过  onDraw() 的重复执行，以提升开发效率。享受这种优化的只有 onDraw() 一个方法。
 */


public class MainActivity extends AppCompatActivity {
    List<View> viewList = new ArrayList<>();
    List<String> titlelist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        viewList.add(inflater.inflate(R.layout.after_ondraw_layout,null));
        viewList.add(inflater.inflate(R.layout.before_ondraw_layout,null));
        viewList.add(inflater.inflate(R.layout.after_dispatchdraw_layout,null));
        viewList.add(inflater.inflate(R.layout.foreground_layout,null));
        viewList.add(inflater.inflate(R.layout.before_draw_layout,null));
        viewList.add(inflater.inflate(R.layout.sample_layout,null));

        titlelist.add("AfterOndraw");
        titlelist.add("BeforeOndraw");
        titlelist.add("AfterDispatchdraw");
        titlelist.add("ForegroundView");
        titlelist.add("BeforeDraw");
        titlelist.add("SampleView");

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
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(viewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(viewList.get(position));
                return viewList.get(position);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titlelist.get(position);
            }
        });

        viewPager.setCurrentItem(5);

    }
}
