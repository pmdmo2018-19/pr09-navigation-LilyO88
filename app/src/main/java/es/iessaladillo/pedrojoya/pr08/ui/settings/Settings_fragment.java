package es.iessaladillo.pedrojoya.pr08.ui.settings;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.preference.PreferenceFragmentCompat;
import es.iessaladillo.pedrojoya.pr08.R;

import android.os.Bundle;

public class Settings_fragment extends PreferenceFragmentCompat {

    private Toolbar toolbar;
    private NavController navController;

    public static Settings_fragment newInstance() {
        return new Settings_fragment();
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String key) {
        setPreferencesFromResource(R.xml.preferences, key);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupViews();
        setupToolbar();
    }

    private void setupViews() {
        toolbar = ActivityCompat.requireViewById(requireActivity(), R.id.toolbarSettings);
        navController = NavHostFragment.findNavController(this);
    }

    private void setupToolbar() {
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupWithNavController(toolbar,  navController, appBarConfiguration);
    }

}
