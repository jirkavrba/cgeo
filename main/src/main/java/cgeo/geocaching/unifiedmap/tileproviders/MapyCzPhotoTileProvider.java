package cgeo.geocaching.unifiedmap.tileproviders;

import android.net.Uri;

import androidx.core.util.Pair;

class MapyCzPhotoTileProvider extends AbstractMapsforgeOnlineTileProvider {
    MapyCzPhotoTileProvider() {
        super("Mapy.cz (letecká)", Uri.parse("https://mapy-cz.vrba.dev"), "/tile/photo/{X}/{Y}/{Z}", 5, 18, new Pair<>("vrba.dev proxy", false));
    }
}
