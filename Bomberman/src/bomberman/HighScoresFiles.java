package bomberman;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class HighScoresFiles {

    public HighScoresFiles() {
    }
    
    public String getFile(int difficult){
        File file;
        FileReader reader;
        BufferedReader buffer;
        String string1 = "";
        String string2 = "";
        try{
            if(difficult==15)
                file = new File("src/Files/easy.txt");
            else if(difficult==21)
                file = new File("src/Files/medium.txt");
            else
                file = new File("src/Files/hard.txt");
            reader = new FileReader(file);
            buffer = new BufferedReader(reader);
            while(string1!=null){ //read the file and storages the data on string2
                string1 = buffer.readLine();
                if(string1!=null)
                    string2+=string1;
            }
            
        }
        catch(Exception e){
        }
        return string2;
    }
    
    public void setFile(int difficult,String[] array){        
        try{
            FileWriter fw;
            if(difficult==15)
                fw = new FileWriter("src/Files/easy.txt");
            else if (difficult==21)
                fw = new FileWriter("src/Files/medium.txt");
            else
                fw = new FileWriter("src/Files/hard.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(int i = 0;i<array.length;i++){//write in the file with the array data
                bw.write(array[i] + " ");
            }
            bw.close();
            fw.close();        
        }
        catch(Exception e){
        }
    }
    
    public boolean isGreater(int difficult,int score){//if the score can be on the list, return true
        String topScores = getFile(difficult);
        String[] scores = topScores.split(" ");
        Boolean is = false;
        for(int i = 1;i<=scores.length;i+=2){
            if(Integer.parseInt(scores[i]) < score)
                is = true;
        }
        return is;
    }
    
    public void newHighScore(int difficult,int score,String name){//push the new score
        String s = getFile(difficult);
        String[] scores = s.split(" ");
        String[] newScores = new String[5];
        int[] numbers = {0,0,0,0,0};
        int cont = 0;
        while(cont<5){ //while the amount of the array isnt 5,adjust the 5 best scores in order and write it to the file
            String user = "";
            int time = Integer.MAX_VALUE;
            for(int i = 1;i<=scores.length;i+=2){ 
                if((Integer.parseInt(scores[i]) > time)){
                    if((contains(Integer.parseInt(scores[i]),numbers))==false){
                        time = Integer.parseInt(scores[i]);
                        user = scores[i-1];
                    }
                }
            }
            if((score<time) && ((contains(score,numbers))==false) ){
                time = score;
                user = name;
            }
            String top = user+" "+Integer.toString(time);
            newScores[cont] = top; //add the user and score to the new array of scores
            numbers[cont] = time;
            cont++;
        }
        setFile(difficult,newScores);//write the new scores to the file
    }
    
    public boolean contains(int number,int[] array){//if an array constains a number, return true
        boolean result = false;
        for(int i = 0;i<array.length;i++){
            if (array[i]==number)
                result = true;
        }
        return result;
    }
    

    
}
