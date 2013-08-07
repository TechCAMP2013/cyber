package ya.example.manga4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class DrawView extends View implements OnTouchListener {
	private int type = 0;	//繧､繝吶Φ繝医�繧ｿ繧､繝�	
	private float posx = 0.0f;	//繧､繝吶Φ繝医′襍ｷ縺阪◆X蠎ｧ讓�	
	private float posy = 0.0f;	//繧､繝吶Φ繝医′襍ｷ縺阪◆Y蠎ｧ讓�	
	private Path path = null;	//繝代せ
	private Bitmap bitmap = null;	//View縺ｮ迥ｶ諷九ｒ菫晏ｭ倥☆繧九◆繧√�Bitmap

	public DrawView(Context context) {
		super(context);
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
		paint.setColor(Color.argb(100, 0, 0, 255));
		//邱壹�縺ｿ(蝪励ｊ縺､縺ｶ縺輔↑縺�
		paint.setStyle(Paint.Style.STROKE);
		//邱壹�螟ｪ縺�
		paint.setStrokeWidth(8);
		//邱壹�荳｡遶ｯ繧剃ｸｸ縺上☆繧�		
		paint.setStrokeCap(Paint.Cap.ROUND);
		//邱壹�縺､縺ｪ縺守岼繧剃ｸｸ縺上☆繧�		
		paint.setStrokeJoin(Paint.Join.ROUND);
		if(path != null){
			//繝代せ繧呈緒逕ｻ縺吶ｋ
			canvas.drawPath(path, paint);
		}
	}

}
