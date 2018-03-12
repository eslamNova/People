package com.alien.islam.people;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView ;
    MyAdapter adapter ;
    ArrayList<PersonClass> arrayList ;

    EditText firstname , lastname ;
    TextView ageText ;
    SeekBar seekBar ;
    int age = 21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecycleView();
        initFields();
    }

    private void initFields() {

        firstname = (EditText) findViewById(R.id.firstName);
        lastname = (EditText) findViewById(R.id.lastName);
        ageText = (TextView) findViewById(R.id.seekText);
        seekBar =(SeekBar) findViewById(R.id.seekbar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                age = progress ;
                ageText.setText("Age: "+String.valueOf(age));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void initRecycleView (){
        recyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        arrayList = new ArrayList<>();

        adapter = new MyAdapter(arrayList);


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    public void Add(View view){
        String fName , lName ;
        fName = firstname.getText().toString();
        lName = lastname.getText().toString();
        if(fName.isEmpty()||lName.isEmpty())
        {
            Toast.makeText(MainActivity.this,"Enter a valid data",Toast.LENGTH_LONG).show();
            return;
        }

        arrayList.add(new PersonClass(fName,lName,age));
        adapter.notifyDataSetChanged();
    }
}
