/*
 * Copyright (C) 2015 Matt Booth (Kryten2k35).
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

package com.chummy.blissroms.updates.activities;

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

import com.chummy.blissroms.updates.R;
import com.chummy.blissroms.updates.utils.Preferences;
import com.chummy.blissroms.updates.utils.Utils;

public class AboutActivity extends Activity {

	private Context mContext;
	
	@SuppressLint("NewApi") @Override
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

		TextView creditsSummary = (TextView) findViewById(R.id.about_tv_credits_summary);


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
		String creditsText =
				openHTML + "Nicholas Chum (nicholaschum)" + closeHTML + " - BlissOTA Implementer/Source Rewrites" + newLine +
                openHTML + "Jezebel Ng (BellaxMiu)" + closeHTML + " - Icon and graphics designer" + newLine +
                openHTML + "Matt Booth (Kryten2k35)" + closeHTML + " - OTAUpdates Original Source Creator" + newLine + newLine +

				openHTML + "Erwan Leboucher (genesixxbf3)" + closeHTML + " - Source Contributor" + newLine +
				openHTML + "Tobias Teschner (tobitege)" + closeHTML + " - OTA server automation" + newLine + newLine +

				openHTML + "Bunyamin Ozdemir (KeTuRr74)" + closeHTML + " - BlissOTA French Translations";
		creditsSummary.setText(Html.fromHtml(creditsText));

	}

	public void openAppDonate(View v) {
        String url = "http://goo.gl/ZKSY4";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

	public void openAppDonateCDT(View v) {
        String url = "https://goo.gl/upDndJ";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
	}

}
