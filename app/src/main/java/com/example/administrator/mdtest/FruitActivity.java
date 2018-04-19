package com.example.administrator.mdtest;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.bumptech.glide.Glide;

public class FruitActivity extends AppCompatActivity {

    public static final String FRUIT_NAME = "fruit_name";
    public static final String FRUIT_ID = "fruit_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        ImageView fruitimage = findViewById(R.id.fruit_image_view);
        Toolbar toolbar = findViewById(R.id.fruit_toolbar);
        TextView fruitContent = findViewById(R.id.fruit_content);

        Intent intent = getIntent();
        String fruitName = intent.getStringExtra(FRUIT_NAME);
        int fruitId = intent.getIntExtra(FRUIT_ID,0);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);//默认是一个箭头的图标
        }

        collapsingToolbarLayout.setTitle(fruitName);//设置当前页面的标题

        Glide.with(this).load(fruitId).into(fruitimage);//设置图片
        String contents = generateContent(fruitName);
        fruitContent.setText(contents);//设置内容

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private String generateContent(String fruitName) {
        StringBuilder content = new StringBuilder();

        for(int i=0;i<500;i++){
            content.append(fruitName);
        }

        return content.toString();
    }
}
