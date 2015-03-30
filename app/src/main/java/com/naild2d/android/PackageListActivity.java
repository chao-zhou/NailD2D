package com.naild2d.android;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.widget.ListView;


/**
 * Created by ebread on 2015/3/29.
 */
public class PackageListActivity extends FragmentActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int LoaderId = 0;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packagelist);
        getSupportLoaderManager().initLoader(LoaderId, null, this);

        mListView = (ListView)findViewById(R.id.pkgls_list);
    }


    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {

    }
}
