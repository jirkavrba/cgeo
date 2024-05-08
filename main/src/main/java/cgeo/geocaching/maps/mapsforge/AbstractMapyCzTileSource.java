package cgeo.geocaching.maps.mapsforge;

import org.mapsforge.core.model.Tile;
import org.mapsforge.map.layer.download.tilesource.AbstractTileSource;

import java.net.MalformedURLException;
import java.net.URL;

public class AbstractMapyCzTileSource extends AbstractTileSource {

    private final String path;

    private static final int PARALLEL_REQUESTS_LIMIT = 8;

    private static final String PROTOCOL = "https";

    private static final String BASE_URL = "mapy-cz.vrba.dev";

    private static final int PORT = 443;

    private static final int ZOOM_LEVEL_MAX = 18;

    private static final int ZOOM_LEVEL_MIN = 0;


    protected AbstractMapyCzTileSource(final String path) {
        super(new String[]{BASE_URL}, PORT);
        this.path = path;
    }


    @Override
    public int getParallelRequestsLimit() {
        return PARALLEL_REQUESTS_LIMIT;
    }

    @Override
    public URL getTileUrl(Tile tile) throws MalformedURLException {
        return new URL(PROTOCOL, getHostName(), port, path + tile.tileX + "/" + tile.tileY + "/" + tile.zoomLevel);
    }

    @Override
    public byte getZoomLevelMax() {
        return ZOOM_LEVEL_MAX;
    }

    @Override
    public byte getZoomLevelMin() {
        return ZOOM_LEVEL_MIN;
    }

    @Override
    public boolean hasAlpha() {
        return false;
    }
}
