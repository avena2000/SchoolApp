package com.sistemexico.schoolmanager.fragment.loggedActivityFragments.chatActivityFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sistemexico.schoolmanager.adapter.WallPostAdapter
import com.sistemexico.schoolmanager.databinding.FragmentLiveChatsBinding


class LiveChatsFragment : Fragment() {

    private lateinit var wallPostRecyclerView: RecyclerView
    private var _binding: FragmentLiveChatsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLiveChatsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
        setupCarouselRecyclerView()
    }


    private fun setupCarouselRecyclerView() {

        /*carouselRecyclerView = binding.wall.carouselRecyclerView
        carouselRecyclerView.adapter = CarouselAdapter(images = getImages(), this)
        val carouselLayoutManager = CarouselLayoutManager()
        carouselLayoutManager.carouselAlignment = CarouselLayoutManager.ALIGNMENT_CENTER
        carouselRecyclerView.layoutManager = carouselLayoutManager
        val snapHelper = CarouselSnapHelper()
        snapHelper.attachToRecyclerView(carouselRecyclerView)*/

        wallPostRecyclerView = binding.wallPost
        wallPostRecyclerView.layoutManager = LinearLayoutManager(binding.root.context)

        val dataList = listOf(
            WallPostAdapter.Data(
                "https://img.freepik.com/foto-gratis/retrato-cintura-joven-mestiza-vestida-casualmente-cabello-rizado-sonriendo-alegremente-audicion-papel-serie-television-sintiendose-emocionada-muy-nerviosa-tratando-impresionar-al-director_273609-1249.jpg?size=626&ext=jpg&ga=GA1.1.1395880969.1711843200&semt=ais",
                "Angélica",
                "11:00 AM",
                "Bienvenidos a la materia de hoy.",
                listOf("https://images.pexels.com/photos/3560168/pexels-photo-3560168.jpeg")
            ),
            WallPostAdapter.Data(
                "https://img.freepik.com/foto-gratis/retrato-cintura-joven-mestiza-vestida-casualmente-cabello-rizado-sonriendo-alegremente-audicion-papel-serie-television-sintiendose-emocionada-muy-nerviosa-tratando-impresionar-al-director_273609-1249.jpg?size=626&ext=jpg&ga=GA1.1.1395880969.1711843200&semt=ais",
                "Angélica",
                "11:00 AM",
                "Bienvenidos a la materia de hoy.",
                listOf(
                    "https://images.pexels.com/photos/3560168/pexels-photo-3560168.jpeg",
                    "https://images.pexels.com/photos/1072179/pexels-photo-1072179.jpeg"
                )
            ),
            WallPostAdapter.Data(
                "https://img.freepik.com/foto-gratis/retrato-cintura-joven-mestiza-vestida-casualmente-cabello-rizado-sonriendo-alegremente-audicion-papel-serie-television-sintiendose-emocionada-muy-nerviosa-tratando-impresionar-al-director_273609-1249.jpg?size=626&ext=jpg&ga=GA1.1.1395880969.1711843200&semt=ais",
                "Angélica",
                "11:00 AM",
                "Bienvenidos a la materia de hoy.",
                listOf(
                    "https://images.pexels.com/photos/3560168/pexels-photo-3560168.jpeg",
                    "https://images.pexels.com/photos/1072179/pexels-photo-1072179.jpeg",
                    "https://upload.wikimedia.org/wikipedia/commons/0/0f/Eiffel_Tower_Vertical.JPG",
                    "https://img.freepik.com/foto-gratis/retrato-cintura-joven-mestiza-vestida-casualmente-cabello-rizado-sonriendo-alegremente-audicion-papel-serie-television-sintiendose-emocionada-muy-nerviosa-tratando-impresionar-al-director_273609-1249.jpg?size=626&ext=jpg&ga=GA1.1.1395880969.1711843200&semt=ais"
                )
            ),
            WallPostAdapter.Data(
                "https://img.freepik.com/foto-gratis/retrato-cintura-joven-mestiza-vestida-casualmente-cabello-rizado-sonriendo-alegremente-audicion-papel-serie-television-sintiendose-emocionada-muy-nerviosa-tratando-impresionar-al-director_273609-1249.jpg?size=626&ext=jpg&ga=GA1.1.1395880969.1711843200&semt=ais",
                "Adrian",
                "11:00 AM",
                "Bienvenidos a la materia de hoy.",
                listOf(
                    "https://images.pexels.com/photos/3560168/pexels-photo-3560168.jpeg",
                    "https://images.pexels.com/photos/1072179/pexels-photo-1072179.jpeg",
                    "https://upload.wikimedia.org/wikipedia/commons/0/0f/Eiffel_Tower_Vertical.JPG"
                )
            ),
            WallPostAdapter.Data(
                "https://img.freepik.com/foto-gratis/retrato-cintura-joven-mestiza-vestida-casualmente-cabello-rizado-sonriendo-alegremente-audicion-papel-serie-television-sintiendose-emocionada-muy-nerviosa-tratando-impresionar-al-director_273609-1249.jpg?size=626&ext=jpg&ga=GA1.1.1395880969.1711843200&semt=ais",
                "Alberto",
                "11:00 AM",
                "Bienvenidos a la materia de hoy.",
                listOf(
                    "https://images.pexels.com/photos/3560168/pexels-photo-3560168.jpeg",
                    "https://images.pexels.com/photos/1072179/pexels-photo-1072179.jpeg",
                    "https://upload.wikimedia.org/wikipedia/commons/0/0f/Eiffel_Tower_Vertical.JPG"
                )
            ),
            WallPostAdapter.Data(
                "https://img.freepik.com/foto-gratis/retrato-cintura-joven-mestiza-vestida-casualmente-cabello-rizado-sonriendo-alegremente-audicion-papel-serie-television-sintiendose-emocionada-muy-nerviosa-tratando-impresionar-al-director_273609-1249.jpg?size=626&ext=jpg&ga=GA1.1.1395880969.1711843200&semt=ais",
                "Angélica",
                "11:00 AM",
                "Bienvenidos a la materia de hoy.",
                listOf(
                    "https://images.pexels.com/photos/3560168/pexels-photo-3560168.jpeg",
                    "https://images.pexels.com/photos/1072179/pexels-photo-1072179.jpeg",
                    "https://upload.wikimedia.org/wikipedia/commons/0/0f/Eiffel_Tower_Vertical.JPG"
                )
            ),
            WallPostAdapter.Data(
                "https://img.freepik.com/foto-gratis/retrato-cintura-joven-mestiza-vestida-casualmente-cabello-rizado-sonriendo-alegremente-audicion-papel-serie-television-sintiendose-emocionada-muy-nerviosa-tratando-impresionar-al-director_273609-1249.jpg?size=626&ext=jpg&ga=GA1.1.1395880969.1711843200&semt=ais",
                "Angélica",
                "11:00 AM",
                "Bienvenidos a la materia de hoy.",
                listOf(
                    "https://images.pexels.com/photos/3560168/pexels-photo-3560168.jpeg",
                    "https://images.pexels.com/photos/1072179/pexels-photo-1072179.jpeg",
                    "https://upload.wikimedia.org/wikipedia/commons/0/0f/Eiffel_Tower_Vertical.JPG"
                )
            ),
            WallPostAdapter.Data(
                "https://img.freepik.com/foto-gratis/retrato-cintura-joven-mestiza-vestida-casualmente-cabello-rizado-sonriendo-alegremente-audicion-papel-serie-television-sintiendose-emocionada-muy-nerviosa-tratando-impresionar-al-director_273609-1249.jpg?size=626&ext=jpg&ga=GA1.1.1395880969.1711843200&semt=ais",
                "Angélica",
                "11:00 AM",
                "Bienvenidos a la materia de hoy.",
                listOf(
                    "https://images.pexels.com/photos/3560168/pexels-photo-3560168.jpeg",
                    "https://images.pexels.com/photos/1072179/pexels-photo-1072179.jpeg",
                    "https://upload.wikimedia.org/wikipedia/commons/0/0f/Eiffel_Tower_Vertical.JPG"
                )
            ),
            WallPostAdapter.Data(
                "https://img.freepik.com/foto-gratis/retrato-cintura-joven-mestiza-vestida-casualmente-cabello-rizado-sonriendo-alegremente-audicion-papel-serie-television-sintiendose-emocionada-muy-nerviosa-tratando-impresionar-al-director_273609-1249.jpg?size=626&ext=jpg&ga=GA1.1.1395880969.1711843200&semt=ais",
                "Adrian",
                "11:00 AM",
                "Bienvenidos a la materia de hoy.",
                listOf(
                    "https://images.pexels.com/photos/3560168/pexels-photo-3560168.jpeg",
                    "https://images.pexels.com/photos/1072179/pexels-photo-1072179.jpeg",
                    "https://upload.wikimedia.org/wikipedia/commons/0/0f/Eiffel_Tower_Vertical.JPG"
                )
            ),
            WallPostAdapter.Data(
                "https://img.freepik.com/foto-gratis/retrato-cintura-joven-mestiza-vestida-casualmente-cabello-rizado-sonriendo-alegremente-audicion-papel-serie-television-sintiendose-emocionada-muy-nerviosa-tratando-impresionar-al-director_273609-1249.jpg?size=626&ext=jpg&ga=GA1.1.1395880969.1711843200&semt=ais",
                "Alberto",
                "11:00 AM",
                "Bienvenidos a la materia de hoy.",
                listOf(
                    "https://images.pexels.com/photos/3560168/pexels-photo-3560168.jpeg",
                    "https://images.pexels.com/photos/1072179/pexels-photo-1072179.jpeg",
                    "https://upload.wikimedia.org/wikipedia/commons/0/0f/Eiffel_Tower_Vertical.JPG"
                )
            ),
            WallPostAdapter.Data(
                "https://img.freepik.com/foto-gratis/retrato-cintura-joven-mestiza-vestida-casualmente-cabello-rizado-sonriendo-alegremente-audicion-papel-serie-television-sintiendose-emocionada-muy-nerviosa-tratando-impresionar-al-director_273609-1249.jpg?size=626&ext=jpg&ga=GA1.1.1395880969.1711843200&semt=ais",
                "Angélica",
                "11:00 AM",
                "Bienvenidos a la materia de hoy.",
                listOf(
                    "https://images.pexels.com/photos/3560168/pexels-photo-3560168.jpeg",
                    "https://images.pexels.com/photos/1072179/pexels-photo-1072179.jpeg",
                    "https://upload.wikimedia.org/wikipedia/commons/0/0f/Eiffel_Tower_Vertical.JPG"
                )
            ),
            WallPostAdapter.Data(
                "https://img.freepik.com/foto-gratis/retrato-cintura-joven-mestiza-vestida-casualmente-cabello-rizado-sonriendo-alegremente-audicion-papel-serie-television-sintiendose-emocionada-muy-nerviosa-tratando-impresionar-al-director_273609-1249.jpg?size=626&ext=jpg&ga=GA1.1.1395880969.1711843200&semt=ais",
                "Angélica",
                "11:00 AM",
                "Bienvenidos a la materia de hoy.",
                listOf(
                    "https://images.pexels.com/photos/3560168/pexels-photo-3560168.jpeg",
                    "https://images.pexels.com/photos/1072179/pexels-photo-1072179.jpeg",
                    "https://upload.wikimedia.org/wikipedia/commons/0/0f/Eiffel_Tower_Vertical.JPG"
                )
            ),
            WallPostAdapter.Data(
                "https://img.freepik.com/foto-gratis/retrato-cintura-joven-mestiza-vestida-casualmente-cabello-rizado-sonriendo-alegremente-audicion-papel-serie-television-sintiendose-emocionada-muy-nerviosa-tratando-impresionar-al-director_273609-1249.jpg?size=626&ext=jpg&ga=GA1.1.1395880969.1711843200&semt=ais",
                "Pepe",
                "11:00 AM",
                "Bienvenidos a la materia de hoy.",
                listOf(
                    "https://images.pexels.com/photos/3560168/pexels-photo-3560168.jpeg",
                    "https://images.pexels.com/photos/1072179/pexels-photo-1072179.jpeg",
                    "https://upload.wikimedia.org/wikipedia/commons/0/0f/Eiffel_Tower_Vertical.JPG"
                )
            ),
            WallPostAdapter.Data(
                "https://img.freepik.com/foto-gratis/retrato-cintura-joven-mestiza-vestida-casualmente-cabello-rizado-sonriendo-alegremente-audicion-papel-serie-television-sintiendose-emocionada-muy-nerviosa-tratando-impresionar-al-director_273609-1249.jpg?size=626&ext=jpg&ga=GA1.1.1395880969.1711843200&semt=ais",
                "Adrian",
                "11:00 AM",
                "Bienvenidos a la materia de hoy.",
                listOf(
                    "https://images.pexels.com/photos/3560168/pexels-photo-3560168.jpeg",
                    "https://images.pexels.com/photos/1072179/pexels-photo-1072179.jpeg",
                    "https://upload.wikimedia.org/wikipedia/commons/0/0f/Eiffel_Tower_Vertical.JPG"
                )
            ),
            WallPostAdapter.Data(
                "https://img.freepik.com/foto-gratis/retrato-cintura-joven-mestiza-vestida-casualmente-cabello-rizado-sonriendo-alegremente-audicion-papel-serie-television-sintiendose-emocionada-muy-nerviosa-tratando-impresionar-al-director_273609-1249.jpg?size=626&ext=jpg&ga=GA1.1.1395880969.1711843200&semt=ais",
                "Alberto",
                "11:00 AM",
                "Bienvenidos a la materia de hoy.",
                listOf(
                    "https://images.pexels.com/photos/3560168/pexels-photo-3560168.jpeg",
                    "https://images.pexels.com/photos/1072179/pexels-photo-1072179.jpeg",
                    "https://upload.wikimedia.org/wikipedia/commons/0/0f/Eiffel_Tower_Vertical.JPG"
                )
            ),
        )
        val adapter = WallPostAdapter(dataList)
        wallPostRecyclerView.adapter = adapter

    }

    /*private fun getImages(): List<String> {
        return listOf(
            "https://upload.wikimedia.org/wikipedia/commons/0/0f/Eiffel_Tower_Vertical.JPG",
            "https://images.pexels.com/photos/1408221/pexels-photo-1408221.jpeg",
        )
    }

   override fun onItemClick(position: Int) {
       val imageUrl = getImages()[position]
       openFullscreenImage(imageUrl)
       carouselRecyclerView.smoothScrollToPosition(position)
   }
   private fun openFullscreenImage(imageUrl: String) {
       val intent = Intent(activity, FullscreenImageActivity::class.java).apply {
           putExtra("image_url", imageUrl)
       }
       startActivity(intent)
   }*/
}