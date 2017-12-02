package com.blogspot.physicsforsmartbrains.www.scorekeeper;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class basketball_2_fragment extends Fragment {
    private String m_Text = "";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v =inflater.inflate(R.layout.activity_basketball_2_fragment,container,false);

        Button button = (Button)v.findViewById(R.id.threepointa);
        button.setOnClickListener(mCorkyListener);

        Button button2 = (Button)v.findViewById(R.id.threepointb);
        button2.setOnClickListener(mCorkyListener2);

        Button button3 = (Button)v.findViewById(R.id.a2);
        button3.setOnClickListener(mCorkyListener3);

        Button button4 = (Button)v.findViewById(R.id.a3);
        button4.setOnClickListener(mCorkyListener4);

        Button button5 = (Button)v.findViewById(R.id.b2);
        button5.setOnClickListener(mCorkyListener5);

        Button button6 = (Button)v.findViewById(R.id.b1);
        button6.setOnClickListener(mCorkyListener6);

        Button button7 = (Button)v.findViewById(R.id.bb_reset);
        button7.setOnClickListener(mCorkyListener7);

        TextView button8 = (TextView) v.findViewById(R.id.bad_pla);
        button8.setOnClickListener(mCorkyListener8);

        TextView button9 = (TextView)v.findViewById(R.id.bad_plb);
        button9.setOnClickListener(mCorkyListener9);

        Button undoa = (Button)v.findViewById(R.id.bb_undo_a);
        undoa.setOnClickListener(aCorkyListener);

        Button undob = (Button)v.findViewById(R.id.bb_undo_b);
        undob.setOnClickListener(bCorkyListener);
        return v;
    }

    int n,m,na,mb;

    private View.OnClickListener aCorkyListener = new View.OnClickListener() {
        public void onClick(View view) {
            n=na;
            display(na);
            Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
    };

    private View.OnClickListener bCorkyListener = new View.OnClickListener() {
        public void onClick(View view) {
            m=mb;
            displayb(mb);
            Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
    };

    private View.OnClickListener mCorkyListener = new View.OnClickListener() {
        public void onClick(View view) {
            na=n;
            n=n+3;
            display(n);
            Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
    };
    private void display(int number) {
        TextView quantityTextView = (TextView) getView().findViewById(R.id.scorea);
        quantityTextView.setText("" + number);
    }
    private View.OnClickListener mCorkyListener2 = new View.OnClickListener() {
        public void onClick(View view) {
            mb=m;
            m=m+3;
            displayb(m);
            Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
    };
    private View.OnClickListener mCorkyListener3 = new View.OnClickListener() {
        public void onClick(View view) {
            na=n;
            n=n+2;
            display(n);
            Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
    };
    private View.OnClickListener mCorkyListener4 = new View.OnClickListener() {
        public void onClick(View view) {
            na=n;
            n=n+1;
            display(n);
            Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
    };
    private View.OnClickListener mCorkyListener5 = new View.OnClickListener() {
        public void onClick(View view) {
            mb=m;
            m=m+2;
            displayb(m);
            Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
    };
    private View.OnClickListener mCorkyListener6 = new View.OnClickListener() {
        public void onClick(View view) {
            mb=m;
            m=m+1;
            displayb(m);
            Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
    };
    private void displayb(int number) {
        TextView quantityTextView = (TextView) getView().findViewById(R.id.scoreb);
        quantityTextView.setText("" + number);
    }

    private View.OnClickListener mCorkyListener7 = new View.OnClickListener() {
        public void onClick(View view) {
            n=0;
            m=0;
            display(n);
            displayb(m);
            Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
    };

    private View.OnClickListener mCorkyListener8 = new View.OnClickListener() {
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Player A");

// Set up the input
            final EditText input = new EditText(getActivity());
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
            input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_WORDS);
            builder.setView(input);

// Set up the buttons
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    m_Text = input.getText().toString();
                    TextView scoreView = (TextView) getView().findViewById(R.id.bad_pla);
                    scoreView.setText(String.valueOf(m_Text));
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();
        }
    };
    private View.OnClickListener mCorkyListener9 = new View.OnClickListener() {
        public void onClick(View view) {

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Player B");

// Set up the input
            final EditText input = new EditText(getActivity());
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
            input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_WORDS);
            builder.setView(input);

// Set up the buttons
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    m_Text = input.getText().toString();
                    TextView scoreView = (TextView) getView().findViewById(R.id.bad_plb);
                    scoreView.setText(String.valueOf(m_Text));
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();
        }
    };
}
