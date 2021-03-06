package com.lycwed.cordova.vungle;

import java.util.Arrays;
import android.util.Log;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;

import org.apache.cordova.CordovaPlugin;
import com.vungle.mediation.VungleAdapter;
import com.vungle.mediation.VungleExtrasBuilder;

public class Vungle extends CordovaPlugin {
    private static final String LOG_TAG = "Vungle mediation plugin init";

    @Override
    protected void pluginInitialize() {
        super.pluginInitialize();

        String[] placements = new String[1];
        placements[0] = preferences.getString("REWARDVIDEO_ID", "");
        placements[1] = preferences.getString("INTERSTITIAL_ID", "");
        Log.v(LOG_TAG, Arrays.toString(placements));

        Bundle extras = new VungleExtrasBuilder(placements).build();
        AdRequest request =  new AdRequest.Builder()
            .addNetworkExtrasBundle(VungleAdapter.class, extras)
            .build();
    }
}