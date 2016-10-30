package ca.utoronto.ece1778.tripstory;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private ImageButton img_b1;
    private ImageButton img_b2;
    private ImageButton img_b3;
    private ImageButton img_b4;
    private ImageButton img_b5;
    private ImageButton img_b6;
    private ImageView srory_frame;
    private TextView StorylineText;
    private Realm realm;
    public int CurrentFrame = 1;
    public int MaxFrames = 3;
    public String framePic;
    public String Im1;
    public String Im2;
    public String Im3;
    public String Im4;
    public String Im5;
    public String Im6;
    public String question;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = findViewById(R.id.imageButton1);

        // Initialize the internal Realm Database
        initRealm();

        // Set the layout
        setContentView(R.layout.activity_main);

        // Create JSON and convert into Realm Object
        initJSON();


//        Idea, we can have 2 global variables, one that keep track of storyline
//        and the other one that keep track of frame number (could be just one variable actually)
//        all the images are pulled from the web or drawables and populated
//        based on logic coming from realm
//
//        In Realm, we can have tables corresponding to each frame and choice

//        For example:
//        Frame1 {storyFrameImg_url, btn1_url, btn2_url, ...}
//        urls are links to images

//        btn1 always has a link to 1, btn2 to 2, etc.
//        when btn 3, for example is pressed, the query goes as follow:
//
//        pull data from Frame2Choice3

//        Frame number will be pulled from global variable that will keep track of the frame number
//        Choice will be pulled from button pressed
//
//        Realm Database will have the following tables (or this could be JSON)
//
//        Frame2Choice1 {storyFrameImg_url, btn1_url, btn2_url, ...}
//        Frame2Choice2 {storyFrameImg_url, btn1_url, btn2_url, ...}
//        Frame2Choice3 {storyFrameImg_url, btn1_url, btn2_url, ...}
//        etc.
//

        /*
        // Button needs to be pressed before moving to the multi-threaded bitmap decoding
        Button1 = (Button) findViewById(R.id.button1);

        Button1.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        */




    }


    public void nextFrame(View view) {

        if (CurrentFrame < MaxFrames) {
            CurrentFrame++;
        } else {
            //do something here
        }

        // Create the next frame
        initRealm();
        initJSON();

    }

    public Realm initRealm() {
        // Realm Database setup --------------------------------------------------------------------
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .build();

        realm = Realm.getInstance(realmConfiguration);
        return realm;
    }

    public void initJSON() {

        img_b1 = (ImageButton) findViewById(R.id.imageButton1);
        img_b2 = (ImageButton) findViewById(R.id.imageButton2);
        img_b3 = (ImageButton) findViewById(R.id.imageButton3);
        img_b4 = (ImageButton) findViewById(R.id.imageButton4);
        img_b5 = (ImageButton) findViewById(R.id.imageButton5);
        img_b6 = (ImageButton) findViewById(R.id.imageButton6);
        srory_frame = (ImageView) findViewById(R.id.storyFrame);
        StorylineText = (TextView) findViewById(R.id.textView);

        // TravelSpots is an example of a destination that will be used for the spiral 2 presentation
        // In the future, a json will be created for each possible destination.

        // Create a Realm object by reading the pre-existing json file
        try {
            InputStream stream = getAssets().open("zoo.json");
            realm.beginTransaction();
            realm.createAllFromJson(JSONCreator.class, stream);
            realm.commitTransaction();
        } catch (IOException e) {
//                realm.cancelTransaction();
            System.err.println(e);
            e.printStackTrace();
        }

        //Run the query to determine the icons to be displayed in the frame at a given time.

        RealmResults<JSONCreator> query = realm.where(JSONCreator.class)
                .equalTo("frame", CurrentFrame)
                .findAll();
        System.out.println("query = " + query);

        String Im1 = query.get(0).getIm1();
        String Im2 = query.get(0).getIm2();
        String Im3 = query.get(0).getIm3();
        String Im4 = query.get(0).getIm4();
        String Im5 = query.get(0).getIm5();
        String Im6 = query.get(0).getIm6();
        //String Frame = query.get(0).getFrame();
        String framePic = query.get(0).getFramePic();
        String question = query.get(0).getQuestion();

        StorylineText.setText(question);

        Drawable myDrawable1 = getDrawable(getResources().getIdentifier(Im1,"drawable","ca.utoronto.ece1778.tripstory"));
        Bitmap anImage1      = ((BitmapDrawable) myDrawable1).getBitmap();
        img_b1.setImageBitmap(anImage1);

        Drawable myDrawable2 = getDrawable(getResources().getIdentifier(Im2,"drawable","ca.utoronto.ece1778.tripstory"));
        Bitmap anImage2      = ((BitmapDrawable) myDrawable2).getBitmap();
        img_b2.setImageBitmap(anImage2);

        Drawable myDrawable3 = getDrawable(getResources().getIdentifier(Im3,"drawable","ca.utoronto.ece1778.tripstory"));
        Bitmap anImage3      = ((BitmapDrawable) myDrawable3).getBitmap();
        img_b3.setImageBitmap(anImage3);

        Drawable myDrawable4 = getDrawable(getResources().getIdentifier(Im4,"drawable","ca.utoronto.ece1778.tripstory"));
        Bitmap anImage4      = ((BitmapDrawable) myDrawable4).getBitmap();
        img_b4.setImageBitmap(anImage4);

        Drawable myDrawable5 = getDrawable(getResources().getIdentifier(Im5,"drawable","ca.utoronto.ece1778.tripstory"));
        Bitmap anImage5      = ((BitmapDrawable) myDrawable5).getBitmap();
        img_b5.setImageBitmap(anImage5);

        Drawable myDrawable6 = getDrawable(getResources().getIdentifier(Im6,"drawable","ca.utoronto.ece1778.tripstory"));
        Bitmap anImage6      = ((BitmapDrawable) myDrawable6).getBitmap();
        img_b6.setImageBitmap(anImage6);


        Drawable FrameImg = getDrawable(getResources().getIdentifier(framePic,"drawable","ca.utoronto.ece1778.tripstory"));
        Bitmap frameImg      = ((BitmapDrawable) FrameImg).getBitmap();
        srory_frame.setImageBitmap(frameImg);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close(); // Remember to close Realm when done.
    }


}
