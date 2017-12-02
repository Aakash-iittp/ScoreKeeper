package com.blogspot.physicsforsmartbrains.www.scorekeeper;

import android.content.DialogInterface;
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

import static android.R.id.button3;

public class soccor_2_fragment extends Fragment {
    private String m_Text = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_soccor_2_fragment, container, false);
        Button button = (Button) v.findViewById(R.id.s_undo_a);
        button.setOnClickListener(aListener);

        Button button2 = (Button) v.findViewById(R.id.s_undo_b);
        button2.setOnClickListener(bListener);

        TextView button3 = (TextView) v.findViewById(R.id.soccor_pla);
        button3.setOnClickListener(s_rename_a);

        TextView button4 = (TextView) v.findViewById(R.id.soccor_plb);
        button4.setOnClickListener(s_rename_b);

        Button button5= (Button) v.findViewById(R.id.point1teamA);
        button5.setOnClickListener(s_p1_a);

        Button button6= (Button) v.findViewById(R.id.point1teamB);
        button6.setOnClickListener(s_p1_b);

        Button button7= (Button) v.findViewById(R.id.soc_rest);
        button7.setOnClickListener(s_reset);
        return v;
    }

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    private View.OnClickListener aListener = new View.OnClickListener() {
        public void onClick(View view) {
            scoreTeamA--;
            displayForTeamA(scoreTeamA);
        }
    };
    private View.OnClickListener bListener = new View.OnClickListener() {
        public void onClick(View view) {
            scoreTeamB--;
            displayForTeamB(scoreTeamB);
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


    private View.OnClickListener s_p1_a = new View.OnClickListener() {
        public void onClick(View view) {
            scoreTeamA = scoreTeamA + 1;
            displayForTeamA(scoreTeamA);
        }
    };

    private View.OnClickListener s_p1_b = new View.OnClickListener() {
        public void onClick(View view) {
            scoreTeamB = scoreTeamB + 1;
            displayForTeamB(scoreTeamB);
        }
    };

    private View.OnClickListener s_reset = new View.OnClickListener() {
        public void onClick(View view) {
            scoreTeamA = 0;
            scoreTeamB = 0;
            displayForTeamA(0);
            displayForTeamB(0);
        }
    };


    private View.OnClickListener s_rename_a = new View.OnClickListener() {
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Team A");

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
                    TextView scoreView = (TextView) getView().findViewById(R.id.soccor_pla);
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

    private View.OnClickListener s_rename_b = new View.OnClickListener() {
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Team B");

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
                    TextView scoreView = (TextView) getView().findViewById(R.id.soccor_plb);
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
