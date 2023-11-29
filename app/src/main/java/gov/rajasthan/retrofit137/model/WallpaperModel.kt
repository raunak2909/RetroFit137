package gov.rajasthan.retrofit137.model

data class DataWallpaperModel(
    val next_page : String? = null,
    val page : Int? = null,
    val per_page : Int? = null,
    val total_results : Int? = null,
    val photos : List<WallpaperModel>? = null,
)

data class WallpaperModel(
    val alt : String? = null,
    val avg_color : String? = null,
    val photographer : String? = null,
    val photographer_url : String? = null,
    val url : String? = null,
    val height : Int? = null,
    val id : Int? = null,
    val photographer_id : Int? = null,
    val width : Int? = null,
    val liked : Boolean? = null,
    val src : Src? = null
)


data class Src(
    val landscape : String? = null,
    val large : String? = null,
    val large2x : String? = null,
    val medium : String? = null,
    val original : String? = null,
    val portrait : String? = null,
    val small : String? = null,
    val tiny : String? = null,
)
