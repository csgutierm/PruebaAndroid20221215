package com.csgm.myapplicationdiciembre

data class UFResponse(
    val version: String,
    val autor: String,
    val codigo: String,
    val nombre: String,
    val unidad_medida: String,
    val serie: List<SerieItem>
)

data class SerieItem(
    val fecha: String,
    val valor: Double
)