package com.example.myandroidbook.presentation.screen.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val allKotlinInfo = homeViewModel.getAllKotlinInfo.collectAsLazyPagingItems()

    Scaffold(topBar = {
        HomeTopBar(onSearchClicked = {})

    }) {

    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen()
}