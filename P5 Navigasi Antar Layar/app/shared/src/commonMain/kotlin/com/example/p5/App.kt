package com.example.p5

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.p5.data.PenyimpananResep
import com.example.p5.nav.RuteAsisten
import com.example.p5.nav.RuteBeranda
import com.example.p5.nav.RuteDetail
import com.example.p5.nav.RuteForm
import com.example.p5.nav.RuteProfil
import com.example.p5.nav.daftarTab
import com.example.p5.nav.pindahTab
import com.example.p5.ui.DetailViewModel
import com.example.p5.ui.FormResepScreen
import com.example.p5.ui.LayarAsisten
import com.example.p5.ui.LayarDaftar
import com.example.p5.ui.LayarDetail
import com.example.p5.ui.LayarProfil
import org.jetbrains.compose.resources.painterResource

@Composable
fun App() {
    MaterialTheme {
        val nav = rememberNavController()
        Scaffold(
            bottomBar = {
                NavigationBar {
                    val entry by nav.currentBackStackEntryAsState()
                    daftarTab.forEach { tab ->
                        NavigationBarItem(
                            selected = entry?.destination?.hasRoute(tab.rute::class) == true,
                            onClick = { pindahTab(nav, tab.rute) },
                            icon = { Icon(painterResource(tab.ikon), contentDescription = null) },
                            label = { Text(tab.label) }
                        )
                    }
                }
            }
        ) { padding ->
            NavHost(
                navController = nav,
                startDestination = RuteBeranda,
                modifier = Modifier.padding(padding)
            ) {
                composable<RuteBeranda> {
                    val daftar by PenyimpananResep.daftar.collectAsState()
                    LayarDaftar(
                        semua = daftar,
                        bukaDetail = { id -> nav.navigate(RuteDetail(id)) },
                        bukaForm = { nav.navigate(RuteForm) }
                    )
                }
                composable<RuteDetail> { entry ->
                    val id = entry.toRoute<RuteDetail>().id
                    val vm = viewModel { DetailViewModel(id) }
                    val state by vm.uiState.collectAsState()
                    LayarDetail(
                        state = state,
                        kembali = { nav.popBackStack() },
                        onSetujui = vm::setujui,
                        onTolak = vm::tolak
                    )
                }
                composable<RuteForm> {
                    FormResepScreen(
                        kembali = { nav.popBackStack() },
                        selesai = { idBaru ->
                            nav.navigate(RuteDetail(idBaru)) {
                                popUpTo<RuteBeranda>()
                                launchSingleTop = true
                            }
                        }
                    )
                }
                composable<RuteAsisten> { LayarAsisten() }
                composable<RuteProfil> { LayarProfil() }
            }
        }
    }
}
