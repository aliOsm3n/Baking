package com.example.aliothman.baking;

import android.content.Intent;
import android.widget.RemoteViewsService;

/**
 * Created by Ali Othman on 21/06/2017.
 */

public class WidgetService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new WidgetViews(this.getApplicationContext());
    }
}
