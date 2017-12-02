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

public class badminton_2_fragment extends Fragment {
    private String m_Text = "";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v =inflater.inflate(R.layout.activity_badminton_2_fragment,container,false);

        Button buttona = (Button) v.findViewById(R.id.bad_one_a);
        buttona.setOnClickListener(badButtonA);

        Button buttonb = (Button)v.findViewById(R.id.bad_one_b);
        buttonb.setOnClickListener(badButtonB);

        Button badreset = (Button)v.findViewById(R.id.badreset);
        badreset.setOnClickListener(resetbutton);

        Button badundoa = (Button) v.findViewById(R.id.bad_undo_a);
        badundoa.setOnClickListener(bad_undo_a);

        Button badundob = (Button)v.findViewById(R.id.bad_undo_b);
        badundob.setOnClickListener(bad_undo_b);

        TextView bad_name_a = (TextView) v.findViewById(R.id.namea);
        bad_name_a.setOnClickListener(namea);

        TextView bad_name_b = (TextView) v.findViewById(R.id.nameb);
        bad_name_b.setOnClickListener(nameb);

        return v;
    }


    int n,m,mb,na;

    private View.OnClickListener bad_undo_a = new View.OnClickListener() {
        public void onClick(View view) {
            n=na;
            display(na);
            Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
    };
    private View.OnClickListener bad_undo_b = new View.OnClickListener() {
        public void onClick(View view) {
            m=mb;
            displayb(mb);
            Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
    };


    private View.OnClickListener badButtonA = new View.OnClickListener() {
        public void onClick(View view) {
            na=n;
            n=n+1;
            display(n);
            Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
    };

    private View.OnClickListener badButtonB = new View.OnClickListener() {
        public void onClick(View view) {
            mb=m;
            m=m+1;
//            String team =teamb +"*";
//            displayMessageb(team);
//            displayMessagea(teama);
            displayb(m);
            Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
    };


    private View.OnClickListener resetbutton = new View.OnClickListener() {
        public void onClick(View view) {
            n=0;
            m=0;
            display(n);
            displayb(m);
            Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
    };

    private void display(int number) {
        TextView quantityTextView = (TextView) getView().findViewById(R.id.badscorea);
        quantityTextView.setText("" + number);
    }
    private void displayb(int number) {
        TextView quantityTextView = (TextView) getView().findViewById(R.id.badscoreb);
        quantityTextView.setText("" + number);
    }

    private View.OnClickListener namea = new View.OnClickListener() {
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
                    TextView scoreView = (TextView) getView().findViewById(R.id.namea);
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

    private View.OnClickListener nameb = new View.OnClickListener() {
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
                    TextView scoreView = (TextView) getView().findViewById(R.id.nameb);
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

