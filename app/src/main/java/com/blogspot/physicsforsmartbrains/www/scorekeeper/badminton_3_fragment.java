package com.blogspot.physicsforsmartbrains.www.scorekeeper;

import android.content.DialogInterface;
import android.os.CountDownTimer;
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
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.R.attr.max;
import static com.blogspot.physicsforsmartbrains.www.scorekeeper.R.id.layout_reset_click;
import static com.blogspot.physicsforsmartbrains.www.scorekeeper.R.id.timer;

public class badminton_3_fragment extends Fragment {
    private String m_Text = "";
    private String m_min = "";
    public String seconds;
    public int minutes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.activity_badminton_3_fragment, container, false);

        Button buttona = (Button) v.findViewById(R.id.start);
        buttona.setOnClickListener(badButtonA);

        LinearLayout timert = (LinearLayout) v.findViewById(layout_reset_click);
        timert.setOnClickListener(timertr);
        return v;
    }

    public void timertrak(long t){

        new CountDownTimer(t, 1000) {

            final TextView text1 = (TextView) getView().findViewById(timer);

            public void onTick(long millisUntilFinished) {
                text1.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                text1.setText("" + 0);
                minute_trak(minutes*60000);
            }
        }.start();
    }

    public void minute_trak(long t){
        new CountDownTimer(t, 60000) {

            final TextView text1=(TextView)getView().findViewById(R.id.miutes);
            public void onTick(long millisUntilFinished) {
                text1.setText("" + millisUntilFinished / 60000);
                //for seconds
                new CountDownTimer(60000, 1000) {

                    final TextView text2 = (TextView) getView().findViewById(timer);

                    public void onTick(long millisUntilFinished) {
                        text2.setText("" + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        text2.setText("" + 0);
                    }
                }.start();
            }
            public void onFinish() {
                text1.setText(""+0);
                new CountDownTimer(60000, 1000) {

                    final TextView text2 = (TextView) getView().findViewById(timer);

                    public void onTick(long millisUntilFinished) {
                        text2.setText("" + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        text2.setText("" + 0);
                    }
                }.start();
            }
        }.start();
    }

    private View.OnClickListener badButtonA = new View.OnClickListener() {
        public void onClick(View view) {
            TextView text = (TextView)getView().findViewById(timer);
            String value = text.getText().toString();
            int l = Integer.parseInt(value);

            TextView tex = (TextView)getView().findViewById(R.id.miutes);
            String valu = tex.getText().toString();
            int ll =Integer.parseInt(valu);

            //to get second less thann 60 its remainder
            int s;
            s=(l%60);
            s=s*1000;
            timertrak(s);

            int m;
            m=(l/60)+ll;
            minutes=m;
        }
    };

    private View.OnClickListener timertr = new View.OnClickListener() {
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Enter time below");
//        builder.setMessage("Seconds")
// Set up the input
            LinearLayout layout = new LinearLayout(getActivity());
            layout.setOrientation(LinearLayout.VERTICAL);

            final EditText input = new EditText(getActivity());
            input.setHint("Minutes");
            layout.addView(input);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
            input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_DATETIME);
            builder.setView(input);

            final EditText inpu = new EditText(getActivity());
            inpu.setHint("Seconds");
            layout.addView(inpu);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
            inpu.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_DATETIME);
            builder.setView(inpu);
            builder.setView(layout);

// Set up the buttons
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //seconds
                    m_Text = inpu.getText().toString();
                    TextView scoreView = (TextView) getView().findViewById(timer);
                    scoreView.setText(String.valueOf(m_Text));
                    seconds=m_Text;

                    //minutes
                    m_min = input.getText().toString();
                    TextView scoreVie = (TextView) getView().findViewById(R.id.miutes);
                    scoreVie.setText(String.valueOf(m_min));
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
