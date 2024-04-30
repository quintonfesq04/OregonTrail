package Gameplay;
import Screens.*;
import Gameplay.*;
import Hunting.*;

public class Conversations {
    private Locations locations = new Locations(this);

    public String getConversation(){
        int distance = locations.getDistance();
        String place = locations.getLocation(distance);
        String locationReader;
        String line; 
        int caseType = 13; 
        for(int i = 0; i < 13; i++){ // Fixed the loop condition
            locationReader = locations.LOCATIONS[i];
            if(locationReader.equals(place)){ // Changed == to .equals() for string comparison
                caseType = i;
            }
        }
        switch (caseType){
            case 0 :
                line = "Captain: What are you going to do? *The Captain gives a groan and falls to the ground.*";
                break;
            case 1 :
                line = "Traveler 1: A man named the Captain fell off his horse.";
                break;
            case 2 :
                line = "Traveler 1: We did worse than alone; in a strange wilderness; without food, without fire; the darkness of night forbade the stars to shine upon me; solitary - all was solitary as death - but the same kind Providence that ever watched over me.";
                break;
            case 3 :
                line = "Traveler: I am looking for venison.";
                break;
            case 4 :
                line = "Orus convinced us to make one more effort to reach the Settlement.";
                break;
            case 5 :
                line = "I would like to see that Oregon Pioneer; I wonder if she is anything like what she used to be.";
                break;
            case 6 :
                line = "I started in an open boat up the river for Salem again; wind and tide against us; it was 13 days reaching Oregon City.";
                break;
            case 7 :
                line = "Winter set in; they pressed me hard to spend the winter with them.";
                break;
            case 8 :
                line = "We are waiting for more people to cut a road through the mountains.";
                break;
            case 9 :
                line = "Hey my name is Mr. Pringle, and I tried to shoot a wolf. But I couldn’t because I am weak and trembling.";
                break;
            case 10 :
                line = "I am going to go look for some relief. I do not know when I will be back.";
                break;  
            case 11 :
                line = "We had all retired to rest in our tents, hoping to forget our troubles until daylight.";
                break;  
            case 12 :
                line = "Traveler 1: There is much sickness and death on the Plains.";
                break;
            default :
                line = "error";
                break;
        }
        return line;
    }
}
