package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button mBtn = null;
    private CustomImage mImgView;
    private int[] mEeitextId = {R.id.editext1,R.id.editext2,R.id.editext3,R.id.editext4,R.id.editext5,R.id.editext6,R.id.editext7,
            R.id.editext8,R.id.editext9, R.id.editext10,R.id.editext11,R.id.editext12,R.id.editext13,
            R.id.editext14,R.id.editext15,R.id.editext16,R.id.editext17,R.id.editext18,R.id.editext19,R.id.editext20};

//    private EditText[] mEditext = {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImgView = (CustomImage) findViewById(R.id.imageview);
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        float[] array = new float[20];
        for (int i = 0; i<20; i++){
            String text = ((EditText)findViewById(mEeitextId[i])).getText().toString();
            array[i] = Float.parseFloat(text);
        }

        mImgView.setmColorArray(array);
    }
}
