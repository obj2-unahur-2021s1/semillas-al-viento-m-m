package ar.edu.unahur.obj2.semillasAlViento

class Parcela(val ancho: Int, val largo: Int, val horasSolPorDia: Int) {
  val plantas = mutableListOf<Planta>()

  fun cantidadDePlantas() = plantas.size

  fun superficie() = ancho * largo

  fun cantidadMaximaPlantas() =
    if (ancho > largo) superficie() / 5 else superficie() / 3 + largo

  //no cumple con la cualidad de robustez
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
  var ahorrosEnPesos = 20000

  /* La función `comprarParcela` no cumple el principio de simplicidad YAGNI (You aren’t gonna need it).
  Ya que implementa una funcionalidad que no se utiliza. */

  // Suponemos que una parcela vale 5000 pesos
  //creo que esta funcion no deberia ir por este comentario "Agricultora.parcelas -> debería ser inmutable, porque en el enunciado dice que no se pueden comprar ni vender."
  fun comprarParcela(parcela: Parcela) {
    if (ahorrosEnPesos >= 5000) {
      parcelas.add(parcela)
      ahorrosEnPesos -= 5000
    }
  }
  fun parcelasSemilleras() = parcelas.filter { it.esSemillera() }

  fun plantarEstrategicamente(planta: Planta) {
    val laElegida = parcelas.maxByOrNull { it.cantidadMaximaPlantas() - it.cantidadDePlantas() }!!
    //laElegida.plantas.add(planta)
    //se usa el metodo de la parcela
    laElegida.plantar(planta)
  }
}


