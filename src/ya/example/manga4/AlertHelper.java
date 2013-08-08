package ya.example.manga4;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.*;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AlertHelper extends Activity{

	/** 
     * 警告メッセージを表示します。 
     * @param context 
     * @param message 
     * @param listenerOK 
     */  
    static void showPreImg(Context context,String message,DialogInterface.OnClickListener listenerOK,Bitmap bmp){  
    	LayoutInflater inflater = LayoutInflater.from(context);  
        final View view = inflater.inflate(R.layout.alert,null);  
        ImageView imgAlertIcon = (ImageView)view.findViewById(R.id.imageAlertIcon);  

        imgAlertIcon.setImageBitmap(bmp);  
        TextView lblMessage = (TextView)view.findViewById(R.id.lblMessage);  
        lblMessage.setText(message);  
        AlertDialog.Builder alert = new AlertDialog.Builder(context);          
        alert.setPositiveButton("OK",listenerOK);  
        alert.setView(view);  
        alert.show();      
    }

	
      
}
