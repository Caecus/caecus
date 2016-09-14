package caecus.com.caecus;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AyudanteFragment extends Fragment {
    private TextView txtCod;
    private static final String ARG_EXAMPLE = "this_is_a_constant";
    private String example_data;
    public AyudanteFragment() {
        // Required empty public constructor
    }
    public static AyudanteFragment newInstance(String example_argmument) {
        AyudanteFragment tabFragment = new AyudanteFragment();
        Bundle args = new Bundle();
        args.putString(ARG_EXAMPLE, example_argmument);
        tabFragment.setArguments(args);
        return tabFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_ayudante, container, false);
        return rootView;
    }

    public void mostrarCodigo(int codigo){
        txtCod.setText(String.valueOf(codigo));
        txtCod.setVisibility(View.VISIBLE);
    }



}
