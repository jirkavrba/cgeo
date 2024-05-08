package cgeo.geocaching.maps.mapsforge;

public class TileSourceMapyCzPhoto extends AbstractMapyCzTileSource {

    public static final TileSourceMapyCzPhoto INSTANCE = new TileSourceMapyCzPhoto();

    private TileSourceMapyCzPhoto() {
        super("/tile/photo/");
    }
}

