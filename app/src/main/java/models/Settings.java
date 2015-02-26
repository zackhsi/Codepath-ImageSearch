package models;

import android.graphics.Color;

import java.io.Serializable;

/**
 * Created by zackhsi on 2/25/15.
 */
public class Settings implements Serializable {
    /*
    Size (small, medium, large, extra-large)
    Color filter (black, blue, brown, gray, green, etc...)
    Type (faces, photo, clip art, line art)
    Site (espn.com)
    */
    public String size;
    public String color;
    public String type;
    public String site;
}