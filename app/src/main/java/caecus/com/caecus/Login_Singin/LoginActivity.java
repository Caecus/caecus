package caecus.com.caecus.Login_Singin;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import caecus.com.caecus.R;
//import com.example.windows.myapplication.MainActivity;
//import com.example.windows.myapplication.R;

public class LoginActivity extends AppCompatActivity {
    private TextView usuario;
    boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usuario = (TextView) findViewById(R.id.txtuser);
        String email = getEmail(this);
        usuario.setText(email);
        SharedPreferences caecusPreferencias = getSharedPreferences("CaecusPreferencias", 0);
        SharedPreferences.Editor prefEditor = caecusPreferencias.edit();
        prefEditor.putString("email",email);
        prefEditor.commit();
    }
    public void Login (View view)
    {
        Intent intent1 = new Intent(this,LoginPasswordActivity.class);
        startActivity(intent1);

    }
    private static String getEmail(Context context) {
        AccountManager accountManager = AccountManager.get(context);
        Account account = getAccount(accountManager);
        String S;
        if (account == null) {
            return null;
        } else {
            return account.name;
        }
    }

    private static Account getAccount(AccountManager accountManager) {
        Account[] accounts = accountManager.getAccountsByType("com.google");
        Account account;
        if (accounts.length > 0) {
            account = accounts[0];
        } else {
            account = null;
        }
        return account;
    }

}
