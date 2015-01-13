package com.diusrex.dialogtutorial;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class OnCreateDialogAndViewDialogFragment extends DialogFragment {
    private String output;

    public static OnCreateDialogAndViewDialogFragment newInstance(String output) {
        OnCreateDialogAndViewDialogFragment f = new OnCreateDialogAndViewDialogFragment();

        // Give arguments. If you don't have any, then can remove the next two lines
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getShowsDialog()) {
            return super.onCreateView(inflater, container, savedInstanceState);
        } else {
            // This is the exact code used for OnCreateViewDialogFragment
            View view = inflater.inflate(R.layout.dialog_standard_view, container, false);

            // Set up the TextView
            TextView outputTV = (TextView) view.findViewById(R.id.output);
            outputTV.setText(output);

            // Set up the button
            Button button = (Button) view.findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Perform any other actions here
                    dismiss(); // Without this dismiss, will not go away
                }
            });

            // No need to have code to alter dialog title

            return view;
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // This is the exact code used for OnCreateDialogFragment
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
