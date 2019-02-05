package es.iessaladillo.pedrojoya.pr08.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import es.iessaladillo.pedrojoya.pr08.R;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private AppBarConfiguration appbarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navController = Navigation.findNavController(this, R.id.navHostFragment);
    }

    private void setupAppbar() {
        Toolbar toolbar = ActivityCompat.requireViewById(this, R.id.toolbarMain);
        setSupportActionBar(toolbar);
        appbarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appbarConfiguration);
    }

    @Override
    public boolean onSupportNavigateUp() {
        //|| por si no funciona
        return NavigationUI.navigateUp(navController, appbarConfiguration)
                || super.onSupportNavigateUp();
    }
}
