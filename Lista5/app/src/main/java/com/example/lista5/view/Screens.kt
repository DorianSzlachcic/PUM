package com.example.lista5.view

sealed class Screens(val route: String) {
    object GradesList : Screens("GradesList")
    object Add : Screens("Add")
    object Update : Screens("Update")
}