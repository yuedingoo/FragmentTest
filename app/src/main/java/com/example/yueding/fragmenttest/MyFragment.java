package com.example.yueding.fragmenttest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by yueding on 2017/5/11.
 */

public class MyFragment extends Fragment {
    @Nullable

    private String content;

    public MyFragment() {
    }

    public MyFragment(String content) {
        this.content = content;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content,container,false);
        TextView textView = (TextView) view.findViewById(R.id.txt_content);
        textView.setText(content);
        return view;
    }
}
