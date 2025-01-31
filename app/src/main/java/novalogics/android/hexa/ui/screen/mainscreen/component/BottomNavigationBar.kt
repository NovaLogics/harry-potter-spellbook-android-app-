package novalogics.android.hexa.ui.screen.mainscreen.component

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import novalogics.android.hexa.R


import java.util.Locale


@Composable
fun BottomNavigationBar(
    navController: NavController,
    items: List<String>
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.primaryContainer
    ) {
        items.forEachIndexed { index, screen ->
            BottomNavigationItem(
                selected = currentRoute == screen,
                onClick = {
                    navController.navigate(screen) {
                        // Prevent multiple copies of the same destination
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        // Avoid building up a large stack of destinations
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                },
                label = { Text(screen.capitalize(Locale.ROOT)) },
                icon = {
                    Icon(
                        painter = painterResource(id = getIcon(index)) ,
                        contentDescription = null
                    )
                }
            )
        }
    }
}


fun getIcon(index: Int) : Int {
    return when (index) {
        0 -> R.drawable.ic_nav_spell_circle
        1 -> R.drawable.ic_nav_spell_book
        else -> R.drawable.ic_nav_spell_circle
    }
}
