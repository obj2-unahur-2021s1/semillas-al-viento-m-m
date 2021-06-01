package ar.edu.unahur.obj2.semillasAlViento
//se cambia val porq es invariable
abstract class Planta(val anioObtencionSemilla: Int, val altura: Double) {
  fun esFuerte() = this.horasDeSolQueTolera() > 10

  // Aquí hay un problema de abstracción/cohesión: esta función debería estar en el módulo `Parcela`
  fun parcelaTieneComplicaciones(parcela: Parcela) =
    parcela.plantas.any { it.horasDeSolQueTolera() < parcela.horasSolPorDia }

  abstract fun horasDeSolQueTolera(): Int
  abstract fun daSemillas(): Boolean
  //open fun daSemillas() = this.esFuerte()
  //llamar al super con las hijas y agregar la condicion de cada planta
}

class Menta(anioObtencionSemilla: Int, altura: Double) : Planta(anioObtencionSemilla, altura) {
  override fun horasDeSolQueTolera() = 6
  override fun daSemillas() = this.esFuerte() || altura > 0.4
}

// no es cohesiva la clase soja xq en el misma clase se busca tratar los 2 tipos
// de soja, es mejor tener una clase soja que se dedique a la soja y
// otra clase, hija de soja, que se encargue de resolver la soja transgenica
open class Soja(anioObtencionSemilla: Int, altura: Double) : Planta(anioObtencionSemilla, altura) {
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
    return horasBase //if (esTransgenica) horasBase * 2 else horasBase
  }
  override fun daSemillas(): Boolean  {
    // Esta función no es consistente con la función anterior, ya que no aplica
    // el mismo criterio de resolución del problema para la condición de transgénica.
    //if (this.esTransgenica) {
      //return false
    //}
    // Esta parte de la función no es robusta porque genera un comportamiento errático
    // al introducir el booleano de la condición 'esFuerte'
    return this.esFuerte() || (this.anioObtencionSemilla > 2007 && this.altura > 1)
  }
}
class SojaTransgenica(anioObtencionSemilla: Int, altura: Double): Soja(anioObtencionSemilla, altura){

  override fun horasDeSolQueTolera() = super.horasDeSolQueTolera()*2

  override fun daSemillas() = false
}