package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity {

    private static String TAG = SecondActivity.class.getSimpleName();

    @BindView(R.id.imageUrl) ImageView imageView;
    @BindView(R.id.tvTitle) TextView tvTitle;
    @BindView(R.id.tvBody) TextView tvBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_arrow_back);

        int image = getIntent().getExtras().getInt("image");
        String title = getIntent().getExtras().getString("title");
        int body = getIntent().getExtras().getInt("body");

        tvTitle.setText(title);
        tvBody.setText(body);
        imageView.setImageResource(image);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
}
