package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class PlantaTest: DescribeSpec({

    describe("Requerimientos Menta") {
        val menta = Menta(2021, 6.0)
        describe("Horas de sol de la menta") {
            it("Las horas de sol de la menta es de 6 horas de sol") {
                menta.horasDeSolQueTolera().shouldBe(6)
            }
            it("Las horas de sol de la menta nunca sera distinto de 6 horas de sol") {
                (menta.horasDeSolQueTolera() == 10).shouldBeFalse()
            }
        }
        describe("La menta es fuerte") {
            it("La menta no es fuerte porque no tolera mas de 6 horas de sol") {
                menta.esFuerte().shouldBeFalse()
            }
        }
        describe("La menta da semillas") {
            it("La menta da semillas porque su altura es mayor a 0.4") {
                menta.daSemillas().shouldBeTrue()
            }
        }
    }
    describe("Requerimientos Soja"){
        val soja1 = Soja(2020,1.5)
        val soja2 = Soja(2019,0.3)
        val soja3 = Soja(2006,0.8)
        describe("Horas de sol de las sojas"){
            it("La soja1 al tener una altura mayor a 1, las horas de sol que toleran son 9"){
                soja1.horasDeSolQueTolera().shouldBe(9)
            }
            it("La soja2 al tener una altura menor a 0.5, las horas de sol que tolera son 6"){
                soja2.horasDeSolQueTolera().shouldBe(6)
            }
            it("La soja3 al tener una altura entre 0.5 y 1, las horas de sol que tolera son 7"){
                soja3.horasDeSolQueTolera().shouldBe(7)
            }
        }
        describe("La soja es fuerte"){
            it("La soja1 no es fuerte porque tolera menos de 10 horas de sol"){
                soja1.esFuerte().shouldBeFalse()
            }
        }
        describe("La soja da semillas"){
            it("La soja1 da semillas porque su altura es mayor a 1.0"){
                soja1.daSemillas().shouldBeTrue()
            }
            it("La soja3 no da semillas porque su altura no es mayor a 1.0 y su año de obtención es previo a 2007"){
                soja3.daSemillas().shouldBeFalse()
            }
        }
    }

    describe("Requerimientos Soja Transgenica"){
        val sojaTransgenica1 = SojaTransgenica(2015,1.2)
        val sojaTransgenica2 = SojaTransgenica(2019,0.3)
        val sojaTransgenica3 = SojaTransgenica(2006,0.8)

        describe("Horas de sol que tolera"){
            it("La altura de la sojatransgenica1 al ser mayor a 1.2 tolera hace que tolere 18 horas de sol"){
                sojaTransgenica1.horasDeSolQueTolera().shouldBe(18)
            }
            it("La sojatransgenica2 al tener una altura menor a 0.5, las horas de sol que tolera son 12"){
                sojaTransgenica2.horasDeSolQueTolera().shouldBe(12)
            }
            it("La sojatransgenica3 al tener una altura entre 0.5 y 1, las horas de sol que tolera son 14"){
                sojaTransgenica3.horasDeSolQueTolera().shouldBe(14)
            }
        }
        describe("La planta es fuerte"){
            it("La sojaTrangenica1 es fuerte porque siempre la cantidad de horas de sol que tolera superan a 10"){
                sojaTransgenica1.esFuerte().shouldBeTrue()
            }
        }
        describe("La planta da semillas"){
            it("La sojaTransgenica no da semillas"){
                sojaTransgenica1.daSemillas().shouldBeFalse()
            }
        }
    }
})