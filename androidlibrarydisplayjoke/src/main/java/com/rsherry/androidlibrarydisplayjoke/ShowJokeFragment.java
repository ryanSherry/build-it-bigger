package com.rsherry.androidlibrarydisplayjoke;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowJokeFragment extends Fragment {
    @BindView(R.id.showJokeTextView) TextView mJokeText;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_joke,container,false);
        ButterKnife.bind(this,view);

        Bundle bundle = this.getArguments();

        if(bundle != null) {
            String joke = bundle.getString("joke");
            mJokeText.setText(joke);
        }

        return view;
    }
}
