package com.example.ecommerce.repository.datasource

import android.content.SharedPreferences
import com.example.ecommerce.model.Login
import com.example.ecommerce.utils.TokenHolder
import io.reactivex.rxjava3.core.Single

class LocalLoginDataSource(private val sharedPreferences: SharedPreferences) : LoginDataSource {
    override fun login(username: String, password: String): Single<Login> {
        TODO("Not yet implemented")
    }

    override fun accessToken(access_token: String, refresh_token: String) {
        sharedPreferences.edit().apply {
            putString("access_token", access_token)
            putString("refresh_token", refresh_token)
        }.apply()
    }

    override fun loadToken(token: String) {
        TokenHolder.updateToken(
            sharedPreferences.getString("access_token", null),
            sharedPreferences.getString("refresh_token", null)
        )
    }

    override fun checkLogin(): Boolean {
        return sharedPreferences.getString("access_token", "") != ""
    }


}