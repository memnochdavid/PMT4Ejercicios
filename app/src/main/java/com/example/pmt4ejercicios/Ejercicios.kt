package com.example.pmt4ejercicios

fun main(){
    var ejercicio=-1
    var planetas= mutableListOf<Planeta>()//se comparte en los ejercicios 1 y 6
    var equipos= mutableListOf<Equipo>()//ejercicios 11 y 12
    var videojuegos= mutableListOf<Videojuego>()//Ejercicios 20 y 21
    var años= mutableListOf<Int>()//Ejercicio 21
    var plataformas= mutableListOf<String>()//Ejercicio 21

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
            11->{
                /*Ejercicio 11. Crea la clase equipo de fútbol que contenga el nombre y país del equipo*/
                println("Este ejercicio sólo consistía en crear la clase.")
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
            14->{
                /*Ejercicio 14: Crea la clase circunferencia. El constructor primario recibirá el
                radio de la circunferencia y el secundario recibirá la posición del centro de la
                circunferencia y un punto cualquiera de la misma. Crear el método longitud()
                y sobrecargar el método toString() de forma que muestre toda la info de la
                circunferencia*/
                var circulo=Circunferencia(5.0f)
                println(circulo.toString())
            }
            15->{
                /*Ejercicio 15: Crea la clase Círculo que hereda de circunferencia. Tendrá dos
                constructores, el primero recibirá el radio y el color del círculo y el segundo
                su centro, un punto cualquiera y su color. Crear el método área() y
                sobrecargar el método toString() de forma que muestre toda la info de la
                circunferencia*/

                var circulo=Circulo(5.0f,"rojo")
                println(circulo.toString())
            }
            16->{
                /*Ejercicio 16: Clase de matemáticas. Crea una clase Matemáticas con métodos para realizar
                operaciones matemáticas como sumar, restar, multiplicar y dividir. Luego, utiliza esta clase en tu
                programa principal.
                */
                var a=0
                var b=0
                println("Introduce dos numeros:")
                a=readln().toInt()
                b=readln().toInt()
                var mat=Matematicas(a,b)
                println("Suma: ${mat.sumar(a,b)}")
                println("Resta: ${mat.restar(a,b)}")
                println("Multiplicacion: ${mat.multiplicar(a,b)}")
                if(mat.dividir(a,b)==-1){
                    println("División: No se puede dividir por cero")
                }
                else{
                    println("DivisiOn: ${mat.dividir(a,b)}")
                }
            }
            17->{
                /*Ejercicio 17: Implementa las siguientes clases:
                    clase Nota. Una nota contiene un identificador numérico y una línea de texto. Define
                    constructor, accedentes y toString.
                    clase NotaAlarma. Una nota que además contiene la hora en la que sonará la alarma. Define
                    constructor, accedentes y toString.
                    clase BlocNotas que modela un bloc de notas en el que se pueden introducir notas, listar
                    todas las notas, eliminar una nota mediante su posición en el bloc de notas o saber cuantas
                    notas contiene el bloc de notas. Debes utilizar una colección.
                    clase Prueba que cree un bloc de Notas de ejemplo y pruebe las operaciones que soporta.*/
                var prueba=Prueba()
                prueba.prueba()
            }
            18->{
                /*Define una jerarquía de clases que permita almacenar datos sobre los
                planetas y satélites que forman parte del sistema solar (junto con el sol).
                Algunos atributos que puede ser interesante recoger son: la masa del
                cuerpo, su diámetro medio, el período de rotación sobre el propio eje,
                período de traslación alrededor del cuerpo que orbitan, distancia media a
                ese cuerpo, excentricidad de la órbita, etc.
                Define un método que, dado un objeto del sistema solar (planeta o satélite),
                imprima toda la información de que se dispone sobre el mismo.*/

                var sol= Estrella("Sol",1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,"Amarilla")
                var tierra=Planeta18("Tierra",1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,sol)
                var luna=Satelite("Luna",1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,tierra)
                println(luna.toString())
            }
            19->{
                /*Ejercicio 19
                Crea la clase PNJ que representa un personaje en un juego de rol.
                La clase tendrá los atributos, nombre, PV –Puntos de Vida-, PM
                –Puntos mágicos- y LVL. Crea las clases hijas de PNJ Guerrero y
                Mago. Dichas clases implementarán el método levelUp() que
                incrementa el atributo LVL del personaje y sus atributos PV y MP.
                Los guerreros por cada nuevo nivel tendrán un 8% más de PV y un
                1% más de PM mientras que los magos tendrán un 4% más de PV y
                un 3% más de PM. Crear un guerrero de nivel 1 con 400PV y 50PM y
                un mago de nivel 1 con 1600PV y 150PM. Partiendo del hecho de
                que ambos personajes subirán de nivel siempre a la vez ¿en qué
                nivel el guerrero tendrá más PV que el mago? */

                var guerrero=Guerrero("Guerrero",400,50,1)
                var mago=Mago("Mago",1600,150,1)
                while(guerrero.lvl==mago.lvl){
                    guerrero.LvlUp()
                    mago.LvlUp()
                    if(guerrero.pv>mago.pv){
                        println("El guerrero tiene más PV. Lo ha superado en el Nivel ${guerrero.lvl}")
                        println(guerrero.toString())
                        println(mago.toString())
                        break
                    }
                }
            }
            20->{
                /*Ejercicio 20. Crea la clase de datos Videojuego, que tendrá nombre, año y plataforma del
                juego. Crea una lista con 8 videojuegos de tres plataformas distintas. Crea una función
                que dada una lista de juegos, una año y una plataforma devuelve los juegos de la lista de
                dicho año y plataforma. La función también debe poder usarse especificando solo el año
                o solo la plataforma.*/
                videojuegos+=Videojuego("The Last of Us Part II",2020,"PS4")
                videojuegos+=Videojuego("The Legend of Zelda: Breath of the Wild",2017,"Nintendo Switch")
                videojuegos+=Videojuego("Super Mario Odyssey",2017,"Nintendo Switch")
                videojuegos+=Videojuego("God of War",2018,"PS4")
                videojuegos+=Videojuego("The Witcher 3: Wild Hunt",2015,"PC")
                videojuegos+=Videojuego("The Elder Scrolls V: Skyrim",2011,"PC")
                videojuegos+=Videojuego("Animal Crossing: New Horizons",2020,"Nintendo Switch")
                videojuegos+=Videojuego("Red Dead Redemption 2",2018,"PS4")

                println("Introduce un año:(cero para omitir) ")
                var año=0
                año=readln().toInt()
                println("Introduce una plataforma:(enter para dejar vacío) ")
                var plataforma=readln()
                if(año==0 && plataforma=="\n")
                    println(listaJuegos20(videojuegos))//imprime todo
                else if(año==0)
                    println(listaJuegos20(videojuegos,null,plataforma))//imprime por plataforma
                else if(plataforma=="")
                    println(listaJuegos20(videojuegos,año,null))//imprime por año
            }
            21->{
                /*Ejercicio 21. Crear una función que dada una lista de videojuegos, lista de años y lista de
                plataformas devuelva los juegos de la lista que fueron creados en esos años y para esas
                plataformas. La función debe poder usarse si solo se especifica la lista de años o la lista
                de plataformas. */
                videojuegos+=Videojuego("The Last of Us Part II",2020,"PS4")
                videojuegos+=Videojuego("The Legend of Zelda: Breath of the Wild",2017,"Nintendo Switch")
                videojuegos+=Videojuego("Super Mario Odyssey",2017,"Nintendo Switch")
                videojuegos+=Videojuego("God of War",2018,"PS4")
                videojuegos+=Videojuego("The Witcher 3: Wild Hunt",2015,"PC")
                videojuegos+=Videojuego("The Elder Scrolls V: Skyrim",2011,"PC")
                videojuegos+=Videojuego("Animal Crossing: New Horizons",2020,"Nintendo Switch")
                videojuegos+=Videojuego("Red Dead Redemption 2",2018,"PS4")

                años+=2015
                años+=2017
                años+=2018
                //años+=2020 //se omite uno de los años de la lista para comprobar que funciona - OK!!

                plataformas+= "Nintendo Switch"
                plataformas+= "PC"
                plataformas+= "PS4"

                println(listaJuegos21(videojuegos,años,plataformas))
            }
            22->{
                /*Ejercicio 22. Crea una función que reciba una lista de juegos y devuelva un mapa
                donde las claves sean las plataformas y el valor el número de juegos para dicha
                plataforma.*/

                videojuegos+=Videojuego("The Last of Us Part II",2020,"PS4")
                videojuegos+=Videojuego("The Legend of Zelda: Breath of the Wild",2017,"Nintendo Switch")
                videojuegos+=Videojuego("Super Mario Odyssey",2017,"Nintendo Switch")
                videojuegos+=Videojuego("God of War",2018,"PS4")
                videojuegos+=Videojuego("The Witcher 3: Wild Hunt",2015,"PC")
                videojuegos+=Videojuego("The Elder Scrolls V: Skyrim",2011,"PC")
                videojuegos+=Videojuego("Animal Crossing: New Horizons",2020,"Nintendo Switch")
                videojuegos+=Videojuego("Red Dead Redemption 2",2018,"PS4")

                var mapa=listaToMap(videojuegos)
                println(mapaToString(mapa))

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

//Ej14
open class Circunferencia(var radio:Float=0.0f){//open para que la clase Circulo pueda heredar de ella
    constructor(
        x:Float,
        y:Float,
        centro:List<Float>
    ):this()

        fun longitud():Float{
            return (2*Math.PI*radio).toFloat()
        }

        override fun toString(): String {
            return "Radio: $radio, Longitud: ${longitud()}"
        }
}

//Ej15
class Circulo(radio: Float, val color: String) : Circunferencia(radio) {
    constructor(centro: List<Float>, x: Float, y: Float, color: String) : this(
        calculaRadio(centro, x, y),
        color
    )

    companion object {
        fun calculaRadio(centro: List<Float>, x: Float, y: Float): Float {
            val centerX = centro[0]
            val centerY = centro[1]
            return Math.sqrt(Math.pow((x - centerX).toDouble(), 2.0) + Math.pow((y - centerY).toDouble(), 2.0)).toFloat()
        }
    }

    fun area( radio: Float): Float {
        return (Math.PI * Math.pow(radio.toDouble(), 2.0)).toFloat()
    }

    override fun toString(): String {
        return "Radio: $radio, Area: ${area(radio)}, color: $color, Longitud: ${longitud()}"
    }
}

//Ej16
class Matematicas(a:Int, b:Int){
    fun sumar(a:Int,b:Int):Int{
        return a+b
    }
    fun restar(a:Int,b:Int):Int{
        return a-b
    }
    fun multiplicar(a:Int,b:Int):Int{
        return a*b
        }
    fun dividir(a:Int,b:Int):Int{
        if(b==0){
            return -1
        }else return a/b
    }
}

//Ej17
open class Nota(var id:Int, var linea:String){
    override fun toString(): String {
        return "ID: $id, Linea: $linea"
    }
}

class NotaAlarma(id:Int, linea:String, var hora:String):Nota(id,linea){
    override fun toString(): String {
        return "ID: $id, Linea: $linea, Hora: $hora"
    }
}

class BlocNotas(var notas:MutableMap<Int, Nota>){//uso una colección, en este caso un MutableMap
    fun listarNotas(){
        for(i in notas){
            println(i.toString())
        }
    }
    fun eliminarNota(key:Int){
        notas.remove(key)
    }
    fun numNotas():Int {
        return notas.size
    }
}
class Prueba{
    var bloc=BlocNotas(mutableMapOf())
    fun prueba() {
        var stop=false
        while(!stop){
            println("¿Desea agregar notas? (s/n)")
            if(readln()=="s"){
                println("¿Nota o alarma? (n/a)")
                when(readln()){
                    "n"->{
                        println("ID: ")
                        var id=readln().toInt()
                        println("Linea: ")
                        var linea=readln()
                        bloc.notas[id]=Nota(id,linea)
                    }
                    "a"->{
                        println("ID: ")
                        var id=readln().toInt()
                        println("Linea: ")
                        var linea=readln()
                        println("Hora: ")
                        var hora=readln()
                        bloc.notas[id]=NotaAlarma(id,linea,hora)
                    }
                    else -> println("Opcion no valida")
                }
            }
            println("¿Desea eliminar alguna nota? (s/n)")
            if(readln()=="s"){
                println("ID: ")
                var id=readln().toInt()
                bloc.eliminarNota(id)
            }
            println("¿Desea listar las notas? (s/n)")
            if(readln()=="s") bloc.listarNotas()
                println("Numero de notas: ${bloc.numNotas()}")

            println("¿Desea salir? (s/n)")
            if(readln()=="s") stop=true
            else stop=false
        }
    }

}

//Ej18
open class Astro(var nombre:String, var masa:Float, var diametro:Float, var periodo_rotacion:Float, var periodo_traslacion:Float, var dist_media:Float, var excentricidad:Float){
    override fun toString(): String {
        return "Nombre: $nombre, Masa: $masa, Diametro: $diametro, Periodo de rotacion: $periodo_rotacion, Periodo de traslacion: $periodo_traslacion, Distancia media: $dist_media, Excentricidad: $excentricidad"
    }
}
open class Estrella(nombre:String, masa:Float, diametro:Float, periodo_rotacion:Float, periodo_traslacion:Float, dist_media:Float, excentricidad:Float, var tipo:String?):Astro(nombre, masa, diametro, periodo_rotacion, periodo_traslacion, dist_media, excentricidad){
    override fun toString(): String {
        return "Nombre: $nombre, Masa: $masa, Diametro: $diametro, Periodo de rotacion: $periodo_rotacion, Periodo de traslacion: $periodo_traslacion, Distancia media: $dist_media, Excentricidad: $excentricidad, Tipo: $tipo"
    }
}
open class Planeta18(nombre:String, masa:Float, diametro:Float, periodo_rotacion:Float, periodo_traslacion:Float, dist_media:Float, excentricidad:Float, var orbitaEstrella:Estrella?):Estrella(nombre, masa, diametro, periodo_rotacion, periodo_traslacion, dist_media, excentricidad, null){
    override fun toString(): String {
        return "Nombre: $nombre, Masa: $masa, Diametro: $diametro, Periodo de rotacion: $periodo_rotacion, Periodo de traslacion: $periodo_traslacion, Distancia media: $dist_media, Excentricidad: $excentricidad, Orbita estrella: $orbitaEstrella"
    }
}
class Satelite(nombre:String, masa:Float, diametro:Float, periodo_rotacion:Float, periodo_traslacion:Float, dist_media:Float, excentricidad:Float, var orbitaPlaneta:Planeta18):Planeta18(nombre, masa, diametro, periodo_rotacion, periodo_traslacion, dist_media, excentricidad, null){
    override fun toString(): String {
        return "Nombre: $nombre, Masa: $masa, Diametro: $diametro, Periodo de rotacion: $periodo_rotacion, Periodo de traslacion: $periodo_traslacion, Distancia media: $dist_media, Excentricidad: $excentricidad, Orbita planeta: $orbitaPlaneta"
    }
}

//Ej19
open class Pnj(var nombre:String, var pv:Int, var pm:Int, var lvl:Int){
    override fun toString(): String {
        return "Nombre: $nombre, PV: $pv, PM: $pm, LVL: $lvl"
    }
}
class Guerrero(nombre:String, pv:Int, pm:Int, lvl:Int):Pnj(nombre, pv, pm, lvl){
    fun LvlUp(){
        lvl++
        pv+=(pv*0.08).toInt()
        pm+=(pm*0.01).toInt()
    }
    override fun toString(): String {
        return "Nombre: $nombre, PV: $pv, PM: $pm, LVL: $lvl"
    }
}
class Mago(nombre:String, pv:Int, pm:Int, lvl:Int):Pnj(nombre, pv, pm, lvl){
    fun LvlUp(){
        lvl++
        pv+=(pv*0.04).toInt()
        pm+=(pm*0.03).toInt()
    }
    override fun toString(): String {
        return "Nombre: $nombre, PV: $pv, PM: $pm, LVL: $lvl"
    }
}

//Ej20
open class Videojuego( var nombre:String, var año:Int, var plataforma:String){
    override fun toString(): String {
        return "Nombre: $nombre, Año: $año, Plataforma: $plataforma\n"
    }
}
fun listaJuegos20(juegos:List<Videojuego>, año:Int?=null, plataforma:String?=null):List<Videojuego>{
    var lista= mutableListOf<Videojuego>()
    for(i in juegos) {
        if (año != null && plataforma != null) {
            if (i.año == año && i.plataforma == plataforma) lista += i
        } else if (año != null) {
            if (i.año == año) lista += i
        } else if (plataforma != null) {
            if (i.plataforma == plataforma) lista += i
        }
    }
    return lista
}

//Ej21
fun listaJuegos21(juegos:List<Videojuego>, años:List<Int>?=null, plataformas:List<String>?=null):List<Videojuego>{
    var lista= mutableListOf<Videojuego>()
    for(i in juegos) {
        if (años != null && plataformas != null) {
            if (años.contains(i.año) && plataformas.contains(i.plataforma)) lista += i
        } else if (años != null) {
            if (años.contains(i.año)) lista += i
        } else if (plataformas != null) {
            if (plataformas.contains(i.plataforma)) lista += i
        }
    }
    return lista
}

//Ej22
fun listaToMap(juegos:List<Videojuego>):Map<String,Int> {
    var mapa = mutableMapOf<String, Int>()
    for (i in juegos) {
        if (mapa.containsKey(i.plataforma)) {
            mapa[i.plataforma] = mapa[i.plataforma]!! + 1
        } else mapa[i.plataforma] = 1
    }
    return mapa
}
fun mapaToString(mapa:Map<String,Int>):String{
    var cadena=""
    for(i in mapa){
        cadena+="Plataforma: ${i.key}, Juegos: ${i.value}\n"
    }
    return cadena
}






























