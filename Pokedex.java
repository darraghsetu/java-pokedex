import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * A class that stores data on the first generation of Pokémon. Users can display Pokémon,
 * search for Pokémon, add and delete Pokémon, and compare two Pokémon.
 * 
 * @author Darragh Drohan
 */
public class Pokedex{
    
    /**
     * Retrieves Pokemon data from a file.
     * 
     * @param fileName The name of the file to be read, formatted as 151 lines of comma-delimited Pokemon data
     * @return A two-dimensional array containing 151 Pokemon, each with 10 data entries. 
     *         Returns array of null values if file not found.
     */
    public static String[][] importPokemon( String fileName ){
        String[][] pokemon = new String[151][10];
        
        try{
            Scanner scanner = new Scanner( new File( fileName ) );
            int index = 0;
            
            while( scanner.hasNextLine( ) ){
                String line = scanner.nextLine( );
                pokemon[index] = line.split( "," );
                index++;
            }
        } catch( FileNotFoundException e ){
            JOptionPane.showMessageDialog( null, getDisplayText( 32 ) + fileName + "\n", "Error!", JOptionPane.ERROR_MESSAGE );
        }
        
        return pokemon;
    }
    
    /**
     * Prints the column headings of the pokemon table.
     */
    public static void printHead( ){
        String heading = "";
        String columnFormat = "%-10s";
        String horizontalRule = " ---------------------------------------------------------------------------------------------------------------------------------";
        String[] headings = {"Number","Name","Type 1","Type 2","Hit Points","Attack","Defence","Sp.Attack","Sp.Defence","Speed"};
        
        for( int i = 0; i < 10; i++ ){
            heading += "| " + String.format( columnFormat, headings[i] ) + " ";
        }
        
        System.out.println( horizontalRule );
        System.out.println( heading + "|" );
        System.out.println( horizontalRule );        
    }
    
    /**
     * Prints the horizontal line at the bottom of the pokemon table.
     */
    public static void printTail( ){
        String horizontalRule = " ---------------------------------------------------------------------------------------------------------------------------------";        
        
        System.out.println( horizontalRule );
        System.out.println( );
    }
    
    /**
     * Prints a Pokemon's information as a row in the Pokemon table.
     * 
     * @param pokemon An array containing the Pokemon to print.
     */
    public static void printPokemon( String[] pokemon ){
        String formattedString = "";
        String columnFormat = "%-10s";
        
        for( int i = 0; i < 10; i++ ){
            formattedString += "| " + String.format( columnFormat, pokemon[i] ) + " ";
        }
        
        System.out.println( formattedString + "|" );
    }
    
    /**
     * Prints the Pokemon table of Pokemon within the range: fromIndex to toIndex.
     * 
     * @param pokemon An array containing all of the Pokemon.
     * @param fromIndex The lower index of the range of Pokemon to print. Must be a value within the range: 1 to pokemon.length.
     * @param toIndex The upper index of the range of Pokemon to print. Must be a value within the range: fromIndex to pokemon.length.
     */
    public static void printTable( String[][] pokemon, int fromIndex, int toIndex ){
        printHead( );
        
        for( int i = fromIndex - 1; i < toIndex; i++ ){
            printPokemon( pokemon[i] );
        }
        
        printTail( );
    }
    
    /**
     * Gets a piece of text corresponding to the selection
     * 
     * @param selection A number corresponding to the piece of text to be returned
     * @return The selected piece of text
     */
    public static String getDisplayText( int selection ){
        String displayText = "";
        
        switch( selection ){
            case 1:
                displayText = "Hello, I'm Professor Oak.\nWelcome to my creation, the Pokedex!\nWhat would you like to do?\n\n1. Display Pokemon\n2. Search for Pokemon\n3. Add a new Pokemon\n4. Delete a Pokemon\n5. Compare two Pokemon\n6. Exit\n\n";
                break;
            case 2:
                displayText = "1. Display all Pokemon\n2. Display all Pokemon in ID range\n3. Display all Pokemon by Type\n4. Display all Pokemon sorted by\n5. Display all User Pokemon\n\n";
                break;
            case 3:
                displayText = "Please enter the ID to display from:\n";
                break;
            case 4:
                displayText = "Please enter the ID to display to:\n";
                break;
            case 5:
                displayText = "Please select the Type you wish to display:\n";
                break;
            case 6:
                displayText = "Display all Pokemon by:\n\nName\nHit Points\nAttack\nDefence\nSpecial Attack\nSpecial Defence\nSpeed\n";
                break;
            case 7:
                displayText = "Please select what you would like to search by:\n";
                break;
            case 8:
                displayText = "Please enter the ID to search for:\n";
                break;
            case 9:
                displayText = "Please enter the name to search for:\n";
                break;
            case 10:
				displayText = "Please enter your Pokemon's name:\n";
				break;
            case 11:
				displayText = "Please select your Pokemon's first type:\n";
				break;
            case 12:
				displayText = "Please select your Pokemon's second type:\n";
				break;
            case 13:
                displayText = "Please enter your Pokemon's hit points:\n";
                break;
            case 14:
				displayText = "Please enter your Pokemon's attack points:\n";
                break;
            case 15:
				displayText = "Please enter your Pokemon's defence points:\n";
                break;
            case 16:
            	displayText = "Please enter your Pokemon's special attack points:\n";
                break;
            case 17:
				displayText = "Please enter your Pokemon's special defence points:\n";
                break;
            case 18:
				displayText = "Please enter your Pokemon's speed:\n";
                break;
            case 19:
                displayText = "Your Pokemon has been added to the Pokedex\n";
				break;
            case 20:
				displayText = "Please enter your Pokemon's ID:\n";
				break;
            case 21:
				displayText = "Your Pokemon has been removed from the Pokedex\n";
				break;
            case 22:
				displayText = "Sorry, no user Pokemon to remove\n";
				break;
            case 23:
				displayText = "Please enter the first Pokemon's ID:\n";
				break;
            case 24:
                displayText = "Please enter the second Pokemon's ID:\n";
				break;
            case 25:
				displayText = "Sorry, the IDs cannot be the same\n";
				break;
            case 26:
				displayText = "Sorry, that name is taken\n";
				break;
            case 27:
				displayText = "Sorry, that name is too long\nPlease enter a name with 10 or less characters\n";
				break;
            case 28:
				displayText = "Sorry, you must enter a name\n";
				break;
			case 29:
				displayText = "Sorry, no user Pokemon to display";
				break;
			case 30:
				displayText = "Sorry, no Pokemon with that ID";
				break;
			case 31:
				displayText = "Sorry, no Pokemon with that name";
				break;
			case 32:
				displayText = "He's dead Jim:\nFile not found - ";
				break;
            default:
                displayText = "No dice";
				break;
        }
        
        return displayText;
    }
    
    /**
     * Checks that a String is not null or the empty string.
     * 
     * @param input The string to validate.
     * @return Returns true if input is not null or the empty string. Otherwise, returns false.
     */
    public static boolean isValid( String input ){
        boolean valid = false;
        
        if( input != null && ! input.equals("") ){
            valid = true;
        }
        
        return valid;
    }
    
    /**
     * Checks that an Integer is within the range: lowerRange to upperRange.
     * 
     * @param input The Integer to be validated.
     * @param lowerRange The lower value of the range.
     * @param upperRange The upper value of the range.
     * @return Returns true if input is within the range: lowerRange to upperRange. Otherwise, returns false.
     */
    public static boolean inRange( int input, int lowerRange, int upperRange ){
        boolean inRange = false;
        
        if( input >= lowerRange && input <= upperRange ){
            inRange = true;
        }
        
        return inRange;
    }
    
    /**
     * Displays a dialog box and prompts user for a number within the range: lowerRange to upperRange.
     * 
     * @param displayText The text to be displayed in the dialog box.
     * @param lowerRange The lower value of the range.
     * @param upperRange The upper value of the range.
     * @param iconName The name of the PNG image from the images subfolder to be displayed as an icon.
     * @return An Integer within the range: lowerRange to upperRange. 
     *         Returns 0 if the user clicks the cancel or close button.
     */
    public static int getUserInput( String displayText, int lowerRange, int upperRange, String iconName ){
        String userInput = "";
        int userChoice = 0;
        boolean validInput = false;
        String title = "Pokedex";
        
        while( ! validInput ){
            ImageIcon icon = new ImageIcon( "./images/" + iconName + ".png" );
            userInput = (String) JOptionPane.showInputDialog( null, displayText, title, JOptionPane.PLAIN_MESSAGE, icon, null, null );
            
            // Checks if the string input is not the empty string or null, then converts to an int and checks its in provided range
            if( isValid( userInput ) ){
                userChoice = Integer.parseInt( userInput );
                
                if( inRange( userChoice, lowerRange, upperRange ) ){
                    validInput = true;
                }else{
                    JOptionPane.showMessageDialog( null, "Sorry, your choice must be between " + lowerRange + " and " + upperRange, "Uh-Oh!", JOptionPane.WARNING_MESSAGE );
                }
            }else{
                // User enters the empty string, or chooses the cancel or close button
                // Returns the default value of userChoice, 0
                validInput = true;
            }
        }
        
        return userChoice;
    }
    
    /**
     * Sorts the Pokemon array by the selected column values, ascending.
     * 
     * @param pokemon The Pokemon array to be sorted.
     * @param columnName The heading of the column in the Pokemon array to be sorted by.
     * @return A two-dimensional array of the sorted Pokemon array.
     */
    public static String[][] sortBy( String[][] pokemon, String columnName ){
        String[] sortedColumn = new String[pokemon.length];
        String[][] sortedPokemon = new String[pokemon.length][10];
        String[][] columnNames = {{"Name","1"}, {"Hit Points","4"}, {"Attack","5"}, {"Defence","6"}, {"Special Attack","7"}, {"Special Defence","8"}, {"Speed","9"}}; 
        
        for( int i = 0; i < columnNames.length; i++ ){
            if( columnName.equals( columnNames[i][0] ) ){
                int column = Integer.parseInt( columnNames[i][1] );
                
                // Copys the selected column's values from Pokemon array to sortedColumn array
                for( int j = 0; j < pokemon.length; j++ ){
                    sortedColumn[j] = pokemon[j][column];
                }
                
                // Sorts sortedColumn
                Arrays.sort( sortedColumn );
                        
                // For each element of sortedColumn
                //     Searches Pokemon array for the current element of sortedColumn
                //     If the Pokemon has not already been added to the sortedPokemon array:
                //         Adds the row from the Pokemon array
                for( int j = 0; j < sortedColumn.length; j++ ){
                    for( String[] entry : pokemon ){
                        if( sortedColumn[j].equals( entry[column] ) ){
                            boolean inArray = false;
                            
                            for( int k = 0; k < sortedColumn.length; k++ ){
                                if( sortedPokemon[k].equals( entry ) ){
                                    inArray = true;
                                }
                            }
                                   
                            if( ! inArray ){
                                sortedPokemon[j] = entry;
                            }
                        }
                    }
                }
            }
        }
        
        return sortedPokemon;
    }
    
    /**
     * Displays a dialog box with the selected Pokemon information.
     * 
     * @param pokemon The Pokemon array containing the Pokemon to be displayed.
     * @param index The index of the Pokemon to be displayed
     * @param iconName The name of the PNG image from the images subfolder to be displayed as an icon.
     */
    public static void displayPokemon( String[][] pokemon, int index, String iconName ){
        String displayText = "Name: " + pokemon[index][1] + "\nType 1: " + pokemon[index][2]+ "\nType 2: " + pokemon[index][3]+ "\nHit Points: " + pokemon[index][4]+ "\nAttack: " + pokemon[index][5]+ "\nDefence: " + pokemon[index][6]+ "\nSpecial Attack: " + pokemon[index][7]+ "\nSpecial Defence: " + pokemon[index][8]+ "\nSpeed: " + pokemon[index][9] + "\n\n";
        ImageIcon pokemonIcon = new ImageIcon( "./images/" + iconName + ".png" ); 
        JOptionPane.showMessageDialog( null, displayText, "Pokemon #" + pokemon[index][0], JOptionPane.PLAIN_MESSAGE, pokemonIcon );
    }
    
    /**
     * Extends the Pokemon array by one and adds the user's Pokemon.
     * 
     * @param array The Pokemon array to be extended.
     * @param userPokemon The values of the Pokemon to be added to the array.
     * @return The extended Pokemon array with the inputted Pokemon added.
     */
    public static String[][] addToArray( String[][] array, String[] userPokemon ){
        String[][] tempArray = new String[array.length + 1][10];
        
		// Copies the Pokemon from the Pokemon array to tempArray
        for( int i = 0; i < array.length; i++ ){
            for( int j = 0; j < 10; j++ ){
                tempArray[i][j] = array[i][j];    
            }
        }
        
		// Appends userPokemon to the end of tempArray
        for( int i = 0; i < 10; i++ ){
            if( i > 3 ){
                tempArray[tempArray.length - 1][i] = String.format( "%03d", Integer.parseInt( userPokemon[i] ) );
            }else{
                tempArray[tempArray.length - 1][i] = userPokemon[i];   
            }
        }
        
        return tempArray;
    }
    
    /**
     * Shortens the Pokemon array by one and removes the user's Pokemon.
     * The Pokemon following the removed Pokemon will have their IDs reduced by one.
     * 
     * @param array The Pokemon array to be shortened by one.
     * @param id The Pokemon ID to be removed from the Pokemon array.
     * @return The shortened Pokemon array with the inputted Pokemon removed. 
     */
    public static String[][] removeFromArray( String[][] array, String id ){
        String[][] tempArray = new String[array.length - 1][10];
        int index = 0;
        
		// Checks there are user Pokemon to delete
		// For each Pokemon in the Pokemon array
		//     Checks if the current Pokemon is the Pokemon to be removed
		//         If not it 
		//		       adds the Pokemon to tempArray
		//		       checks if the Pokemon ID is after the Pokemon to be removed
		//			       If it is it reduces the ID by one
        if( array.length > 151 ){
            for( int i = 0; i < array.length; i++ ){
                if( ! array[i][0].equals( id ) ){
                    for( int j = 0; j < 10; j++ ){
                        tempArray[index][j] = array[i][j];
                    }
                    
                    if( ! tempArray[index][0].equals( array[index][0] ) ){
                        tempArray[index][0] = array[index][0];
                    }
                    
					// index counts how many pokemon have been transferred
					// index equals i until the user's Pokemon gets removed, it is not incremented then and is one less than i from that point onwards
					// This allows the program to decrease the IDs after the removed Pokemon by one
                    index++;
                }
            }
        }
        
        return tempArray;
    }
    
    /**
     * Compares two Pokemon's stats, displays if their stats are equal, 
     * otherwise displays the Pokemon with the larger stat for each column.
     * 
     * @param pokemon The Pokemon array containing the two Pokemon.
     * @param firstId The ID of the first Pokemon.
     * @param secondId The ID of the second Pokemon.
     */
    public static void comparePokemon( String[][] pokemon, String firstId, String secondId ){
        String[] firstPokemon = pokemon[Integer.parseInt( firstId ) - 1];
        String[] secondPokemon = pokemon[Integer.parseInt( secondId ) - 1];
		String[] columns = {"Hit Points", "Attack Points", "Defence Points", "Special Attack Points", "Special Defence Points", "Speed"};
        String displayText = "";
        String title = "Pokedex";
        
		// Compares each column value for each pokemon
		for( int i = 4; i < 10; i++ ){
			if( Integer.parseInt( firstPokemon[i] ) > Integer.parseInt( secondPokemon[i] ) ){
				displayText += firstPokemon[1] + " has more " + columns[i-4] + "\n";
			}else if( Integer.parseInt( firstPokemon[i] ) < Integer.parseInt( secondPokemon[i] ) ){
				displayText += secondPokemon[1] + " has more " + columns[i-4] + "\n";
			}else{
				displayText += "Both pokemon have the same Hit Points\n";
			}
		}
        
        JOptionPane.showMessageDialog( null, displayText + "\n", title, JOptionPane.PLAIN_MESSAGE );
    }
    
    /**
     * Displays the Pokedex menu, looping until the user chooses "6", the close or exit button.
     * 
     * @param args The command line arguements.
     */
    public static void main(String[] args){
        int userChoice = 0;
        String fileName = "pokemon_data.csv";
        String title = "Pokedex";
        
        // Retrieves the 151 Pokemon stored in pokemon_data.csv
        String[][] pokemon = importPokemon( fileName );
        
        do{
            // Displays the main menu dialog box and stores the user's choice
            userChoice = getUserInput( getDisplayText( 1 ), 1, 7, "professor_oak" );
            
            switch( userChoice ){
                case 1:
                    // 1. Display Pokemon
                    userChoice = getUserInput( getDisplayText( 2 ), 1, 5, "default" );
    
                    switch( userChoice ){
                        case 1:
                            // 1. Display all Pokemon
                            printTable( pokemon, 1, pokemon.length );
                            break;
                            
                        case 2:
                            // 2. Display all Pokemon in ID range
                            int lowerRange = getUserInput( getDisplayText( 3 ), 1, pokemon.length, "default" );
                            
                            if( lowerRange != 0 ){
                                int upperRange = getUserInput( getDisplayText( 4 ), lowerRange, pokemon.length, "default" );
                                
                                if( upperRange != 0 ){
                                    printTable( pokemon, lowerRange, upperRange );
                                }
                            }
							
                            break;
                            
                        case 3:
                            // 3. Display all Pokemon by Type
                            String[] types = {"Normal","Fire","Water","Ice", "Grass", "Ground", "Rock", "Electric", "Poison", "Psychic", "Fighting", "Flying", "Dragon", "Ghost", "Bug"};
                            String type = (String) JOptionPane.showInputDialog( null, getDisplayText( 5 ), title, JOptionPane.PLAIN_MESSAGE, null, types, null );
                            
                            if( isValid( type ) ){
                                printHead( );
                                for( String[] entry : pokemon ){
                                    if ( entry[2].equals( type ) || entry[3].equals(type) ){
                                        printPokemon( entry );
                                    }
                                }
                                printTail( );
                            }
							
                            break;
                            
                        case 4:
                            // 4. Display all Pokemon sorted by
                            String[] columns = {"Name","Hit Points","Attack","Defence", "Special Attack", "Special Defence", "Speed" };
                            String column = (String) JOptionPane.showInputDialog( null, getDisplayText( 6 ), title, JOptionPane.PLAIN_MESSAGE, null, columns, null );
                            
                            if( isValid( column ) ){
                                String[][] sorted = sortBy( pokemon, column );
                                printTable( sorted, 1, sorted.length );
                            }
							
                            break;
                            
                        case 5:
                            // 5. Display all user Pokemon
                            if( pokemon.length > 151 ){
                                printTable( pokemon, 152, pokemon.length );
                            }else{
                                JOptionPane.showMessageDialog( null, getDisplayText( 29 ), "Uh-Oh!", JOptionPane.WARNING_MESSAGE );
                            }
							
                            break;
                    }
					
                    break;
                    
                case 2:
                    // 2. Search for Pokemon
                    String[] columns = {"Identification Number", "Name"};
                    String column = (String) JOptionPane.showInputDialog( null, getDisplayText( 7 ), title, JOptionPane.PLAIN_MESSAGE, null, columns, null );
                    
                    if( isValid( column ) ){
                        if( column.equals( columns[0] ) ){
							// Searching by ID
                            String searchId = JOptionPane.showInputDialog( null, getDisplayText( 8 ), title, JOptionPane.PLAIN_MESSAGE );
                            
                            if( isValid( searchId ) ){
                                if( inRange( Integer.parseInt( searchId ), 1, pokemon.length ) ){
                                    searchId = String.format( "%03d", Integer.parseInt( searchId ) );
                                    
                                    for( int i = 0; i < pokemon.length; i++ ){
                                        if( pokemon[i][0].equals( searchId ) ){
                                            switch( searchId ){
                                                // Special cases where the Pokemon name is not the same as the icon image's name
												case "029":
                                                    displayPokemon( pokemon, i, "nidoran-f" );
                                                    break;
                                                case "032":
                                                    displayPokemon( pokemon, i, "nidoran-m" );
                                                    break;
                                                case "083":
                                                    displayPokemon( pokemon, i, "farfetchd" );
                                                    break;
                                                case "122":
                                                    displayPokemon( pokemon, i, "mr-mime" );
                                                    break;
                                                default:
													// All other cases
                                                    displayPokemon( pokemon, i, pokemon[i][1].toLowerCase( ) );
                                                    break;
                                            }
                                        }
                                    }
                                }else{
                                    JOptionPane.showMessageDialog( null, getDisplayText( 30 ), "Uh-Oh!", JOptionPane.WARNING_MESSAGE );
                                }
                            }
                        }else{
							// Searching by name
                            String searchName = JOptionPane.showInputDialog( null, getDisplayText( 9 ), title, JOptionPane.PLAIN_MESSAGE );
                            int index = 0;
                            
                            if( isValid( searchName ) ){
                                for( int i = 0; i < pokemon.length; i++ ){
                                    if( pokemon[i][1].toLowerCase( ).equals( searchName.toLowerCase( ) ) ){
                                        index = i;
                                    }
                                }
                                
                                if( index != 0 ){
                                    switch( searchName.toLowerCase( ) ){
                                        // Special cases where the Pokemon name is not the same as the icon image's name
										case "nidoran(f)":
                                            displayPokemon( pokemon, index, "nidoran-f" );
                                            break;
                                        case "nidoran(m)":
                                            displayPokemon( pokemon, index, "nidoran-m" );
                                            break;
                                        case "farfetch'd":
                                            displayPokemon( pokemon, index, "farfetchd" );
                                            break;
                                        case "mr. mime":
                                            displayPokemon( pokemon, index, "mr-mime" );
                                            break;
                                        default:
											// All other cases
                                            displayPokemon( pokemon, index, pokemon[index][1].toLowerCase( ) );
                                            break;
                                    }
                                }else{
                                    JOptionPane.showMessageDialog( null, getDisplayText( 31 ), "Uh-Oh!", JOptionPane.WARNING_MESSAGE );
                                }
                            }
                        }
                    }		
					
                    break;
                    
                case 3:
                    // 3. Add a new Pokemon
                    String name, typeOne, typeTwo;
                    name = typeOne = typeTwo = "";
                    
                    int hp, attack, defence, spAttack, spDefence, speed;
                    hp = attack = defence = spAttack = spDefence = speed = 0;
                    
                    boolean valid, inArray;
                    valid = inArray = false;
                    
                    do{
                        name = JOptionPane.showInputDialog( null, getDisplayText( 10 ), title, JOptionPane.PLAIN_MESSAGE );
                        
						// Checking name is not null or empty string
                        if( isValid( name ) ){
                            // Checking name is not over 10 characters
							if( name.length( ) <= 10 ){
                                // Checking name is not already taken
								for( int i = 0; i < pokemon.length; i++ ){
                                    if( pokemon[i][1].equals( name ) ){
                                        inArray = true;
                                    }
                                }
                                
                                if( ! inArray ){
                                    valid = true;
                                }else{
                                    JOptionPane.showMessageDialog( null, getDisplayText( 26 ), "Uh-Oh!", JOptionPane.WARNING_MESSAGE );
                                    inArray = false;
                                }
                            }else{
                                JOptionPane.showMessageDialog( null, getDisplayText( 27 ), "Uh-Oh!", JOptionPane.WARNING_MESSAGE );
                            }
                        }else{
                            if( name != null  ){
								if( name.equals( "" ) ){
									JOptionPane.showMessageDialog( null, getDisplayText( 28 ), "Uh-Oh!", JOptionPane.WARNING_MESSAGE );
								}
                            }else{
                                valid = true;
							}
                        } 
                    }while( ! valid );
                    
					if( name != null ){
						String[] types1 = {"Normal","Fire","Water","Ice", "Grass", "Ground", "Rock", "Electric", "Poison", "Psychic", "Fighting", "Flying", "Dragon", "Ghost", "Bug"};
						String[] types2 = {"-", "Normal","Fire","Water","Ice", "Grass", "Ground", "Rock", "Electric", "Poison", "Psychic", "Fighting", "Flying", "Dragon", "Ghost", "Bug"};
						
						do{
							typeOne = (String) JOptionPane.showInputDialog( null, getDisplayText( 11 ), title, JOptionPane.PLAIN_MESSAGE, null, types1, null );
						}while( typeOne == null );
						
						do{
							typeTwo = (String) JOptionPane.showInputDialog( null, getDisplayText( 12 ), title, JOptionPane.PLAIN_MESSAGE, null, types2, null );
						}while( typeTwo == null );
						
						do{
							hp = getUserInput( getDisplayText( 13 ), 1, 999, "default" );
						}while( hp == 0 );
						
						do{
							attack = getUserInput( getDisplayText( 14 ), 1, 999, "default" );
						}while( attack == 0 );
						
						do{
							defence = getUserInput( getDisplayText( 15 ), 1, 999, "default" );
						}while( defence == 0 );
						
						do{
							spAttack = getUserInput( getDisplayText( 16 ), 1, 999, "default" );
						}while( spAttack == 0 );
						
						do{
							spDefence = getUserInput( getDisplayText( 17 ), 1, 999, "default" );
						}while( spDefence == 0 );
						
						do{
							speed = getUserInput( getDisplayText( 18 ), 1, 999, "default" );
						}while( speed == 0 );
						
					
						String[] userPokemon = {String.valueOf( pokemon.length + 1 ), name, typeOne, typeTwo, String.valueOf( hp ), String.valueOf( attack ), String.valueOf( defence ), String.valueOf( spAttack ), String.valueOf( spDefence ), String.valueOf( speed )};
						pokemon = addToArray( pokemon, userPokemon );
							
						for( String[] entry : pokemon ){
							System.out.println( Arrays.toString( entry ) );
						}
							
						JOptionPane.showMessageDialog( null, getDisplayText( 19 ), title, JOptionPane.PLAIN_MESSAGE );
					}
					
                    break;
                    
                case 4:
                    // 4. Delete a Pokemon
					
					// Checks if there are user Pokemon to delete
                    if( pokemon.length > 151 ){
                        String id = String.valueOf( getUserInput( getDisplayText( 20 ), 152, pokemon.length, "default" ) );
                        if( ! id.equals( "0" ) ){
							System.out.println( id );
							pokemon = removeFromArray( pokemon, id );
							JOptionPane.showMessageDialog( null, getDisplayText( 21 ), title, JOptionPane.PLAIN_MESSAGE );
						}
                    }else{
                        JOptionPane.showMessageDialog( null, getDisplayText( 22 ), "Uh-Oh!", JOptionPane.WARNING_MESSAGE );
                    }
					
                    break;
                    
                case 5:
                    // 5. Compare two Pokemon
                    String firstId, secondId;
                    firstId = secondId = "";
                    
                    firstId = String.valueOf( getUserInput( getDisplayText( 23 ), 1, pokemon.length, "default" ) );
                    
					// Checks if first Pokemon is not the second Pokemon
					do{
                        secondId = String.valueOf( getUserInput( getDisplayText( 24 ), 1, pokemon.length, "default" ) );
                        
                        if( firstId.equals( secondId ) ){
                            JOptionPane.showMessageDialog( null, getDisplayText( 25 ), "Uh-Oh!", JOptionPane.WARNING_MESSAGE );
                        }
                    }while( firstId.equals( secondId ) );
                    
					if( ( ! firstId.equals( "0" ) ) && ( ! secondId.equals( "0" ) ) ){
						comparePokemon( pokemon, firstId, secondId );
					}
					
                    break;
                    
				case 6:
					// 6. Exit
					break;
					
                default:
                    // The empty string, the cancel or close button are chosen
                    userChoice = 6;
                    break;
            }
        }while( userChoice != 6 );
    }
}