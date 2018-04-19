package com.devindi.wallpaper.misc

import com.devindi.wallpaper.home.WallpaperFactory
import com.squareup.picasso.Picasso
import com.squareup.picasso.Request
import com.squareup.picasso.RequestHandler
import org.osmdroid.util.BoundingBox
import org.osmdroid.util.TileSystem

class TileRequestHandler(private val factory: WallpaperFactory): RequestHandler() {

    override fun canHandleRequest(data: Request): Boolean {
        return data.uri.scheme == "osm"
    }

    override fun load(request: Request, networkPolicy: Int): Result {
        //todo extract params from request
        val bitmap = factory.createWallpaper(BoundingBox(TileSystem.MaxLatitude, TileSystem.MaxLongitude - 1, TileSystem.MinLatitude, TileSystem.MinLongitude + 1), 0)
        return Result(bitmap, Picasso.LoadedFrom.DISK)
    }
}