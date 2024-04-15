package com.sistemexico.schoolmanager.fragment.loggedActivityFragments.chatActivityFragments

sealed class WallDataClass(
    val profilePicture: String,
    val profileUsername: String,
    val time: String,
    val text: String,
    val listItems: List<String>
) {
    data object Angelica : WallDataClass(
        "https://img.freepik.com/foto-gratis/retrato-cintura-joven-mestiza-vestida-casualmente-cabello-rizado-sonriendo-alegremente-audicion-papel-serie-television-sintiendose-emocionada-muy-nerviosa-tratando-impresionar-al-director_273609-1249.jpg?size=626&ext=jpg&ga=GA1.1.1395880969.1711843200&semt=ais",
        "Angélica",
        "11:00 AM",
        "Bienvenidos a la materia de hoy.",
        listOf("https://images.pexels.com/photos/3560168/pexels-photo-3560168.jpeg")
    )

    data object Alberto : WallDataClass(
        "https://img.freepik.com/foto-gratis/retrato-cintura-joven-mestiza-vestida-casualmente-cabello-rizado-sonriendo-alegremente-audicion-papel-serie-television-sintiendose-emocionada-muy-nerviosa-tratando-impresionar-al-director_273609-1249.jpg?size=626&ext=jpg&ga=GA1.1.1395880969.1711843200&semt=ais",
        "Angélica",
        "11:00 AM",
        "Bienvenidos a la materia de hoy.",
        listOf("https://images.pexels.com/photos/3560168/pexels-photo-3560168.jpeg")
    )

    data object Pepe : WallDataClass(
        "https://img.freepik.com/foto-gratis/retrato-cintura-joven-mestiza-vestida-casualmente-cabello-rizado-sonriendo-alegremente-audicion-papel-serie-television-sintiendose-emocionada-muy-nerviosa-tratando-impresionar-al-director_273609-1249.jpg?size=626&ext=jpg&ga=GA1.1.1395880969.1711843200&semt=ais",
        "Angélica",
        "11:00 AM",
        "Bienvenidos a la materia de hoy.",
        listOf("https://images.pexels.com/photos/3560168/pexels-photo-3560168.jpeg")
    )

    data object Adrian : WallDataClass(
        "https://img.freepik.com/foto-gratis/retrato-cintura-joven-mestiza-vestida-casualmente-cabello-rizado-sonriendo-alegremente-audicion-papel-serie-television-sintiendose-emocionada-muy-nerviosa-tratando-impresionar-al-director_273609-1249.jpg?size=626&ext=jpg&ga=GA1.1.1395880969.1711843200&semt=ais",
        "Angélica",
        "11:00 AM",
        "Bienvenidos a la materia de hoy.",
        listOf("https://images.pexels.com/photos/3560168/pexels-photo-3560168.jpeg")
    )
}
