package sit.com.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sit.com.R;

public class ComingSoonFragment extends Fragment {

    public ComingSoonFragment() {

    }

    public static ComingSoonFragment newInstance() {
        ComingSoonFragment comingSoonFragment = new ComingSoonFragment();
        Bundle bundle = new Bundle();
        comingSoonFragment.setArguments(bundle);
        return comingSoonFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_coming_soon, container, false);
        return view;
    }
}
