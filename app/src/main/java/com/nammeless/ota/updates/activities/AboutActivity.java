/*
 * Copyright (C) 2015 Nicholas Chum (nicholaschum) and Matt Booth (Kryten2k35).
 *
 * Licensed under the Attribution-NonCommercial-ShareAlike 4.0 International 
 * (the "License") you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://creativecommons.org/licenses/by-nc-sa/4.0/legalcode
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nammeless.ota.updates.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.nammeless.ota.updates.R;
import com.nammeless.ota.updates.utils.Preferences;
import com.nammeless.ota.updates.utils.Utils;

public class AboutActivity extends Activity {

    private Context mContext;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mContext = this;
        setTheme(Preferences.getTheme(mContext));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ota_about);


        if (Utils.isLollipop()) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_about);
            setActionBar(toolbar);
            toolbar.setTitle(getResources().getString(R.string.app_name));
        }

        String openHTML = "";
        if (Utils.isLollipop()) {
            if (Preferences.getCurrentTheme(this) == 0) { // Light
                openHTML = "<font color='#000000'>";
            } else {
                openHTML = "<font color='#ffffff'>";
            }
        } else {
            openHTML = "<font color='#777777'>";
        }
        String closeHTML = "</font>";
        String newLine = "<br />";
    }

    public void openAppDonate(View v) {
        String url = "http://forum.xda-developers.com/donatetome.php?u=5750672";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    public void openAppDonateCDT(View v) {
        String url = "http://forum.xda-developers.com/donatetome.php?u=5750672";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

}
