package com.ashishkumar.dscsolutionbefit.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.ashishkumar.dscsolutionbefit.R;

public class Fragment_Walk_and_Step extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    public static Fragment_Walk_and_Step newInstance(String str, String str2) {
        Fragment_Walk_and_Step mainFragment = new Fragment_Walk_and_Step();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM1, str);
        bundle.putString(ARG_PARAM2, str2);
        mainFragment.setArguments(bundle);
        return mainFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_wak_and_step, viewGroup, false);



        return inflate;
    }


}
