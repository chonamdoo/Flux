package com.vicky7230.flux.data

import com.vicky7230.flux.data.db.AppDbHelper
import com.vicky7230.flux.data.db.room.model.ConfigurationDbModel
import com.vicky7230.flux.data.network.AppApiHelper
import com.vicky7230.flux.data.network.addToWatchlist.AddToWatchlist
import com.vicky7230.flux.data.network.model.account.Account
import com.vicky7230.flux.data.network.model.authentication.AuthenticationToken
import com.vicky7230.flux.data.network.model.configuration.Configuration
import com.vicky7230.flux.data.network.model.genres.Genres
import com.vicky7230.flux.data.network.model.results.Results
import com.vicky7230.flux.data.network.model.session.Session
import com.vicky7230.flux.data.network.model.setFavourite.SetFavourite
import com.vicky7230.flux.data.network.model.tvDetails.TvDetails
import com.vicky7230.flux.data.prefs.AppPreferencesHelper
import com.vicky7230.flux.ui.tvDetails.Favourite
import com.vicky7230.flux.ui.tvDetails.Watchlist
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by vicky on 31/12/17.
 */
class AppDataManager @Inject
constructor(
        private val appApiHelper: AppApiHelper,
        private val appPreferencesHelper: AppPreferencesHelper,
        private val appDbHelper: AppDbHelper
) : DataManager {

    override fun setAccountId(accountId: Int?) {
        appPreferencesHelper.setAccountId(accountId)
    }

    override fun getAccountId(): Int? {
        return appPreferencesHelper.getAccountId()
    }

    override fun getUserName(): String? {
        return appPreferencesHelper.getUserName()
    }

    override fun setUserName(userName: String?) {
        appPreferencesHelper.setUserName(userName)
    }

    override fun getName(): String? {
        return appPreferencesHelper.getName()
    }

    override fun setName(name: String?) {
        return appPreferencesHelper.setName(name)
    }

    override fun setIsUserLoggedIn() {
        appPreferencesHelper.setIsUserLoggedIn()
    }

    override fun getIsUserLoggedIn(): Boolean {
        return appPreferencesHelper.getIsUserLoggedIn()
    }

    override fun setSessionIdIntoPreference(sessionId: String?) {
        appPreferencesHelper.setSessionIdIntoPreference(sessionId)
    }

    override fun getSessionIdFromPreference(): String? {
        return appPreferencesHelper.getSessionIdFromPreference()
    }

    override fun setGenresSelected() {
        appPreferencesHelper.setGenresSelected()
    }

    override fun getGenresSelected(): Boolean {
        return appPreferencesHelper.getGenresSelected()
    }

    override fun setBaseImageUrl(url: String?) {
        appPreferencesHelper.setBaseImageUrl(url)
    }

    override fun getBaseImageUrl(): String? {
        return appPreferencesHelper.getBaseImageUrl()
    }

    override fun deleteConfigurations() {
        appDbHelper.deleteConfigurations()
    }

    override fun getConfigurations(apiKey: String): Observable<Configuration> {
        return appApiHelper.getConfigurations(apiKey)
    }

    override fun insertConfigurations(configurations: MutableList<ConfigurationDbModel>): List<Long> {
        return appDbHelper.insertConfigurations(configurations)
    }

    override fun getGenresTv(apiKey: String): Observable<Genres> {
        return appApiHelper.getGenresTv(apiKey)
    }

    override fun getGenresMovies(apiKey: String): Observable<Genres> {
        return appApiHelper.getGenresMovies(apiKey)
    }

    override fun getTvByGenres(apiKey: String, withGenres: String, page: String, sortBy: String, voteAverage: String): Observable<Results> {
        return appApiHelper.getTvByGenres(apiKey, withGenres, page, sortBy, voteAverage)
    }

    override fun setUserGenres(genres: String?): Observable<Boolean> {
        return appPreferencesHelper.setUserGenres(genres)
    }

    override fun getUserGenres(): String? {
        return appPreferencesHelper.getUserGenres()
    }

    override fun requestAuthenticationToken(apiKey: String): Observable<AuthenticationToken> {
        return appApiHelper.requestAuthenticationToken(apiKey)
    }

    override fun getSessionId(apiKey: String, requestToken: String): Observable<Session> {
        return appApiHelper.getSessionId(apiKey, requestToken)
    }

    override fun getAccountDetails(apiKey: String, sessionId: String): Observable<Account> {
        return appApiHelper.getAccountDetails(apiKey, sessionId)
    }

    override fun getTvDetails(tvId: String, apiKey: String): Observable<TvDetails> {
        return appApiHelper.getTvDetails(tvId, apiKey)
    }

    override fun getSearchResults(apiKey: String, query: String, page: String): Observable<Results> {
        return appApiHelper.getSearchResults(apiKey, query, page)
    }

    override fun setFavourite(accountId: Int, apiKey: String, sessionId: String, favourite: Favourite): Observable<SetFavourite> {
        return appApiHelper.setFavourite(accountId, apiKey, sessionId, favourite)
    }

    override fun getFavourites(accountId: Int, apiKey: String, sessionId: String, page: String): Observable<Results> {
        return appApiHelper.getFavourites(accountId, apiKey, sessionId, page)
    }

    override fun addToWatchlist(accountId: Int, apiKey: String, sessionId: String, watchlist: Watchlist): Observable<AddToWatchlist> {
        return appApiHelper.addToWatchlist(accountId, apiKey, sessionId, watchlist)
    }

    override fun getWatchList(accountId: Int, apiKey: String, sessionId: String, page: String): Observable<Results> {
        return appApiHelper.getWatchList(accountId, apiKey, sessionId, page)
    }

}
