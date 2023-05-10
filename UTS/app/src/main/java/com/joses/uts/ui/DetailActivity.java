package com.joses.uts.ui;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.joses.uts.R;

public class DetailActivity extends AppCompatActivity {
    ImageView tvNewsImage;
    TextView tvNewsTitle, tvNewsDetail, tvNewsAuthor;

    @SuppressLint("WrongConstant")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("ONIC Fans Apps");
        actionBar.setDisplayHomeAsUpEnabled(true);

        tvNewsTitle = findViewById(R.id.tv_newsTitle);
        tvNewsImage = findViewById(R.id.tv_newsImage);
        tvNewsAuthor = findViewById(R.id.tv_newsAuthor);
        tvNewsDetail = findViewById(R.id.tv_newsDetail);

        int newsImage = getIntent().getIntExtra("news_image", 0);
        String newsTitle = getIntent().getStringExtra("news_title");
        String newsDetail = getIntent().getStringExtra("news_detail");
        String newsAuthor = getIntent().getStringExtra("news_author");

        Glide.with(this).asBitmap().load(newsImage).into(tvNewsImage);

        tvNewsTitle.setText(newsTitle);
        tvNewsDetail.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
        tvNewsDetail.setText(newsDetail);
        tvNewsAuthor.setText(newsAuthor);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}