package ya.example.manga4;

import android.app.Activity;
import android.os.Bundle;

public class DrawActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new DrawView(this));
	}
}
