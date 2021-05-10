package ar.edu.unahur.obj2.semillasAlViento

abstract class Planta(val anioObtencionSemilla: Int, var altura: Float) {
  fun esFuerte() = this.horasDeSolQueTolera() > 10

  // Aquí hay un problema de abstracción: esta función debería estar en el módulo `Parcela`
  fun parcelaTieneComplicaciones(parcela: Parcela) =
    parcela.plantas.any { it.horasDeSolQueTolera() < parcela.horasSolPorDia }

  abstract fun horasDeSolQueTolera(): Int
  abstract fun daSemillas(): Boolean
}
// si ya lo definió en la clase padre es necesario definirlo en la hija?
// NO ENTIENDO A QUÉ REFIERE LA PREGUNTA...
class Menta(anioObtencionSemilla: Int, altura: Float) : Planta(anioObtencionSemilla, altura) {
  override fun horasDeSolQueTolera() = 6
  override fun daSemillas() = this.esFuerte() || altura > 0.4  // Esta función no es robusta porque genera un
                                                               // comportamiento errático al introducir el
                                                               // booleano de la condición 'esFuerte'
}
// no es cohesiva la clase soja
class Soja(anioObtencionSemilla: Int, altura: Float, val esTransgenica: Boolean) : Planta(anioObtencionSemilla, altura) {
  override fun horasDeSolQueTolera(): Int  {
    // ¡Magia de Kotlin! El `when` es como un `if` pero más poderoso:
    // evalúa cada línea en orden y devuelve lo que está después de la flecha.

    //no seria flexible porq a medida que agregas mas condiciones se haria mas largo el codigo
    val horasBase = when {
      altura < 0.5  -> 6
      altura < 1    -> 7
      else          -> 9
    }
     //
    return if (esTransgenica) horasBase * 2 else horasBase
  }

  override fun daSemillas(): Boolean  {
    //el enunciado no especifica que si es transgénica no devuelve
    if (this.esTransgenica) {
      return false
    }

    return this.esFuerte() || (this.anioObtencionSemilla > 2007 && this.altura > 1)
  }
}
