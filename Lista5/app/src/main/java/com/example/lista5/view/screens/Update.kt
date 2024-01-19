package com.example.lista5.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lista5.model.Grade
import com.example.lista5.model.SubjectAndGrade
import com.example.lista5.viewmodel.GradeViewModel

@Composable
fun Update(
    arg: String,
    viewModel: GradeViewModel,
    navController: NavController) {

    var grade by remember {
        mutableStateOf(viewModel.getGrade(arg.toInt()))
    }

    Scaffold {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)) {
            Text(text = "Przedmiot:")
            TextField(
                value = grade.subject,
                onValueChange = { grade = grade.copy(subject = it) },
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center))
            Text(text = "Ocena:")
            TextField(
                value = grade.grade.toString(),
                onValueChange = { grade = grade.copy(grade = it)},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
            )
            ElevatedButton(onClick = {
                if (viewModel.validateAndUpdateGrade(grade))
                    navController.popBackStack()
            }) {
                Text(text = "Edytuj")
            }
            ElevatedButton(onClick = {
                viewModel.deleteGrade(grade)
                navController.popBackStack()
            }) {
                Text(text = "Usuń")
            }
        }
    }
}
