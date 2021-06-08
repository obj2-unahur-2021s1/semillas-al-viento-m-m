package ar.edu.unahur.obj2.semillasAlViento

class Parcela(val ancho: Int, val largo: Int, val horasSolPorDia: Int) {
  val plantas = mutableListOf<Planta>()

  fun cantidadDePlantas() = plantas.size

  fun superficie() = ancho * largo

  fun cantidadMaximaPlantas() =
    if (ancho > largo) superficie() / 5 else superficie() / 3 + largo

  fun plantar(planta: Planta) {

    check((cantidadDePlantas() < cantidadMaximaPlantas())) {
      "Ya no hay lugar en esta parcela"
    }
    //creo q deberia ser al reves
    check((horasSolPorDia <= (planta.horasDeSolQueTolera() + 2))) {
      "No se puede plantar aquí, se va a quemar"
    }
    plantas.add(planta)
  }

  fun esSemillera() = plantas.all{ it.daSemillas() }

  fun parcelaTieneComplicaciones() = plantas.any { it.horasDeSolQueTolera() < this.horasSolPorDia }

}
class Agricultora(val parcelas: MutableList<Parcela>) {

  fun parcelasSemilleras() = parcelas.filter { it.esSemillera() }

  fun plantarEstrategicamente(planta: Planta) {
    val laElegida = parcelas.maxByOrNull { it.cantidadMaximaPlantas() - it.cantidadDePlantas() }!!
    laElegida.plantar(planta)
  }
}


