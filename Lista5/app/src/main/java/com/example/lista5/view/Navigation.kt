package com.example.lista5.view

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lista5.view.screens.Add
import com.example.lista5.view.screens.GradesList
import com.example.lista5.view.screens.Update
import com.example.lista5.viewmodel.GradeViewModel

@Composable
fun Navigation() {
    var navController = rememberNavController()
    var viewModel = GradeViewModel(LocalContext.current.applicationContext as Application)
    
    NavHost(navController = navController, startDestination = Screens.GradesList.route) {
        composable(route = Screens.GradesList.route) {
            GradesList(viewModel = viewModel, navController = navController)
        }

        composable(route = Screens.Add.route) {
            Add(viewModel = viewModel, navController = navController)
        }

        composable(route = Screens.Update.route + "/{grade}") {
            val arg = it.arguments?.getString("grade")
            if (arg != null)
            {
                Update(arg = arg, viewModel = viewModel, navController = navController)
            }
        }
    }

}