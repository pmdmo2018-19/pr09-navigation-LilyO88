package es.iessaladillo.pedrojoya.pr08.ui.main;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import es.iessaladillo.pedrojoya.pr08.R;

public class MainFragment extends Fragment {

    private Toolbar toolbar;
    private TextView txtLorem;
    private NavController navController;
    private AppBarConfiguration appbarConfiguration;

    public MainFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        navController = NavHostFragment.findNavController(this);
        MainActivityViewModel viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        setupViews();
        viewModel.getTxtContent().observe(this, this::setText);
        setupAppbar();
    }

    private void setText(String key) {
        if(TextUtils.equals(key, getString(R.string.prefTextType_defaultValue))) {
            txtLorem.setText(getString(R.string.main_latin_ipsum));
        } else {
            txtLorem.setText(getString(R.string.main_chiquito_ipsum));
        }
    }

    private void setupViews() {
        FloatingActionButton fab = ActivityCompat.requireViewById(requireActivity(), R.id.fabMain);
        txtLorem = ActivityCompat.requireViewById(requireActivity(), R.id.textLoremMain);
        //Fab's listener
        fab.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_destMainFragment_to_destDetailFragment));
    }

    private void setupAppbar() {
        toolbar = ActivityCompat.requireViewById(requireActivity(), R.id.toolbarMain);
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> toolbar.setTitle(R.string.titleMainFragment));
        ((AppCompatActivity)requireActivity()).setSupportActionBar(toolbar);
        appbarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupWithNavController(toolbar, navController, appbarConfiguration);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return NavigationUI.onNavDestinationSelected(item, navController)
                || super.onOptionsItemSelected(item);
    }
}
