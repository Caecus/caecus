package caecus.com.caecus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import java.util.HashMap;

import caecus.com.caecus.Help.helpMenu;



public class Menu extends AppCompatActivity {
    //private static final int REQUEST_CONNECT_DEVICE_SECURE = 1;
    //private static final int REQUEST_CONNECT_DEVICE_INSECURE = 2;
    //private static final int REQUEST_ENABLE_BT = 3;
    // sesion
    UserSessionManager session;
    /**
     * Local Bluetooth adapter
     */
    //private BluetoothAdapter mBluetoothAdapter = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        session = new UserSessionManager(getApplicationContext());
        HashMap<String, String> user = session.getUserDetails();
       // if (session.checkLogin())finish();


        /*Crear una instacia de GoogleAPIClient.
        if(mGoogleApiClient == null){
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }
        */
        //Bluetooth
        //mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        //if (mBluetoothAdapter == null) {
            // Device does not support Bluetooth
        //}
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    public void onStart() {
        super.onStart();
        /*
        If BT is not on, request that it be enabled.
        setupChat() will then be called during onActivityResult

        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
            // Otherwise, setup the chat session
        } else if (mChatService == null) {
            setupChat();
        }*/
    }
    public void onFollowMe(View view) {
        Intent intent1 = new Intent(this, AdmAyudante.class);
        startActivity(intent1);
    }
    public void onHelp(View view) {
        Intent intent1 = new Intent(this, helpMenu.class);
        startActivity(intent1);
    }
}
