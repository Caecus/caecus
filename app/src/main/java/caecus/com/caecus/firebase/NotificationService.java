package caecus.com.caecus.firebase;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import caecus.com.caecus.MainActivity;
import caecus.com.caecus.R;


public class NotificationService extends FirebaseMessagingService {

    public static final String TAG = "FIREBASE";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        //super.onMessageReceived(remoteMessage);
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Notification Message Body: " + remoteMessage.getData());
        enviarNotificacion(remoteMessage);

    }

    public void enviarNotificacion(RemoteMessage remoteMessage) {

        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("LAT", Double.parseDouble(remoteMessage.getData().get("lat")));
        i.putExtra("LNG", Double.parseDouble(remoteMessage.getData().get("lng")));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_ONE_SHOT);

        Uri sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificacion = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_person_add_black_24dp)
                .setContentTitle("Atencion")
                .setContentText(remoteMessage.getData().get("message"))
                .setAutoCancel(true)
                .setSound(sonido)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificacion.build());
    }
}