package com.example.pmt4ejercicios

fun main(){
    var ejercicio=-1
    var planetas= mutableListOf<Planeta>()//se comparte en los ejercicios 1 y 6
    var equipos= mutableListOf<Equipo>()//ejercicios 11 y 12
    while(true){
        println("Elige un ejercicio a ejecutar: (cero, rompe)")
        ejercicio=readln().toInt()
        when(ejercicio){
            0->{
                break
            }
            1->{
                /*Ejercicio 1. Crea la clase de datos Planeta.
                Cada planeta tendrá un nombre, tipo –Rocoso o gaseoso- y una masa. Crea la clase
                sistema solar la cual tendrá una lista de planetas y los métodos .planetaMayor() que
                devuelve el planeta de mayor masa, .planetaMenor() que devuelve el planeta de menor
                masa y .masaMedia() que devuelve la masa media de los planetas del sistema solar.*/
                var planetas= mutableListOf<Planeta>()
                planetas+=Planeta("Mercurio","Rocoso",0.33f)
                planetas+=Planeta("Venus","Rocoso",4.87f)
                planetas+=Planeta("Tierra","Rocoso",5.97f)
                planetas+=Planeta("Marte","Rocoso",0.642f)
                planetas+=Planeta("Jupiter","Gaseoso",1898f)
                planetas+=Planeta("Saturno","Gaseoso",568f)
                planetas+=Planeta("Urano","Gaseoso",86.8f)
                planetas+=Planeta("Neptuno","Gaseoso",102f)
                var SistemaSolar=SistemaSolar(planetas)
                println("Los planetas del Sistema Solar son:")
                println(SistemaSolar.toString())
                println("\nEl planeta mas grande es:")
                println(SistemaSolar.planetaMayor().toString())
                println("\nEl planeta mas pequeño es:")
                println(SistemaSolar.planetaMenor().toString())
                println("\nLa masa media de los planetas es:")
                println(SistemaSolar.masaMedia())
            }
            2->{
                /*Ejercicio 2. Crear la clase triangulo. Propiedades: longitud de los tres lados, perímetro,
                tipo de triángulo (isósceles, escaleno o equilátero). Implementar el metodo rectangulo():Boolean
                que calcula si el triángulo es rectángulo. Nota (se parte de la
                hipótesis de que la longitud de los lados dados crean un triángulo)*/
                println(triangulo(3,4,5).toString())//Escaleno y rectangulo
                println(triangulo(3,3,6).toString())//Isosceles
                println(triangulo(3,3,3).toString())//Equilatero

            }
            3->{
                var contactos= mutableListOf<Contacto>()
                var nombre="";
                var telefono=0
                var email=""
                var new_contacto:Contacto
                var parar=false
                while(!parar){
                    println("1.Nuevo CONTACTO  -  2.Buscar CONTACTO  - 3.Lista de contactos  -   4.Eliminar contacto")
                    when(readln()!!.toInt()){
                        1->{
                            println("Nuevo CONTACTO:")
                            println("Nombre: ")
                            nombre= readln()!!
                            println("Telefono: ")
                            telefono= readln()!!.toInt()
                            println("Email: ")
                            email= readln()!!
                            new_contacto=Contacto(nombre,telefono,email)
                            contactos+=new_contacto
                        }
                        2->{
                            println("Buscar CONTACTO:")
                            println("Nombre: ")
                            nombre= readln()!!
                            for(i in contactos){
                                if(i.nom.equals(nombre)){
                                    println(i.toString())
                                    break
                                }
                                else println("No encontrado")
                                break
                            }
                        }
                        3->{
                            println("Lista de contactos:")
                            for(i in contactos){
                                println(i.toString())
                            }
                        }
                        4->{
                            println("Eliminar contacto:")
                            println("Nombre: ")
                            nombre= readln()
                            var pos=-1
                            for(i in contactos){
                                if(i.nom.equals(nombre)){
                                    pos=contactos.indexOf(i)
                                }
                            }
                            if(pos!=-1){
                                contactos.removeAt(pos)
                                println("Contacto $nombre eliminado")
                            }
                            else println("No encontrado")
                        }
                        else -> println("Opcion no valida")


                    }

                }

            }
            4->{
                var estudiantes= mutableListOf<Estudiante>()
                var nombre="";
                var edad=0
                var n_notas=0
                var calificaciones= mutableListOf<Float>()
                var new_estudiante:Estudiante
                var parar=false
                var parar_calif=false
                while(!parar){
                    println("\n1.Nuevo ESTUDIANTE  -  2.Buscar ESTUDIANTE  - 3.Lista de ESTUDIANTE  -   4.Eliminar ESTUDIANTE     -   5.MEDIA de Calificaciones")
                    when(readln().toInt()){
                        1->{
                            println("Nuevo ESTUDIANTE:")
                            println("Nombre: ")
                            nombre= readln()
                            println("Edad: ")
                            edad= readln().toInt()
                            n_notas=0

                            while(!parar_calif || n_notas<1) {
                                println("Calificaciones")
                                println("¿Nueva?(s/n)")
                                if (readln().lowercase() == "s") {
                                    println("Nota: ")
                                    calificaciones += readln().toFloat()
                                    n_notas++
                                    parar_calif = false
                                } else parar_calif = true
                            }


                            new_estudiante=Estudiante(nombre,edad,calificaciones)
                            estudiantes+=new_estudiante
                        }
                        2->{
                            println("Buscar ESTUDIANTE:")
                            println("Nombre: ")
                            nombre= readln()
                            for(i in estudiantes){
                                if(i.nom.equals(nombre)){
                                    println(i.toString())
                                    break
                                }
                                else println("No encontrado")
                                break
                            }
                        }
                        3->{
                            println("Lista de ESTUDIANTES:")
                            for(i in estudiantes){
                                println(i.toString())
                            }
                        }
                        4->{
                            println("Eliminar ESTUDIANTE:")
                            println("Nombre: ")
                            nombre= readln()
                            var pos=-1
                            for(i in estudiantes){
                                if(i.nom.equals(nombre)){
                                    pos=estudiantes.indexOf(i)
                                }
                            }
                            if(pos!=-1){
                                estudiantes.removeAt(pos)
                                println("Estudiante $nombre eliminado")
                            }
                            else println("No encontrado")
                        }
                        5->{
                            var suma=0.0f
                            var num_notas=0
                            for(i in estudiantes){
                                for(j in i.calif.indices){
                                    suma+=i.calif[j]
                                    num_notas++
                                }
                            }
                            suma/=num_notas
                            println("Media de calificaciones: $suma")
                        }
                        6->{
                            println("¿Terminar(s/n)?")
                            if(readln().lowercase()=="s") parar=true
                        }
                        else -> println("Opcion no valida")
                    }
                }

            }
            5->{
                var nombre=""
                var precio=0.0f
                var stock=0
                var producto_seleccionado=-1
                var productos= mutableListOf<Producto>()
                var new_producto:Producto
                var parar=false
                while(!parar) {
                    println("1.Nuevo PRODUCTO  -  2.Actualizar Strock PRODUCTO  - 3.INVENTARIO")
                    when (readln().toInt()) {
                        1 -> {
                            println("Nuevo PRODUCTO")
                            println("Nombre: ")
                            nombre = readln()
                            println("Precio: ")
                            precio = readln().toFloat()
                            println("Stock: ")
                            stock = readln().toInt()
                            new_producto = Producto(nombre, precio, stock)
                            productos += new_producto
                        }
                        2 -> {
                            println("Actualizar Strock PRODUCTO")
                            println("Nombre: ")
                            nombre = readln()

                            for(i in productos){
                                if(i.nom.equals(nombre)){
                                    println(i.toString())
                                    producto_seleccionado=productos.indexOf(i)
                                    break
                                }
                                else println("No encontrado")
                                break
                            }
                            if(producto_seleccionado!=-1){
                                println("Nuevo stock: ")
                                stock = readln().toInt()
                                productos[producto_seleccionado].stock=stock
                                println("Stock actualizado")
                                println(productos[producto_seleccionado])
                                producto_seleccionado=-1
                            }
                        }
                        3->{
                            println("INVENTARIO")
                            for(i in productos){
                                println(i.toString())
                            }
                        }

                    }
                }
            }
            6->{
                /*Ejercicio 6. Crea una lista con los nueve planeta del Sistema Solar.
                Usa la clase planeta creada en el ejercicio 1*/
                planetas+=Planeta("Mercurio","Rocoso",0.33f)
                planetas+=Planeta("Venus","Rocoso",4.87f)
                planetas+=Planeta("Tierra","Rocoso",5.97f)
                planetas+=Planeta("Marte","Rocoso",0.642f)
                planetas+=Planeta("Jupiter","Gaseoso",1898f)
                planetas+=Planeta("Saturno","Gaseoso",568f)
                planetas+=Planeta("Urano","Gaseoso",86.8f)
                planetas+=Planeta("Neptuno","Gaseoso",102f)

            }
            7->{
                /*Ejercicio 7. Muestra por pantalla toda la información de todos los planetas*/
                for(i in planetas){
                    println("${i}")
                }
            }
            8->{
                /*Ejercicio 8. Muestra por pantalla todos los planetas que empiecen por la letra ‘M’*/
                var filtroPlanetas= planetas.filter{it.nombre.startsWith("M")}
                for(i in filtroPlanetas){
                    println("${i}")
                }
            }
            9->{
                /*Ejercicio 9. Muestra por pantalla todos los planetas gaseosos cuya masa sea superior a 20
                veces la de la tierra*/
                var tierra=planetas.filter{it.nombre=="Tierra"}
                var filtroPlanetas= planetas.filter{it.tipo=="Gaseoso" && it.masa>tierra[0].masa*20}
                for(i in filtroPlanetas){
                    println("${i}")
                }

            }
            10->{
                /*Ejercicio 10. Muestra por pantalla la masa media de los planetas del sistema solar*/
                var suma=0.0f
                for(i in planetas){
                    suma+=i.masa
                }
                println("Masa media: ${suma/planetas.size}")
            }
            12->{
                /*Ejercicio 12. Crea una lista con 16 equipos de fútbol de países distintos (no puede
                haber más de cuatro equipos por país)*/
                equipos+=Equipo("Real Madrid","España")
                equipos+=Equipo("Barcelona","España")
                equipos+=Equipo("Atlético Madrid","España")
                equipos+=Equipo("Sevilla","España")
                equipos+=Equipo("Manchester United","Inglaterra")
                equipos+=Equipo("Manchester City","Inglaterra")
                equipos+=Equipo("Liverpool","Inglaterra")
                equipos+=Equipo("PSG","Francia")
                equipos+=Equipo("Marseille","Francia")
                equipos+=Equipo("Lyon","Francia")
                equipos+=Equipo("Juventus","Italia")
                equipos+=Equipo("Milan","Italia")
                equipos+=Equipo("Inter","Italia")
                equipos+=Equipo("Bayern","Alemania")
                equipos+=Equipo("Dortmund","Alemania")
                equipos+=Equipo("Borussia Dortmund","Alemania")
                println("Lista de equipos:")
                println("${equipos}")
            }
            13->{
                /*Ejercicio 13. Crea la función championsLeague() que recibe como entrada la lista con
                los 16 equipos y muestra por pantalla un sorteo de octavos* de final de la Champions.
                *(no tengas en cuenta que equipos de un mismo país no pueden enfrentarse) */
                println("Sorteo de octavos de final de la Champions:")
                championsLeague(equipos)

            }

        }
    }

}
//Ej01 - Clase Planeta y Sistema Solar
class Planeta(var nombre: String ="", var tipo:String, var masa:Float=0.0f){

    override fun toString(): String {
        return "Nombre: $nombre, Tipo: $tipo, Masa: $masa"
    }
}

class SistemaSolar(val planetas:List<Planeta>){
    fun planetaMayor():Planeta{
        var masa_mayor=planetas[0]
        for(i in planetas){
            if(i.masa>masa_mayor.masa) masa_mayor=i
        };return masa_mayor
    }
    fun planetaMenor():Planeta{
        var masa_menor=planetas[0]
        for(i in planetas){
            if(i.masa<masa_menor.masa) masa_menor=i
        };return masa_menor
    }
    fun masaMedia():Float{
        var suma=0.0f
        for(i in planetas){
            suma+=i.masa
        }
        return suma/planetas.size
    }
    override fun toString(): String {
        return "Planetas: ${planetas.joinToString("\n")}"
    }
}

//Ej02 - Clase Triangulo
class triangulo(var a:Int=1, var b:Int=1, var c:Int=1, var perim:Float=0.0f, var tipo:String=""){

    init{
        if(a==b && b==c) tipo="Equilatero"
        else if(a==b || b==c || a==c) tipo="Isosceles"
        else tipo="Escaleno"

        perim=(a+b+c).toFloat()
    }

    fun rectangulo(a:Int,b:Int,c:Int):Boolean{
        var lados=mutableListOf<Int>(a,b,c)
        lados=lados.sortedDescending().toMutableList()
        return (lados[0] * lados[0] == lados[1] * lados[1] + lados[2] * lados[2])
    }

    override fun toString(): String {
        return "Lados: $a, $b, $c, Perimetro: $perim, Tipo: $tipo, Rectangulo: ${rectangulo(a,b,c)}"
    }
}

//Ej03 - Clase Contacto
class Contacto(var nom:String, var tlf:Int, var mail:String){

    override fun toString(): String {
        return "Nombre: $nom, Telefono: $tlf, Email: $mail"
    }
}

//Ej04 - Clase Estudiante
class Estudiante(var nom:String, var edad:Int, var calif:MutableList<Float>){

    override fun toString(): String {
        return "Nombre: $nom, Edad: $edad, Calificaciones: ${calif.joinToString(", ")}"
    }
}

//Ej05 - Clase Producto
class Producto(var nom:String, var precio:Float, var stock:Int){

    override fun toString(): String {
        return "Nombre: $nom, Precio: $precio, Stock: $stock"
    }
}

//Ej11
class Equipo(var nom:String, var pais:String){
    override fun toString(): String {
        return "Nombre: $nom, Pais: $pais\n"
    }
}

//Ej13
fun championsLeague(equipos:List<Equipo>){
    var encuentros=equipos.shuffled().toMutableList()//crea una copia aleatoria de la lista
    var por_parejas=0//controla si ya se han realizado todas las parejas
    var i=0//controla el indice de la lista de encuentros
    if(equipos.isEmpty()){
        println("No hay equipos. Ejecuta primero el ejercicio 12.\n")
        return
    }
    else{
        while(por_parejas<4){
            while(i in 0..encuentros.size-1){//imprime los equipos en parejas. Básicamente crea parejas de 2 en 2 con la lista de encuentros
                println("${encuentros[i].nom} vs ${encuentros[i+1].nom}")//imprime los nombres de los equipos
                i+=2
            }
            por_parejas+=2
        }
    }
}




