package ca.utoronto.ece1778.tripstory;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/**
 * Created by sssk9797 on 05/11/2016.
 */
public class ThemeSelectorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println(" ~~~~~ Inside Theme Selector = " );

        setContentView(R.layout.activity_themeselector);

        String photoFilePath = getIntent().getStringExtra("photoFile");

        Button UnderwaterButton = (Button) findViewById(R.id.button4);

        final String filePath = photoFilePath;

        UnderwaterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Create intent to launch Main Activity from here
                Intent intent = new Intent(ThemeSelectorActivity.this, MainActivity.class);
                intent.putExtra("photoFile", filePath);

                //Start details activity
                startActivity(intent);
                // Launch the front facing using a button
                Snackbar.make(view, "Get Ready!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }

        });


        Button ZooButton = (Button) findViewById(R.id.button5);
        ZooButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Launch the front facing using a button
                Snackbar.make(view, "Get Ready!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });



    }
}
