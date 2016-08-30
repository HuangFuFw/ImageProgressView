package com.ai.eve.ui.demo.widget;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.ai.eve.ui.demo.R;

/**
 * Created by huangfu on 2016/3/8 17:32.
 */
public class MyDialogFragment extends DialogFragment implements TextView.OnEditorActionListener{

    private TextView editText;

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                UserNameListener listener= (UserNameListener) getActivity();
                listener.onFinished(editText.getText().toString());
                this.dismiss();
                return true;
    }

    public  interface UserNameListener{
        void onFinished(String userName);
    }

    public MyDialogFragment() {

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_username,container);
        editText = (TextView) view.findViewById(R.id.username);
//        Button btn= (Button) view.findViewById(R.id.btn1);

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                UserNameListener listener= (UserNameListener) getActivity();
//                listener.onFinished(editText.getText().toString());
//                getDialog().dismiss();
//
//            }
//        });

        editText.setOnEditorActionListener(this);
        editText.requestFocus();
//        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                UserNameListener listener= (UserNameListener) getActivity();
//                listener.onFinished(editText.getText().toString());
//                getDialog().dismiss();
//                return true;
//            }
//        });

        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        getDialog().getWindow().setTitle("Please enter username");

        return view;
    }
}
