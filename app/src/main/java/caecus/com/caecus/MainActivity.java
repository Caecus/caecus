package caecus.com.caecus;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

import caecus.com.caecus.FollowMe.DestinoListActivity;
import caecus.com.caecus.Help.helpMenu;

public class MainActivity extends AppCompatActivity {

    // sesion
    UserSessionManager session;

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TextView txtCodigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new UserSessionManager(getApplicationContext());
        HashMap<String, String> user = session.getUserDetails();
        //if (session.checkLogin())finish(); Lucas lo comento asi no va para el login


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        //txtCodigo= (TextView) findViewById(R.id.txtCodigo);
        //txtCodigo.setVisibility(View.INVISIBLE);



    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());
        adapter.addFragment(FollowmeFragment.newInstance("this data is for fragment 3"), "Three");
        adapter.addFragment(HelpFragment.newInstance("this data is for fragment 1"), "One");
        adapter.addFragment(AyudanteFragment.newInstance("this data is for fragment 2"), "Two");


        viewPager.setAdapter(adapter);

    }
    public void onHelp(View view) {
        Intent intent1 = new Intent(this, helpMenu.class);
        startActivity(intent1);
    }
    public void onFollowMe(View view) {
        Intent intent1 = new Intent(this, DestinoListActivity.class);
        startActivity(intent1);

    }
    public void onCrearCodigo(View view) {
        Intent intent1 = new Intent(this, AdmAyudante.class);
        startActivity(intent1);


        /*
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://www.google.com";
        String complemento = String.valueOf(codigo);

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url + complemento,
                new ResponseInt.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new ResponseInt.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //txtCodigo.setText("Error!:(");
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Bearer " + session.getUserDetails().get(UserSessionManager.KEY_TOKEN));
                return headers;
            }
        };
// Add the request to the RequestQueue.
        queue.add(stringRequest); */




    }
}
