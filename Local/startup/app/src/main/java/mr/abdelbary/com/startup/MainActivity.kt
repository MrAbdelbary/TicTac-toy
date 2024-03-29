package mr.abdelbary.com.startup

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun buSelect(view: View){
val buChoise=view as Button
        var cellID=0
        when ( buChoise.id){
            R.id.bu1->cellID=1
            R.id.bu2->cellID=2
            R.id.bu3->cellID=3
            R.id.bu4->cellID=4
            R.id.bu5->cellID=5
            R.id.bu6->cellID=6
            R.id.bu7->cellID=7
            R.id.bu8->cellID=8
            R.id.bu9->cellID=9
        }
        Log.d("cellId:",cellID.toString())
        playgame(cellID,buChoise)

    }
    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()
    var activeplayer=1
    fun playgame(cellID:Int,buChoise:Button){
        if (activeplayer==1){
            buChoise.text="Anas"
            buChoise.setBackgroundResource(R.color.blue)
            player1.add(cellID)
            activeplayer=2
            AutoPlay()
        }
        else{
            buChoise.text="Yomna"
            buChoise.setBackgroundResource(R.color.pink)
            player2.add(cellID)
            activeplayer=1

        }
        buChoise.isEnabled = false
        CheckWinner()
    }
   fun CheckWinner(){
       var winner=-1
       if (player1.contains(1)&&player1.contains(2)&&player1.contains(3)){
           winner=1
       }
       if (player2.contains(1)&&player2.contains(2)&&player2.contains(3)){
           winner=2
       }
       if (player1.contains(4)&&player1.contains(5)&&player1.contains(6)){
           winner=1
       }
       if (player2.contains(4)&&player2.contains(5)&&player2.contains(6)){
           winner=2
       }
       if (player1.contains(7)&&player1.contains(7)&&player1.contains(9)){
           winner=1
       }
       if (player2.contains(7)&&player2.contains(8)&&player2.contains(9)){
           winner=2
       }
       if (player1.contains(1)&&player1.contains(4)&&player1.contains(7)){
           winner=1
       }
       if (player2.contains(1)&&player2.contains(4)&&player2.contains(7)){
           winner=2
       }
       if (player1.contains(2)&&player1.contains(5)&&player1.contains(8)){
           winner=1
       }
       if (player2.contains(2)&&player2.contains(5)&&player2.contains(8)){
           winner=2
       }
       if (player1.contains(3)&&player1.contains(6)&&player1.contains(9)){
           winner=1
       }
       if (player2.contains(3)&&player2.contains(6)&&player2.contains(9)){
           winner=2
       }
       if (player1.contains(1)&&player1.contains(5)&&player1.contains(9)){
           winner=1
       }
       if (player2.contains(1)&&player2.contains(5)&&player2.contains(9)){
           winner=2
       }
       if (player1.contains(3)&&player1.contains(5)&&player1.contains(7)){
           winner=1
       }
       if (player2.contains(3)&&player2.contains(5)&&player2.contains(7)){
           winner=2
       }
       if (winner!=-1){
           if (winner==1){
               Toast.makeText(this,"Player 1 won the game",Toast.LENGTH_LONG).show()
           }

           else{

               Toast.makeText(this,"Player 2 won the game",Toast.LENGTH_LONG).show()
           }
       }
   }
    fun AutoPlay(){
        val emptyCells=ArrayList<Int>()
        for (cellID in 1..9){
            if (!(player1.contains(cellID)||player2.contains(cellID))){
                emptyCells.add(cellID)
            }

        }
        val r=Random()
        val randIndex=r.nextInt(emptyCells.size-0)+0
        val cellID=emptyCells[randIndex]
        var buSelect:Button?
        when (cellID){
            1->buSelect=bu1
            2->buSelect=bu2
            3->buSelect=bu3
            4->buSelect=bu4
            5->buSelect=bu5
            6->buSelect=bu6
            7->buSelect=bu7
            8->buSelect=bu8
            9->buSelect=bu9
            else->{
                buSelect=bu1
            }
        }
        playgame(cellID,buSelect)
    }

}
