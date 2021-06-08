package ar.edu.unahur.obj2.semillasAlViento

abstract class Planta(val anioObtencionSemilla: Int, val altura: Double) {
  fun esFuerte() = this.horasDeSolQueTolera() > 10
  abstract fun horasDeSolQueTolera(): Int
  abstract fun factorAdicional() : Boolean
  open fun daSemillas(): Boolean = this.esFuerte() || this.factorAdicional()
}

class Menta(anioObtencionSemilla: Int, altura: Double) : Planta(anioObtencionSemilla, altura) {
  override fun horasDeSolQueTolera() = 6
  override fun factorAdicional() = altura > 0.4
}

open class Soja(anioObtencionSemilla: Int, altura: Double) : Planta(anioObtencionSemilla, altura) {
  override fun horasDeSolQueTolera(): Int  {
    val horasBase = when {
      altura < 0.5  -> 6
      altura < 1    -> 7
      else          -> 9
    }
    return horasBase
  }

  override fun factorAdicional() = this.anioObtencionSemilla > 2007 && this.altura > 1
}
class SojaTransgenica(anioObtencionSemilla: Int, altura: Double): Soja(anioObtencionSemilla, altura){
  override fun horasDeSolQueTolera() = super.horasDeSolQueTolera()*2
  override fun daSemillas() = false
}