package com.example.showusersonfragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class SelectUserFragment extends Fragment {

    //Definimos esse atributo que terá como função receber meu listener no onAttach
    OnSelectUserListener onSelectUserListener;

    //Definimos que vai "executar" o listener
    Button button1, button2, button3;

    public SelectUserFragment() {
        // Required empty public constructor
    }

    public static SelectUserFragment newInstance() {
        SelectUserFragment selectUserFragment = new SelectUserFragment();
        //Caso houver parâmetros deverão ser colocados dentro de um objeto Bundle
        //e passado através do método fragment.setArguments(Bundle)
        return selectUserFragment;
    }


    //Definir interface para o listener
    public interface OnSelectUserListener {
        public void onUserSelected(int id);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OnSelectUserListener) {
            onSelectUserListener = (OnSelectUserListener)context;
        } else {
            throw new ClassCastException("Zebra! Contexto não implementa a interface OnSelectUserListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Caso existir argumentos devê-se utilizar o getArguments();
        //if(getArguments() != null)


        View v = inflater.inflate(R.layout.fragment_select_user, container, false);
        button1 = v.findViewById(R.id.button1);
        button2 = v.findViewById(R.id.button2);
        button3 = v.findViewById(R.id.button3);

        //@todo melhorar para um click listener
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onSelectUserListener.onUserSelected(1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onSelectUserListener.onUserSelected(21);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onSelectUserListener.onUserSelected(3);
            }
        });

        return v;
    }

   /*public void selectUserOnClick(View view) {
        Log.d("SelectUserFragment", "Aqui chegou");
        switch (view.getId()) {
            case R.id.button1:
                onSelectUserListener.onUserSelected(1);
                break;
            case R.id.button2:
                onSelectUserListener.onUserSelected(2);
                break;
            case R.id.button3:
                onSelectUserListener.onUserSelected(3);
                break;
        }
    }*/
}
