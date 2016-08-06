package com.seniordesign.appmd;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.AlertDialog;
import android.view.View;

import java.util.Calendar;

/**
 * Created by lindsayherron on 8/6/16.
 */
public class DialogMaker extends DialogFragment {
    public Dialog onCreateDialog(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage("Would you like to create an event?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(Intent.ACTION_INSERT);
                        intent.setType("vnd.android.cursor.item/event");

                        Calendar cal = Calendar.getInstance();
                        long startTime = cal.getTimeInMillis();
                        long endTime = cal.getTimeInMillis()  + 60 * 60 * 1000;

                        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime);
                        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,endTime);
                        intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);

                        intent.putExtra(CalendarContract.Events.TITLE, "Neel Birthday");
                        intent.putExtra(CalendarContract.Events.DESCRIPTION,  "This is a sample description");
                        intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "My Guest House");
                        intent.putExtra(CalendarContract.Events.RRULE, "FREQ=YEARLY");

                        startActivity(intent);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();

    }
}
