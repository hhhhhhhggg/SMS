package com.jfq.msms.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jfq.msms.R;

/**
 * Created by Administrator on 2016.12.27.
 */

public class Fragment3 extends Fragment{
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment3_layout,container,false);
        return view;

    }
}
