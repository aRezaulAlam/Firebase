package com.agroho.fruit;

/**
 * Created by USER on 8/27/2016.
 */
public class FirebaseUIListView {
    /*
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

public class MainActivity extends AppCompatActivity {

    ListView fruitList;
    EditText fruitInput;
    TextView fruitTextView;
    Button fruitEntryButton;
    ArrayList<Fruit> fruits = new ArrayList<>();
    CustomList fruitAdapter;
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

        fruitAdapter = new CustomList(this,fruits);
        fruitList.setAdapter(fruitAdapter);

         DatabaseReference fruitRef = firebaseRef.child("Fruit");


        fruitEntryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fruitName = fruitInput.getText().toString();
                String key = firebaseRef.child("Fruit").push().getKey();
                HashMap<String,Object> values = new HashMap<String, Object>();
                values.put("/Fruit/" + key, fruitName);
                firebaseRef.updateChildren(values);
            }
        });

        FirebaseListAdapter<String> adapter = new FirebaseListAdapter<String>(this,String.class,android.R.layout.simple_list_item_1,fruitRef) {
            @Override
            protected void populateView(View v, String model, int position) {

                TextView textView = (TextView)v.findViewById(android.R.id.text1);
                textView.setText(model);

            }
        };

      fruitList.setAdapter(adapter);
    }

}

*/
}
