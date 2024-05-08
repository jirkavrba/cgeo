package cgeo.geocaching.unifiedmap.tileproviders;

import android.net.Uri;

import androidx.core.util.Pair;

class MapyCzTileProvider extends AbstractMapsforgeOnlineTileProvider {
    MapyCzTileProvider() {
        super("Mapy.cz", Uri.parse("https://mapy-cz.vrba.dev"), "/tile/{X}/{Y}/{Z}", 5, 18, new Pair<>("vrba.dev proxy", false));
    }
}
