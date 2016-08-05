package mato.cphbusiness.dk.mobileappside.API;

import java.util.ArrayList;

/**
 * Created by Mato on 05.08.16.
 */
class DataHandler {

    private static ArrayList<String> currentFileList; //should be compared with a list from internall storage
    private ArrayList<String> oldFileList;

    public ArrayList<String> getFiles() {
        return currentFileList;
    }

    public void setFiles(ArrayList<String> files) {
        this.currentFileList = files;
    }
}
