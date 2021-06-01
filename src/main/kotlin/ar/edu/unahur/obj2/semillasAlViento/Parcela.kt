package ar.edu.unahur.obj2.semillasAlViento

class Parcela(val ancho: Int, val largo: Int, val horasSolPorDia: Int) {
  val plantas = mutableListOf<Planta>()
 //var cantidadPlantas = 0 // esta variable no refleja simplicidad y presenta desacoplamiento, porque es independiente
                          // de la lista anterior.

  fun superficie() = ancho * largo

  fun cantidadDePlantas() = plantas.size

  // La función no cumple con la cualidad de simplicidad
  fun cantidadMaximaPlantas() =
    if (ancho > largo) ancho * largo / 5 else ancho * largo / 3 + largo

  //no cumple con la cualidad de robustez
  fun plantar(planta: Planta) {
    //agregar el check para las exeption
    if (this.cantidadDePlantas() == this.cantidadMaximaPlantas()) {
      println("Ya no hay lugar en esta parcela")
    } else if (horasSolPorDia > planta.horasDeSolQueTolera() + 2) {
      println("No se puede plantar esto acá, se va a quemar")
    } else {
      plantas.add(planta)
      //cantidadPlantas += 1 // esto es redundante, porque la forma de resolver el valor de la variable no es simple y
                           // está desacoplado de la lista de plantas.
    }
  }
  //se agrega funcion para mejorar
  fun esSemillera() = plantas.all{ it.daSemillas() }
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
    // Esta función no presenta un buen nivel de abstracción para la determinación de si una parcela es semillera.
      // Tampoco tiene facilidad de prueba.
      //parcelas.filter { parcela ->
        //parcela.plantas.all { planta ->
          //planta.daSemillas()
        //}
      //}

  fun plantarEstrategicamente(planta: Planta) {
      val laElegida = parcelas.maxBy { it.cantidadMaximaPlantas() - it.cantidadDePlantas() }!!
      //laElegida.plantas.add(planta)
      //se usa el metodo de la parcela
      laElegida.plantar(planta)
    }
  }

