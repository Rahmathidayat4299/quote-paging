package com.course.qoutepaging

import com.google.gson.annotations.SerializedName

/**
 *hrahm,08/03/2024, 19:41
 **/
data class QuoteResponseItem(


//    @field:SerializedName("id")
//    val id: String,

    @field:SerializedName("title")
    val title: String? = null,

//    @field:SerializedName("en")
//    val en: String? = null
)
