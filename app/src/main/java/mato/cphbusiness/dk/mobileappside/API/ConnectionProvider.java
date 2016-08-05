package mato.cphbusiness.dk.mobileappside.API;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;

import java.io.IOException;

/**
 * Created by Mato on 05.08.16.
 */

public class ConnectionProvider {

    //probably good idea to move
    private static final String ACCESS_TOKEN = "gJpuKawxsWAAAAAAAAAADe0xYvAPkuyAKIGvIS9lKStlkgS9sV842K3cFZ0YYoR8";
    private DbxClientV2 client;


    public void provideAuthorization() throws DbxException, IOException {
        DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
        client = new DbxClientV2(config, ACCESS_TOKEN);
    }



    /*public static void main(String[] args) {

    DropboxManager dm = new DropboxManager();
        try {
            dm.provideAuthorization();
        } catch (DbxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/

    public DbxClientV2 getClientV2(){
        return client;
    }
}
