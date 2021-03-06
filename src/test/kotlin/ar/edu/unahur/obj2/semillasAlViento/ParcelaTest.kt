package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import javax.lang.model.type.NullType

class ParcelaTest() : DescribeSpec( {

    val miParcela = Parcela(25, 50, 9)
    val menta = Menta(2020, 0.48)
    val sojaGrande = Soja(2019, 1.70)
    val sojaChica = Soja(2020, 0.6)

    describe("Características de la parcela") {
        it("La superficie es 1250 m2") {
            miParcela.superficie().shouldBe(1250)
        }
        it("cantidad máxima de plantas toleradas es 466") {
            miParcela.cantidadMaximaPlantas().shouldBe(466)
        }
        it("La parcela no tiene complicaciones") {
            miParcela.plantar(sojaGrande)
            miParcela.parcelaTieneComplicaciones().shouldBe(false)
        }
        it("La parcela tiene complicaciones") {
            miParcela.plantar(sojaChica)
            miParcela.parcelaTieneComplicaciones().shouldBe(true)
        }
    }

    describe("Acciones en la parcela") {
        it("Se puede plantar una plata") {
            shouldNotThrow<Throwable> {
                miParcela.plantar(sojaGrande)
            }
        }

        it("La parcela recibe más de 2 hs. de las toleradas por la planta") {
            shouldThrowAny {
                miParcela.plantar(menta)
            }
        }

        it("Se supera la cantidad máxima de plantas y arroja error") {
            // Plantamos 466 plantas de soja que se agregan a las tres anteriores.
            (0..465).forEach {
                miParcela.plantar(sojaGrande)
            }
            miParcela.cantidadDePlantas().shouldBe(466)
        }
    }
 }
)

