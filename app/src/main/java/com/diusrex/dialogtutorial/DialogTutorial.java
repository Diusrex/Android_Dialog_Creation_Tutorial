package com.diusrex.dialogtutorial;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

public class DialogTutorial extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_tutorial);
    }

    // Button onClick functions
    public void displayOnCreateViewDialogFragment(View v) {
        OnCreateViewDialogFragment fragment = OnCreateViewDialogFragment.newInstance("On Create View DialogFragment");
        showDialogFragment(fragment);
    }

    public void displayOnCreateDialogFragment(View v) {
        OnCreateDialogFragment fragment = OnCreateDialogFragment.newInstance("Message");
        showDialogFragment(fragment);
    }

    public void displayBareAlertDialog(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Hi there")
                .setPositiveButton("Positive", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Perform any other actions here
                        // Will be dismissed automatically
                    }
                })
                .setNegativeButton("Negative", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        /// Perform any other actions here
                        // Will be dismissed automatically
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showDialogFragment(DialogFragment fragment) {
        fragment.show(getFragmentManager(), "dialog");
    }
}
