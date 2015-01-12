package com.diusrex.dialogtutorial;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class OnCreateDialogFragment extends DialogFragment {
    private String output;

    public static OnCreateDialogFragment newInstance(String output) {
        OnCreateDialogFragment f = new OnCreateDialogFragment();

        // Give arguments
        Bundle args = new Bundle();
        args.putString("output", output);
        // Save additional arguments here
        f.setArguments(args);

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        output = getArguments().getString("output");
        // Load any additional arguments here
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Title")
                .setMessage(output)
                .setPositiveButton("Positive", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Perform any other actions here
                        // Will be dismissed automatically
                    }
                })
                .setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
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

        return builder.create();
    }
}

