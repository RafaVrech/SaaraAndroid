package com.example.rafavrech.saara;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class DialogAnotacao  extends DialogFragment {

    public static DialogAnotacao newInstance(String titulo, String mensagem) {
        DialogAnotacao f = new DialogAnotacao();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putString("titulo", titulo);
        args.putString("mensagem", mensagem);
        f.setArguments(args);

        return f;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getArguments().getString("titulo"));
        builder.setMessage(getArguments().getString("mensagem"));
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // You don't have to do anything here if you just
                // want it dismissed when clicked
            }
        });

        // Create the AlertDialog object and return it
        return builder.create();
    }
}

