package mato.cphbusiness.dk.mobileappside.API;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Mato on 05.08.16.
 */
public abstract class Checker extends Context {

    SharedPreferences sp;
    static ArrayList old = new ArrayList();

    public static void loadArray(Context mContext){

        SharedPreferences mSharedPreference1 =   PreferenceManager.getDefaultSharedPreferences(mContext);
        old.clear();
        int size = mSharedPreference1.getInt("Status_size", 0);

        for(int i=0;i<size;i++)
        {
            old.add(mSharedPreference1.getString("Status_" + i, null));
        }

    }

    private void compareLists(ArrayList<String> current){

        Collection<String> original = new ArrayList(old);
        Collection<String> updated = new ArrayList(current);

        List<String> toDelete = new ArrayList<String>(original);
        List<String> toDownload = new ArrayList<String>(updated);

        toDelete.removeAll(updated);
        toDownload.removeAll(original);

        System.out.println( toDelete );                                 //what should be deleted
        System.out.println( toDownload );                               //what should be downloaded

        saveNewList((ArrayList<String>) updated);

    }

    private boolean saveNewList(ArrayList<String> temp){

        sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sp.edit();

        editor.putInt("Status_size", temp.size());

        for(int i=0;i<temp.size();i++)
        {
            editor.remove("Status_" + i);
            editor.putString("Status_" + i, temp.get(i));
        }

        return editor.commit();
    }

}
