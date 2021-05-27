package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.shouldBe

class PlantaTest: DescribeSpec({

    describe("requerimientos Menta"){
        //se cambia el tipo de dato de altura de float a int, ya que salta "The integer literal does not conform to the expected type Float"
        val menta = Menta(2021,6)
        describe("horas de sol de la menta"){
            it("las horas de sol de la menta es de 6 horas"){
                menta.horasDeSolQueTolera().shouldBe(6)
            }
            it("las horas de sol de la menta nunca sera distinto de 6 horas "){
                (menta.horasDeSolQueTolera()==10).shouldBeFalse()
            }
        }
    }

    describe("requerimientos Soja"){}

    describe("requerimientos Soja Transgenica"){}

    describe("requerimientos Parcela"){}

    describe("requerimientos Agricultora"){}
})