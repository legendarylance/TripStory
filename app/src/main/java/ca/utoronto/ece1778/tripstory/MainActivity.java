package ca.utoronto.ece1778.tripstory;

import android.content.Intent;
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
import java.security.PublicKey;
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

    public boolean areWeDone;

    public int currentfame;
    public int nextOption, previousOption;

    public ArrayList currstory = new ArrayList();


    public String[][][] storyarray = new String[][][]{
            {
                    {"f1o1", "Question frame 1 option 1", "cat", "fish", "whale", "bee", "fish", "pig", "You and your friend", "went to"}
            },
            {
                    {"f2o1","Question frame 2 option 1", "cat", "pig", "cat", "cat", "whale", "cat", "You and your friend", "went to"},
                    {"f2o2","Question frame 2 option 2", "bee", "bee", "pig", "bee", "dog", "bee", "You and your friend", "went to"},
                    {"f2o3","Question frame 2 option 3", "dragon", "dragon", "snail", "monkey", "dragon", "fish", "You and your friend", "went to"},
                    {"f2o4","Question frame 2 option 4", "cat", "pig", "cat", "cat", "pig", "cat", "You and your friend", "went to"},
                    {"f2o5","Question frame 2 option 5", "bee", "monkey", "dog", "bee", "monkey", "bee", "You and your friend", "went to"},
                    {"f2o6","Question frame 2 option 6", "dog", "dragon", "snail", "rabbit", "dragon", "fish", "You and your friend", "went to"}
            },
            {
                    {"f3o1", "Question frame 3 option 1", "rabbit", "dragon", "rabbit", "fish", "rabbit", "dragon", "You and your friend", "went to"},
                    {"f3o2", "Question frame 3 option 2", "snail", "rabbit", "dog", "dragon", "pig", "fish", "You and your friend", "went to"},
                    {"f3o3", "Question frame 3 option 3", "dragon", "snail", "dragon", "pig", "fish", "snail", "You and your friend", "went to"},
                    {"f3o4", "Question frame 3 option 4", "rabbit", "monkey", "rabbit", "fish", "rabbit", "dragon", "You and your friend", "went to"},
                    {"f3o5", "Question frame 3 option 5", "snail", "rabbit", "dragon", "dog", "dragon", "fish", "You and your friend", "went to"},
                    {"f3o6", "Question frame 3 option 6", "dragon", "snail", "dragon", "dragon", "fish", "snail", "You and your friend", "went to"}
            },
            {
                    {"f4o1", "Question frame 4 option 1", "rabbit", "dragon", "rabbit", "fish", "rabbit", "dragon", "You and your friend", "went to"},
                    {"f4o2", "Question frame 4 option 2", "snail", "rabbit", "dragon", "dog", "dragon", "fish", "You and your friend", "went to"},
                    {"f4o3", "Question frame 4 option 3", "dragon", "snail", "monkey", "dragon", "fish", "snail", "You and your friend", "went to"},
                    {"f4o4", "Question frame 4 option 4", "rabbit", "dragon", "rabbit", "fish", "rabbit", "dragon", "You and your friend", "went to"},
                    {"f4o5", "Question frame 4 option 5", "monkey", "rabbit", "dog", "dragon", "dragon", "fish", "You and your friend", "went to"},
                    {"f4o6", "Question frame 4 option 6", "dragon", "snail", "dragon", "dragon", "fish", "snail", "You and your friend", "went to"}
            },
            {
                    {"f5o1", "Question frame 5 option 1", "rabbit", "dragon", "rabbit", "fish", "rabbit", "dragon", "You and your friend", "went to"},
                    {"f5o2", "Question frame 5 option 2", "dog", "rabbit", "whale", "dragon", "whale", "fish", "You and your friend", "went to"},
                    {"f5o3", "Question frame 5 option 3", "dragon", "snail", "dragon", "dragon", "fish", "snail", "You and your friend", "went to"},
                    {"f5o4", "Question frame 5 option 4", "rabbit", "dragon", "rabbit", "fish", "rabbit", "dragon", "You and your friend", "went to"},
                    {"f5o5", "Question frame 5 option 5", "snail", "rabbit", "dragon", "monkey", "dragon", "fish", "You and your friend", "went to"},
                    {"f5o6", "Question frame 5 option 6", "dragon", "snail", "dragon", "dragon", "fish", "snail", "You and your friend", "went to"}
            }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout
        setContentView(R.layout.activity_main);

        currentfame = 0;

        // Initialize the internal Realm Database
//        initRealm();



        // Create JSON and convert into Realm Object
//        initJSON();

        img_b1 = (ImageButton) findViewById(R.id.imageButton1);
        img_b2 = (ImageButton) findViewById(R.id.imageButton2);
        img_b3 = (ImageButton) findViewById(R.id.imageButton3);
        img_b4 = (ImageButton) findViewById(R.id.imageButton4);
        img_b5 = (ImageButton) findViewById(R.id.imageButton5);
        img_b6 = (ImageButton) findViewById(R.id.imageButton6);
        srory_frame = (ImageView) findViewById(R.id.storyFrame);
        StorylineText = (TextView) findViewById(R.id.textView);

//        SET INITIAL VIEW
        initialSean();

        img_b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextOption = 0;
                buttonaction();
//                currentfame += 1;
//                previousOption=nextOption;
                if(areWeDone == false) {
                    compile(previousOption, nextOption);
                    nextFrameSean(nextOption);
                }

            }
        });

        img_b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousOption = nextOption;
                nextOption = 1;
                buttonaction();
//                currentfame += 1;
//                previousOption=nextOption;
                if(areWeDone == false) {
                    compile(previousOption, nextOption);
                    nextFrameSean(nextOption);
                }
            }
        });

        img_b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousOption = nextOption;
                nextOption = 2;
                buttonaction();
//                currentfame += 1;
//                previousOption=nextOption;
                if(areWeDone == false) {
                    compile(previousOption, nextOption);
                    nextFrameSean(nextOption);
                }
            }
        });

        img_b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousOption = nextOption;
                nextOption = 3;
                buttonaction();
//                currentfame += 1;
//                previousOption=nextOption;
                if(areWeDone == false) {
                    compile(previousOption, nextOption);
                    nextFrameSean(nextOption);
                }
            }
        });

        img_b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousOption = nextOption;
                nextOption = 4;
                buttonaction();
//                currentfame += 1;
//                previousOption=nextOption;
                if(areWeDone == false) {
                    compile(previousOption, nextOption);
                    nextFrameSean(nextOption);
                }
            }
        });

        img_b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousOption = nextOption;
                nextOption = 5;
                buttonaction();
//                currentfame += 1;
//                previousOption=nextOption;
                if(areWeDone == false) {
                    compile(previousOption, nextOption);
                    nextFrameSean(nextOption);
                }
            }
        });

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
    }

    public void initialSean()
    {
        int option = 0;
        Drawable myDrawable1 = getDrawable(getResources().getIdentifier(storyarray[currentfame][option][2],"drawable","ca.utoronto.ece1778.tripstory"));
        Bitmap anImage1      = ((BitmapDrawable) myDrawable1).getBitmap();
        img_b1.setImageBitmap(anImage1);

        Drawable myDrawable2 = getDrawable(getResources().getIdentifier(storyarray[currentfame][option][3],"drawable","ca.utoronto.ece1778.tripstory"));
        Bitmap anImage2      = ((BitmapDrawable) myDrawable2).getBitmap();
        img_b2.setImageBitmap(anImage2);

        Drawable myDrawable3 = getDrawable(getResources().getIdentifier(storyarray[currentfame][option][4],"drawable","ca.utoronto.ece1778.tripstory"));
        Bitmap anImage3      = ((BitmapDrawable) myDrawable3).getBitmap();
        img_b3.setImageBitmap(anImage3);

        Drawable myDrawable4 = getDrawable(getResources().getIdentifier(storyarray[currentfame][option][5],"drawable","ca.utoronto.ece1778.tripstory"));
        Bitmap anImage4      = ((BitmapDrawable) myDrawable4).getBitmap();
        img_b4.setImageBitmap(anImage4);

        Drawable myDrawable5 = getDrawable(getResources().getIdentifier(storyarray[currentfame][option][6],"drawable","ca.utoronto.ece1778.tripstory"));
        Bitmap anImage5      = ((BitmapDrawable) myDrawable5).getBitmap();
        img_b5.setImageBitmap(anImage5);

        Drawable myDrawable6 = getDrawable(getResources().getIdentifier(storyarray[currentfame][option][7],"drawable","ca.utoronto.ece1778.tripstory"));
        Bitmap anImage6      = ((BitmapDrawable) myDrawable6).getBitmap();
        img_b6.setImageBitmap(anImage6);


        Drawable FrameImg = getDrawable(getResources().getIdentifier(storyarray[currentfame][option][0],"drawable","ca.utoronto.ece1778.tripstory"));
        Bitmap frameImg      = ((BitmapDrawable) FrameImg).getBitmap();
        srory_frame.setImageBitmap(frameImg);

        StorylineText.setText(storyarray[currentfame][option][1]);
    }

    public void buttonaction(){
        if (currentfame<(storyarray.length-1)) {
            currentfame += 1;
            areWeDone = false;
        }
        else{
//            Toast.makeText(MainActivity.this, "Done!", Toast.LENGTH_SHORT).show();
            areWeDone = true;
            compile(previousOption, nextOption);
            Intent intent = new Intent(MainActivity.this, Compile.class);
            intent.putExtra("mylist", currstory);
            startActivity(intent);
        }
    }
    public void nextFrameSean(int option){

        Drawable myDrawable1 = getDrawable(getResources().getIdentifier(storyarray[currentfame][option][2],"drawable","ca.utoronto.ece1778.tripstory"));
        Bitmap anImage1      = ((BitmapDrawable) myDrawable1).getBitmap();
        img_b1.setImageBitmap(anImage1);

        Drawable myDrawable2 = getDrawable(getResources().getIdentifier(storyarray[currentfame][option][3],"drawable","ca.utoronto.ece1778.tripstory"));
        Bitmap anImage2      = ((BitmapDrawable) myDrawable2).getBitmap();
        img_b2.setImageBitmap(anImage2);

        Drawable myDrawable3 = getDrawable(getResources().getIdentifier(storyarray[currentfame][option][4],"drawable","ca.utoronto.ece1778.tripstory"));
        Bitmap anImage3      = ((BitmapDrawable) myDrawable3).getBitmap();
        img_b3.setImageBitmap(anImage3);

        Drawable myDrawable4 = getDrawable(getResources().getIdentifier(storyarray[currentfame][option][5],"drawable","ca.utoronto.ece1778.tripstory"));
        Bitmap anImage4      = ((BitmapDrawable) myDrawable4).getBitmap();
        img_b4.setImageBitmap(anImage4);

        Drawable myDrawable5 = getDrawable(getResources().getIdentifier(storyarray[currentfame][option][6],"drawable","ca.utoronto.ece1778.tripstory"));
        Bitmap anImage5      = ((BitmapDrawable) myDrawable5).getBitmap();
        img_b5.setImageBitmap(anImage5);

        Drawable myDrawable6 = getDrawable(getResources().getIdentifier(storyarray[currentfame][option][7],"drawable","ca.utoronto.ece1778.tripstory"));
        Bitmap anImage6      = ((BitmapDrawable) myDrawable6).getBitmap();
        img_b6.setImageBitmap(anImage6);


        Drawable FrameImg = getDrawable(getResources().getIdentifier(storyarray[currentfame][option][0],"drawable","ca.utoronto.ece1778.tripstory"));
        Bitmap frameImg      = ((BitmapDrawable) FrameImg).getBitmap();
        srory_frame.setImageBitmap(frameImg);

        StorylineText.setText(storyarray[currentfame][option][1]);
    }

    public void compile(int compileoption, int nextOption){

        currstory.add(storyarray[currentfame-1][compileoption][8]+" "+storyarray[currentfame-1][compileoption][nextOption+2]+" "+storyarray[currentfame-1][compileoption][9]);
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
