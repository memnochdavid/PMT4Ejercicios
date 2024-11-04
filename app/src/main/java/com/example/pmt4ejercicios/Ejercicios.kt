package com.example.pmt4ejercicios
import kotlin.math.max

fun main(){
    var ejercicio=-1
    println("Elige un ejercicio a ejecutar:")
    ejercicio=readln().toInt()
    when(ejercicio){
        1->{
            /*Ejercicio 1. Crea la clase de datos Planeta.
            Cada planeta tendrá un nombre, tipo –Rocoso o gaseoso- y una masa. Crea la clase
            sistema solar la cual tendrá una lista de planetas y los métodos .planetaMayor() que
            devuelve el planeta de mayor masa, .planetaMenor() que devuelve el planeta de menor
            masa y .masaMedia() que devuelve la masa media de los planetas del sistema solar.*/

            class Planeta(var nombre: String ="", var tipo:String, var masa:Float=0.0f)

            class SistemaSolar(val planetas:List<Planeta>){
                fun planetaMayor():Planeta{
                    var masa_mayor=planetas[0].masa
                    for(i in planetas){
                        if(i.masa>masa_mayor) return i
                    };throw Exception("fuck")
                }
                fun planetaMenor():Planeta{
                    var masa_menor=planetas[0].masa
                    for(i in planetas){
                        if(i.masa<masa_menor) return i
                    };throw Exception("fuck")
                }
                fun masaMedia():Float{
                    var suma=0.0f
                    for(i in planetas){
                        suma+=i.masa
                    }
                    return suma/planetas.size
                }
            }
        }
        2->{
            /*Ejercicio 2. Crear la clase triangulo. Propiedades: longitud de los tres lados, perímetro,
            tipo de triángulo (isósceles, escaleno o equilátero). Implementar el metodo rectangulo():Boolean
            que calcula si el triángulo es rectángulo. Nota (se parte de la
            hipótesis de que la longitud de los lados dados crean un triángulo)*/
            class triangulo(var a:Int=1, var b:Int=1, var c:Int=1,
                            var perim:Float= (a+b+c).toFloat(),
                            var tipo:String
            )



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
                println("¿Terminar(s/n)?")
                if(readln().lowercase()=="s") parar=true
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