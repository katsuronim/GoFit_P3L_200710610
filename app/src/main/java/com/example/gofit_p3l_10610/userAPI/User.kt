package com.example.gofit_p3l_10610.userAPI

class User {
    private var id: Int? = null
    private var ID_USER: String? = null
    private var NAMA: String? = null
    private var JABATAN: String? = null
    private var EMAIL: String? = null
    private var USERNAME: String? = null
    private var PASSWORD: String? = null

    fun getId(): Int? {
        return id
    }
    fun getIdUser(): String? {
        return ID_USER
    }
    fun getNama(): String? {
        return NAMA
    }fun getJabatan(): String? {
        return JABATAN
    }fun getEmail(): String? {
        return EMAIL
    }fun getUsername(): String? {
        return USERNAME
    }fun getPassword(): String? {
        return PASSWORD
    }
}