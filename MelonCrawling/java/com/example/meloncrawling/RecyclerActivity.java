package com.example.meloncrawling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.meloncrawling.Common.CommonUtil;
import com.example.meloncrawling.Dto.MusicDto;
import com.example.meloncrawling.RecyclerPackage.RecyclerAdapter;
import com.example.meloncrawling.SQLite.DbOpenHelper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    final DbOpenHelper dbOpenHelper = new DbOpenHelper(this, "melonCrawling", null, 1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();

        recyclerView = findViewById(R.id.recyclerView);
        new Description().execute();
    }


    private class Description extends AsyncTask<Void, Void, Void> {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute(){
            super.onPreExecute();

            progressDialog = new ProgressDialog(RecyclerActivity.this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("wait...");
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            final String url = "https://www.melon.com/chart/"; //크롤링 대상 url

            try{
                Document doc = Jsoup.connect(url).get();
                Elements elementsDataSize = doc.select("tr[class=lst50]");

                if(!dbOpenHelper.isMusicExist()){
                    for(Element el : elementsDataSize){
                        MusicDto music = new MusicDto();
                        music.setRank(CommonUtil.strToInt(el.select("td>div[class=wrap t_center]>span.rank").html()));
                        music.setImgSoruce(el.select("td>div.wrap>a>img").attr("src"));
                        music.setTitle(el.select("td>div>div>div[class=ellipsis rank01]>span>a").text());
                        music.setSinger(el.select("td>div>div>div[class=ellipsis rank02]>span>a").text());
                        music.setAlbum(el.select("td>div>div>div[class=ellipsis rank03]>span>a").text());

                        dbOpenHelper.insert(music);
                    }
               }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(Void Result){
            List<MusicDto> musicList = dbOpenHelper.getMusicList();
            RecyclerAdapter adapter = new RecyclerAdapter(musicList);

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);

            progressDialog.dismiss();
        }
    }
}
