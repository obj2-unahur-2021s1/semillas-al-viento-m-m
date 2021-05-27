package ar.edu.unahur.obj2.semillasAlViento

abstract class Planta(val anioObtencionSemilla: Int, var altura: Int) {
  fun esFuerte() = this.horasDeSolQueTolera() > 10

  // Aquí hay un problema de abstracción/cohesión: esta función debería estar en el módulo `Parcela`
  fun parcelaTieneComplicaciones(parcela: Parcela) =
    parcela.plantas.any { it.horasDeSolQueTolera() < parcela.horasSolPorDia }

  abstract fun horasDeSolQueTolera(): Int
  abstract fun daSemillas(): Boolean
}

class Menta(anioObtencionSemilla: Int, altura: Int) : Planta(anioObtencionSemilla, altura) {
  override fun horasDeSolQueTolera() = 6
  override fun daSemillas() = this.esFuerte() || altura > 0.4  // Esta función no es robusta porque genera
                                                               // un comportamiento errático al introducir
                                                               // el booleano de la condición 'esFuerte'
}

// no es cohesiva la clase soja xq en el misma clase se busca tratar los 2 tipos
// de soja, es mejor tener una clase soja que se dedique a la soja y
// otra clase, hija de soja, que se encargue de resolver la soja transgenica
class Soja(anioObtencionSemilla: Int, altura: Int, val esTransgenica: Boolean) : Planta(anioObtencionSemilla, altura) {
  override fun horasDeSolQueTolera(): Int  {
    // ¡Magia de Kotlin! El `when` es como un `if` pero más poderoso:
    // evalúa cada línea en orden y devuelve lo que está después de la flecha.

    // No sería flexible porque a medida que agregas más condiciones se haría más largo el código
    val horasBase = when {
      altura < 0.5  -> 6
      altura < 1    -> 7
      else          -> 9
    }
     //
    return if (esTransgenica) horasBase * 2 else horasBase
  }

  override fun daSemillas(): Boolean  {
    // Esta función no es consistente con la función anterior, ya que no aplica
    // el mismo criterio de resolución del problema para la condición de transgénica.
    if (this.esTransgenica) {
      return false
    }
    // Esta parte de la función no es robusta porque genera un comportamiento errático
    // al introducir el booleano de la condición 'esFuerte'
    return this.esFuerte() || (this.anioObtencionSemilla > 2007 && this.altura > 1)
  }
}
