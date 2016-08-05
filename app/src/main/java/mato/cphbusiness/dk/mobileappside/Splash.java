package mato.cphbusiness.dk.mobileappside;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dropbox.core.DbxException;

import java.io.IOException;

import mato.cphbusiness.dk.mobileappside.API.ConnectionProvider;

public class Splash extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConnectionProvider con = new ConnectionProvider();
        try {
            con.provideAuthorization();
        } catch (DbxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
