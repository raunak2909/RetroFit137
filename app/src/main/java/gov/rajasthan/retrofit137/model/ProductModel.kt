package gov.rajasthan.retrofit137.model

data class ProductModel(
    val brand : String? = null,
    val category : String? = null,
    val description : String? = null,
    val thumbnail : String? = null,
    val title : String? = null,
    val discountPercentage : Double? = null,
    val rating : Double? = null,
    val id: Int? = null,
    val stock: Int? = null,
    val price: Int? = null,
    val images : ArrayList<String>? = null
)

data class DataProductModel(
    val limit : Int? = null,
    val total : Int? = null,
    val skip : Int? = null,
    val products : ArrayList<ProductModel>? = null,

    )
