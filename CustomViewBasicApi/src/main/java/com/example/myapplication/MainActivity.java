package com.example.myapplication;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.customview.FlipEffection_17;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<View> viewList = new ArrayList<>();
    List<String> titleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater inflater = LayoutInflater.from(this);
        viewList.add(inflater.inflate(R.layout.canvas_use_layout,null));
        viewList.add(inflater.inflate(R.layout.path_use_layout,null));
        viewList.add(inflater.inflate(R.layout.piechart_layout,null));
        viewList.add(inflater.inflate(R.layout.paint_shader_layout,null));
        viewList.add(inflater.inflate(R.layout.paint_com_shader_layout,null));
        viewList.add(inflater.inflate(R.layout.paint_other_layout,null));
        viewList.add(inflater.inflate(R.layout.paint_shadow_layout,null));
        viewList.add(inflater.inflate(R.layout.paint_path_layout,null));
        viewList.add(inflater.inflate(R.layout.draw_text_path_layout,null));
        viewList.add(inflater.inflate(R.layout.static_layout_view,null));
        viewList.add(inflater.inflate(R.layout.text_style_layout,null));
        viewList.add(inflater.inflate(R.layout.text_bound_view,null));
        viewList.add(inflater.inflate(R.layout.canvas_clip_layout,null));
        viewList.add(inflater.inflate(R.layout.canvas_transform_layout,null));
        viewList.add(inflater.inflate(R.layout.canvas_matrix_layout,null));
        viewList.add(inflater.inflate(R.layout.canvas_camera_layout,null));
        View flipView = inflater.inflate(R.layout.flip_layout,null);
        viewList.add(flipView);

        flipViewSetUp(flipView);

        titleList.add("Canvas_Use");
        titleList.add("Paint_Use");
        titleList.add("PieChart");
        titleList.add("PaintShader");
        titleList.add("PaintComShader");
        titleList.add("PaintOther");
        titleList.add("PaintShadow");
        titleList.add("PaintPath");
        titleList.add("DrawTextPath");
        titleList.add("StaticLayout");
        titleList.add("TextStyleLayout");
        titleList.add("TextMeasureLayout");
        titleList.add("CanvasClipLayout");
        titleList.add("CanvasTransformLayout");
        titleList.add("CanvasMatrixLayout");
        titleList.add("CanvasCameraLayout");
        titleList.add("FlipEffection");

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
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
            public CharSequence getPageTitle(int position) {
                return titleList.get(position);
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
        });
        viewPager.setCurrentItem(7);

    }

    private void flipViewSetUp(View flipView) {
        Button btn = flipView.findViewById(R.id.flip_btn);
        final EditText editText = flipView.findViewById(R.id.flip_editext);
        final FlipEffection_17 flip = flipView.findViewById(R.id.flipview);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int degree = Integer.valueOf(editText.getText().toString());
                //flip.setDegree(degree);
            }
        });
    }
}
