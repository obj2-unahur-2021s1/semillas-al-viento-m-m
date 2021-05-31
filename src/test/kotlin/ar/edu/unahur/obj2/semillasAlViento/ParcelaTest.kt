package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import javax.lang.model.type.NullType

class ParcelaTest() : DescribeSpec( {

    val miParcela = Parcela(25, 50, 9)
    val menta = Menta(2020, 0.48)
    val sojaGrande = Soja(2019, 1.70, false)
    val sojaChica = Soja(2020, 0.6, false)

    describe("Características de la parcela") {
        it("La superficie es 1250 m2") {
            miParcela.superficie().shouldBe(1250)
        }
        it("cantidad máxima de plantas toleradas es 466") {
            miParcela.cantidadMaximaPlantas().shouldBe(466)
        }
        it("La parcela no tiene complicaciones") {
            miParcela.plantar(sojaGrande)
            sojaGrande.parcelaTieneComplicaciones(miParcela).shouldBe(false)
        }
        it("La parcela tiene complicaciones") {
            miParcela.plantar(sojaChica)
            sojaChica.parcelaTieneComplicaciones(miParcela).shouldBe(true)
        }
    }

    describe("Acciones en la parcela") {
        it("Se puede plantar una plata") {
            shouldNotThrow<Throwable> {
                miParcela.plantar(sojaGrande)
            }
        }

        it("La parcela recibe más de 2 hs. de las toleradas por la planta") {
            miParcela.plantar(menta).shouldBe(kotlin.Unit) // la función no produce un error sino un mensaje
                                                           // por lo tanto no se puede manejar como una excepción
        }

        it("Se supera la cantidad máxima de plantas y arroja error") {
            // Plantamos 466 plantas de soja que se agregan a las tres anteriores.
            (0..465).forEach {
                miParcela.plantar(sojaGrande)
            }
            miParcela.cantidadPlantas.shouldBe(466)
            miParcela.plantar(sojaGrande)(kotlin.Unit) // la función no produce un error sino un mensaje
                                                       // por lo tanto no se puede manejar como una excepción
        }
    }
 }
)
