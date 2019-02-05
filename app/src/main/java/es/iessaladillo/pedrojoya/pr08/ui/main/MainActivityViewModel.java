package es.iessaladillo.pedrojoya.pr08.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.preference.PreferenceManager;
import es.iessaladillo.pedrojoya.pr08.R;
import es.iessaladillo.pedrojoya.pr08.ui.settings.SharedPreferencesStringLiveData;

public class MainActivityViewModel  extends AndroidViewModel {

    private final LiveData<String> txtContent;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        txtContent = new SharedPreferencesStringLiveData(
                PreferenceManager.getDefaultSharedPreferences(application),
                application.getString(R.string.prefTextType_key),
                application.getString(R.string.prefTextType_defaultValue));
    }

    LiveData<String> getTxtContent() {
        return txtContent;
    }

}