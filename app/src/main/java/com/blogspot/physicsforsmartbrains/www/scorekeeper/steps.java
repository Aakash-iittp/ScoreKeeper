package com.blogspot.physicsforsmartbrains.www.scorekeeper;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.blogspot.physicsforsmartbrains.www.scorekeeper.R.id.textView;

public class steps extends AppCompatActivity {

    private SensorManager mSensorManager;
    private Sensor mStepSensor;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps);

        mTextView = (TextView) findViewById(R.id.text_step);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mStepSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
    }

    public static double stp;

    private SensorEventListener mSensorEventListener = new SensorEventListener() {

        private float mStepOffset;

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            if (mStepOffset == 0) {
                mStepOffset = event.values[0];
            }
            stp=event.values[0] - mStepOffset;
            mTextView.setText(Float.toString(event.values[0] - mStepOffset));
            display(stp);
            clar();

        }



    };

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(mSensorEventListener, mStepSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(mSensorEventListener);

    }
    private void display(double number) {
        number=number*0.000762;
        TextView quantityTextView = (TextView) findViewById(R.id.distance);
        quantityTextView.setText(Double.toString(number));
    }
    public static double getStepsWalked() {
        return stp;
    }

    public void clar(){
        Intent intent = new Intent(this,SimpleWidgetProvider.class);
        intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        // Use an array and EXTRA_APPWIDGET_IDS instead of AppWidgetManager.EXTRA_APPWIDGET_ID,
// since it seems the onUpdate() is only fired on that:
        int ids[] = AppWidgetManager.getInstance(getApplication()).getAppWidgetIds(new ComponentName(getApplication(), SimpleWidgetProvider.class));

        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS,ids);
        sendBroadcast(intent);
    }
}
