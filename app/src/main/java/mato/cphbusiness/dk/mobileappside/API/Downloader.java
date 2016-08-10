package mato.cphbusiness.dk.mobileappside.API;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Mato on 08.08.16.
 */
public class Downloader implements Runnable {

    File temp;
    String path;
    ConnectionProvider con = new ConnectionProvider();
    DbxClientV2 client = con.getClientV2();
    public Downloader(DbxClientV2 clientV2, String path) {
        this.client = clientV2;
        this.path = path;

    }


    public File download(String path) {
        DbxDownloader<FileMetadata> downloader = null;
        try {
            downloader = client.files().downloadBuilder(path).start();
        } catch (DbxException e) {
            e.printStackTrace();
        }

        try {
            downloader.download(new FileOutputStream(temp));
        } catch (DbxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            downloader.close();

        }
        return temp;
    }

    @Override
    public void run() {
        download(path);

    }
}
