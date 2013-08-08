package ya.example.manga4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Environment;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;

public class DrawView extends View implements OnTouchListener {

	private int type = 0;	//繧､繝吶Φ繝医�繧ｿ繧､繝�	
	private float posx = 0.0f;	//繧､繝吶Φ繝医′襍ｷ縺阪◆X蠎ｧ讓�	
	private float posy = 0.0f;	//繧､繝吶Φ繝医′襍ｷ縺阪◆Y蠎ｧ讓�	
	private Path path = null;	//繝代せ
	private Bitmap bitmap = null;	//View縺ｮ迥ｶ諷九ｒ菫晏ｭ倥☆繧九◆繧√�Bitmap
	int haba = 22;
	String[] color_array = {"0","0","0"};
	private Canvas bmpCanvas;
	private Activity _context;
	private static Activity activity;
	int back = 0;
	
	public static void show(String str)
	{
		Toast.makeText(activity, str, Toast.LENGTH_SHORT).show();
	}
	
	public DrawView(Context context) {
		super(context);
		_context = (Activity)context;
		activity = _context;
		setOnTouchListener(this);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO 髢ｾ�ｪ陷肴�蜃ｽ隰瑚���ｹｧ蠕娯螺郢晢ｽ｡郢ｧ�ｽ郢晢ｿｽ繝ｩ郢晢ｽｻ郢ｧ�ｹ郢ｧ�ｿ郢晢ｿｽ		
		try{
			String act = "";
			type = event.getAction();	//郢ｧ�､郢晏生ﾎｦ郢晏現�ｽ郢ｧ�ｿ郢ｧ�､郢晢ｿｽ			
			posx = event.getX();	//郢ｧ�､郢晏生ﾎｦ郢晏現窶ｲ隘搾ｽｷ邵ｺ髦ｪ笳�陟趣ｽｧ隶難ｿｽ			
			posy = event.getY();	//郢ｧ�､郢晏生ﾎｦ郢晏現窶ｲ隘搾ｽｷ邵ｺ髦ｪ笳�陟趣ｽｧ隶難ｿｽ			
			//郢ｧ�､郢晏生ﾎｦ郢晏現�ｽ郢ｧ�ｿ郢ｧ�､郢晏干��ｸｺ�ｨ邵ｺ�ｫ陷�ｽｦ騾�ｿｽ�帝坎�ｭ陞ｳ�ｽ			
			switch(type){
			case MotionEvent.ACTION_DOWN:	//隴幢ｿｽ�ｽ邵ｺ�ｮ郢晄亢縺�ｹ晢ｽｳ郢晢ｿｽ				
				//郢昜ｻ｣縺帷ｹｧ雋橸ｿｽ隴帶ｺｷ蝟ｧ
				path = new Path();
				//郢昜ｻ｣縺帷ｸｺ�ｮ陝狗距縺帷ｸｺ�ｸ驕假ｽｻ陷搾ｿｽ				
				path.moveTo(posx, posy);
				act = "down";
				break;
			case MotionEvent.ACTION_MOVE:	//鬨ｾ豈費ｽｸ�ｭ邵ｺ�ｮ郢晄亢縺�ｹ晢ｽｳ郢晢ｿｽ		
				//邵ｺ�ｲ邵ｺ�ｨ邵ｺ�､陷鷹亂�ｽ郢晄亢縺�ｹ晢ｽｳ郢晏現ﾂｰ郢ｧ蟲ｨ�ｽ驍ｱ螢ｹ�定�霈費ｿ･
				path.lineTo(posx, posy);
				act = "move";
				break;
			case MotionEvent.ACTION_UP:	//隴幢ｿｽ�ｾ蠕鯉ｿｽ郢晄亢縺�ｹ晢ｽｳ郢晢ｿｽ			
				//邵ｺ�ｲ邵ｺ�ｨ邵ｺ�､陷鷹亂�ｽ郢晄亢縺�ｹ晢ｽｳ郢晏現ﾂｰ郢ｧ閾･�ｷ螢ｹ�定�霈費ｿ･
				path.lineTo(posx, posy);
				//霑ｴ�ｾ陜ｨ�ｨ邵ｺ�ｮView郢ｧ骰嬖tmap邵ｺ�ｫ闖ｫ譎擾ｽｭ蛟･笘�ｹｧ�ｽ			
				v.setDrawingCacheEnabled(true);
				bitmap = Bitmap.createBitmap(v.getDrawingCache());
				v.setDrawingCacheEnabled(false);
				act = "up";
			}
			//郢晢ｽｭ郢ｧ�ｰ郢ｧ螳夲ｽｿ�ｽ陷会ｿｽ			
			Log.v("MotionEvent","action=" + act + "&x=" + posx + "&y=" + posy);
			//View郢ｧ蜻亥ｳｩ隴�ｽｰ邵ｺ蜷ｶ��			
			v.invalidate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		//髢ｭ譴ｧ蜍ｹ郢ｧ蝣､蜊�ｸｺ荳橸ｽ｡蜉ｱ�顔ｸｺ�､邵ｺ�ｶ邵ｺ�ｽ		
		canvas.drawColor(Color.WHITE);
		if(back == 1){
			canvas.drawBitmap(DrawActivity.back_bitmap, 0, 0,new Paint());
			//back = 0;
		}
		if(bitmap != null){
			//闖ｫ譎擾ｽｭ蛟･��ｸｺ�ｦ邵ｺ繧�ｽ毅itmap郢ｧ蜻育ｷ帝��ｻ邵ｺ蜷ｶ��			
			canvas.drawBitmap(bitmap, 0, 0, null);
		}
		Paint paint = new Paint();
		//郢ｧ�｢郢晢ｽｳ郢昶�縺顔ｹｧ�､郢晢ｽｪ郢ｧ�｢郢ｧ�ｹ郢ｧ蜻域�陷会ｽｹ邵ｺ�ｫ邵ｺ蜷ｶ��		
		paint.setAntiAlias(true);
		//鬮ｱ螳夂横邵ｲ�ｽ�ｽ隴丈ｸｻ�ｺ�ｦ100
		paint.setColor(Color.argb(255, Integer.valueOf(color_array[0]), Integer.valueOf(color_array[1]), Integer.valueOf(color_array[2])));
		//驍ｱ螢ｹ�ｽ邵ｺ�ｿ(陜ｪ蜉ｱ�顔ｸｺ�､邵ｺ�ｶ邵ｺ霈披�邵ｺ�ｽ
		paint.setStyle(Paint.Style.STROKE);
		//邱壹�螟ｪ縺�
		paint.setStrokeWidth(haba);
		//邱壹�荳｡遶ｯ繧剃ｸｸ縺上☆繧�		//驍ｱ螢ｹ�ｽ陞滂ｽｪ邵ｺ�ｽ
		//驍ｱ螢ｹ�ｽ闕ｳ�｡驕ｶ�ｯ郢ｧ蜑�ｽｸ�ｸ邵ｺ荳岩�郢ｧ�ｽ		
		paint.setStrokeCap(Paint.Cap.ROUND);
		//驍ｱ螢ｹ�ｽ邵ｺ�､邵ｺ�ｪ邵ｺ螳亥ｲｼ郢ｧ蜑�ｽｸ�ｸ邵ｺ荳岩�郢ｧ�ｽ		
		paint.setStrokeJoin(Paint.Join.ROUND);
		if(path != null){
			//郢昜ｻ｣縺帷ｹｧ蜻育ｷ帝��ｻ邵ｺ蜷ｶ��			
			canvas.drawPath(path, paint);
		}
		
	}
	public void clearDrawList(){
		bmpCanvas = new Canvas(bitmap);
		 bmpCanvas.drawColor(Color.WHITE);
		 invalidate();
		}
	private boolean sdcardWriteReady(){
		 String state = Environment.getExternalStorageState();
		 return (Environment.MEDIA_MOUNTED.equals(state));
		}
	public void saveToFile(){
		 if(!sdcardWriteReady()){
		 Toast.makeText(_context, "SDCARD縺瑚ｪ崎ｭ倥＆繧後∪縺帙ｓ縲�", Toast.LENGTH_SHORT).show();
		 return;
		 }
		 // test
		 String url = "http://133.242.188.195:8080/cyber4koma/file";
		 File file = new File(Environment.getExternalStorageDirectory().getPath()+"/drawbm/");
		 
		 
		 try{
			    if(!file.exists()){
				file.mkdir();
			    }
			}catch(SecurityException e){}
		 
			String AttachName = file.getAbsolutePath() + "/";
			AttachName += System.currentTimeMillis()+".jpg";
			File saveFile = new File(AttachName);
			while(saveFile.exists()) {
			    AttachName = file.getAbsolutePath() + "/" + System.currentTimeMillis() +".jpg";
			    saveFile = new File(AttachName);
			}
			try {
			    FileOutputStream out = new FileOutputStream(AttachName);
			    bitmap.compress(CompressFormat.JPEG, 100, out);
			    out.flush();
			    out.close();
			    Toast.makeText(_context, "菫晏ｭ倥＆繧後∪縺励◆縲�", Toast.LENGTH_SHORT).show();
			} catch(Exception e) {
			    Toast.makeText(_context, "萓句､也匱逕�", Toast.LENGTH_SHORT).show();
			}
	
			AsyncHttpFile asyncHttpFile = new AsyncHttpFile(saveFile);
			asyncHttpFile.send();
			
		}
	
	

	 

}
