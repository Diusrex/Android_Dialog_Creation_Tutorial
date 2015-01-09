package com.diusrex.dialogtutorial;

import android.app.Activity;
import android.app.DialogFragment;
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

    private void showDialogFragment(DialogFragment fragment) {
        fragment.show(getFragmentManager(), "dialog");
    }
}
