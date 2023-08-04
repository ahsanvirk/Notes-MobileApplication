package com.example.p4cis436;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

public class stacks extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new stacksItems(getApplicationContext(),intent);
    }
    class stacksItems implements RemoteViewsFactory{
        private Context context;
        private int widget;
        private String[] exitems={"Hello", "Welcome", "to","our","database"
                ,"app"};
        stacksItems(Context context,Intent intent){
            this.context = context;
            this.widget = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID);
        }
        @Override
        public void onCreate() {
            SystemClock.sleep(3000);
        }

        @Override
        public void onDataSetChanged() {

        }

        @Override
        public void onDestroy() {

        }

        @Override
        public int getCount() {
            return exitems.length;
        }

        @Override
        public RemoteViews getViewAt(int i) {
            RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.itemtext);
            views.setTextViewText(R.id.textitem,exitems[i]);
            SystemClock.sleep(500);
            return views;
        }

        @Override
        public RemoteViews getLoadingView() {
            return null;
        }

        @Override
        public int getViewTypeCount() {
            return 1;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }
    }
}
