package li.barter;

import java.net.URI;

import org.json.JSONException;
import org.json.JSONObject;

import li.barter.http.HttpConstants;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.saulpower.fayeclient.FayeClient;
import com.saulpower.fayeclient.FayeClient.FayeListener;

/**
 * @author Vinay S Shenoy Activity for displaying chat messages
 */
public class ChatActivity extends AbstractBarterLiActivity implements FayeListener, OnClickListener {

	private static final String TAG = "ChatActivity";

	/**
	 * {@link FayeClient} instance for sending/receiving messages
	 */
	private FayeClient mFayeClient;

	private TextView mReceivedChatTextView;

	private Button mSendChatButton;

	private Handler mHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);

		mReceivedChatTextView = (TextView) findViewById(R.id.text_received_message);
		mSendChatButton = (Button) findViewById(R.id.button_send_message);
		
		mHandler = new Handler();
		mFayeClient = new FayeClient(mHandler, URI.create(HttpConstants.getSocketUri()), HttpConstants.CHAT_SOCKET_ENDPOINT);
		mFayeClient.setFayeListener(this);
		mFayeClient.connectToServer(new JSONObject());

	}

	@Override
	public void connectedToServer() {
		mSendChatButton.setOnClickListener(this);
	}

	@Override
	public void disconnectedFromServer() {
		mSendChatButton.setOnClickListener(null);
		
	}

	@Override
	public void subscribedToChannel(String subscription) {
		showToast("Subscribed:" + subscription, false);
	}

	@Override
	public void subscriptionFailedWithError(String error) {
		showToast("Subscribe failed:" + error, false);
		
	}

	@Override
	public void messageReceived(JSONObject json) {
		mReceivedChatTextView.setText(json.toString());
	}

	@Override
	public void onClick(View v) {

		if(v.getId() == R.id.button_send_message) {
			try {
				
				JSONObject message = new JSONObject();
				//message.put(HttpConstants.SENDER_ID, "sender_id");
				message.put(HttpConstants.MESSAGE, "Test Message! barter.li rocks!");
				mFayeClient.sendMessage(message);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}
}
