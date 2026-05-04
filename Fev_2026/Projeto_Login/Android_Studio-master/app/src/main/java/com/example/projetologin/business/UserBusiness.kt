package com.example.projetologin

class UserBusiness {

    fun checkCredentials(email: String, password: String): Boolean {
        return email.isNotEmpty() && password.isNotEmpty()
    }
}
