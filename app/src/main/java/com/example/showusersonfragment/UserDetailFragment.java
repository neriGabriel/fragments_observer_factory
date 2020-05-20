package com.example.showusersonfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserDetailFragment extends Fragment{

    public static final String USER_ARGUMENT = "USER_AGR";

    TextView textId;
    TextView textName;
    TextView textApelido;

    public UserDetailFragment() {
        // Required empty public constructor
    }


    public static UserDetailFragment newInstance(User user) {
        UserDetailFragment userDetailFragment = new UserDetailFragment();
        Bundle bundle = new Bundle();
        //Necessário implementar na classe user a interface Serializable
        bundle.putSerializable(USER_ARGUMENT, user);
        //Seto o bundle necessário
        userDetailFragment.setArguments(bundle);
        return userDetailFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Este fragment não precisa responder nada para a activty, ou seja, não tem observe
        View v = inflater.inflate(R.layout.fragment_user_detail, container, false);

        //Inicio meus componentes da view
        this.textId = v.findViewById(R.id.textView_user_id);
        this.textName = v.findViewById(R.id.textView_user_nome);
        this.textApelido = v.findViewById(R.id.textView_user_apelido);

        //Verifico se meus argumentos(bundle) passados não estão nulos
        if(getArguments() != null) {
            //Se não estiver nulo, pego meu objeto de usuario, através do getSerializable castando o mesmo e obtenho acesso as propriedades
            User user = (User)getArguments().getSerializable(USER_ARGUMENT);
            //Seto os valores nos componentes
            this.textId.setText(String.valueOf(user.getId() + 1));
            this.textName.setText(user.getNome());
            this.textApelido.setText(user.getApelido());
        }

        return v;
    }

}
