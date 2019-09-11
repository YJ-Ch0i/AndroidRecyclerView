package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.recyclerview.Data.Data;
import com.example.recyclerview.Data.Person;
import com.example.recyclerview.RecyclerViewClasses.RecyclerAdapter;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.ObjectStreamException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        SharedPreferences sharedPreferences = getSharedPreferences("shared", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        List<Person> list = setPersonData();

        String json = new Gson().toJson(list);

        editor.putString("contacts", json);
        editor.commit();

        String strContact = sharedPreferences.getString("contacts", "");
        Type listType = new TypeToken<ArrayList<Person>>() {}.getType();
        ArrayList<Person> datas = new Gson().fromJson(strContact, listType);

//        Map<Integer, Map<String, Object>> map = setPersonData();
//        for(Map.Entry<Integer, Map<String, Object>> entry : map.entrySet()){
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//            editor.putInt("id", entry.getKey());
//            editor.putInt("img", (Integer) entry.getValue().get("img"));
//            editor.putString("name", (String) entry.getValue().get("name"));
//
//            System.out.println(editor.toString());
//            //editor.commit();
//        }

//        String json = new Gson().toJson(map);
//        editor.putString("shared", json);
//        editor.commit();
//
//        Type type = new TypeToken<ArrayList<Person>>() {}.getType();
//
//        ArrayList<Person> personalList = new Gson().fromJson(json, type);
//        for(Person p : personalList){
//            System.out.println(p.getpId());
//            System.out.println(p.getName());
//            System.out.println(p.getImageId());
//        }

        recyclerView.setAdapter(new RecyclerAdapter(datas));
    }


    public List<Person> setPersonData(){

        List<String> nameList = new ArrayList<>();
        nameList.add("김병구");
        nameList.add("김형진");
        nameList.add("박경현");
        nameList.add("이지율");
        nameList.add("최영재");

        List<Person> personList = new ArrayList<>();

        for(int i=0; i < 5; i++){
            Person person = new Person();
            person.setImageId(R.drawable.ic_launcher_foreground);
            person.setpId(i+1);
            person.setName(nameList.get(i));

            personList.add(person);
        }

//        Map<Integer, Map<String, Object>> map = new HashMap<>();
//
//        for(Person p : personList){
//            Map<String, Object> newMap = new HashMap<>();
//            newMap.put("img", p.getImageId());
//            newMap.put("name", p.getName());
//
//            map.put(p.getpId(), newMap);
//        }
        return personList;
    }
}
