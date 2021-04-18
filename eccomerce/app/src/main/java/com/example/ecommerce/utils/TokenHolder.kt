package com.example.ecommerce.utils

object TokenHolder {
    var access_token: String? = null
        private set
    var refresh_token: String? = null
        private set

    fun updateToken(access_token: String?, refresh_token: String?) {
        this.access_token = access_token
        this.refresh_token = refresh_token
    }
}