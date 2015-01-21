package com.diusrex.dialogtutorial;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class OnCreateViewDialogFragment extends DialogFragment {
    private String output;

    public static OnCreateViewDialogFragment newInstance(String output) {
        OnCreateViewDialogFragment f = new OnCreateViewDialogFragment();

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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

        // Adding a title
        // WILL CAUSE AN EXCEPTION IF THE APP IS EMBEDDED
        //getDialog().setTitle("Title");

        return view;
    }

    /*
    // Removing the title
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog d = super.onCreateDialog(savedInstanceState);
        d.requestWindowFeature(Window.FEATURE_NO_TITLE);    // Remove the bar completely
        return d;
    }
    */
}
