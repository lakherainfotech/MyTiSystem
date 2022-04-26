import java.time.LocalDate;
import java.util.*;

public class MyTiSystem {
    public static void main(String[] args) {
        run();
    }

     private static void run()
     {
         ArrayList<Station> stationList  = getStation();
         HashMap<String,User> userList = new HashMap<>();
         int choice = 0;
         while(choice != 8)
         {
             choice = getUserInput();
             switch (choice)
             {
                 case 1:
                 {

                     break;
                 }
                 case 4:
                 {
                     printUserReport(userList); // calling function print user report
                     break;
                 }
                 case 6:
                 {
                     displayStation(stationList);
                     break;
                 }
                 case 7:
                 {
                     addUser(userList);
                     break;
                 }
                 case 8:
                 {
                     System.out.println("Thank you for using the code");
                     break;
                 }
             }
         }
     }


    /**
     * this function buys the journey for user
     * @param userList list of the users
     * @param stationList list of the stations
     */
     private static void buyJourneyForUser(HashMap<String,User> userList, ArrayList<Station> stationList)
     {
         Scanner scanner = new Scanner(System.in);
         String userID;
         System.out.print("Enter user id for which you have to buy pass: ");
         userID = scanner.nextLine();
         if(!userList.containsKey(userID))
         {
             System.out.println("No user exists with this id");
         }
         else
         {
             LocalDate date = getDate();

             Station startStation = getStation(stationList, "");
             Station endStation = getStation(stationList, startStation.getName());

         }
     }


    /**
     *
     * @param message displayed to user
     * @return integer input entered by user
     */
     private static int getIntegerInput(String message)
     {
         Scanner scanner = new Scanner(System.in);
         int input;
         while(true)
         {
             try
             {
                 System.out.println("Enter "+message+": ");
                 input = scanner.nextInt();
                 return input;
             }
             catch (InputMismatchException e)
             {
                 System.out.println("Enter only integer input");
                 scanner.nextLine();
             }
         }
     }


    /**
     *
     * @return the date of journey
     */
     private static LocalDate getDate()
     {
         Scanner scanner = new Scanner(System.in);
         int day, month, year;
         LocalDate date;
         while(true)
         {
             try
             {
                 System.out.println("Enter date information");
                 day = getIntegerInput("day");
                 month = getIntegerInput("month");
                 year = getIntegerInput("year");
                 date = LocalDate.of(year,  month, day);
                 return date;
             }
             catch(Exception e)
             {
                 System.out.println("Invalid Date ");
                 scanner.nextLine();
             }
         }
     }

    /**
     * this function select the station from the user and returns it
     * @param stationList list of station available
     * @param stationName name of the station select by user
     * @return the station selected by user
     */
     private static Station getStation(ArrayList<Station> stationList, String stationName)
     {
         Scanner scanner = new Scanner(System.in);
         Station station;
         while(true)
         {
             station = getUserStation(stationList);
             if(station.getName().equalsIgnoreCase(stationName))
             {
                 System.out.println("Starting and the ending station cannot be same");
             }
             else
             {
                 return station;
             }
         }
     }

     private static Station getUserStation(ArrayList<Station> stationList)
     {
         Scanner scanner = new Scanner(System.in);
         String name;
         while(true)
         {
             displayStation(stationList);
             System.out.print("Enter station name to select: ");
             name = scanner.nextLine();
             for(int i = 0;i<stationList.size();i++)
             {
                 if(stationList.get(i).getName().equalsIgnoreCase(name))
                 {
                     return stationList.get(i);
                 }
             }
             System.out.println("Invalid station name");
         }
     }



    /**
     * print report of the specific user
     * @param userList the user list of the user
     */
    private static void printUserReport(HashMap<String,User> userList) {
        Scanner scanner = new Scanner(System.in);
        String id;
        System.out.print("Enter user id: ");
        id = scanner.nextLine();
        if(userList.containsKey(id)) // checking if the id is exists
        {
            userList.get(id).displayInformation();
        }
        else
        {
            System.out.println("Invalid user id");
        }
    }

    /**
     * add user to the user list
     * @param userList the user list of the user
     */
     private static void addUser(HashMap<String,User> userList)
     {
         Scanner scanner = new Scanner(System.in);
         String id, type,  name, email;
         id = "";
         while(true)
         {
             System.out.print("Enter user id: ");
             id = scanner.nextLine();
             if(userList.containsKey(id)) // checking if the id is already taken by another user
             {
                 System.out.println("This id is already taken by another user");
             }
             else
             {
                 break;
             }
         }
         type = "";
         while(true)
         {
             System.out.print("Enter user type: (Adult, Junior, Senior): ");
             type = scanner.nextLine();
             type = type.substring(0,1).toUpperCase() + type.substring(1).toLowerCase();
             if(type.equalsIgnoreCase("Adult") || type.equalsIgnoreCase("Junior") || type.equalsIgnoreCase("Senior"))
             {
                 break;
             }
             else
             {
                 System.out.println("Invalid user type it can be Adult, Junior or Senior");
             }
         }
         System.out.print("Enter name: ");
         name = scanner.nextLine();
         System.out.print("Enter email: ");
         email = scanner.nextLine();
         User user = new User(id, type, name, email);
         userList.put(id, user);
         System.out.println("User Added To System");
     }


    /**
     * This function display the menu
     */
    private static void displayMenu()
    {
        System.out.println("\nSelect From Below Options");
        System.out.println("1. Buy a Journey for a User");
        System.out.println("2. Recharge a MyTi card for a User");
        System.out.println("3. Show remaining credit for a User");
        System.out.println("4. Print User Reports");
        System.out.println("5. Update pricing");
        System.out.println("6. Show Station statistics");
        System.out.println("7. Add a new User");
        System.out.println("8. Quit");
    }

    /**
     *
     * @return the user choice
     */
    private static int getUserInput()
    {
        Scanner scanner = new Scanner(System.in);
        int option;
        while(true)
        {
            try{
                displayMenu();
                System.out.print("Enter your choice: ");
                option  = scanner.nextInt();
                if(option >= 1 && option <= 8)
                {
                    return option;
                }
                else
                {
                    System.out.println("Invalid Choice");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Please enter integer values only");
                scanner.nextLine();
            }
        }
    }

    /**
     *
     * @return the array list of station
     */
    private static ArrayList<Station> getStation()
    {
        ArrayList<Station> stationList = new ArrayList<>();
        // creating station
        Station firstStation = new Station("Central", 1);
        //Station secondStation = new Station("Central", 1);
        Station thirdStation = new Station("Richmond", 1);
        Station fourthStation = new Station("LilyDale", 2);
        Station fifthStation = new Station("Epping", 2);
        // adding station to array list
        stationList.add(firstStation);
       // stationList.add(secondStation);
        stationList.add(thirdStation);
        stationList.add(fourthStation);
        stationList.add(fifthStation);
        return stationList;
    }

    /**
     *
     * @param stationList array list of station for which information needed to be displayed
     */
    private static void displayStation(ArrayList<Station> stationList)
    {
        System.out.println("Displaying Station List");
        System.out.println(String.format("%-10s %-5s","Name","Zone"));
        for(int i = 0;i< stationList.size();i++)
        {
            System.out.println(String.format("%-10s %-5d", stationList.get(i).getName(), stationList.get(i).getZone()));
        }
    }

}
