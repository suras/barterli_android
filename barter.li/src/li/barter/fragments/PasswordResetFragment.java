/*******************************************************************************
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package li.barter.fragments;

import li.barter.R;
import li.barter.http.BlRequest;
import li.barter.http.HttpConstants;
import li.barter.http.HttpConstants.ApiEndpoints;
import li.barter.http.HttpConstants.RequestId;
import li.barter.http.IBlRequestContract;
import li.barter.http.ResponseInfo;
import li.barter.utils.Logger;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request.Method;
import com.squareup.picasso.Picasso;

/**
 * @author Sharath Pandeshwar
 */

@FragmentTransition(enterAnimation = R.anim.slide_in_from_right, exitAnimation = R.anim.zoom_out, popEnterAnimation = R.anim.zoom_in, popExitAnimation = R.anim.slide_out_to_right)
public class PasswordResetFragment extends AbstractBarterLiFragment {

    private static final String TAG          = "PasswordResetFragment";
    private EditText            mResetPasswordEmail;
    private EditText            mResetPasswordNew;
    private EditText            mResetPasswordToken;
    private String              mEmail;
    private String              mPassword;
    private String              mToken;
    private Button              mSetPasswordResetButton;
    private Button              mSendResetTokenButton;
    
    @Override
    public View onCreateView(final LayoutInflater inflater,
                    final ViewGroup container, final Bundle savedInstanceState) {
        init(container);
        setHasOptionsMenu(true);
        final View view = inflater.inflate(R.layout.fragment_password_reset, null);

        mResetPasswordEmail          = (EditText) view.findViewById(R.id.reset_password_email);
        mResetPasswordNew            = (EditText) view.findViewById(R.id.reset_password_new);
        mResetPasswordToken          = (EditText) view.findViewById(R.id.reset_password_token);
        mSendResetTokenButton        = (Button) view.findViewById(R.id.send_reset_token_button);
        mSetPasswordResetButton      = (Button) view.findViewById(R.id.set_password_reset_button);
       
        mResetPasswordEmail.addTextChangedListener(new TextWatcher() {
	        public void onTextChanged(
	        	  CharSequence c, int start, int before, int count) {
	        		mEmail = c.toString();
	        	}
	        public void beforeTextChanged(
	        	  CharSequence c, int start, int count, int after) {
	        	  // This space intentionally left blank
	        	}
	        public void afterTextChanged(Editable c) {
	        	  // This one too
	        	}
        	});
        
        mResetPasswordToken.addTextChangedListener(new TextWatcher() {
        	public void onTextChanged(
        	  CharSequence c, int start, int before, int count) {
        		mToken = c.toString();
        	}
        	public void beforeTextChanged(
        	  CharSequence c, int start, int count, int after) {
        	  // This space intentionally left blank
        	}
        	public void afterTextChanged(Editable c) {
        	  // This one too
        	}
    	});
        
        mResetPasswordNew.addTextChangedListener(new TextWatcher() {
        	public void onTextChanged(
        	  CharSequence c, int start, int before, int count) {
        		mPassword = c.toString();
        	}
        	public void beforeTextChanged(
        	  CharSequence c, int start, int count, int after) {
        	  // This space intentionally left blank
        	}
        	public void afterTextChanged(Editable c) {
        	  // This one too
        	}
    	});
        
        
        mSetPasswordResetButton.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v) {
        	// Start CheatActivity
        	}
        	});
        
        
        mSendResetTokenButton  .setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v) {
        	// Start CheatActivity
        	}
        	});
        
        

        // Make a call to server
        try {

            final BlRequest request = new BlRequest(Method.GET, HttpConstants.getApiBaseUrl()
                            + ApiEndpoints.TRIBUTE, null, mVolleyCallbacks);
            request.setRequestId(RequestId.TRIBUTE);
            addRequestToQueue(request, true, 0);
        } catch (final Exception e) {
            // Should never happen
            Logger.e(TAG, e, "Error building report bug json");
        }

        return view;
    }

    @Override
    protected Object getVolleyTag() {
        return TAG;
    }

    @Override
    public void onSuccess(final int requestId,
                    final IBlRequestContract request,
                    final ResponseInfo response) {

        if (requestId == RequestId.TRIBUTE) {
            try {
                

            } catch (final Exception e) {
                // Should never happen
                Logger.e(TAG, e, "Error parsing json response");
            }
        }
    }

    @Override
    public void onBadRequestError(final int requestId,
                    final IBlRequestContract request, final int errorCode,
                    final String errorMessage, final Bundle errorResponseBundle) {
    }

}


