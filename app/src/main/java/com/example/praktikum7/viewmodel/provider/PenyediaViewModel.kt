package com.example.praktikum7.viewmodel.provider

import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.praktikum7.repositori.AplikasiSiswa
import com.example.praktikum7.viewmodel.EntryViewModel
import com.example.praktikum7.viewmodel.HomeViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras

object PenyediaViewModel {
    val Factory = viewModelFactory {

        // HAPUS BARIS INI: val aplikasiSiswa = this.aplikasiSiswa()

        initializer {
            // Pindah variabel ke sini, di mana 'this' adalah CreationExtras
            val aplikasiSiswa = this.aplikasiSiswa()
            HomeViewModel(
                aplikasiSiswa.container.repositoriSiswa
            )
        }
        initializer {
            // Ulangi untuk EntryViewModel
            val aplikasiSiswa = this.aplikasiSiswa()
            EntryViewModel(
                aplikasiSiswa.container.repositoriSiswa
            )
        }
    }
}
fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)