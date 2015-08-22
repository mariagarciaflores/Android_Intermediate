package com.android.gif;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Griss Garcia on 16/08/2015.
 */
public class MapCreator {
    public Map<Integer, String> poleImageVideos;
    private static MapCreator asigner;

    public MapCreator() {
        poleImageVideos = new HashMap<>();
        fillPoleImagesVideo();
    }

    public static MapCreator getInstance() {
        if (asigner == null) {
            asigner = new MapCreator();
        }
        return asigner;
    }

    public Map<Integer, String> getPoleImageVideos() {
        return poleImageVideos;
    }

    private void fillPoleImagesVideo() {
        poleImageVideos.put(R.drawable.fig1, "8jTdm7H89u8");
        poleImageVideos.put(R.drawable.fig2, "LgLI9Z41TfY");
        poleImageVideos.put(R.drawable.fig3, "IKckRbMesOs");
        poleImageVideos.put(R.drawable.fig4, "sVkZMSaUz24");
        poleImageVideos.put(R.drawable.fig6, "zbmp4RYqpnE");
        poleImageVideos.put(R.drawable.fig5, "DuPKVOPxi6U");
        poleImageVideos.put(R.drawable.fig6, "tIxWdekse-g");
        poleImageVideos.put(R.drawable.fig7, "G90vLUhM16E");
        poleImageVideos.put(R.drawable.fig8, "26j-cLeTQWM");
        poleImageVideos.put(R.drawable.fig9, "rCRP-5om_3Y");
        poleImageVideos.put(R.drawable.fig10, "LV-8K4tRw2U");
        poleImageVideos.put(R.drawable.fig11, "G90vLUhM16E");
        poleImageVideos.put(R.drawable.fig12, "SC3798xDqhc");
        poleImageVideos.put(R.drawable.fig13, "-tQHZHhI-Ac");
        poleImageVideos.put(R.drawable.fig14, "aUxAn5-DCSU");
    }
}
