package com.tkb.movie.utilities;

import com.tkb.movie.entities.SongObject;

import java.util.ArrayList;
import java.util.List;

public class TabFactory {

    public static List<SongObject>getTabItems(int position){
        switch (position){
            case 0 :
                return getTestData();
            case 1 :
                return getTestData2();
            case 2 :
                return getTestData3();
            default:
                return getTestData1();
        }
    }
    private static List<SongObject> getTestData() {
        List<SongObject> recentSongs = new ArrayList<SongObject>();

        return recentSongs;
    }

    private static List<SongObject> getTestData1() {
        List<SongObject> recentSongs = new ArrayList<SongObject>();
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        return recentSongs;
    }
    private static List<SongObject> getTestData2() {
        List<SongObject> recentSongs = new ArrayList<SongObject>();
        recentSongs.add(new SongObject("dele", "Like You", ""));
        recentSongs.add(new SongObject("dele", "Like You", ""));
        recentSongs.add(new SongObject("dele", "Like You", ""));
        recentSongs.add(new SongObject("dele", "Like You", ""));
        recentSongs.add(new SongObject("dele", "Like You", ""));
        recentSongs.add(new SongObject("dele", "Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        return recentSongs;
    }
    private static List<SongObject> getTestData3() {
        List<SongObject> recentSongs = new ArrayList<SongObject>();
        recentSongs.add(new SongObject("Tkb", " Like ", ""));
        recentSongs.add(new SongObject("Tkb", " Like ", ""));
        recentSongs.add(new SongObject("Tkb", " Like ", ""));
        recentSongs.add(new SongObject("Tkb", " Like ", ""));
        recentSongs.add(new SongObject("Tkb", " Like ", ""));
        recentSongs.add(new SongObject("Tkb", " Like ", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        recentSongs.add(new SongObject("Adele", "Someone Like You", ""));
        return recentSongs;
    }
}
