package com.joses.uts.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.joses.uts.model.NewsData;
import com.joses.uts.R;
import com.joses.uts.adapter.NewsAdapter;
import com.joses.uts.model.News;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvNews;
    private ArrayList<News> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        setTitle("ONIC Fans Apps");

        rvNews = findViewById(R.id.rv_news);
        rvNews.setHasFixedSize(true);

        list.addAll(NewsData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvNews.setLayoutManager(new LinearLayoutManager(this));
        NewsAdapter newsAdapter = new NewsAdapter(list);
        rvNews.setAdapter(newsAdapter);

        newsAdapter.setOnItemClickCallBack(new NewsAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClicked(News data) {
                ShowNews(data);
            }
        });
    }

    private void ShowNews(News news) {
        Intent directintent = new Intent(MainActivity.this, DetailActivity.class);
        Toast.makeText(this, news.getNewsTitle(), Toast.LENGTH_SHORT).show();
        directintent.putExtra("news_image", news.getNewsImage());
        directintent.putExtra("news_title", news.getNewsTitle());
        directintent.putExtra("news_author", news.getNewsAuthor());
        directintent.putExtra("news_detail", news.getNewsDetail());
        startActivity(directintent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.news_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setModeMenu(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setModeMenu(int IdisSelected) {
        switch (IdisSelected) {
            case R.id.item_ribbon:
                hereAboutMe();
                break;
        }
    }
    private void hereAboutMe(){
        Intent directIintent = new Intent(MainActivity.this, NoteActivity.class);
        startActivity(directIintent);
    }
}