package com.example.hp.ournetwork;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class events extends AppCompatActivity {
    private Firebase myRef;

    ListView mListView;
    String m="";
    Map<String,Map<String,String>> value;
    List<String> jaw = new ArrayList<String>();
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);


        mListView = (ListView) findViewById(R.id.listView);
        Firebase.setAndroidContext(this);
        myRef = new Firebase("https://ournetwork-a40d6.firebaseio.com/");




        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                value = dataSnapshot.getValue(Map.class);


                List<evt> evts = new ArrayList<evt>();

              for( i=0;i<value.size();i++){
                  m=Integer.toString(i+1);
                evts.add(new evt(Color.TRANSPARENT ,value.get("evt"+m).get("name"),value.get("evt"+m).get("date")));
                  jaw.add(value.get("evt"+m).get("url"));

                  mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                      @Override
                      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                          Toast.makeText(events.this,jaw.get(position),Toast.LENGTH_LONG).show();
                          Intent browserIntent= new Intent(Intent.ACTION_VIEW,Uri.parse(jaw.get(position)));
                          startActivity(browserIntent);
                      }


                  });

                }

                EvtAdapter adapter = new EvtAdapter(events.this, evts);
                mListView.setAdapter(adapter);



                adapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }


        });

    }


}
