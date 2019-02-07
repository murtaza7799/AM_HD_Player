/*
 * *************************************************************************
 *  PreferencesSubtitles.java
 * **************************************************************************
 *  Copyright © 2016 VLC authors and VideoLAN
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston MA 02110-1301, USA.
 *  ***************************************************************************
 */

package org.videolan.mudiAudioVideo.gui.preferences;

import android.content.SharedPreferences;

import org.videolan.mudiAudioVideo.R;
import org.videolan.mudiAudioVideo.util.VLCInstance;

public class PreferencesSubtitles extends BasePreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    protected int getXml() {
        return R.xml.preferences_subtitles;
    }

    @Override
    protected int getTitleId() {
        return R.string.subtitles_prefs_category;
    }

    @Override
    public void onStart() {
        super.onStart();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        switch (key){
            case "subtitles_size":
            case "subtitles_bold":
            case "subtitles_color":
            case "subtitles_background":
            case "subtitle_text_encoding":
                VLCInstance.restart();
                if (getActivity() != null )
                    ((PreferencesActivity)getActivity()).restartMediaPlayer();
        }
    }

}