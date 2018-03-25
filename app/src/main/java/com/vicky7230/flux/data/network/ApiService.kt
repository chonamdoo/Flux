package com.vicky7230.flux.data.network

import com.vicky7230.flux.data.network.model.account.Account
import com.vicky7230.flux.data.network.model.authentication.AuthenticationToken
import com.vicky7230.flux.data.network.model.configuration.Configuration
import com.vicky7230.flux.data.network.model.genres.Genres
import com.vicky7230.flux.data.network.model.results.Results
import com.vicky7230.flux.data.network.model.session.Session
import com.vicky7230.flux.data.network.model.tvDetails.Videos
import com.vicky7230.flux.data.network.model.tvDetails.TvDetails
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * Created by vicky on 31/12/17.
 */
interface ApiService {

    @GET("genre/tv/list")
    fun getGenresTv(
            @Query("api_key") apiKey: String
    ): Observable<Genres>

    @GET("genre/movie/list")
    fun getGenresMovies(
            @Query("api_key") apiKey: String
    ): Observable<Genres>

    @GET("configuration")
    fun getConfigurations(
            @Query("api_key") apiKey: String
    ): Observable<Configuration>

    @GET("discover/tv")
    fun getTvByGenres(
            @Query("api_key") apiKey: String,
            @Query("with_genres") withGenres: String,
            @Query("page") page: String,
            @Query("sort_by") sortBy: String,
            @Query("vote_average.gte") voteAverage: String
    ): Observable<Results>

    @GET("authentication/token/new")
    fun requestAuthenticationToken(
            @Query("api_key") apiKey: String
    ): Observable<AuthenticationToken>

    @GET("authentication/session/new")
    fun getSessionId(
            @Query("api_key") apiKey: String,
            @Query("request_token") requestToken: String
    ): Observable<Session>

    @GET("account")
    fun getAccountDetails(
            @Query("api_key") apiKey: String,
            @Query("session_id") sessionId: String
    ): Observable<Account>

    @GET("tv/{tv_id}")
    fun getTvDetails(
            @Path("tv_id") tvId: String,
            @Query("api_key") apiKey: String,
            @Query("append_to_response") value: String = "videos,reviews,credits"
    ): Observable<TvDetails>
}