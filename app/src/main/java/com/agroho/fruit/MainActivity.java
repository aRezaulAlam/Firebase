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

import com.firebase.ui.database.FirebaseListAdapter;
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
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ListView fruitList;
    EditText fruitNameEditText,editTextSummary;
    Button fruitSubmitButton;
    ArrayList<Fruit> fruits = new ArrayList<>();
    static boolean calledAlready = false;
    DatabaseReference firebaseRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!calledAlready)
        {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
            calledAlready = true;
        }
        firebaseRef = FirebaseDatabase.getInstance().getReference();


        fruitNameEditText = (EditText)findViewById(R.id.fruitNameEditText);
        fruitSubmitButton = (Button)findViewById(R.id.fruitSubmitButton);
        editTextSummary = (EditText)findViewById(R.id.editTextSummary);
        fruitList = (ListView)findViewById(R.id.fruitListView);

    }

    @Override
    protected void onStart(){
        super.onStart();

         DatabaseReference fruitRef = firebaseRef.child("Fruit");

        fruitSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fruitName = fruitNameEditText.getText().toString();
                String fruitSummary = editTextSummary.getText().toString();
                String key = firebaseRef.child("Fruit").push().getKey();
                Fruit fruit = new Fruit(fruitName,fruitSummary);
                Map<String, Object> fruitValues = fruit.toMap();

                HashMap<String,Object> values = new HashMap<String, Object>();
                values.put("/Fruit/" + key, fruitValues);
                firebaseRef.updateChildren(values);
                fruitNameEditText.setText("");
                editTextSummary.setText("");
            }
        });

        FirebaseListAdapter<Fruit> adapter = new FirebaseListAdapter<Fruit>(this,Fruit.class,R.layout.fruititem,fruitRef) {
            @Override
            protected void populateView(View v, Fruit model, int position) {
                TextView textViewTitle = (TextView)v.findViewById(R.id.fruitTitle);
                TextView textViewSummary = (TextView)v.findViewById(R.id.fruitSummary);
                textViewTitle.setText(model.getFruitName());
                textViewSummary.setText(model.getFruitSummary());
            }
        };

      fruitList.setAdapter(adapter);
    }

}

