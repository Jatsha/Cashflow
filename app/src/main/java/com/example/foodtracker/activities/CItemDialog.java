package com.example.foodtracker.activities;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.foodtracker.R;

public class CItemDialog extends AppCompatDialogFragment {
    private EditText editTextName;
    private EditText editTextPrice;
    private CItemDialogListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_newentry, null);

        builder.setView(view)
                .setTitle("New Item")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = editTextName.getText().toString();
                        String price = editTextPrice.getText().toString();
                        listener.addItem(name, price);
                    }
                });
        editTextName = view.findViewById(R.id.c_item_name);
        editTextPrice = view.findViewById(R.id.c_item_cost);

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (CItemDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement CItemDialogListener");
        }
    }

    public interface CItemDialogListener{
        void addItem(String name, String price);

    }
}
