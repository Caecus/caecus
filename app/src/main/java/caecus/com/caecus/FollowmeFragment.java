package caecus.com.caecus;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FollowmeFragment extends Fragment {

    private static final String ARG_EXAMPLE = "this_is_a_constant";
    private String example_data;

    public FollowmeFragment() {
        // Required empty public constructor
    }
    public static FollowmeFragment newInstance(String example_argmument) {
        FollowmeFragment tabFragment = new FollowmeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_EXAMPLE, example_argmument);
        tabFragment.setArguments(args);
        return tabFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_followme, container, false);
    }

}
