package com.example.android.perfectcoffee;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Switch;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * Created by MissTank on 7/10/17.
 */

public class OrderActivity extends AppCompatActivity
{

    private SeekBar seekBar;

    private TextView textView;
    private TextView textViewh;
    String swt="";
    public Switch swtch;
    int number=0;
    int price=0;
    boolean swtitchboolen;
    private RadioGroup radioGroup;
    private RadioGroup radioGroup2;
    String nstring="";
    public int progress = 0;
    private RadioButton radioButton;
    private Button btnDisplay;
    int typeofcofee=0;
    String caffinepercent="";
    String tcoffee="";

    public void incrment(View view)
    {
        number++;
        display();
        displayprice();
    }

    public void decrement(View view)
    {
        number--;
        display();
        displayprice();

    }

    public void display()
    {
        TextView a= (TextView) findViewById(R.id.quantity_text_view);
        a.setText("  "+number+"  ");
        displayprice();
    }
    //mocha=4;
    //frapp =3;
    //misto=1;
    //iceblend=2;

    public void displayprice()
    {
        if(typeofcofee==1)
        {
            price=5*number;
        }
        else if(typeofcofee==2)
        {
            price=4*number;
        }
        else if(typeofcofee==3)
        {
            price=6*number;
        }
        else if(typeofcofee==4)
        {
            price=6*number;
        }


        TextView a= (TextView) findViewById(R.id.price_text_view);
        a.setText(NumberFormat.getCurrencyInstance().format(price));
    }


    public void submitOrder(View view)
    {
        EditText edit = (EditText)findViewById(R.id.name);
        String result = edit.getText().toString();
        TextView m=(TextView)findViewById(R.id.message);
        m.setText("Thank You For Doing Business With Us... ");


        String end ="                           Thank You " +result+ "... \nWe Have Received Your Order Of "+number+ " "+tcoffee+ "\n\nYour Total is: $" +price;
        String order="Amount Of Caffine : "+ progress +"%";
        AlertDialog alertDialog = new AlertDialog.Builder(OrderActivity.this).create(); //Read Update
        alertDialog.setTitle("Order Review");
        alertDialog.setMessage(end +"\n"+swt+"\n"+order);
        alertDialog.show();



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);
        seekBar = (SeekBar) findViewById(R.id.seekbar);
        textView = (TextView) findViewById(R.id.textView1);
        textView.setText(seekBar.getProgress() + "%" );

        RadioGroup rg = (RadioGroup) findViewById(R.id.type);






        radioGroup2 = (RadioGroup) findViewById(R.id.type2);

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {

            //mocha=4;
            //frapp =3;
            //misto=1;
            //iceblend=2;


            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch (checkedId) {
                    case R.id.a1:
                        typeofcofee=1;
                        tcoffee="Caffè Misto";
                        break;
                    case R.id.a2:
                        typeofcofee=2;
                        tcoffee="Ice Blend";

                        break;
                    case R.id.a3:
                        typeofcofee=3;
                        tcoffee="Frappuccino";

                        break;
                    case R.id.a4:
                        tcoffee="Mocha";
                        typeofcofee=4;
                        break;

                }
            }
        });



        swtch= (Switch) findViewById(R.id.swtch);
        seekBar.setOnSeekBarChangeListener(
                new OnSeekBarChangeListener() {


                    @Override
                    public void onProgressChanged(SeekBar seekBar,
                                                  int progresValue, boolean fromUser) {
                        progress = progresValue;
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        // Display the value in textview
                        textView.setText(progress + "%");

                    }
                });




        swtch.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if(isChecked==true) {
                    swtitchboolen=true;
                    swt="With Whip Cream";

                }
                else
                {
                    swtitchboolen=false;
                    swt="WithOut Whip Cream";

                }
            }
        });
    }


}





