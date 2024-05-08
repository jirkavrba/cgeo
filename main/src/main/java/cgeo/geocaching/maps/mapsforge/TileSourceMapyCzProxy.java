package cgeo.geocaching.maps.mapsforge;

import org.mapsforge.core.model.Tile;
import org.mapsforge.map.layer.download.tilesource.AbstractTileSource;
import org.mapsforge.map.layer.download.tilesource.TileSource;

import java.net.MalformedURLException;
import java.net.URL;

public class TileSourceMapyCzProxy extends AbstractTileSource {

    public static final TileSourceMapyCzProxy INSTANCE = new TileSourceMapyCzProxy(new String[]{"mapy-cz.vrba.dev"}, 443);
    private static final int PARALLEL_REQUESTS_LIMIT = 8;
    private static final String PROTOCOL = "https";
    private static final int ZOOM_LEVEL_MAX = 18;
    private static final int ZOOM_LEVEL_MIN = 0;

    public TileSourceMapyCzProxy(final String[] hostNames, final int port) {
        super(hostNames, port);
    }

    @Override
    public int getParallelRequestsLimit() {
        return PARALLEL_REQUESTS_LIMIT;
    }

    @Override
    public URL getTileUrl(Tile tile) throws MalformedURLException {
        return new URL(PROTOCOL, getHostName(), port, "/tile/" + tile.tileX + "/" + tile.tileY + "/" + tile.zoomLevel);
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
