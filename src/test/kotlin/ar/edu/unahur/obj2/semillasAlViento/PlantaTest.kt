package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class PlantaTest: DescribeSpec({

    describe("requerimientos Menta") {
        //se cambia el tipo de dato de altura de float a Double, ya que salta "The Double literal does not conform to the expected type Float"
        val menta = Menta(2021, 6.0)
        describe("horas de sol de la menta") {
            it("las horas de sol de la menta es de 6 horas de sol") {
                menta.horasDeSolQueTolera().shouldBe(6)
            }
            it("las horas de sol de la menta nunca sera distinto de 6 horas de sol") {
                (menta.horasDeSolQueTolera() == 10).shouldBeFalse()
            }
        }
        describe("es fuerte la menta") {
            it("la menta no es fuerte porq no tolera mas de 6 horas de sol") {
                menta.esFuerte().shouldBeFalse()
            }
        }
        describe("da semillas la menta") {
            it("la menta da semillas porq su altura es mayor a 0.4") {
                menta.daSemillas().shouldBeTrue()
            }
        }
    }
    describe("requerimientos Soja"){
        val soja1 = Soja(2020,1.5,false)
        val soja2 = Soja(2019,0.3,false)
        val soja3 = Soja(2006,0.8,false)
        describe("horas de sol de las sojas"){
            it("la soja1 al tener una altura mayor a 1, las horas de sol que toleran son 9"){
                soja1.horasDeSolQueTolera().shouldBe(9)
            }
            it("la soja2 al tener una altura menor a 0.5, las horas de sol que tolera son 6"){
                soja2.horasDeSolQueTolera().shouldBe(6)
            }
            it("la soja3 al tener una altura entre 0.5 y 1, las horas de sol que tolera son 7"){
                soja3.horasDeSolQueTolera().shouldBe(7)
            }
        }
        describe("es fuerte la soja"){
            it("la soja1 no es fuerte porq tolera menos de 10 horas de sol"){
                soja1.esFuerte().shouldBeFalse()
            }
        }
        describe("da semillas la soja"){
            it("la soja1 da semillas porq su altura es mayor a 1.0"){
                soja1.daSemillas().shouldBeTrue()
            }
            it("la soja3 no da semillas porq su altura no es mayor a 1.0 y su año de obtencion es previo a 2007"){
                soja3.daSemillas().shouldBeFalse()
            }
        }
    }

    describe("requerimientos Soja Transgenica"){}

    describe("requerimientos Parcela"){}

    describe("requerimientos Agricultora"){}
})