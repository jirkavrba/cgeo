package cgeo.geocaching.maps.mapsforge;

public class TileSourceMapyCz extends AbstractMapyCzTileSource {

    public static final TileSourceMapyCz INSTANCE = new TileSourceMapyCz();

    private TileSourceMapyCz() {
        super("/tile/tourist/");
    }
}
