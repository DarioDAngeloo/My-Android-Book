package com.example.myandroidbook.presentation.screen.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.myandroidbook.presentation.common.ListContent
import com.example.myandroidbook.presentation.components.RankingDifficultyWidget

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val allKotlinInfo = homeViewModel.getAllKotlinInfo.collectAsLazyPagingItems()

    Scaffold(topBar = {
        HomeTopBar(onSearchClicked = {})

    },
        content = {
            ListContent(kotlinInfo = allKotlinInfo, navHostController = navHostController )
        }

    )


}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {

}