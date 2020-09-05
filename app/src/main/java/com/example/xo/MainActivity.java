package com.example.xo;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import  android.widget.Toast;
import  android.widget.Button;
import java.util.Random;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity  {

    // declaration des variable
    public Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
    public ImageView reset;
    public TextView joeur1,joeur2;
    public int score_1,score_2 = 0;
    public boolean turn;

    Random number= new Random();
    public int y= number.nextInt();
    public boolean is_win;
    public int i,j,p,pp= 0;
    public Button [][] all_btn = new Button[3][3];




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        reset = (ImageView) findViewById(R.id.buttonR);
        joeur1 = (TextView) findViewById(R.id.textView);
        joeur2 = (TextView) findViewById(R.id.textView2);
        // initialiser le score
        joeur1.setText((joeur1.getText().toString())+Integer.toString(score_1));
        joeur2.setText((joeur2.getText().toString())+Integer.toString(score_2));
        //

        if((y %2) == 0)
        {
            turn = true;
            joeur1.setTextColor(getResources().getColor(R.color.d_grey));
        }
        else
        {
            turn = false;
            joeur2.setTextColor(getResources().getColor(R.color.d_grey));
        }
        ///
        /// initialisation de tableau
        all_btn[0][0] = (Button) findViewById(R.id.button1);
        all_btn[0][1] = (Button) findViewById(R.id.button2);
        all_btn[0][2] = (Button) findViewById(R.id.button3);
        all_btn[1][0] = (Button) findViewById(R.id.button4);
        all_btn[1][1] =  (Button) findViewById(R.id.button5);
        all_btn[1][2] = (Button) findViewById(R.id.button6);
        all_btn[2][0] = (Button) findViewById(R.id.button7);
        all_btn[2][1]= (Button) findViewById(R.id.button8);
        all_btn[2][2] = (Button) findViewById(R.id.button9);

       ///


          ///



        ////
          for(i= 0;i< all_btn.length;i++)
          {
              for(j = 0 ;j < all_btn[i].length;j++)
              {
                  all_btn[i][j].setOnClickListener(new View.OnClickListener() {
                      final int  k  = i;
                      final int  kk = j;
                      @Override
                      public void onClick(View v) {


                              if(turn)
                              {

                                  all_btn[k][kk].setEnabled(false);
                                  all_btn[k][kk].setText("X");
                                  turn = false;
                                  reload();





                              }
                              else
                              {

                                  all_btn[k][kk].setEnabled(false);
                                  all_btn[k][kk].setText("O");
                                  turn = true;
                                  reload();



                              }
                          if(win())
                          {
                              if(!turn)
                              {
                                  score_1++;
                                  joeur1.setText("X : "+score_1);
                                  Toast.makeText(getApplicationContext(),"le joueur X gagné",Toast.LENGTH_SHORT).show();

                              }
                              else
                              {
                                  score_2++;
                                  joeur2.setText("O: "+score_2);
                                  Toast.makeText(getApplicationContext(),"le joueur O gagné",Toast.LENGTH_SHORT).show();


                              }

                                turn = !turn;
                              clear();



                          }

                      }
                  });
              }
          }
        /// restart

        /// method rejouer
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                score_1=0;score_2=0;

                joeur1.setText("X : "+score_1);
                joeur2.setText("O : "+score_2);


                clear();
                Toast.makeText(getApplicationContext(),"le joue est mise à nouveau",Toast.LENGTH_SHORT).show();
            }
        });
        //////


    }


    public void clear()
    {
        for(i= 0;i< all_btn.length;i++) {
            for (j = 0; j < all_btn[i].length; j++) {

                all_btn[i][j].setText("");

                all_btn[i][j].setEnabled(true);
                //turn = true;
                reload();
            }
        }
    }

    /// no winer
    public boolean no_winer()
    {

        for(i= 0;i< all_btn.length;i++) {
            for (j = 0; j < all_btn[i].length;j++) {

                 if (all_btn[i][j].getText().toString() != "")
                 {
                     is_win = true;
                 }
                 else
                 {
                     is_win = false;
                     return is_win;
                 }

            }}
            return is_win;
    }

    ///  winer
    public boolean win(){

        if ((all_btn[0][0].getText().toString() == all_btn[1][1].getText().toString()) &&
                (all_btn[0][0].getText().toString() == all_btn[2][2].getText().toString())
                && ((all_btn[0][0].getText().toString() != ""))) { return true; }
        else if ((all_btn[0][2].getText().toString() == all_btn[1][1].getText().toString()) &&
                (all_btn[0][2].getText().toString() == all_btn[2][0].getText().toString())
                && ((all_btn[0][2].getText().toString() != "")))
        {
                return true;
        }
        else if ((all_btn[0][0].getText().toString() == all_btn[1][0].getText().toString()) &&
                (all_btn[0][0].getText().toString() == all_btn[2][0].getText().toString())
                && ((all_btn[0][0].getText().toString() != "")))
        {
            return true;
        }
        else if ((all_btn[0][1].getText().toString() == all_btn[1][1].getText().toString()) &&
                (all_btn[0][1].getText().toString() == all_btn[2][1].getText().toString())
                && ((all_btn[0][1].getText().toString() != "")))
        {
            return true;
        }
        else if ((all_btn[0][2].getText().toString() == all_btn[1][2].getText().toString()) &&
                (all_btn[0][2].getText().toString() == all_btn[2][2].getText().toString())
                && ((all_btn[0][2].getText().toString() != "")))
        {
            return true;
        }
        else if ((all_btn[0][0].getText().toString() == all_btn[0][1].getText().toString()) &&
                (all_btn[0][0].getText().toString() == all_btn[0][2].getText().toString())
                && ((all_btn[0][0].getText().toString() != "")))
        {
            return true;
        }
        else if ((all_btn[1][0].getText().toString() == all_btn[1][1].getText().toString()) &&
                (all_btn[1][0].getText().toString() == all_btn[1][2].getText().toString())
                && ((all_btn[1][0].getText().toString() != "")))
        {
            return true;
        }
        else if ((all_btn[2][0].getText().toString() == all_btn[2][1].getText().toString()) &&
                (all_btn[2][0].getText().toString() == all_btn[2][2].getText().toString())
                && ((all_btn[2][0].getText().toString() != "")))
        {
            return true;
        }
        else if(no_winer()){

             clear();
             Toast.makeText(getApplicationContext(),"partie nulle",Toast.LENGTH_SHORT).show();
             return false;


        }
        else
            {
                return false;
            }

    }

    // reload
    public void reload()
    {
        if(turn)
        {
            joeur2.setTextColor(getResources().getColor(R.color.grey));
            joeur1.setTextColor(getResources().getColor(R.color.d_grey));
        }
        else
        {
            joeur1.setTextColor(getResources().getColor(R.color.grey));
            joeur2.setTextColor(getResources().getColor(R.color.d_grey));
        }
    }

}
