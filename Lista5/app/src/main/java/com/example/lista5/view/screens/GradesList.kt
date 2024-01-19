package com.example.lista5.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.lista5.view.Screens
import com.example.lista5.viewmodel.GradeViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lista5.model.Grade

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GradesList(viewModel: GradeViewModel, navController: NavController) {
    val grades = viewModel.getGrades()
    var sum = 0f
    for (grade in grades)
        sum += grade.grade.toFloat()
    val average = if (sum != 0f) sum / grades.size else 0

    Scaffold(floatingActionButton = {
            AddGradeButton(onClick = { navController.navigate(Screens.Add.route) })
        }) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ){
            LazyColumn(
                userScrollEnabled = true,
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .padding(top = 10.dp)
            ) {
                items(grades) {
                    grade ->
                    CreateListItem(grade, viewModel, navController)
                }
            }
            OutlinedCard(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(bottom = 100.dp)
                    .height(50.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically){
                    Text(text = "Średnia ocen: ", fontSize = 20.sp)
                    Spacer(Modifier.weight(1f))
                    Text(text = average.toString(), fontSize = 30.sp)
                }
            }
        }
    }
}

@Composable
fun AddGradeButton(onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        onClick = onClick
    ) {
        Text(text = "Dodaj")
    }
}

@Composable
fun CreateListItem(grade: Grade, viewModel: GradeViewModel, navController: NavController) {
    OutlinedButton(
        onClick = { navController.navigate(Screens.Update.route + "/${grade.uid}")
                  println(Screens.Update.route + "/${grade.uid}")},
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(text = grade.subject, fontSize = 20.sp)
        Spacer(Modifier.weight(1f))
        Text(text = grade.grade.toString(), fontSize = 30.sp)
    }
}