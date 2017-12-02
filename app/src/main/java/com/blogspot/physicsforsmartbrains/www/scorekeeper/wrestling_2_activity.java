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

import static android.R.attr.button;

public class wrestling_2_activity extends Fragment {
    private String m_Text = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_wrestling_2_activity, container, false);

        TextView buttonc = (TextView)v.findViewById(R.id.w_rename_pla);
        buttonc.setOnClickListener(wrenamepla);

        TextView buttond = (TextView)v.findViewById(R.id.w_rename_plb);
        buttond.setOnClickListener(wrenameplb);

        Button buttonb = (Button)v.findViewById(R.id.w_undo_b);
        buttonb.setOnClickListener(badButtonB);

        Button buttona = (Button)v.findViewById(R.id.w_undo_a);
        buttona.setOnClickListener(badButtonA);

        Button button1 = (Button)v.findViewById(R.id.point1teamA);
        button1.setOnClickListener(w_a_1);

        Button button2 = (Button)v.findViewById(R.id.point1teamB);
        button2.setOnClickListener(w_b_1);

        Button button3 = (Button)v.findViewById(R.id.point2teamA);
        button3.setOnClickListener(w_a_2);

        Button button4 = (Button)v.findViewById(R.id.point2teamB);
        button4.setOnClickListener(w_b_2);

        Button button5 = (Button)v.findViewById(R.id.point4teamA);
        button5.setOnClickListener(w_a_4);

        Button button6 = (Button)v.findViewById(R.id.point4teamB);
        button6.setOnClickListener(w_b_4);

        Button button7 = (Button)v.findViewById(R.id.point5teamA);
        button7.setOnClickListener(w_a_5);

        Button button8 = (Button)v.findViewById(R.id.point5teamB);
        button8.setOnClickListener(w_b_5);

        Button button9 = (Button)v.findViewById(R.id.w_reset);
        button9.setOnClickListener(w_set);
        return v;
    }

    int scoreTeamA=0;
    int m,n;
    int scoreTeamB=0;

    private View.OnClickListener w_a_1 = new View.OnClickListener() {
        public void onClick(View view) {
            m=scoreTeamA;
            scoreTeamA=scoreTeamA+1;
            displayForTeamA(scoreTeamA);
            Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
    };

    private View.OnClickListener w_b_1 = new View.OnClickListener() {
        public void onClick(View view) {
            n=scoreTeamB;
            scoreTeamB=scoreTeamB+1;
            displayForTeamB(scoreTeamB);
            Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
    };

    private View.OnClickListener w_a_2 = new View.OnClickListener() {
        public void onClick(View view) {
            m=scoreTeamA;
            scoreTeamA=scoreTeamA+2;
            displayForTeamA(scoreTeamA);
            Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
    };

    private View.OnClickListener w_b_2 = new View.OnClickListener() {
        public void onClick(View view) {
            n=scoreTeamB;
            scoreTeamB=scoreTeamB+2;
            displayForTeamB(scoreTeamB);
            Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
    };

    private View.OnClickListener w_a_4 = new View.OnClickListener() {
        public void onClick(View view) {
            m=scoreTeamA;
            scoreTeamA=scoreTeamA+4;
            displayForTeamA(scoreTeamA);
            Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
    };

    private View.OnClickListener w_b_4 = new View.OnClickListener() {
        public void onClick(View view) {
            n=scoreTeamB;
            scoreTeamB=scoreTeamB+4;
            displayForTeamB(scoreTeamB);
            Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
    };

    private View.OnClickListener w_a_5 = new View.OnClickListener() {
        public void onClick(View view) {
            m=scoreTeamA;
            scoreTeamA=scoreTeamA+5;
            displayForTeamA(scoreTeamA);
            Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
    };

    private View.OnClickListener w_b_5 = new View.OnClickListener() {
        public void onClick(View view) {
            n=scoreTeamB;
            scoreTeamB=scoreTeamB+5;
            displayForTeamB(scoreTeamB);
            Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
    };

    private View.OnClickListener badButtonB = new View.OnClickListener() {
        public void onClick(View view) {
            scoreTeamB=n;
            displayForTeamB(n);
            Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
    };
    private View.OnClickListener badButtonA = new View.OnClickListener() {
        public void onClick(View view) {
            scoreTeamA=m;
            displayForTeamA(m);
            Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
    };

    public void displayForTeamA(int t) {
        TextView scoreView = (TextView) getView().findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(t));
    }
    public void displayForTeamB(int t) {
        TextView scoreView = (TextView) getView().findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(t));
    }

    private View.OnClickListener w_set = new View.OnClickListener() {
        public void onClick(View view) {
            scoreTeamA=0;
            scoreTeamB=0;
            displayForTeamA(0);
            displayForTeamB(0);
            Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
    };

    private View.OnClickListener wrenamepla = new View.OnClickListener() {
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Blue Player");

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
                    TextView scoreView = (TextView) getView().findViewById(R.id.w_rename_pla);
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
    private View.OnClickListener wrenameplb = new View.OnClickListener() {
        public void onClick(View view) {

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Red Player");

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
                    TextView scoreView = (TextView) getView().findViewById(R.id.w_rename_plb);
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
