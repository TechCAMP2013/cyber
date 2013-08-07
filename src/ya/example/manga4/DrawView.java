package ya.example.manga4;

import java.io.File;
import java.io.FileOutputStream;

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

	private int type = 0;	//イベントのタイプ
	private float posx = 0.0f;	//イベントが起きたX座標
	private float posy = 0.0f;	//イベントが起きたY座標
	private Path path = null;	//パス
	private Bitmap bitmap = null;	//Viewの状態を保存するためのBitmap
	int haba = 22;
	String[] color_array = {"0","0","0"};
	private Canvas bmpCanvas;
	private Activity _context;

	public DrawView(Context context) {
		super(context);
		_context = (Activity)context;
		// TODO 閾ｪ蜍慕函謌舌＆繧後◆繧ｳ繝ｳ繧ｹ繝医Λ繧ｯ繧ｿ繝ｼ繝ｻ繧ｹ繧ｿ繝�		
		setOnTouchListener(this);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�ラ繝ｻ繧ｹ繧ｿ繝�		
		try{
			String act = "";
			type = event.getAction();	//繧､繝吶Φ繝医�繧ｿ繧､繝�			
			posx = event.getX();	//繧､繝吶Φ繝医′襍ｷ縺阪◆X蠎ｧ讓�			
			posy = event.getY();	//繧､繝吶Φ繝医′襍ｷ縺阪◆Y蠎ｧ讓�			
			//繧､繝吶Φ繝医�繧ｿ繧､繝励＃縺ｨ縺ｫ蜃ｦ逅�ｒ險ｭ螳�			
			switch(type){
			case MotionEvent.ACTION_DOWN:	//譛��縺ｮ繝昴う繝ｳ繝�				
				//繝代せ繧貞�譛溷喧
				path = new Path();
				//繝代せ縺ｮ蟋狗せ縺ｸ遘ｻ蜍�				
				path.moveTo(posx, posy);
				act = "down";
				break;
			case MotionEvent.ACTION_MOVE:	//騾比ｸｭ縺ｮ繝昴う繝ｳ繝�		
				//縺ｲ縺ｨ縺､蜑阪�繝昴う繝ｳ繝医°繧峨�邱壹ｒ蠑輔￥
				path.lineTo(posx, posy);
				act = "move";
				break;
			case MotionEvent.ACTION_UP:	//譛�ｾ後�繝昴う繝ｳ繝�			
				//縺ｲ縺ｨ縺､蜑阪�繝昴う繝ｳ繝医°繧臥ｷ壹ｒ蠑輔￥
				path.lineTo(posx, posy);
				//迴ｾ蝨ｨ縺ｮView繧鍛itmap縺ｫ菫晏ｭ倥☆繧�			
				v.setDrawingCacheEnabled(true);
				bitmap = Bitmap.createBitmap(v.getDrawingCache());
				v.setDrawingCacheEnabled(false);
				act = "up";
			}
			//繝ｭ繧ｰ繧定ｿｽ蜉�			
			Log.v("MotionEvent","action=" + act + "&x=" + posx + "&y=" + posy);
			//View繧呈峩譁ｰ縺吶ｋ
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
		//閭梧勹繧堤區縺丞｡励ｊ縺､縺ｶ縺�		
		canvas.drawColor(Color.WHITE);
		if(bitmap != null){
			//菫晏ｭ倥＠縺ｦ縺ゅｋBitmap繧呈緒逕ｻ縺吶ｋ
			canvas.drawBitmap(bitmap, 0, 0, null);
		}
		Paint paint = new Paint();
		//繧｢繝ｳ繝√お繧､繝ｪ繧｢繧ｹ繧呈怏蜉ｹ縺ｫ縺吶ｋ
		paint.setAntiAlias(true);
		//髱定牡縲��譏主ｺｦ100
		paint.setColor(Color.argb(255, Integer.valueOf(color_array[0]), Integer.valueOf(color_array[1]), Integer.valueOf(color_array[2])));
		//邱壹�縺ｿ(蝪励ｊ縺､縺ｶ縺輔↑縺�
		paint.setStyle(Paint.Style.STROKE);
		//線の太さ8
		paint.setStrokeWidth(haba);
		//線の両端を丸くする
		//邱壹�螟ｪ縺�
		//邱壹�荳｡遶ｯ繧剃ｸｸ縺上☆繧�		
		paint.setStrokeCap(Paint.Cap.ROUND);
		//邱壹�縺､縺ｪ縺守岼繧剃ｸｸ縺上☆繧�		
		paint.setStrokeJoin(Paint.Join.ROUND);
		if(path != null){
			//繝代せ繧呈緒逕ｻ縺吶ｋ
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
		 Toast.makeText(_context, "SDCARDが認識されません。", Toast.LENGTH_SHORT).show();
		 return;
		 }
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
			    Toast.makeText(_context, "保存されました。", Toast.LENGTH_SHORT).show();
			} catch(Exception e) {
			    Toast.makeText(_context, "例外発生", Toast.LENGTH_SHORT).show();
			}
		}

	 

}
