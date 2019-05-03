package com.examplcoue.mazen.qu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    TextView quText;
    Spinner ansText;
    Button startBtn,nextBtn;
    ArrayList<String> qu=new ArrayList<>();
    String[] countries={"egypt","usa","france","senegal"};
    String[] capitals={"cairo","ws","paris","dakkar"};

    byte i,score,ii;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quText=findViewById(R.id.quText);
        ansText=findViewById(R.id.ansText);
        startBtn=findViewById(R.id.startBtn);
        nextBtn=findViewById(R.id.nextBtn);
    }

    public void StartBtn(View view) {
        qu.clear();
        i=0;
        score=0;
        nextBtn.setEnabled(true);
        Collections.addAll(qu,"please select", "cairo", "damascus", "tripoli", "ws", "berlin", "london",
                "tokyo",
                "paris",
                "dakkar");
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,qu);
        ansText.setAdapter(adapter);
        quText.setText("What's the capital of "+countries[i]);


    }

    public void nextBtn(View view) {
        if (ansText.getSelectedItem().toString().equals("please select"))
        {

            Toast.makeText(this, "Invalid ans", Toast.LENGTH_SHORT).show();
            ii++;

        }

if (ii>2){
        Toast.makeText(this, "Don't be a fool", Toast.LENGTH_SHORT).show();
        score= (byte) (score-1);

}
        if (ansText.getSelectedItem().toString().equals(capitals[i]))
        {
        score++;

            qu.remove(ansText.getSelectedItem().toString());
        }
        i++;
        if (i<4)
        {
            quText.setText("What's the capital of "+countries[i]);
        }
        else {

            nextBtn.setEnabled(false);
            Toast.makeText(this, "Score is "+score, Toast.LENGTH_SHORT).show();
        }
        ansText.setSelection(0);
    }
}
