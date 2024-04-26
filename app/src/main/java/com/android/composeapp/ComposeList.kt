package com.android.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.composeapp.ui.theme.ComposeAppTheme

class ComposeList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TwoListsLayout()
                }
            }
        }
    }
    

    @Composable
    fun ListLazyRowDemo(){
        val textList = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ){
            items(textList){
                text -> Text(text = text,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)
                )
            }
        }
    }

    @Composable
    fun ListLazyColumnDemo(){
        val textList = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
        LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)){
            items(textList) {
                text -> Text(text = text,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp))
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun TwoListsLayout() {
        Column {
            ListLazyRowDemo()

            ListLazyColumnDemo()

            LazyVerticalGridDemo()
        }
    }

    @Composable
    fun LazyVerticalGridDemo() {
        val list = (1..10).map { it.toString() }
        val textList = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
        LazyVerticalGrid(
            columns = GridCells.Adaptive(128.dp)
        ){
            items(textList) { item ->
                Text(text = item)
            }
        }

        LazyHorizontalGrid(
            rows = GridCells.Adaptive(100.dp)
        ){
            items(textList) { item ->
                Text(text = item)
            }
        }

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Adaptive(100.dp)
        ){
            items(textList) { item ->
                Text(text = item)
            }
        }


    }
}