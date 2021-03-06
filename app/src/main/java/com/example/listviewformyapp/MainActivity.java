package com.example.listviewformyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listviewformyapp.databinding.ActivitySignUpScreenBinding;

import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {
        ListView lv;
        ArrayList<Teacher> teachersList;
        TeacherAdapter teacheradapter;
        //varibales for animation
        Animation topAnimation, bottomAnimation;
        ImageView imageAnim;
        TextView appName, appDiteil;
        private static int SPLASH_SCREEN=5000;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
            //animations
            topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
            bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
            //Hooks
            imageAnim=findViewById(R.id.imageView);
            appName=findViewById(R.id.appName);
            appDiteil=findViewById(R.id.appDetail);

            imageAnim.setAnimation(topAnimation);
            appName.setAnimation(bottomAnimation);
            appDiteil.setAnimation(bottomAnimation);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent= new Intent(MainActivity.this,SplashScreen.class );
                    startActivity(intent);
                    finish();
                }
            },SPLASH_SCREEN);

            ////select teacher screen..
            Bitmap teacherpic1 = BitmapFactory.decodeResource(getResources(),R.drawable.teacherpic1);
            Bitmap teacherpic2 = BitmapFactory.decodeResource(getResources(),R.drawable.teacherpic2);
            Bitmap teacherpic3 = BitmapFactory.decodeResource(getResources(),R.drawable.teacherpic3);
            Bitmap teacherpic4 = BitmapFactory.decodeResource(getResources(),R.drawable.teacherpic4);
            Bitmap teacherpic5 = BitmapFactory.decodeResource(getResources(),R.drawable.teacherpic5);
            Bitmap teacherpic6 = BitmapFactory.decodeResource(getResources(),R.drawable.teacherpic6);



            Teacher t1 = new Teacher("???????? ???????? ", "??-????", teacherpic1);
            Teacher t2 = new Teacher("????????????????  ", "??-????", teacherpic2);
            Teacher t3 = new Teacher("??????  ", "??-????", teacherpic3);
            Teacher t4 = new Teacher("????????????  ", "??-????", teacherpic4);
            Teacher t5 = new Teacher("?????????? ", "??-????", teacherpic5);
            Teacher t6 = new Teacher("???????? ????????  ", "??-????", teacherpic6);

            teachersList = new ArrayList<Teacher>();
            teachersList.add(t1);
            teachersList.add(t2);
            teachersList.add(t3);
            teachersList.add(t4);
            teachersList.add(t5);
            teachersList.add(t6);

            teacheradapter = new TeacherAdapter(this,0,0,teachersList);
            lv =(ListView)findViewById(R.id.lv);
            lv.setAdapter(teacheradapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(getApplicationContext(),"???????????? ???? ?????????? "+ teachersList.get(position).getName(), Toast.LENGTH_SHORT).show();
                }
            });



        }


        }

