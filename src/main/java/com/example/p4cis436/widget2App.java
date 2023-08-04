package com.example.p4cis436;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.Toast;

public class widget2App extends AppWidgetProvider {
    private static final String toast1 = "This is our third widget";
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for(int appWidgetId : appWidgetIds) {
            Intent intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
            @SuppressLint("RemoteViewLayout") RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget2);
            //views.setOnClickPendingIntent(R.id.button_apply, pendingIntent);
            views.setOnClickPendingIntent(R.id.readtoast,
                    getPendingSelfIntent(context, toast1));
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }

    }

    protected PendingIntent getPendingSelfIntent(Context context, String action) {
        Intent intent = new Intent(context, getClass());
        intent.setAction(action);
        return PendingIntent.getBroadcast(context, 0, intent, 0);
    }
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if (toast1.equals(intent.getAction())) {
            Toast.makeText(context, "Welcome to our database!", Toast.LENGTH_SHORT).show();
        }
    }

}
