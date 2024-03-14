package com.course.qoutepaging

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 *hrahm,08/03/2024, 19:41
 **/
interface ApiService {
    @GET("?p=api/biblio/all-pagination/{page}/{perPage}")
    suspend fun getQuote(
        @Path("page") page: Int,
        @Path("perPage") size: Int
    ): List<QuoteResponseItem>
}