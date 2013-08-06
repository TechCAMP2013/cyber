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
	private int type = 0;	//イベントのタイプ
	private float posx = 0.0f;	//イベントが起きたX座標
	private float posy = 0.0f;	//イベントが起きたY座標
	private Path path = null;	//パス
	private Bitmap bitmap = null;	//Viewの状態を保存するためのBitmap

	public DrawView(Context context) {
		super(context);
		// TODO 自動生成されたコンストラクター・スタブ
		setOnTouchListener(this);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO 自動生成されたメソッド・スタブ
		try{
			String act = "";
			type = event.getAction();	//イベントのタイプ
			posx = event.getX();	//イベントが起きたX座標
			posy = event.getY();	//イベントが起きたY座標
			//イベントのタイプごとに処理を設定
			switch(type){
			case MotionEvent.ACTION_DOWN:	//最初のポイント
				//パスを初期化
				path = new Path();
				//パスの始点へ移動
				path.moveTo(posx, posy);
				act = "down";
				break;
			case MotionEvent.ACTION_MOVE:	//途中のポイント
				//ひとつ前のポイントから、線を引く
				path.lineTo(posx, posy);
				act = "move";
				break;
			case MotionEvent.ACTION_UP:	//最後のポイント
				//ひとつ前のポイントから線を引く
				path.lineTo(posx, posy);
				//現在のViewをbitmapに保存する
				v.setDrawingCacheEnabled(true);
				bitmap = Bitmap.createBitmap(v.getDrawingCache());
				v.setDrawingCacheEnabled(false);
				act = "up";
			}
			//ログを追加
			Log.v("MotionEvent","action=" + act + "&x=" + posx + "&y=" + posy);
			//Viewを更新する
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
		//背景を白く塗りつぶす
		canvas.drawColor(Color.WHITE);
		if(bitmap != null){
			//保存してあるBitmapを描画する
			canvas.drawBitmap(bitmap, 0, 0, null);
		}
		Paint paint = new Paint();
		//アンチエイリアスを有効にする
		paint.setAntiAlias(true);
		//青色、透明度100
		paint.setColor(Color.argb(100, 0, 0, 255));
		//線のみ(塗りつぶさない)
		paint.setStyle(Paint.Style.STROKE);
		//線の太さ8
		paint.setStrokeWidth(8);
		//線の両端を丸くする
		paint.setStrokeCap(Paint.Cap.ROUND);
		//線のつなぎ目を丸くする
		paint.setStrokeJoin(Paint.Join.ROUND);
		if(path != null){
			//パスを描画する
			canvas.drawPath(path, paint);
		}
	}

}
