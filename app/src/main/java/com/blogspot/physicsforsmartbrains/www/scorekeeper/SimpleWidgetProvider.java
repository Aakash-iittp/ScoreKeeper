package com.blogspot.physicsforsmartbrains.www.scorekeeper;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import java.util.Random;

/**
 * Created by HP Customer on 17-07-2017.
 */

public class SimpleWidgetProvider extends AppWidgetProvider {

    double wsteps=steps.getStepsWalked();
//    double number;

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        final int count = appWidgetIds.length;

        for (int i = 0; i < count; i++) {
            int widgetId = appWidgetIds[i];
//            number=wsteps*2;
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.simple_widget);
            remoteViews.setTextViewText(R.id.textView, Double.toString(wsteps));

//            RemoteViews remoteDViews = new RemoteViews(context.getPackageName(), R.layout.simple_widget);
//            remoteDViews.setTextViewText(R.id.distanceView, Double.toString(number));


            Intent intent = new Intent(context, SimpleWidgetProvider.class);
            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);
            appWidgetManager.updateAppWidget(widgetId, remoteViews);
        }
    }
}
