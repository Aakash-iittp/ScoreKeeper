package com.blogspot.physicsforsmartbrains.www.scorekeeper;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.os.Handler;
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
import static com.blogspot.physicsforsmartbrains.www.scorekeeper.R.id.timeView;


public class badminton_3_fragment extends Fragment {
    private String m_Text = "";
    private String m_min = "";
    private int seconds;
    private boolean running;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.activity_badminton_3_fragment, container, false);


        Button buttona = (Button) v.findViewById(R.id.start);
        buttona.setOnClickListener(badButtonA);
        Button buttonb = (Button) v.findViewById(R.id.stop);
        buttonb.setOnClickListener(badButtonB);
        Button buttonc = (Button) v.findViewById(R.id.reset);
        buttonc.setOnClickListener(badButtonC);
        TextView timert = (TextView) v.findViewById(timeView);
        timert.setOnClickListener(timertr);
        return v;
    }

    private int i=0;
    private View.OnClickListener badButtonA = new View.OnClickListener() {
        public void onClick(View view) {
           running=true;

           if(i==0){runTimer();}
            i++;

        }
    };
    private View.OnClickListener badButtonB = new View.OnClickListener() {
        public void onClick(View view) {
            running= false;
        }
    };
    private View.OnClickListener badButtonC = new View.OnClickListener() {
        public void onClick(View view) {
            running= false;
            seconds=0;
//            i=0;
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
//                    TextView scoreView = (TextView) getView().findViewById(timer);
//                    scoreView.setText(String.valueOf(m_Text));
//                    seconds=m_Text;

                    //minutes
                    m_min = input.getText().toString();
//                    TextView scoreVie = (TextView) getView().findViewById(R.id.miutes);
//                    scoreVie.setText(String.valueOf(m_min));
                    int result = Integer.parseInt(m_Text);
                    int resultm = Integer.parseInt(m_min);
                    seconds= result + (resultm*60);
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

    private void runTimer(){
        final TextView textView = (TextView) getView().findViewById(R.id.timeView);
        final Handler handler = new Handler();
        handler.post(new Runnable(){
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String time = String.format("%02d:%02d:%02d", hours, minutes, secs);
                textView.setText(time);
                if (running && seconds>0) {
                    seconds--;
                }
                handler.postDelayed(this,1000);
            }
        });
    }

}
