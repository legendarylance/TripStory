package ca.utoronto.ece1778.tripstory;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageButton img_b1;
    private ImageButton img_b2;
    private ImageButton img_b3;
    private ImageButton img_b4;
    private ImageButton img_b5;
    private ImageButton img_b6;
    private ImageView srory_frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_b1 = (ImageButton) findViewById(R.id.imageButton1);
        img_b2 = (ImageButton) findViewById(R.id.imageButton2);
        img_b3 = (ImageButton) findViewById(R.id.imageButton3);
        img_b4 = (ImageButton) findViewById(R.id.imageButton4);
        img_b5 = (ImageButton) findViewById(R.id.imageButton5);
        img_b6 = (ImageButton) findViewById(R.id.imageButton6);
        srory_frame = (ImageView) findViewById(R.id.storyFrame);

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


        Drawable myDrawable1 = getResources().getDrawable(R.drawable.ant);
        Bitmap anImage1      = ((BitmapDrawable) myDrawable1).getBitmap();
        img_b1.setImageBitmap(anImage1);

        Drawable myDrawable2 = getResources().getDrawable(R.drawable.bee);
        Bitmap anImage2      = ((BitmapDrawable) myDrawable2).getBitmap();
        img_b2.setImageBitmap(anImage2);

        Drawable myDrawable3 = getResources().getDrawable(R.drawable.cat);
        Bitmap anImage3      = ((BitmapDrawable) myDrawable3).getBitmap();
        img_b3.setImageBitmap(anImage3);

        Drawable myDrawable4 = getResources().getDrawable(R.drawable.dog);
        Bitmap anImage4      = ((BitmapDrawable) myDrawable4).getBitmap();
        img_b4.setImageBitmap(anImage4);

        Drawable myDrawable5 = getResources().getDrawable(R.drawable.dragon);
        Bitmap anImage5      = ((BitmapDrawable) myDrawable5).getBitmap();
        img_b5.setImageBitmap(anImage5);

        Drawable myDrawable6 = getResources().getDrawable(R.drawable.fish);
        Bitmap anImage6      = ((BitmapDrawable) myDrawable6).getBitmap();
        img_b6.setImageBitmap(anImage6);


        Drawable FrameImg = getResources().getDrawable(R.drawable.frame1);
        Bitmap frameImg      = ((BitmapDrawable) FrameImg).getBitmap();
        srory_frame.setImageBitmap(frameImg);

    }
}
