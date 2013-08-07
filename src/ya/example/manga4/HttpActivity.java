package ya.example.manga4;

import java.util.Map;

import android.app.Activity;

public abstract class HttpActivity extends Activity {
	
	abstract void receiveMessage(Map<String, Object> map);

}

