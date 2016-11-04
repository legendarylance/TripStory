package ca.utoronto.ece1778.tripstory;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ayazhan on 11/2/2016.
 */

public class Compile extends AppCompatActivity {

    private TextView story;
    private Button back;

    private TextView text1, text2,
            text1_2, text2_2,
            text1_3, text2_3,
            text1_4, text2_4,
            text1_5, text2_5;

    private int[] arrayB;
    private ImageView pic1, pic2, pic3, pic4, pic5;

    public String[][] currstory = new String[][]{
            {"frame1", "Who do you want to pick as a friend?", "f1_o1", "f1_o2", "f1_o3", "f1_o4", "You picked ", " as a friend"},
            {"frame2", "You and your friend find what?", "f2_o1", "f2_o2", "f2_o3", "f2_o4", "You and your friend found ", " "},
            {"frame3", "Suddenly, you see a _________ coming from behind", "f3_o1", "f3_o2", "f3_o3", "f3_o4", "Suddenly, you saw a ", " coming from behind."},
            {"frame4", "Where do you go to hide away from it?", "f4_o1", "f4_o2", "f4_o3", "f4_o4", "So you hid away in a ", " from it"},
            {"frame5", "There you find _________ stuck in a net", "f5_o1", "f5_o2", "f5_o3", "f5_o4", "There you found a ", " stuck in a net"}
    };



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout
        setContentView(R.layout.compile_layout);

        arrayB = getIntent().getIntArrayExtra("myStoryint");

//        for (int i = 0; i<arrayB.length; i++){
//            Toast.makeText(Compile.this, "Option was "+arrayB[i], Toast.LENGTH_SHORT).show();
//        }


        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text1_2 = (TextView) findViewById(R.id.text1_2);
        text2_2 = (TextView) findViewById(R.id.text2_2);
        text1_3 = (TextView) findViewById(R.id.text1_3);
        text2_3 = (TextView) findViewById(R.id.text2_3);
        text1_4 = (TextView) findViewById(R.id.text1_4);
        text2_4 = (TextView) findViewById(R.id.text2_4);
        text1_5 = (TextView) findViewById(R.id.text1_5);
        text2_5 = (TextView) findViewById(R.id.text2_5);

        pic1 = (ImageView) findViewById(R.id.pic1);
        pic2 = (ImageView) findViewById(R.id.pic2);
        pic3 = (ImageView) findViewById(R.id.pic3);
        pic4 = (ImageView) findViewById(R.id.pic4);
        pic5 = (ImageView) findViewById(R.id.pic5);

//        Bundle extras = getIntent().getExtras();
//        int[] arrayB = extras.getIntArray("myStoryint");



//        Bundle b=this.getIntent().getExtras();
//        String[] array=b.getStringArray(key);

        Drawable myDrawable1 = getDrawable(getResources().getIdentifier(currstory[0][arrayB[0]+2],"drawable","ca.utoronto.ece1778.tripstory"));
        Bitmap anImage1      = ((BitmapDrawable) myDrawable1).getBitmap();
        text1.setText(currstory[0][6]);
        pic1.setImageBitmap(anImage1);
        text2.setText(currstory[0][7]);

        Drawable myDrawable2 = getDrawable(getResources().getIdentifier(currstory[1][arrayB[1]+2],"drawable","ca.utoronto.ece1778.tripstory"));
        Bitmap anImage2      = ((BitmapDrawable) myDrawable2).getBitmap();
        text1_2.setText(currstory[1][6]);
        pic2.setImageBitmap(anImage2);
        text2_2.setText(currstory[1][7]);

        Drawable myDrawable3 = getDrawable(getResources().getIdentifier(currstory[2][arrayB[2]+2],"drawable","ca.utoronto.ece1778.tripstory"));
        Bitmap anImage3      = ((BitmapDrawable) myDrawable3).getBitmap();
        text1_3.setText(currstory[2][6]);
        pic3.setImageBitmap(anImage3);
        text2_3.setText(currstory[2][7]);

        Drawable myDrawable4 = getDrawable(getResources().getIdentifier(currstory[3][arrayB[3]+2],"drawable","ca.utoronto.ece1778.tripstory"));
        Bitmap anImage4      = ((BitmapDrawable) myDrawable4).getBitmap();
        text1_4.setText(currstory[3][6]);
        pic4.setImageBitmap(anImage4);
        text2_4.setText(currstory[3][7]);

        Drawable myDrawable5 = getDrawable(getResources().getIdentifier(currstory[4][arrayB[4]+2], "drawable", "ca.utoronto.ece1778.tripstory"));
        Bitmap anImage5 = ((BitmapDrawable) myDrawable5).getBitmap();
        text1_5.setText(currstory[4][6]);
        pic5.setImageBitmap(anImage5);
        text2_5.setText(currstory[4][7]);







////        try {
////            Drawable myDrawable5 = getDrawable(getResources().getIdentifier(currstory[4][arrayB[4]], "drawable", "ca.utoronto.ece1778.tripstory"));
////            Bitmap anImage5 = ((BitmapDrawable) myDrawable5).getBitmap();
////            text1_5.setText(currstory[4][6]);
////            pic5.setImageBitmap(anImage5);
////            text2_5.setText(currstory[4][7]);
////        }
////        finally {
////            Toast.makeText(Compile.this,"No luck", Toast.LENGTH_SHORT).show();
////        }
////        String listString = "";
////
//
//
////        for (int i = 0; i<currstory.length; i++){
////            text1.setText(currstory[i][6]);
////            text2.setText(currstory[i][7]);
////        }
//
//


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
