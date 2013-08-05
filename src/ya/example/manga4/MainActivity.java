package ya.example.manga4;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	//ikeeeeeeeeeeee
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// 縺薙％縺ｫ繧ｳ繝｡繝ｳ繝医＠縺溘ｈ
		// 縺輔ｉ縺ｫ繧ｳ繝｡繝ｳ繝�		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
