package caecus.com.caecus;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import caecus.com.caecus.Help.helpMenu;


/**
 * A simple {@link Fragment} subclass.
 */
public class HelpFragment extends Fragment {



    private static final String ARG_EXAMPLE = "this_is_a_constant";
    private String example_data;

    public HelpFragment() {
        // Required empty public constructor
    }
    public static HelpFragment newInstance(String example_argmument) {
        HelpFragment tabFragmentOne = new HelpFragment();
    Bundle args = new Bundle();
    args.putString(ARG_EXAMPLE, example_argmument);
    tabFragmentOne.setArguments(args);
    return tabFragmentOne;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_help,container,false);
    }

    public void onHelp(View view){
        Intent intent1 = new Intent(getActivity(), helpMenu.class);
        startActivity(intent1);
    }

}
