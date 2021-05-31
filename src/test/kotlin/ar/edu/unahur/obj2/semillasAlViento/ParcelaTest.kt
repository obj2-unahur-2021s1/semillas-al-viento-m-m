package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ParcelaTest() : DescribeSpec( {
    val miParcela = Parcela(25, 50, 10)
    describe("Características de la parcela") {
        it("La superficie es 1250 m2") {
            miParcela.superficie().shouldBe(1250)
        }
        it("cantidad máxima de plantas toleradas es XX") {
            // TODO: 30/5/21
        }
        it("La parcela tiene complicaciones")
    }
    describe("Acciones en la parcela") {
        it("Se puede plantar una plata") {
            // TODO: 30/5/21
        }
        it("Se supera la cantidad máxima de plantas y arroja error") {
            // TODO: 30/5/21
        }
        it("La parcela recibe más de 2 hs. de las toleradas por la planta")
    }
 }
)
