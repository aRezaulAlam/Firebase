package com.agroho.fruit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView fruitList;
    EditText fruitInput;
    TextView fruitTextView;
    Button fruitEntryButton;
    ArrayList<String> fruits = new ArrayList<>();
    ArrayAdapter fruitAdapter;
    DatabaseReference firebaseRef = FirebaseDatabase.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fruitInput = (EditText)findViewById(R.id.fruitNameEditText);
        fruitEntryButton = (Button)findViewById(R.id.fruitSubmitButton);
        fruitTextView = (TextView)findViewById(R.id.FruitTextView);
        fruitList = (ListView)findViewById(R.id.fruitListView);

    }

    @Override
    protected void onStart(){
        super.onStart();

        fruitAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,fruits);
        fruitList.setAdapter(fruitAdapter);

         DatabaseReference fruitRef = firebaseRef.child("Fruit");


        fruitEntryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fruitName = fruitInput.getText().toString();
                String key = firebaseRef.child("Fruit").push().getKey();
                HashMap<String,Object> values = new HashMap<String, Object>();
                //values.put(fruitName,fruitName);
               // fruitRef.setValue(fruitName);
                values.put("/Fruit/" + key, fruitName);
                firebaseRef.updateChildren(values);
            }
        });

        fruitRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String fruit = dataSnapshot.getValue(String.class);
                Log.d("Fruit Added: ","FuitName"+" : "+fruit);
                fruits.add(fruit);
                fruitAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                String fruit = dataSnapshot.getValue(String.class);
                Log.d("Fruit Changed: ","FuitName"+" : "+fruit);
                fruits.add(fruit);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String fruit = dataSnapshot.getValue(String.class);
                Log.d("Fruit Removed: ","FuitName"+" : "+fruit);
                fruits.add(fruit);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





    }

}


























/*

fruitRef.addValueEventListener(new ValueEventListener() {
@Override
public void onDataChange(DataSnapshot dataSnapshot) {
        String fruitName = dataSnapshot.getValue(String.class);
        fruitTextView.setText(fruitName);
        }

@Override
public void onCancelled(DatabaseError databaseError) {

        }
        });

        fruitEntryButton.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        String fruitName = fruitInput.getText().toString();
        fruitRef.setValue(fruitName);

        }
        });

*/




















      /*  fruitList = (ListView)findViewById(R.id.fruitListView);
        fruitInput = (EditText)findViewById(R.id.fruitNameEditText);
        fruitEntryButton = (Button)findViewById(R.id.fruitSubmitButton);

        fruits = new ArrayList<>();

        fruitAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,fruits);
        fruitList.setAdapter(fruitAdapter);

        submitFruit();
        fruitRef = firebaseRef.child("Fruit");
        fruitRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Fruit fruit = dataSnapshot.getValue(Fruit.class);
                Log.d("Fruit Added: ","FuitName"+" : "+fruit.getFruitName());
                fruits.add(fruit.getFruitName());
                fruitAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Fruit fruit = dataSnapshot.getValue(Fruit.class);
                Log.d("Fruit Changed: ","FuitName"+" : "+fruit.getFruitName());
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Fruit fruit = dataSnapshot.getValue(Fruit.class);
                Log.d("Fruit Removed: ","FuitName"+" : "+fruit.getFruitName());
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void submitFruit() {

        fruitEntryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fruitName = fruitInput.getText().toString();
                String key = fruitRef.child("Fruit").push().getKey();
                Fruit frobj = new Fruit(key,fruitName,"Good","BD");


                Map<String,Object> mapValues =  new HashMap<>();
                mapValues.put("/Fruit/"+key, frobj.toMap());

                fruitRef.updateChildren(mapValues);
                *//*fruits.add(fruitName);
                fruitAdapter.notifyDataSetChanged();*//*
            }
        });
    }

*/