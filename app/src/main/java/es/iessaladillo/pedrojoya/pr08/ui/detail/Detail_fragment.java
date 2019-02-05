package es.iessaladillo.pedrojoya.pr08.ui.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import es.iessaladillo.pedrojoya.pr08.R;
import es.iessaladillo.pedrojoya.pr08.utils.ToastUtils;

public class Detail_fragment extends Fragment {

    private FloatingActionButton fab;
    private NavController navController;

    public Detail_fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        navController = NavHostFragment.findNavController(this);
        setupAppBar();
        setupViews();
    }

    private void setupViews() {
        fab = ActivityCompat.requireViewById(requireActivity(), R.id.fabDetail);
        /*Listeners*/
        fab.setOnClickListener(v -> fabAction());
    }

    private void setupAppBar() {
        Toolbar toolbar = ActivityCompat.requireViewById(requireActivity(), R.id.toolbarDetail);
        CollapsingToolbarLayout collapsingToolbarLayout = ActivityCompat.requireViewById(requireActivity(), R.id.collapsingToolbar);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupWithNavController(collapsingToolbarLayout, toolbar,  navController, appBarConfiguration);
    }

    private void fabAction() {
        ToastUtils.toast(getContext(), "Saved successfully");
        requireActivity().getSupportFragmentManager().popBackStack();
    }
}