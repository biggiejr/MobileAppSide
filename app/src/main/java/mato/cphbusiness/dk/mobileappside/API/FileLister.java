package mato.cphbusiness.dk.mobileappside.API;


import android.os.AsyncTask;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;

import java.util.ArrayList;

/**
 * Created by Mato on 23.05.16.
 */

class FileLister extends AsyncTask<String, ArrayList<String>, ArrayList<String>> {

    static DataHandler dh = new DataHandler();
    ArrayList<String> files;
    ConnectionProvider con = new ConnectionProvider();
    DbxClientV2 client = con.getClientV2();    //access token


    @Override
    protected ArrayList<String> doInBackground(String... params) {
        String pathString = params[0];
        ListFolderResult result = null;

        try {
            result = client.files().listFolder(pathString);    //accessing folder
        } catch (DbxException e) {
            e.printStackTrace();
        }

        while (true) {                                         //populating array

            for (Metadata metadata : result.getEntries()) {
                files.add(metadata.getPathLower());
            }
            //if complete then break
            if (!result.getHasMore()) {
                break;
            }

            try {
                result = client.files().listFolderContinue(result.getCursor());
            } catch (DbxException e) {
                e.printStackTrace();
            }
        }
        return files;
    }

    //returns arraylist with a list of files in a root folder
    //saved in array of data handler class
    @Override
    protected void onPostExecute(ArrayList<String> result) {
        dh.setFiles(files);
    }




}

