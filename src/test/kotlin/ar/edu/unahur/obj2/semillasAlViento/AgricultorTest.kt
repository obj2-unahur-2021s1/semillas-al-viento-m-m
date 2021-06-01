package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldNotContain
import io.kotest.matchers.shouldBe

class AgricultorTest: DescribeSpec( {

    val miParcela = Parcela(25, 50, 9)
    val miParcela2 = Parcela(25, 50, 9)

    val menta = Menta(2020, 0.7)
    val sojaGrande = Soja(2019, 1.70)
    val sojaChica = Soja(2020, 0.6)
    val sojaTransgenica = SojaTransgenica(2020, 0.6)

    miParcela.plantar(menta)
    miParcela.plantar(sojaGrande)

    miParcela2.plantar(menta)
    miParcela2.plantar(sojaChica)
    miParcela2.plantar(sojaTransgenica)

    val listaParcela = mutableListOf<Parcela>()
    listaParcela.add(miParcela)
    listaParcela.add(miParcela2)

    val agricultora = Agricultora(listaParcela)

    describe("parcelas semilleras"){
        it("la parcela 1 es la unica semillera de la agricultura es la miParcela"){
            menta.daSemillas().shouldBeTrue()
            sojaGrande.daSemillas().shouldBeTrue()
            agricultora.parcelasSemilleras().size.shouldBe(1)
            agricultora.parcelasSemilleras().shouldContain(miParcela)

        }
        it("la parcela 2 no es semillera"){
            agricultora.parcelasSemilleras().shouldNotContain(miParcela2)
        }
    }
    describe("plantar estrategicamente"){
        val soja = Soja(2021, 1.70)
        it("se planta en la parcela 1"){
            soja.daSemillas().shouldBeTrue()

            agricultora.plantarEstrategicamente(soja)
            //la parcela 1 es la primera que se agrego, por ende esta en la posicion 0
            agricultora.parcelas[0].plantas.shouldContain(soja)
        }
    }
})


