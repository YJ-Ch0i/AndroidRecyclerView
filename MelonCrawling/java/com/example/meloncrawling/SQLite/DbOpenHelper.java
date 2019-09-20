package com.example.meloncrawling.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.meloncrawling.Dto.MusicDto;

import java.util.ArrayList;
import java.util.List;

public class DbOpenHelper extends SQLiteOpenHelper {

    //DB이름과 버전 정보를 받는 생성자
    public DbOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * 데이터베이스를 새로 생성할 때 호출하는 메소드
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS music(" +
                "rank INTEGER PRIMARY KEY," +
                "img TEXT, " +
                "title TEXT, " +
                "singer TEXT, " +
                "almum TEXT)");
    }

    /**
     * db업그레이드를 위해 버전이 변경될 때 호출되는 함수
     * @param sqLiteDatabase
     * @param i
     * @param i1
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    /**
     * DB에 저장
     * @param dto
     */
    public void insert(MusicDto dto){

        //db열기
        SQLiteDatabase db = getWritableDatabase();
        //insert sql
        db.execSQL("INSERT INTO music VALUES(" +
                "" + dto.getRank() + ", " +
                "'" + dto.getImgSoruce() +"' , " +
                "'" + dto.getTitle() + "', " +
                "'" + dto.getSinger()+ "', " +
                "'" + dto.getAlbum() + "'" +
                ")");
        db.close();
    }

    /**
     * 모든 음악정보를 가져옴
     * @return
     */
    public List<MusicDto> getMusicList(){
        SQLiteDatabase db = getReadableDatabase();  //읽기가 가능한 DB 오픈
        Cursor cursor = null;   //데이터를 쉽게 가져오기 위해 cursor를 사용
        List<MusicDto> musicList = new ArrayList<>();   //music객체를 담기위한 List
        String sql = "SELECT * FROM music";

        try{
            cursor = db.rawQuery(sql, null);

            while(cursor.moveToNext()){
                MusicDto dto = new MusicDto();  //music객체 생성
                dto.setRank(cursor.getInt(0));
                dto.setImgSoruce(cursor.getString(1));
                dto.setTitle(cursor.getString(2));
                dto.setSinger(cursor.getString(3));
                dto.setAlbum(cursor.getString(4));

                musicList.add(dto);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(cursor != null){try{cursor.close();}catch(Exception e){e.printStackTrace();}}
            if(db != null){try{db.close();}catch(Exception e){e.printStackTrace();}}
        }
        return musicList;
    }

    /**
     * 최초 로그인 시 SQLite에 값이 있는지를 확인하는 메소드
     * @return  SQLite에 값이 있다 ? true : false;
     */
    public boolean isMusicExist(){
        SQLiteDatabase db = getReadableDatabase();  //읽기가 가능한 DB 오픈
        Cursor cursor = null;   //데이터를 쉽게 가져오기 위해 cursor를 사용
        String sql = "SELECT * FROM music";

        try{
            cursor = db.rawQuery(sql, null);    //쿼리를 던졌다!

            if(cursor.moveToNext()){
                return true;    //값이 있으면 true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(cursor != null){try{cursor.close();}catch(Exception e){e.printStackTrace();}}
            if(db != null){try{db.close();}catch(Exception e){e.printStackTrace();}}
        }
        return false;   //값이 없으면 false;
    }
}
