package com.shubham.igi.ui.navigation

sealed class Screen(val route: String) {
    data object Start : Screen("start")
    data object Home : Screen("home")
    data object AddEdit : Screen("add_edit")
    data object AddEditFilm : Screen("add_edit_film")
    data object List : Screen("list")
    data object History : Screen("history")
    data object HistoryFilm : Screen("history_film")
    data object FilmStock : Screen("film_stock")

    // Receipts
    data object ClientList : Screen("clients")
    data object AddClient : Screen("add-client")
    data class ClientDetail(val clientId: Long) : Screen("clients/$clientId")
}