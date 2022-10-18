import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;
public class Main {

        public static void main(String args []){
            String[] randomMysteryWordArray = {"censorship","progress","heart","slap","move","polite","vegetation","distant","share","architect","brink","lemon","false","true","resort","bleed","giant","dwarf","bleed","eliminate","scholar","novel","fur","contact"};

            String mysteryWord = randomMysteryWordArray[(int) (Math.random()*24)];
            int hp = 5;
            int hpMinimum = 0;
            int correctGuesses = 0;
            int totalCorrectLetters = 0;
            char[] mysteryWordArray1 = mysteryWord.toCharArray();
            char[] mysteryWordArray2 = new char[mysteryWordArray1.length + 1];
            char[] guessedCharacters = new char[40];
            int wordLength = mysteryWordArray2.length - 2;
            char o = 0;
            mysteryWordArray2 = mysteryWord.toCharArray();
            System.out.println(mysteryWord);
            System.out.println("Please type the first letter that you wish to guess");
            System.out.println("You currently have " + hp + " HP ");
            for(int i = 0; i<=mysteryWordArray1.length-1;i++){

                mysteryWordArray1[i] = o;
            }
            System.out.println("The word: " + Arrays.toString(mysteryWordArray1));
            while(true){
                loopstart:
                if(totalCorrectLetters<=wordLength){
                    Scanner sc1 = new Scanner(System.in);
                    String letter = sc1.nextLine();
                    char[] letterArray = letter.toCharArray();
                    if(letterArray[0] <= 0){
                        break loopstart;}
                    for(int i = 0; i < guessedCharacters.length;i++){
                        if(letterArray[0] == guessedCharacters[i]){
                            System.out.println("You already guessed this, please try another letter");
                            break loopstart;
                        }
                        else if(guessedCharacters[i]==0){
                            guessedCharacters[i] = letterArray[0];
                            break;}
                    }
                    if(letter.length()>1){
                        System.out.println("Please only type 1 letter at a time");
                    }
                    else{
                        correctGuesses=0;
                        for(int i = 0; i <=mysteryWord.length() - 1; i++){
                            if(mysteryWordArray2[i] == letterArray[0]){
                                correctGuesses = correctGuesses +1;
                                mysteryWordArray1[i] = mysteryWordArray2[i];
                                if (correctGuesses<=1){
                                    totalCorrectLetters = totalCorrectLetters + correctGuesses;
                                }
                                else{
                                    totalCorrectLetters = totalCorrectLetters + correctGuesses - (correctGuesses-1);
                                }
                            } else {
                            }
                        } if(correctGuesses==0){
                            hp = hp -1;}
                        System.out.println("The letter '"+ letter + "' is in the word " + correctGuesses + " time(s)");
                        System.out.println(Arrays.toString(mysteryWordArray1));
                        System.out.println("You currently have " + hp + " HP ");
                        System.out.println(totalCorrectLetters);
                    }
                } else if(totalCorrectLetters>=wordLength) {
                    System.out.println("You won, the mystery word was '" + mysteryWord+"'");
                    System.out.println(Arrays.toString(guessedCharacters));
                    break;

                }
                if(hp==0){
                    System.out.println("You lost, the mystery word was " + mysteryWord);
                    break;
                }

            }
        }}


