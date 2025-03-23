package com.example.tuto_connexion.tp.helpers

data class AlertDialogModelData(var isShow: Boolean = false, var message: String =  "", var onClose: () -> Unit = {}) {
}