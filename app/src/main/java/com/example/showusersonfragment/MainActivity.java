package com.example.showusersonfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectUserFragment.OnSelectUserListener{

    private List<User> userList = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.populate();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_select_user, SelectUserFragment.newInstance())
                .commit();
    }

    @Override
    public void onUserSelected(int id) {
        //Toast.makeText(this, String.valueOf(id), Toast.LENGTH_SHORT).show();
        //Chamo meu método que "atualizara/chamará" a fragment
        updateUserDetailFragment(id);
    }

    private void updateUserDetailFragment(int id) {
        //As escolhas dos botões são, 1,2,3 então é necessário converte-la para os indicies da lista
        // 1 = 0
        // 2 = 1
        // 3 = 2
        int userPosition = id - 1;
        //Chamo a nova fragment, usando o repalce
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_show_user, UserDetailFragment.newInstance(userList.get(userPosition)))
                .commit();
    }

    //Método para startar a lista
    private void populate() {
        User obj1 = new User(0, "Amanda", "Manda");
        User obj2 = new User(1, "Cléo", "Cléo");
        User obj3 = new User(2, "Margarida", "Margarida");

        this.userList.add(obj1);
        this.userList.add(obj2);
        this.userList.add(obj3);
    }
}
