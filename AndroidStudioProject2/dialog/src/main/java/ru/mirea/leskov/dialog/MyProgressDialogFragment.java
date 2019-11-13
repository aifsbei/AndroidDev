package ru.mirea.leskov.dialog;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class MyProgressDialogFragment extends DialogFragment {
    public Dialog onCreateDialog(Bundle savedInstanceState){
        ProgressDialog progressdialog =  new ProgressDialog(getActivity(), getTheme());
        progressdialog.setTitle("Progress dialog");
        progressdialog.setMessage("Please wait");
        progressdialog.setIndeterminate(true);
        progressdialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        return progressdialog;
    }
}
