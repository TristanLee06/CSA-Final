import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Character> kingdom = new ArrayList<>();
        // This is to get the user inputs to make this game dynamic!
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Introductory information to the player!
        System.out.println("Welcome to the Medieval Kingdom!");
        System.out.println("Build your kingdom, interact with characters, and manage their adventures.");

        // Campaign. This will keep runnning like a while loop until an escape sequence is made!
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a Character");
            System.out.println("2. View All Characters");
            System.out.println("3. Interact with Characters");
            System.out.println("4. Heal a Character");
            System.out.println("5. Exit");
            System.out.println("6. Campaign");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            // The switch statement here is to select different menu options from the dropdown. It is like a conditional statement except it's mroe efficient
            // than traditional if else logic. Just think of it like this. case 1: just means if (choice == 1) essentially.
            switch (choice) {
                case 1: // Add a character
                    System.out.println("Choose a character type: 1. Knight 2. Peasant 3. Merchant 4. Wizard");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    // Parent class shared parameters so specialization of child class is not necessary quite yet
                    System.out.print("Enter character name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter health points: ");
                    int health = scanner.nextInt();
                    System.out.print("Enter the strength: ");
                    int strength = scanner.nextInt();

                    // This is to dynamically change the parameter inputs because different constructors among child classes
                    switch (type) {
                        case 1:
                            System.out.print("Enter armor value: ");
                            int armor = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Enter sword type: ");
                            String sword = scanner.nextLine();
                            System.out.print("Enter shield type: ");
                            String shield = scanner.nextLine();
                            kingdom.add(new Knight(name, health, strength, armor, sword, shield));
                            System.out.println("Knight added!");
                            break;
                        case 2:
                            System.out.print("Enter harvested goods: ");
                            int goods = scanner.nextInt();
                            kingdom.add(new Peasant(name, health, strength, goods));
                            System.out.println("Peasant added!");
                            break;
                        case 3:
                            kingdom.add(new Merchant(name, health, strength));
                            System.out.println("Merchant added!");
                            break;
                        case 4:
                            System.out.print("Enter mana points: ");
                            int mana = scanner.nextInt();
                            kingdom.add(new Wizard(name, health, strength, mana));
                            System.out.println("Wizard added!");
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;

                case 2: // View all characters
                    if (kingdom.isEmpty()) {
                        System.out.println("No characters in the kingdom yet!");
                    } else {
                        System.out.println("Current Kingdom:");
                        for (Character c : kingdom) {
                            System.out.println("\n" + c.toString());
                        }
                    }
                    break;

                    case 3: // Interact with characters
                    if (kingdom.size() < 2) {
                        System.out.println("Not enough characters for interactions!");
                    } else {
                        System.out.println("Choose two characters to interact (enter their index):");
                        for (int i = 0; i < kingdom.size(); i++) {
                            System.out.println(i + ": " + kingdom.get(i).getName() + " (" + kingdom.get(i).getClass().getSimpleName() + ")");
                        }
                        int c1 = scanner.nextInt();
                        int c2 = scanner.nextInt();
                
                        Character char1 = kingdom.get(c1);
                        Character char2 = kingdom.get(c2);
                
                        System.out.println("Valid Actions:");
                
                        // Determine valid actions based on character types
                        if (char1 instanceof Knight && char2 instanceof Character) {
                            System.out.println("1. Protect");
                        }
                        if (char1 instanceof Knight && char2 instanceof Knight) {
                            System.out.println("2. Duel");
                        }
                        if (char1 instanceof Peasant && char2 instanceof Character) {
                            System.out.println("3. Trade");
                        }
                        if (char1 instanceof Merchant && char2 instanceof Character) {
                            System.out.println("4. Sell Item");
                        }
                        if (char1 instanceof Wizard && char2 instanceof Character) {
                            System.out.println("5. Cast Spell");
                        }
                        if (char1 instanceof Wizard && char2 instanceof Wizard) {
                            System.out.println("6. Spell Duel");
                        }
                        System.out.println("Choose a valid action: ");
                        int action = scanner.nextInt();
                
                        // Execute the chosen action
                        switch (action) {
                            case 1: // Knight Protect
                                if (char1 instanceof Knight && char2 instanceof Character) {
                                    ((Knight) char1).protect(char2);
                                } else {
                                    System.out.println("Invalid action!");
                                }
                                break;
                
                            case 2: // Knight Duel
                                if (char1 instanceof Knight && char2 instanceof Knight) {
                                    System.out.println(char1.getName() + " and " + char2.getName() + " duel!");
                                    char2.takeDamage(((Knight) char1).getStrength() * 2);
                                    System.out.println("Ouch! " + char2.getName() + " just got hit by " + char1.getName() + " " + ((Knight) char1).getSwordType());
                                    System.out.println(char2.getName() + " now has " + char2.getHealth() + " health and " + ((Knight) char2).getArmor());
                                } else {
                                    System.out.println("Invalid action!");
                                }
                                break;
                
                            case 3: // Peasant Trade
                                if (char1 instanceof Peasant && char2 instanceof Character) {
                                    ((Peasant) char1).trade();
                                } else {
                                    System.out.println("Invalid action!");
                                }
                                break;
                
                            case 4: // Merchant Sell Item
                                if (char1 instanceof Merchant && char2 instanceof Character) {
                                    System.out.println("Enter item to sell:");
                                    String item = scanner.next();
                                    ((Merchant) char1).trade(item);
                                } else {
                                    System.out.println("Invalid action!");
                                }
                                break;
                
                            case 5: // Wizard Cast Spell
                                if (char1 instanceof Wizard && char2 instanceof Character) {
                                    ((Wizard) char1).castSpell(char2);
                                } else {
                                    System.out.println("Invalid action!");
                                }
                                break;
                
                            case 6: // Wizard Spell Duel
                                if (char1 instanceof Wizard && char2 instanceof Wizard) {
                                    System.out.println(char1.getName() + " and " + char2.getName() + " engage in a spell duel!");
                                    ((Wizard) char1).castSpell(char2);
                                    ((Wizard) char2).castSpell(char1);
                                } else {
                                    System.out.println("Invalid action!");
                                }
                                break;
                
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    }
                    break;
                

                case 4: // Heal a character
                    System.out.println("Choose a character to heal (enter their index):");
                    for (int i = 0; i < kingdom.size(); i++) {
                        System.out.println(i + ": " + kingdom.get(i).getName());
                    }
                    int index = scanner.nextInt();
                    System.out.print("Enter amount to heal: ");
                    int healAmount = scanner.nextInt();
                    kingdom.get(index).heal(healAmount);
                    System.out.println(kingdom.get(index).getName() + " healed by " + healAmount + " points!");
                    break;

                case 5: // Exit
                    running = false;
                    System.out.println("Exiting the kingdom... Goodbye!");
                    break;

                case 6: // Campaign Mode
                    if (kingdom.size() < 1) {
                        System.out.println("You must have people in the kingdom to play the campaign!");
                        break;
                    }
                    int dragonHealth = 200;
                    int kingHealth = 100;

                    // This is a control logic to see which game ending should be had. Game over or victory!
                    boolean dragonDefeated = false;
                
                    System.out.println("\n=== Campaign: Defeat the Dragon ===");
                    System.out.println("The dragon has appeared! Protect the king at all costs.");
                    System.out.println("Dragon Health: " + dragonHealth);
                    System.out.println("King's Health: " + kingHealth);
                
                    while (kingHealth > 0 && dragonHealth > 0) {
                        System.out.println("\nYour Team's Turn:");
                
                        // Team actions with dynamic options for each character. these will only appear if its valid 
                        // for a specific character type in the kingdom. 
                        for (Character c : kingdom) {
                            System.out.println("\n" + c.getName() + "'s turn (" + c.getClass().getSimpleName() + "):");
                            System.out.println("Choose an action:");
                            System.out.println("1. Attack the Dragon");
                            if (c instanceof Knight) {
                                System.out.println("2. Protect the King");
                                System.out.println("3. Duel the Dragon");
                            }
                            if (c instanceof Wizard) {
                                System.out.println("4. Cast Spell on the Dragon");
                                System.out.println("5. Protect an Ally");
                                System.out.println("6. Strengthen a Knight");
                            }
                            if (c instanceof Peasant) {
                                System.out.println("7. Support the King with Harvested Goods");
                            }
                            if (c instanceof Merchant) {
                                System.out.println("8. Supply the Team with Food and Potions");
                            }
                            System.out.print("Enter your choice: ");
                            int action = scanner.nextInt();

                            // Execute the chosen action
                            switch (action) {
                                case 1: // Attack the Dragon
                                    System.out.println(c.getName() + " attacks the dragon!");
                                    dragonHealth -= c.getStrength();
                                    break;

                                case 2: // Protect the King (Knight only)
                                    if (c instanceof Knight) {
                                        System.out.println(c.getName() + " protects the king, reducing damage.");
                                        kingHealth += 10;
                                    } else {
                                        System.out.println("Invalid action.");
                                    }
                                    break;

                                case 3: // Duel the Dragon (Knight only)
                                    if (c instanceof Knight) {
                                        int dragonhealthbefore = dragonHealth;
                                        dragonHealth = ((Knight) c).attackDragon(dragonHealth);
                                        int damageDealt = dragonhealthbefore - dragonHealth;
                                        System.out.println(c.getName() + " duels the dragon, dealing " + damageDealt + " damage! Dragon now has " + dragonHealth + " left!");
                                    } else {
                                        System.out.println("Invalid action.");
                                    }
                                    break;

                                case 4: // Cast Spell on the Dragon (Wizard only)
                                    if (c instanceof Wizard) {
                                        dragonHealth -= 15; // Reflecting the spell's effect on the dragon's health
                                        System.out.println(c.getName() + " casts a deadly spell! Dealing " + 15 + " damage! The dragon now has " + dragonHealth + " health left");
                                    } else {
                                        System.out.println("Invalid action.");
                                    }
                                    break;

                                case 5: // Protect an Ally (Wizard only)
                                    if (c instanceof Wizard) {
                                        System.out.println("Choose an ally to protect:");
                                        for (int i = 0; i < kingdom.size(); i++) {
                                            if (kingdom.get(i) != c) {
                                                System.out.println(i + ": " + kingdom.get(i).getName());
                                            }
                                        }
                                        int allyIndex = scanner.nextInt();
                                        ((Wizard) c).protect(kingdom.get(allyIndex));
                                    } else {
                                        System.out.println("Invalid action.");
                                    }
                                    break;

                                case 6: // Strengthen a Knight (Wizard only)
                                    if (c instanceof Wizard) {
                                        System.out.println("Choose a Knight to strengthen:");
                                        for (int i = 0; i < kingdom.size(); i++) {
                                            if (kingdom.get(i) instanceof Knight) {
                                                System.out.println(i + ": " + kingdom.get(i).getName());
                                            }
                                        }
                                        int knightIndex = scanner.nextInt();
                                        ((Wizard) c).strengthen((Knight) kingdom.get(knightIndex));
                                    } else {
                                        System.out.println("Invalid action.");
                                    }
                                    break;

                                case 7: // Support the King with Harvested Goods (Peasant only)
                                    if (c instanceof Peasant) {
                                        System.out.println(c.getName() + " supports the team with harvested goods.");
                                        kingHealth += 5;
                                    } else {
                                        System.out.println("Invalid action.");
                                    }
                                    break;

                                case 8: // Supply the Team with Food and Potions (Merchant only)
                                    if (c instanceof Merchant) {
                                        System.out.println(c.getName() + " supplies food and potions.");
                                        kingHealth += 10;
                                    } else {
                                        System.out.println("Invalid action.");
                                    }
                                    break;

                                default:
                                    System.out.println("Invalid choice. Turn skipped.");
                            }
                        }

                
                        // Dragon's Turn
                        System.out.println("\n=== Dragon's Turn ===");
                        int dragonAttack = 30;
                        kingHealth -= dragonAttack;
                        System.out.println("The dragon attacks the king, dealing " + dragonAttack + " damage!");
                        System.out.println("King's Health: " + kingHealth);
                        System.out.println("Dragon's Health: " + dragonHealth);
                
                        // Boss Dialogue
                        if (dragonHealth > 100) {
                            System.out.println("Dragon: \"You are no match for my flames!\"");
                        } else if (dragonHealth > 50) {
                            System.out.println("Dragon: \"You dare challenge me? I'll scorch you all!\"");
                        } else if (dragonHealth > 0) {
                            System.out.println("Dragon: \"Impossible! My power is fading...\"");
                        }
                
                        // Check Win/Loss Conditions
                        if (kingHealth <= 0) {
                            System.out.println("\nThe king has fallen! The dragon reigns supreme. Game over.");
                            break;
                        } else if (dragonHealth <= 0) {
                            dragonDefeated = true;
                            System.out.println("\nThe dragon has been defeated! The kingdom is saved!");
                            break;
                        }
                    }
                
                    if (dragonDefeated) {
                        System.out.println("Your team celebrates their hard-fought victory. Glory to the kingdom!");
                        for (Character c : kingdom) {
                            c.levelUP();
                        }
                    }
                    break;
                
                

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}

