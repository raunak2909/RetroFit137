package gov.rajasthan.retrofit137.model

data class QuoteModel(
    val id : String? = null,
    val quote : String? = null,
    val author : String? = null
)

data class DataModel(
    val quotes : List<QuoteModel>? = null,
    val limit : Int? = null,
    val skip : Int? = null,
    val total : String? = null,
)