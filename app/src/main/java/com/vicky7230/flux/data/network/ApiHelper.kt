package com.vicky7230.flux.data.network

import com.vicky7230.flux.data.network.model.configuration.Configuration
import com.vicky7230.flux.data.network.model.genres.Genres
import com.vicky7230.flux.data.network.model.results.Results
import io.reactivex.Observable

/**
 * Created by vicky on 31/12/17.
 */
interface ApiHelper {

    fun getConfigurations(apiKey: String): Observable<Configuration>

    fun getGenres(apiKey: String): Observable<Genres>

    fun getTvByGenres(apiKey: String, withGenres: String, page: String): Observable<Results>

}