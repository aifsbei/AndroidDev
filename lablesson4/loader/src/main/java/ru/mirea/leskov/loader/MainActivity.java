package ru.mirea.leskov.loader;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;


public class MainActivity extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<String> {
    public final String TAG = this.getClass().getSimpleName();
    public static final int LOADER_ID = 1;
    private Loader<String> mLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle bundle = new Bundle();
        bundle.putString(RandomLoader.ARG_WORD, "mirea");
        mLoader = getSupportLoaderManager().initLoader(LOADER_ID, bundle, this);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {
        Log.d(TAG, "onLoaderReset");
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int i, @Nullable Bundle bundle) {
        Loader<String> mLoader = null;
        if (i == LOADER_ID) {
            mLoader = new MyLoader(this, bundle);
            Log.d(TAG, "onCreateLoader");
        }
        return mLoader;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String s) {
        Log.d(TAG, "onLoadFinished" + s);
    }

    public class MyLoader extends AsyncTaskLoader {
        @Nullable
        @Override
        public Integer loadInBackground() {
            SystemClock.sleep(5000);
            return 5;
        }
        MyLoader(Context context, Bundle bundle) {
            super(context);
        }
        @Override
        protected void onStartLoading() {
            super.onStartLoading();
            forceLoad();
        }
    }

}
