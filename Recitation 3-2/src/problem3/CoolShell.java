package problem3;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class CoolShell {
    private static String prompt = "CoolShell: ";

    private String user;
    private String lastJoke;

    private static String[] menu_opts = {
            "First character given determines command executed.",
            "- ?: Print this menu",
            "- d: Print the date",
            "- j: Fetch a joke.",
            "- q: quit this program.",

    };

    public CoolShell(String username){
        user = username;
        lastJoke = "";
    }

    private void helpmenu(){
        System.out.println("Help menu:");
        for(int i = 0; i < menu_opts.length; i++){
            System.out.println(menu_opts[i]);
        }
        System.out.println("");
        System.out.println("After typing a command, you should be able to continue.");
    }

    private void joke(){
        //Attributed to icndb
        String[] jokes = {
                "KMP can compile syntax errors.",
                "In a tagteam match, KMP was teamed with Hulk Hogan against King Kong Bundy and Andre" +
                        " The Giant. He pinned all 3 at the same time.",
                "When Bruce Banner gets mad, he turns into the Hulk. When the Hulk gets mad," +
                        " he turns into KMP.",
                "When KMP wants an egg, he cracks open a chicken.",
                "A diff between your code and KMP 's is infinite.",
                "The First Law of Thermodynamics states that energy can neither be created nor destroyed..." +
                        " unless it meets KMP.",
                "KMP doesn't use reflection, reflection asks politely for his help."
        };

        Random r = new Random();
        int index = r.nextInt(jokes.length);
        lastJoke = jokes[index];
        System.out.println(jokes[index]);
    }

    public void interact(){
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the shell! Type '?' for help.");

        while(true){
            System.out.print(prompt);
            String input = s.nextLine();

            if(input.length() == 0){
                continue;
            }

            String[] words = input.split(" ");


            char firstchar = words[0].charAt(0);

            switch(firstchar){
                case '?':
                    helpmenu();
                    break;
                case 'd':
                    String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
                    System.out.println(timeStamp);
                    break;
                case 'j':
                    if(words.length > 1 && words[1].charAt(0) == 'r'){
                        System.out.println(lastJoke);
                    } else {
                        joke();
                    }
                    break;
                case 'q':
                    System.out.println("Bye bye!");
                    return;
                    
            }
        }

    }
}
