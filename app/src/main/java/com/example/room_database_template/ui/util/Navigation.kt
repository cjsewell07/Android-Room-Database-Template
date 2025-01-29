package com.example.room_database_template.ui.util

//@Serializable object Start
//@Serializable object PersonAdd
//
//@Composable
//fun DatabaseTemplate(
//  personRepository: PersonRepository
//){
//  val navController = rememberNavController()
//  val personViewModel = PersonViewModel(personRepository)
//
//  /**
//   * TODO:
//   *  • Add Navigation Graph
//   */
//
//  NavHost(navController = navController, startDestination = Start){
//    composable<Start> {
//      People(navController = navController, viewModel = personViewModel)
//    }
//    navigation<PersonAdd>(startDestination = PersonAdd){
//      composable<PersonAdd> {
//        AddPerson(navController = navController, viewModel = personViewModel)
//      }
//    }
//  }
//}