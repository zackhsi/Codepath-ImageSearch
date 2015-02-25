package models;

import java.util.List;

/**
 * Created by zackhsi on 2/25/15.
 */
public class ResultCursor {
    public String resultCount;
    public List<Page> pages;
    public int estimatedResultCount;
    public int currentPageIndex;
    public String moreResultsUrl;
}
