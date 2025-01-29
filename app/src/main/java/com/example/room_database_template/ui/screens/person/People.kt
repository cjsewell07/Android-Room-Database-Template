package com.example.room_database_template.ui.screens.person

import PersonAdd
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.room_database_template.ui.viewmodels.PersonViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun People(
  navController: NavController,
  viewModel: PersonViewModel
){
  val listPeople by viewModel.allPeople.observeAsState(listOf())
  
  Scaffold(
    topBar = {
      TopAppBar(
        colors = topAppBarColors(
          containerColor = MaterialTheme.colorScheme.primaryContainer,
          titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
          Text("Database Template")
        }
      )
    },
    bottomBar = {
      BottomAppBar {
        Row{
          Button(onClick = { navController.navigate(route = PersonAdd)}) {
            Text("Add Person")
          }
          Button(onClick = { }) {
            Text("Delete Database")
          }
        }
      }
    }
  ){ innerPadding ->
    Column (
      modifier = Modifier
        .padding(innerPadding)
    ) {
      Text("Hello, the database is shown below!")
      LazyColumn {
        items(listPeople.size) { index ->
          Row {
            Text(text = listPeople[index].name)
            Button(onClick = { /*TODO*/ }) {
              Text(text = "Remove")
            }
            Button(onClick = { /*TODO*/ }) {
              Text(text = "Edit")
            }
          }
        }
      }
      
    }
  }
}