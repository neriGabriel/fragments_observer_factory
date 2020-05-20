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
/*
* Quando estamos mexendo com fragments não conseguimos referenciar diretamente no componente o onClick
* então temos vários métodos de implementação, um dos utilizados é implementar a interface View.OnClickListener
* gerar o método necessário e utiliza-lo.
* Quando for necessário basta somente adicionar .setOnClickListener(this) ao componente que irá entender.
* */
public class SelectUserFragment extends Fragment implements View.OnClickListener{

    //Definimos esse atributo que terá como função receber meu listener no onAttach
    OnSelectUserListener onSelectUserListener;

    //Definimos quem vai "executar" o listener
    Button button1, button2, button3;

    public SelectUserFragment() {
        // Required empty public constructor
    }


    //Método factory para seguir um padrão de projetos.
    public static SelectUserFragment newInstance() {
        SelectUserFragment selectUserFragment = new SelectUserFragment();
        //Caso houver parâmetros deverão ser colocados dentro de um objeto Bundle
        //e passado através do método fragment.setArguments(Bundle)
        return selectUserFragment;
    }

    //Definir interface para o listener, que será implementado na main
    public interface OnSelectUserListener {
        public void onUserSelected(int id);
    }

    //Verifico se o listener recebido pelo método onAttach é válido
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OnSelectUserListener) {
            //faço o casting da variavel
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

        button1.setOnClickListener(this);

        button2.setOnClickListener(this);

        button3.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {
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
    }
}
