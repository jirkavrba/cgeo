package cgeo.geocaching.test.mock;

import cgeo.geocaching.GCConstants;
import cgeo.geocaching.ICache;
import cgeo.geocaching.cgBase;
import cgeo.geocaching.cgImage;
import cgeo.geocaching.cgTrackable;
import cgeo.geocaching.geopoint.Geopoint;
import cgeo.geocaching.utils.BaseUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public abstract class MockedCache implements ICache {

    final protected Geopoint coords;
    String data;

    protected MockedCache(final Geopoint coords) {
        this.coords = coords;
    }

    protected String getUserLoggedIn() {
        return BaseUtils.getMatch(data, GCConstants.PATTERN_USERLOGGEDIN, true, "");
    }

    /*
     * The data for the caches can be generated by entering the url
     * http://www.geocaching.com/seek/cache_details.aspx?log=y&wp=GCxxxx&numlogs=35&decrypt=y
     * into a browser and saving the file
     */
    public String getData() {
        data = MockedCache.readCachePage(getGeocode());
        return data;
    }

    public static String readCachePage(final String geocode) {
        try {
            final InputStream is = MockedCache.class.getResourceAsStream("/cgeo/geocaching/test/mock/" + geocode + ".html");
            final BufferedReader br = new BufferedReader(new InputStreamReader(is), 150000);

            final StringBuffer buffer = new StringBuffer();
            String line = null;

            while ((line = br.readLine()) != null) {
                buffer.append(line).append('\n');
            }

            br.close();
            return BaseUtils.replaceWhitespace(buffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getLatitude() {
        return cgBase.formatLatitude(coords.getLatitude(), true);
    }

    @Override
    public String getLongitude() {
        return cgBase.formatLongitude(coords.getLongitude(), true);
    }

    @Override
    public boolean isArchived() {
        return false;
    }

    @Override
    public boolean isDisabled() {
        return false;
    }

    @Override
    public boolean isMembersOnly() {
        return false;
    }

    @Override
    public boolean isOwn() {
        return false;
    }

    @Override
    public String getHint() {
        return "";
    }

    @Override
    public String getShortDescription() {
        return "";
    }

    @Override
    public String getPersonalNote() {
        return "";
    }

    @Override
    public boolean isFound() {
        return false;
    }

    @Override
    public boolean isFavorite() {
        return false;
    }

    @Override
    public Integer getFavoritePoints() {
        return new Integer(0);
    }

    @Override
    public boolean isWatchlist() {
        return false;
    }

    @Override
    public List<cgTrackable> getInventory() {
        return new ArrayList<cgTrackable>();
    }

    @Override
    public List<cgImage> getSpoilers() {
        return null;
    }

    @Override
    public String getNameForSorting() {
        return getName();
    }
}
