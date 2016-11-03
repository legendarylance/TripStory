package ca.utoronto.ece1778.tripstory;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ayazhan on 11/2/2016.
 */

public class Compile extends AppCompatActivity {

    private TextView story;
    private Button back;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout
        setContentView(R.layout.compile_layout);

        Intent intent = getIntent();
        ArrayList<String> currstory = (ArrayList<String>) intent.getSerializableExtra("mylist");

        String listString = "";

        int i = 1;
        for (String s : currstory)
        {
            listString += i + ". " + s + "\t\n";
            i++;
        }

        story = (TextView) findViewById(R.id.storyText);
        story.setText(listString);

        back = (Button)findViewById(R.id.compile_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Compile.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
