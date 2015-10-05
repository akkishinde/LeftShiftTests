package com.akshay.leftshifttests;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;



/**
 * Created by leftshift on 10/1/15.
 */


public class PM_Fragment extends Fragment {
    private static final String TAG = "";
    @Bind(R.id.btnNext)Button btnNext;
    FragmentCallBacks mListener;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pm_fragment, container,
                false);
        Log.i(TAG,"In PM_Fragment");
        ButterKnife.bind(this,view);
        final LM_Fragment lm_fragment=new LM_Fragment();
        /**
         * Inflate the layout for this fragment
         */
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mListener.navigateTo(lm_fragment);
            }
        });
        return view;

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (FragmentCallBacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement FragmentCallbacks");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
